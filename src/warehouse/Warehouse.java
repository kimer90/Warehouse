/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import entities.Users;
import frames.LoginUI;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



/**
 *
 * @author Karelin
 */
public class Warehouse implements WarInterface { 
    
    private static String clientStatus;
    private static String clientPoint = null;
    
    private Data data;
    private Data test;
    
    private Socket clientSocket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    
    public static void main(String[] args) {
        LoginUI login = new LoginUI();
        login.setVisible(true);        
    }
    public void run(Data data) 
    {
        System.out.println("Client: run started");
        getData(data);
        System.out.println("Client: getData executed");
    }
    
    @Override
    public int connect() 
    {
        String[] args = {};
        return this.connect(args);
    }
    @Override
    public int connect(String[] args) 
    {
        String host = "localhost";
        int port=WarInterface.DEFAULT_SERVER_PORT;
        System.out.println("Client: connect");
        try 
        {
            clientSocket = new Socket (host, port);
            output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("SUCCESSFULLY connected with Warserver!");
            return WarInterface.OK;
        } 
        catch (IOException ex) {System.out.println("Client:IO error in connect(args)");}
        return WarInterface.ERROR;
     }
    @Override
    public Data getData(Data data) {          
        try 
        {
            output.writeObject(data);            
            test = (Data)input.readObject();
            if (test.getOperation() != -1 && data.getOperation() == 2)
            {
                clientStatus = ((Users)test.getValues().get(0)).getStatus();
                System.out.println("Status: " + ((Users)test.getValues().get(0)).getStatus());
            }
        } 
        catch (ClassNotFoundException ex) {System.err.println("Client : getData Class definition error -> "+ex.getMessage());} 
        catch (IOException ex) {System.err.println("Client : getData IO error -> "+ ex.getMessage());}
        return null;
    }
    @Override
    public int disconnect() 
    {
        System.out.println("Client: disconnect executed");
        return WarInterface.DISCONNECT;    
    }
    
    public static void setClientPoint(String clientPoint) {
        Warehouse.clientPoint = clientPoint;
    }
    public static void setClientStatus(String clientStatus) {
        Warehouse.clientStatus = clientStatus;
    }
    public static String getClientPoint() {
        return clientPoint;
    }
    public static String getClientStatus() {
        return clientStatus;
    }   
    public Data getData() {
        return data;
    }
    public Data getTest() {
        return test;
    }
    
}
