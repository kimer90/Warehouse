/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import entities.Delivery;
import entities.Facility;
import entities.Goods;
import entities.GoodsInFacility;
import entities.GoodsInPoint;
import entities.GoodsInWarehouse;
import entities.Log;
import entities.Points;
import entities.Users;
import entities.Warehouses;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Karelin
 */
public class WarServer implements WarInterface {
    private ServerSocket serverSocket;
    private Socket clientSocket;
   
    private Set<Socket> SocketColl=new HashSet<Socket>();
    private ObjectInputStream input;
    private ObjectOutputStream output;
    
    private int SvPort;
    private String LOCALHOST = "localhost";
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WarehousePU");
    private static EntityManager em = emf.createEntityManager();
    
    private Query query;
    private List<Object> list;


    public WarServer() 
    {
        this(DEFAULT_SERVER_PORT);
        System.out.println("Server: Default Server Constructed");
    }
    public WarServer(int port)
    {
        SvPort = port;
        System.out.println("Server: Server(int port) Constructed");
    }
    public static void main(String[] args) 
    {
        System.out.println("Server: main");
        WarServer server = new WarServer();
        if(args.length==0)
        {
            System.out.println("Server: Start Server with Default parameters");
            server.run();
            //server.disconnect();                
        }
        else
        {
            System.out.println("Server: Start Server with Custom parameters");
            server.run();
            // server.disconnect();            
        }
    }
    private void run() 
    { 
        try {serverSocket = new ServerSocket (SvPort);}
        catch (IOException ex) {System.err.println("Server : IO Error in run -> "+ex.getMessage());} 
        while(true)
        {
            try 
            {
                clientSocket = new Socket();
                clientSocket= serverSocket.accept();
                if(!clientSocket.isClosed())
                {
                    ClientThread CT=new ClientThread(this,clientSocket);
                    Thread t1=new Thread(CT);
                    t1.start();
                }
            } 
            catch (IOException ex) {System.err.println("Server : IO Error in run -> "+ex.getMessage());} 
            System.out.println("Server : query executed");
        }    
    }
    /**
     * Transports initial {@link Data} object from {@link ClientThread} object to
     * {@link ServerDb} object and returns modified {@link Data} object to
     * {@link ClientThread} object.
     * @param data Initial {@link Data} object which was obtained from client
     * application.
     * @return modified {@link Data} object
     */
    @Override
    public Data getData(Data data) 
    {  
        int state = data.getOperation();
        switch (state)
        {
            case 2:
                    System.out.println("LOGIN");
                    query = em.createQuery("SELECT u FROM Users u WHERE u.name = '" + 
                            (String)data.getValues().get(0) + "' AND u.password = '" + 
                            (String)data.getValues().get(1) + "'");
                    list  = query.getResultList();
                    if (list.size() == 1)
                        {
                            data.setOperation(0);
                            data.setValues(list);
                        }
                    else
                        data.setOperation(-1); 
                    return data;
            case 3:
                    System.out.println("GETWAREHOUSE");   
                    getCatalog(data, "Warehouses");
                    return data;                    
            case 4:
                    System.out.println("GETFACILITY");
                    getCatalog(data, "Facility");
                    return data;                    
            case 5:
                    System.out.println("NEWUSER");
                    somethingNew(data, "Users", Users.class);
                    return data;
            case 6:
                    System.out.println("NEWWAREHOUSE");
                    somethingNew(data, "Warehouses", Warehouses.class);
                    return data;
            case 7:
                    System.out.println("NEWFACILITY");
                    somethingNew(data, "Facility", Facility.class);
                    return data;
            case 8:
                    System.out.println("NEWGOODS");
                    somethingNew(data, "Goods", Goods.class);
                    return data;  
            case 9:
                    System.out.println("REFRESH");
                    getCatalogs(data);
                    return data;   
            case 10:
                    System.out.println("ARRIVALWAREHOUSE");
                    changeGoods(data, "GoodsInWarehouse", GoodsInWarehouse.class, "warehouses");
                    return data;
            case 11:
                    System.out.println("CONSUMPTIONWAREHOUSE");
                    changeGoods(data, "GoodsInWarehouse", GoodsInWarehouse.class, "warehouses");
                    return data;
            case 12:
                    System.out.println("DELIVERYTOWAREHOUSE");
                    changeGoods(data, "GoodsInWarehouse", GoodsInWarehouse.class, "warehouses");
                    return data;
            case 13:
                    System.out.println("CONSUMPTIONFACILITY");
                    changeGoods(data, "GoodsInFacility", GoodsInFacility.class, "facility");
                    return data;
            case 14:
                    System.out.println("DELIVERYTOFACILITY");
                    changeGoods(data, "GoodsInFacility", GoodsInFacility.class, "facility");
                    return data;
            case 32:
                    System.out.println("ORIGIN");
                    return data;
        }
        return null;
    }
    /**
     * The method closes connection with database.
     * @return error code. The method returns {@link JHelp#OK} if a connection
     * with database ({@link ServerDb} object) closed successfully,
     * otherwise the method returns {@link JHelp#ERROR} or any error code.
     */
    @Override
    public int disconnect() 
    {
        System.out.println("Server : disconnect executed");
        return OK;
    }

    @Override
    public int connect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int connect(String[] args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Data changeGoods(Data data, String str, Class<? extends GoodsInPoint> clazz, String typepoint) {
        try
        {
            em.getTransaction().begin();
            for (Object obj : data.getValues())
            {
                Log log = (Log)obj;                
                query = em.createQuery("SELECT g FROM " + str + " g WHERE g.goodsId.id = '" + 
                                log.getGoodsId().getId() + "' AND g." + typepoint + "Id.id = '" + 
                                log.getActivePointId().getId() + "'");
                list  = query.getResultList();
                if (list.size() == 1)
                {
                    System.err.println("OK!");
                    GoodsInPoint gip = (GoodsInPoint)list.get(0);
                    if (gip.getAmount() + log.getAmount() >= 0)
                    {
                        System.err.println("OK!!1");
                        System.err.println(gip.getAmount() + log.getAmount());
                        gip.setAmount(gip.getAmount() + log.getAmount());
                        em.persist(gip);
                    }
                    else
                    {
                        System.err.println("OK!!2");
                        System.err.println(gip.getAmount() + log.getAmount());
                        data.setOperation(1);
                        log.setGoodsId(gip.getGoodsId());
                        log.setAmount(gip.getAmount());
                        List<Object> a = new ArrayList<Object>();
                        a.add(log);
                        data.setValues(a);
                        break; 
                    }
                }
                else if (list.size() == 0)
                {
                    GoodsInPoint gip = clazz.newInstance();
                    gip.setAmount(log.getAmount());
                    gip.setGoodsId(log.getGoodsId());
                    gip.setPointsId(log.getActivePointId());
                    em.persist(gip);
                }
                log.setAmount(Math.abs(log.getAmount()));
                em.persist(log);
                if (data.getOperation() == 11 || data.getOperation() == 13)
                {
                    if (log.getPassivePointId() != null)
                    {
                        System.err.println("OK!!!1");
                        Delivery deliv = new Delivery();
                        deliv.setGoodsId(log.getGoodsId());
                        deliv.setFromPoint(log.getActivePointId().getName());
                        deliv.setWherePoint(log.getPassivePointId().getName());
                        deliv.setAmount(log.getAmount());
                        deliv.setDocumentNumber(log.getDocumentNumber());
                        em.persist(deliv);
                    }
                }
                if (data.getOperation() == 12 || data.getOperation() == 14)
                {
                    System.err.println("OK!!!2");
                    query = em.createQuery("SELECT g FROM Delivery g WHERE g.wherePoint = '" + 
                                log.getActivePointId().getName() + "' AND g.fromPoint = '" + 
                                log.getPassivePointId().getName() + "' AND g.documentNumber = '" +
                                log.getDocumentNumber() + "' AND g.goodsId.id = '" +
                                log.getGoodsId().getId() + "'");
                    List<Object> resultlist = query.getResultList();
                    if (resultlist.size() == 1)
                    {
                        Delivery deliv = (Delivery)resultlist.get(0);
                        em.remove(deliv);
                    }
                }
            }
            System.err.println(data.getOperation());
            query = em.createQuery("SELECT g FROM " + str + " g WHERE g.amount = '" + 0 + "'");
            list  = query.getResultList();
            if (!list.isEmpty())
            {
                for (Object obj : list)
                {
                    GoodsInPoint gip = (GoodsInPoint)obj;
                    em.remove(gip);
                }
            }
            if (data.getOperation() != 1 && data.getOperation() != -1)
            {
                em.getTransaction().commit();
                data.setOperation(0);
            }
            else
            {em.getTransaction().rollback();}
            System.err.println(data.getOperation());
        }
        catch (Exception ex) 
        {
            System.err.println("Error-> " + ex.getMessage()); 
            data.setOperation(-1);
            em.getTransaction().rollback();
        }
        return data;
    }
    public Data getCatalogs (Data data)
    {
        ArrayList<Object> catalog = new ArrayList<>();
        List<String> arrstr = Arrays.asList("Warehouses", "Facility", "Goods", "GoodsInWarehouse", 
                "GoodsInFacility", "Delivery", "ArrivalWarehouse", "ArrivalFacility", 
                "ConsumptionWarehouse", "ConsumptionFacility");
        for (String str : arrstr)
        {
            query = em.createNamedQuery(str + ".findAll");
            for (Object obj : query.getResultList()) 
            {
                catalog.add(obj);
            }
        }
        list = catalog;
        data.setOperation(0);
        data.setValues(list);
        return data;
    }
    public Data somethingNew (Data data, String str, Class<? extends Points> clazz)
    {
        Points point = (Points)data.getValues().get(0);
        query = em.createQuery("SELECT u FROM " + str + " u WHERE u.name = '" + 
                point.getName() + "'");
        list  = query.getResultList();
        if (list.isEmpty())
            {
                try
                {
                    em.getTransaction().begin();
                    em.persist(point);
                    em.getTransaction().commit();
                    data.setOperation(0);
                }
                catch (Exception ex) 
                {data.setOperation(-1);}
            }
        else
        {data.setOperation(1);}
        return data;
    }
    public Data getCatalog(Data data, String str)
    {
        query = em.createNamedQuery(str + ".findAll");
        list  = query.getResultList();
        data.setOperation(0);
        data.setValues(list);
        return data;
    }
}
