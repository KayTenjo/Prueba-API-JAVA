/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.api.java;

import java.util.List;

/**
 *
 * @author kayjt
 */
public class Glove {
    
    
    Communication communication = new Communication();
    MessageGenerator messageGenerator = new MessageGenerator();

    public void openPort(String portName, int baudRate)
    {
        communication.openPort(portName,baudRate);
    }

    public void closePort()
    {
        communication.closePort();
    }

    public String[] getPortNames()
    {
        return communication.getPortNames();
    }

    public void initializeMotor(List<Integer> pins)
    {
        String message = messageGenerator.initializeMotor(pins);
        communication.write(message);
    }

    public void activateMotor(List<Integer> pins, List<String> values)
    {
        String message = messageGenerator.activateMotor(pins,values);
        communication.write(message);
    }

    public String readLine()
    {
        return communication.readLine();
    }

    public void write(String message)
    {
        communication.write(message);
    }

    public String analogRead(int pin)
    {
        String message = messageGenerator.analogRead(pin);
        communication.write(message);
        String value = communication.readLine();
        return value;
    }

    public String digitalRead(int pin)
    {
        String message = messageGenerator.digitalRead(pin);
        communication.write(message);
        String value = communication.readLine();
        return value;
    }

    public void pinMode(int pin, String mode)
    {
        String message = messageGenerator.pinMode(pin,mode);
        communication.write(message);
    }
    public void pinMode(List<Integer> pins, List<String> modes)
    {
        String message = messageGenerator.pinMode(pins, modes);
        communication.write(message);
    }

    public void digitalWrite(int pin, String value)
    {
        String message = messageGenerator.digitalWrite(pin, value);
        communication.write(message);
    }

    public void digitalWrite(List<Integer> pins, List<String> values)
    {
        String message = messageGenerator.digitalWrite(pins, values);
        communication.write(message);
    }

    public void analogWrite(int pin, int value)
    {
        String message = messageGenerator.analogWrite(pin, value);
        communication.write(message);
    }

    public void analogWrite(List<Integer> pins, List<Integer> values)
    {
        String message = messageGenerator.analogWrite(pins, values);
        communication.write(message);

    }
}
