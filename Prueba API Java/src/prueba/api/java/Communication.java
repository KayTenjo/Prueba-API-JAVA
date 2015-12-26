/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.api.java;

import com.fazecast.jSerialComm.*;
import java.util.Scanner;

/**
 *
 * @author kayjt
 */
public class Communication {
    
    SerialPort port;
    Scanner scanner;
    
    public Communication()
    {
    }
    public Communication(String portName, int baudRate)  
    {
        port = SerialPort.getCommPort(portName);
        port.setBaudRate(baudRate);
        port.openPort();
        scanner = new Scanner(port.getInputStream());
    }

    public String[] getPortNames() {

        String [] portNames = new String [SerialPort.getCommPorts().length];
        for (int i=0; i < SerialPort.getCommPorts().length; i++){
        
            portNames[i] = SerialPort.getCommPorts()[i].getSystemPortName();
            
        }
        return portNames;      
    }

    public void openPort(String portName, int baudRate)
    {
        scanner.close();
        port.closePort();
        port = SerialPort.getCommPort(portName);
        port.setBaudRate(baudRate);
        port.openPort();
    }

    public void write(String data)
    {
        byte[] buffer = data.getBytes();
        port.writeBytes(buffer, buffer.length);
    }

    public String ReadLine()
    {
        return scanner.nextLine();
        
    }

    public void ClosePort()
    {
        scanner.close();
        port.closePort();
    }
   
}
