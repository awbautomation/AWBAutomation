package com.awb.test.core.util;
import java.util.LinkedList;

/**
 * This class contains the list of commands that were run be selenium.
 * 
 * @author sshyamala
 */
public class CommandList {
    
    /**
     * Queue object for collecting commands
     */
    private LinkedList list = new LinkedList();   
  
    
    /**
     * CommandList instance
     */
    private static CommandList instance = new CommandList();
    
    /**
     * Default Constructor
     */
    public CommandList() { }
    
    /**
     * Return the instance of this object.
     * 
     * @return The instance of this object 
     */
    public static CommandList getInstance() { return instance; }
    
    /**
     * Add a command to the list.
     * 
     * @param s the command that was run 
     */
    public void addToList(String s) { list.add(s); }
    
    /**
     * Removes all commands in the list.
     */
    public void clear() { list.clear(); }
    
    /**
     * Get all of the commands in the list.
     * 
     * @return 
     */
    public String[] getAllInList() { 
        
        Object[] objectList = list.toArray();
        
        String[] stringList = new String[objectList.length];

        for (int i = 0; i < objectList.length; i++) stringList[i] = objectList[i].toString();

        return stringList; 
    
    }
    
    /**
     * Get the size of the list.
     * 
     * @return 
     */
    public int getSize() { return list.size(); }
    
    /**
     * Indicates if command list contains no commands
     * 
     * @return 
     */
    public boolean isEmpty() {
        
        return (getSize() == 0);
        
    }
            
}