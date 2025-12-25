package com.fileparser.parser;

import java.io.File;
import java.util.List;

import com.fileparser.model.Order;

public interface OrderJsonParser {
	List<Order> parse(File file) throws ParserException;
}
