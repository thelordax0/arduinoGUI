/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thelordax0.arduinogui;
import com.fazecast.jSerialComm.SerialPort;

/**
 *
 * @author musta
 */
public class ReadDataThread extends Thread{
    private String name;
    private SerialPort port;
    private String data;
    private long interval;
    public ReadDataThread(String name,SerialPort port,int interval){
        this.name=name;
        this.port=port;
        this.interval=interval;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }



    public SerialPort getPort() {
        return port;
    }

    public void setPort(SerialPort port) {
        this.port = port;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    
    
    
    @Override
    public void run() {
        
            try {
            data=Utils.readData(port);
            System.out.println(data);
            Thread.sleep(interval);
            
        } catch (Exception e) {
            System.out.println("read error");
           
        }
            
        
        
    }
    
    
}
