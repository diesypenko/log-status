package com.fileparser.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.Map;

public class XmlWriterService {
    public static final String FILENAME_prefix = "statistics_by_";

    public void writeStatistics(Map<String, Integer> stats, String attributeName) {

        StatisticsWrapper wrapper = new StatisticsWrapper(stats);

        try {
            JAXBContext context = JAXBContext.newInstance(StatisticsWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File file = new File(FILENAME_prefix + attributeName + ".xml");
            marshaller.marshal(wrapper, file);

            System.out.println("Statistics written to " + file.getAbsolutePath());

        } catch (Exception e) {
            throw new RuntimeException("Error writing XML file", e);
        }
    }
}
