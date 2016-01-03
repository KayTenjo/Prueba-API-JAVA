/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.api.java;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author kayjt
 */
public class MessageGenerator {
    
    static final private String SEPARATOR = ",";
    static final private String TERMINAL = "s";
    static final private String INITIALIZE_MOTOR_FUNCTION_NUMBER = "1";
    static final private String ACTIVATE_MOTOR_FUNCTION_NUMBER = "2";
    static final private String ANALOG_READ_FUNCTION_NUMBER = "3";
    static final private String DIGITAL_READ_FUNCTION_NUMBER = "4";
    static final private String INITIALIZE_DIGITAL_INPUT_FUNCTION_NUMBER = "5";
    static final private String PIN_MODE_FUNCTION_NUMBER = "6";
    static final private String DIGITAL_WRITE_FUNCTION_NUMBER = "7";
    static final private String ANALOG_WRITE_FUNCTION_NUMBER = "8";

    public String initializeMotor(Collection<Integer> pins)
    {
        if (pins.isEmpty())
        {
            throw new IllegalArgumentException("List must have at least one element");
        }
        StringBuilder initializeMessage = new StringBuilder();

        initializeMessage.append(INITIALIZE_MOTOR_FUNCTION_NUMBER + SEPARATOR + pins.size());

        for(int pin : pins)
        {
            String message = SEPARATOR + pin;
            initializeMessage.append(message);
        }

        initializeMessage.append(TERMINAL);
        return initializeMessage.toString();

    }

    public String activateMotor(Collection<Integer> pins, Collection<String> values)
    {

        if (pins.size() != values.size())
        {
            throw new IllegalArgumentException("Lists length must be equal");
        }

        StringBuilder activateMessage = new StringBuilder();

        activateMessage.append(ACTIVATE_MOTOR_FUNCTION_NUMBER + SEPARATOR + pins.size());

        for (int i = 0; i < pins.size(); i++)
        {
            String value = "";

            if (values.get(i).equals("HIGH"))
            {
                value = "-1";
            }

            else if (values.get(i).equals("LOW"))
            {
                value = "-2";
            }

            else
            {
                try
                {

                    int valueAux = Integer.parseInt(values.get(i));
                    
                    if ((valueAux < 256) && (valueAux >= 0))
                    {
                        value = Integer.toString(valueAux);
                    }

                    else
                    {
                        throw new IllegalArgumentException("Values must be between 0 and 255");
                    }

                }

                catch (NumberFormatException e)
                {
                    
                    throw new IllegalArgumentException("Invalid value " + values.get(i));
                }

            }

            String message = SEPARATOR + pins.get(i) + SEPARATOR + value;
            activateMessage.append(message);
        }

        activateMessage.append(TERMINAL);

        return activateMessage.toString();

    }

    public String analogRead(int pin)
    {
        String message = ANALOG_READ_FUNCTION_NUMBER + SEPARATOR + pin + TERMINAL;
        return message;
    }

    public String digitalRead(int pin)
    {
        String message = DIGITAL_READ_FUNCTION_NUMBER + SEPARATOR + pin + TERMINAL;
        return message;
    }

    public String pinMode(int pin, String mode)
    {
        String modeProtocol = "";

        if (mode.equals("INPUT"))
        {
            modeProtocol = "1";
        }

        else if (mode .equals("OUTPUT"))
        {
            modeProtocol = "2";
        }

        else
        {
            throw new IllegalArgumentException(mode + " is not a valid mode");
        }

        String message = PIN_MODE_FUNCTION_NUMBER + SEPARATOR + "1" + SEPARATOR + pin + SEPARATOR 
            + modeProtocol + TERMINAL;
        return message;
    }
    public String pinMode(List<Integer> pins, List<String> modes)
    {
        if (pins.size() != modes.size())
        {
            throw new IllegalArgumentException("Lists length must be equal");
        }

        StringBuilder pinModeMessage = new StringBuilder();
        pinModeMessage.append(PIN_MODE_FUNCTION_NUMBER + SEPARATOR + pins.size());

        for (int i = 0; i < pins.size(); i++)
        {
            String modeProtocol = "";

            if (modes.get(i).equals("INPUT"))
            {
                modeProtocol = "1";
            }

            else if (modes.get(i).equals("OUTPUT"))
            {
                modeProtocol = "2";
            }

            else
            {
                throw new IllegalArgumentException(modes.get(i) + " is not a valid mode");
            }

            String message = SEPARATOR + pins.get(i) + SEPARATOR + modeProtocol;
            pinModeMessage.append(message);

        }

        pinModeMessage.append(TERMINAL);
        return pinModeMessage.toString();

}

    public String digitalWrite(int pin, String value)
    {
        String valueProtocol = "";

        if (value.equals("LOW"))
        {
            valueProtocol = "0";
        }

        else if (value.equals("HIGH"))
        {
            valueProtocol = "1";
        }

        else
        {
            throw new IllegalArgumentException(value + " is not a valid value");
        }

        String message = DIGITAL_WRITE_FUNCTION_NUMBER + SEPARATOR + "1" + SEPARATOR +
            pin + SEPARATOR + valueProtocol + TERMINAL;
        return message;
    }

    public String digitalWrite(List<Integer> pins, List<String> values)
    {
        if (pins.size() != values.size())
        {
            throw new IllegalArgumentException("Lists length must be equal");
        }

        StringBuilder digitalWriteMessage = new StringBuilder();
        digitalWriteMessage.append(DIGITAL_WRITE_FUNCTION_NUMBER + SEPARATOR + pins.size());

        for (int i = 0; i < pins.size(); i++)
        {
            String valueProtocol = "";

            if (values.get(i).equals("LOW") )
            {
                valueProtocol = "0";
            }

            else if (values.get(i).equals("HIGH") )
            {
                valueProtocol = "1";
            }

            else
            {
                throw new IllegalArgumentException(values.get(i) + " is not a valid value");
            }

            String message = SEPARATOR + pins.get(i) + SEPARATOR + valueProtocol;
            digitalWriteMessage.append(message);

        }

        digitalWriteMessage.append(TERMINAL);
        return digitalWriteMessage.toString();
    }

    public String analogWrite(int pin, int value)
    {
        String message = ANALOG_WRITE_FUNCTION_NUMBER + SEPARATOR + "1" + SEPARATOR + pin 
            + SEPARATOR + value + TERMINAL;
        return message;
    }

    public String analogWrite(List<Integer> pins, List<Integer> values)
    {
        if (pins.size() != values.size())
        {
            throw new IllegalArgumentException("Lists length must be equal");
        }

        StringBuilder analogWriteMessage = new StringBuilder();
        analogWriteMessage.append(ANALOG_WRITE_FUNCTION_NUMBER + SEPARATOR + pins.size());

        for (int i = 0; i < pins.size(); i++)
        {

            String message = SEPARATOR + pins.get(i) + SEPARATOR + values.get(i);
            analogWriteMessage.append(message);

        }

        analogWriteMessage.append(TERMINAL);
        return analogWriteMessage.toString();

    }
 
}
