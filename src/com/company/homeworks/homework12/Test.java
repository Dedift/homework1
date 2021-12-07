package com.company.homeworks.homework12;

import com.company.homeworks.homework12.Devices.Device;
import com.company.homeworks.homework12.Devices.Devices;
import com.company.homeworks.homework12.Devices.Type;
import com.company.homeworks.homework12.ServiceClasses.SAXHandler;
import com.company.homeworks.homework12.ServiceClasses.XMLUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import generated.ObjectFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Test {

    private static final String RESOURCES_DIR = "resources";
    private static final String SRC = "src";
    private static final String HOMEWORK_12 = "homework12";
    private static final String SCHEMA = "Schema.xsd";
    private static final String DEVICES_XML = "devices.xml";
    private static final String DEVICES_JSON = "devices.json";

    public static void main(String[] args) {
        //Create POJO
        XMLUtils.generateJAXBObjects(SRC, RESOURCES_DIR + File.separator + HOMEWORK_12 + File.separator + SCHEMA);

        //Create XML
        Type cpuType = new Type(false, true, 12);
        Device cpu = new Device("CPU", "China", "212.32", true, "KS3934JS234", cpuType);

        Type monitorType = new Type(true, false, 22);
        Device monitor = new Device("Monitor", "China", "242.83",
                false, "KFYL4969JS898", monitorType);

        Type microphoneType = new Type(true, false, 123);
        Device microphone = new Device("Microphone", "Russia", "345.23",
                false, "LHEP7900KY686", microphoneType);

        Type headphonesType = new Type(true, false, 25);
        Device headphones = new Device("Headphones", "China", "122.35",
                false, "PHVJ7948TI950", headphonesType);

        Type keyboardType = new Type(true, false, 43);
        Device keyboard = new Device("Keyboard", "China", "200.46",
                false, "FYJO7830RI684", keyboardType);

        Type mouseType = new Type(true, false, 23);
        Device mouse = new Device("Mouse", "Russia", "110.85",
                false, "UMOD5308PO768", mouseType);

        Type powerUnitType = new Type(false, false, 67);
        Device powerUnit = new Device("PowerUnit", "China", "125.85",
                true, "PNYJ5795PK697", powerUnitType);

        Type computerCaseType = new Type(false, false, 0);
        Device computerCase = new Device("Case", "China", "153.21",
                false, "UVSR9080QY468", computerCaseType);

        Type blueRayDriveType = new Type(true, false, 5);
        Device blueRayDrive = new Device("BlueRayDrive", "Belarus", "124.32",
                false, "JSNA7800PF789", blueRayDriveType);

        Type dvdDriveType = new Type(true, false, 3);
        Device dvdDrive = new Device("DVDDrive", "Belarus", "121.63",
                false, "USPA4698GU570", dvdDriveType);

        Type ssdType = new Type(false, true, 35);
        Device ssd = new Device("SSD", "China", "256.92",
                true, "VBSI6786HD795", ssdType);

        Type hddType = new Type(false, true, 12);
        Device hdd = new Device("HDD", "Russia", "222.63",
                true, "KSPA0135JI678", hddType);

        Type ramType = new Type(false, true, 52);
        Device ram = new Device("RAM", "China", "125.83",
                true, "LOPN6729KI47", ramType);

        Type graphicsCardType = new Type(false, true, 42);
        Device graphicsCard = new Device("GraphicsCard", "Belarus", "221.74",
                true, "LODP8987NU689", graphicsCardType);

        Type motherboardType = new Type(false, true, 72);
        Device motherboard = new Device("Motherboard", "Russia", "243.72",
                true, "FHSN8790NS789", motherboardType);

        ObjectFactory factory = new ObjectFactory();

        generated.Device jaxbCpu = XMLUtils.getJaxbDevice(cpu, cpuType);
        generated.Device jaxbMonitor = XMLUtils.getJaxbDevice(monitor, monitorType);
        generated.Device jaxbMicrophone = XMLUtils.getJaxbDevice(microphone, microphoneType);
        generated.Device jaxbMouse = XMLUtils.getJaxbDevice(mouse, mouseType);
        generated.Device jaxbHdd = XMLUtils.getJaxbDevice(hdd, hddType);
        generated.Device jaxbDvdDrive = XMLUtils.getJaxbDevice(dvdDrive, dvdDriveType);
        generated.Device jaxbComputerCase = XMLUtils.getJaxbDevice(computerCase, computerCaseType);
        generated.Device jaxbBlueRayDrive = XMLUtils.getJaxbDevice(blueRayDrive, blueRayDriveType);
        generated.Device jaxbGraphicsCard = XMLUtils.getJaxbDevice(graphicsCard, graphicsCardType);
        generated.Device jaxbHeadphones = XMLUtils.getJaxbDevice(headphones, headphonesType);
        generated.Device jaxbKeyboard = XMLUtils.getJaxbDevice(keyboard, keyboardType);
        generated.Device jaxbMotherboard = XMLUtils.getJaxbDevice(motherboard, motherboardType);
        generated.Device jaxbPowerUnit = XMLUtils.getJaxbDevice(powerUnit, powerUnitType);
        generated.Device jaxbRam = XMLUtils.getJaxbDevice(ram, ramType);
        generated.Device jaxbSsd = XMLUtils.getJaxbDevice(ssd, ssdType);

        generated.Devices jaxbDevices = factory.createDevices();
        jaxbDevices.getDevices().add(jaxbCpu);
        jaxbDevices.getDevices().add(jaxbMonitor);
        jaxbDevices.getDevices().add(jaxbMicrophone);
        jaxbDevices.getDevices().add(jaxbMouse);
        jaxbDevices.getDevices().add(jaxbHdd);
        jaxbDevices.getDevices().add(jaxbDvdDrive);
        jaxbDevices.getDevices().add(jaxbComputerCase);
        jaxbDevices.getDevices().add(jaxbBlueRayDrive);
        jaxbDevices.getDevices().add(jaxbGraphicsCard);
        jaxbDevices.getDevices().add(jaxbHeadphones);
        jaxbDevices.getDevices().add(jaxbKeyboard);
        jaxbDevices.getDevices().add(jaxbMotherboard);
        jaxbDevices.getDevices().add(jaxbPowerUnit);
        jaxbDevices.getDevices().add(jaxbRam);
        jaxbDevices.getDevices().add(jaxbSsd);

        XMLUtils.marshallToXml(jaxbDevices, DEVICES_XML);

        //Parsing
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        saxFactory.setNamespaceAware(true);
        try {
            SAXParser parser = saxFactory.newSAXParser();
            parser.parse(Path.of(RESOURCES_DIR, HOMEWORK_12, DEVICES_XML).toFile(), new SAXHandler());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        //Create JSON
        Devices saxHandlerDevices = SAXHandler.getDevices();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(
                            Path.of(RESOURCES_DIR, HOMEWORK_12, DEVICES_JSON).toFile(),
                            saxHandlerDevices
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Create devises from JSON
        if (XMLUtils.validateXml(SCHEMA, DEVICES_XML)) {
            try {
                Devices devicesFromJson = objectMapper.readValue(Path.of(RESOURCES_DIR, HOMEWORK_12, DEVICES_JSON).toFile(), Devices.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
