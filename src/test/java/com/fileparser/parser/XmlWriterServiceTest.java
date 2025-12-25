package com.fileparser.parser;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fileparser.service.XmlWriterService;

class XmlWriterServiceTest {

	@Test
	void testXmlWrite() throws Exception {
	    XmlWriterService writer = new XmlWriterService();

	    Map<String, Integer> stats = Map.of(
	            "Pending", 2,
	            "Completed", 1
	    );

	    writer.writeStatistics(stats, "status");

	    File out = new File("statistics_by_status.xml");

	    assertTrue(out.exists());
	    assertTrue(out.length() > 0);
	}

}
