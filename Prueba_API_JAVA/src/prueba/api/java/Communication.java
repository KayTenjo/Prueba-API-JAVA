/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.api.java;

import com.fazecast.jSerialComm.*;
import java.util.Scanner;


public class Communication {
    
    SerialPort port;
    //Scanner scanner;
    
    public Communication()
    {
    }
    public Communication(String portName, int baudRate)  
    {
        port = SerialPort.getCommPort(portName);
        port.setBaudRate(baudRate);
        port.openPort();
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 1000, 0);
        
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
        
        port = SerialPort.getCommPort(portName);
        port.setBaudRate(baudRate);
        port.openPort();
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 1000, 0);

    }

    public void write(String data)
    {
        byte[] buffer = data.getBytes();
        port.writeBytes(buffer, buffer.length);
    }

    public String readLine()
    {
        Scanner scanner = new Scanner(port.getInputStream());
        String line ="";
		
	if(scanner.hasNextLine()){
        
            line = scanner.nextLine();
        }
        
        scanner.close();	
        return line;
        
    }

    public void closePort()
    {
        port.closePort();
    }
   
}
