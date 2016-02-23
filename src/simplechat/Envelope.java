/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechat;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author wills5140
 */
public class Envelope implements Serializable {

    private String key;
    private Object data;
    private File file;
    private String destinationUserName;

    public Envelope() {
    }

    public Envelope(String key, Object data) {
        this.setKey(key);
        this.setData(data);
    }
    
    public Envelope(String key, Object data, File file){
        this.setKey(key);
        this.setData(data);
        this.setFile(file);
    }
    
        public Envelope(String key,File file, String destinationusername){
        this.setKey(key);
        this.setFile(file);
        this.setDestinationUserName(destinationusername);
    }
    public Envelope(String key, Object data, File file, String destinationusername){
        this.setKey(key);
        this.setData(data);
        this.setFile(file);
        this.setDestinationUserName(destinationusername);
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

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @return the destinationUserName
     */
    public String getDestinationUserName() {
        return destinationUserName;
    }

    /**
     * @param destinationUserName the destinationUserName to set
     */
    public void setDestinationUserName(String destinationUserName) {
        this.destinationUserName = destinationUserName;
    }
}
