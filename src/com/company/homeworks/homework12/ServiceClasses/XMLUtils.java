package com.company.homeworks.homework12.ServiceClasses;

import com.company.homeworks.homework12.Devices.Device;
import com.company.homeworks.homework12.Devices.Type;
import com.sun.tools.xjc.BadCommandLineException;
import com.sun.tools.xjc.Driver;
import com.sun.tools.xjc.XJCListener;
import generated.Devices;
import generated.ObjectFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class XMLUtils {

    private static final String RESOURCES_DIR = "resources";
    private static final String HOMEWORK_12 = "homework12";

    private XMLUtils(){
        throw new UnsupportedOperationException();
    }

    public static boolean validateXml(String schemaFileName, String xmlFileName){
        boolean result = false;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(Path.of(RESOURCES_DIR, HOMEWORK_12, schemaFileName).toFile());
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(Files.newInputStream(Path.of(RESOURCES_DIR, HOMEWORK_12, xmlFileName))));
            result = true;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void marshallToXml(Devices jaxbDevices, String xmlFileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(Devices.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(jaxbDevices, Path.of(RESOURCES_DIR, HOMEWORK_12, xmlFileName).toFile());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static boolean generateJAXBObjects(String directoryToGenerate, String schemaName) {
        boolean result = false;
        try {
            Driver.run(new String[]{"-d", directoryToGenerate, schemaName}, new XJCListener() {
                @Override
                public void error(SAXParseException e) {
                    e.printStackTrace();
                }

                @Override
                public void fatalError(SAXParseException e) {
                    e.printStackTrace();
                }

                @Override
                public void warning(SAXParseException e) {
                    e.printStackTrace();
                }

                @Override
                public void info(SAXParseException e) {
                    e.printStackTrace();
                }
            });
            result = true;
        } catch (BadCommandLineException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static generated.Device getJaxbDevice(Device device, Type type){
        ObjectFactory factory = new ObjectFactory();

        generated.Type jaxbDeviceType = factory.createType();
        jaxbDeviceType.setPeripheral(type.isPeripheral());
        jaxbDeviceType.setPresenceOfCooler(type.isPresenceOfCooler());
        jaxbDeviceType.setEnergyConsumption(type.getEnergyConsumption());

        generated.Device jaxbDevice = factory.createDevice();
        jaxbDevice.setName(device.getName());
        jaxbDevice.setCritical(device.isCritical());
        jaxbDevice.setId(device.getId());
        jaxbDevice.setOrigin(device.getOrigin());
        jaxbDevice.setPrice(device.getPrice());
        jaxbDevice.setType(jaxbDeviceType);
        return jaxbDevice;
    }
}