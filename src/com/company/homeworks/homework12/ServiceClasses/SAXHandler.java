package com.company.homeworks.homework12.ServiceClasses;

import com.company.homeworks.homework12.Devices.Device;
import com.company.homeworks.homework12.Devices.Devices;
import com.company.homeworks.homework12.Devices.Type;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;

public class SAXHandler extends DefaultHandler {

    private static Devices devices = new Devices(new LinkedList<>());
    private String name;
    private String origin;
    private String price;
    private boolean critical;
    private String id;
    private boolean peripheral;
    private boolean presenceOfCooler;
    private int energyConsumption;
    private String thisElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = localName;
        for (int i = 0; i < attributes.getLength(); i++) {
            id = attributes.getValue(i);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (!"".equals(thisElement)) {
            if ("name".equalsIgnoreCase(thisElement)) {
                name = value;
            } else if ("origin".equalsIgnoreCase(thisElement)) {
                origin = value;
            } else if ("price".equalsIgnoreCase(thisElement)) {
                price = value;
            } else if ("critical".equalsIgnoreCase(thisElement)) {
                critical = Boolean.parseBoolean(value);
            } else if ("peripheral".equalsIgnoreCase(thisElement)) {
                peripheral = Boolean.parseBoolean(value);
            } else if ("presenceOfCooler".equalsIgnoreCase(thisElement)) {
                presenceOfCooler = Boolean.parseBoolean(value);
            } else if ("energyConsumption".equalsIgnoreCase(thisElement)) {
                energyConsumption = Integer.parseInt(value);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        thisElement = "";
        if ("devices".equals(localName)) {
            devices.getDevices().add(
                    new Device(name, origin, price, critical, id,
                            new Type(peripheral, presenceOfCooler, energyConsumption)));
        }
    }

    public static Devices getDevices() {
        return devices;
    }
}
