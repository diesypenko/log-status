package com.fileparser.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.Map;

public class XmlWriterService {

    public void writeStatistics(Map<String, Integer> stats, String attributeName) {

        StatisticsWrapper wrapper = new StatisticsWrapper(stats);

        try {
            JAXBContext context = JAXBContext.newInstance(StatisticsWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File file = new File("statistics_by_" + attributeName + ".xml");
            marshaller.marshal(wrapper, file);

            System.out.println("Statistics written to " + file.getAbsolutePath());

        } catch (Exception e) {
            throw new RuntimeException("Error writing XML file", e);
        }
    }
}
