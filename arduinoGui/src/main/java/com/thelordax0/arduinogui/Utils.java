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
public class Utils {
    public static String color;
    public static SerialPort[] getPorts() {
        SerialPort[] ports = SerialPort.getCommPorts();
        return ports;
    }

    public static void connectPort(SerialPort port) {
        SerialPort[] ports = SerialPort.getCommPorts();
    }

    public static void writeData(SerialPort port, String data) throws Exception {
        // Veri gönderme
        // Göndermek istediğiniz veri

        if (port.isOpen()) {
            port.writeBytes(data.getBytes(), data.length());
        } else {
            throw new Exception("Closed Port Exception");
        }

    }

    public static String readData(SerialPort port) throws Exception {
        if (port.isOpen()) {
            byte[] readBuffer = new byte[1024];
            int bytesRead;
            StringBuilder receivedDataBuffer = new StringBuilder(); // Gelen veriyi bir arabellekte biriktir

            
                
                    bytesRead = port.readBytes(readBuffer, readBuffer.length);
                    String receivedData = new String(readBuffer, 0, bytesRead);
                    receivedDataBuffer.append(receivedData);

                    
                        // Veriyi ayracı kullanarak işleyin (örneğin, \n karakteri)
                        String completeData = receivedDataBuffer.toString();

                        // Veriyi sıfırlayın
                        receivedDataBuffer.setLength(0);

                        return completeData;
                    
                    

                
            
            
        }else{
            throw new Exception("Closed Port Exception");
        }
    }

    
       

}
