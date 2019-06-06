/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Karelin
 */
public class Data implements Serializable {
    
    private int operation;
    private List<Object> values;

    
    public Data() {
        this(WarInterface.ORIGIN, null);
    }

   
    public Data(int operation, List<Object> values) {
        this.operation = operation;
        this.values = values;
    }

   
    public int getOperation() {
        return operation;
    }

    
    public void setOperation(int operation) {
        this.operation = operation;
    }
    
    
    public List<Object> getValues() {
        return values;
    }

    
    public void setValues(List<Object> values) {
        this.values = values;
    }
}
