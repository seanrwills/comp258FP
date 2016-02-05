/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechat;
import java.io.Serializable;
/**
 *
 * @author wills5140
 */
public class Envelope implements Serializable{
    private String key;
    private Object data;
    
    public Envelope(){}
    public Envelope(String key, Object data){
        this.setKey(key);
        this.setData(data);
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }
}
