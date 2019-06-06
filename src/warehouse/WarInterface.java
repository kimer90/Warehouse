/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

/**
 *
 * @author Karelin
 */
public interface WarInterface {
    /**
     * Present situation when any method complets properly
     */
    public static final int OK = 0;
    /**
     * Present situation when any method make an error
     */
    public static final int ERROR = -1;
    /**
     * Present situation when any server is connected and can process requests.
     */
    public static final int NOTAVAILABLE = 1;
    /**
     * Present situation when any server is disconnected
     */
    public static final int DISCONNECT = -2;
    
    public static final int LOGIN = 2;
    
    public static final int GETWAREHOUSE = 3;
    
    public static final int GETFACILITY = 4;
    
    public static final int NEWUSER = 5;
    
    public static final int NEWWAREHOUSE = 6;
    
    public static final int NEWFACILITY = 7;
    
    public static final int NEWGOODS = 8;
    
    public static final int REFRESH = 9;
    
    public static final int ARRIVALWAREHOUSE = 10;
    
    public static final int CONSUMPTIONWAREHOUSE = 11;
    
    public static final int DELIVERYTOWAREHOUSE = 12;
    
    public static final int CONSUMPTIONFACILITY = 13;
    
    public static final int DELIVERYTOFACILITY = 14;
    
    public static final int ORIGIN = 32;
    
    public static final int DEFAULT_SERVER_PORT = 12345;

    
    int connect();

    
    int connect(String[] args); //connect to server and initialize it;

    
    Data getData(Data data); // send him termin and getting manual in Data format

    
    int disconnect(); //anticonnect
}
