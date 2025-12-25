package com.fileparser.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "statistics")
public class StatisticsWrapper {

	private List<Item> items = new ArrayList<>();

	public StatisticsWrapper() {
	}

	public StatisticsWrapper(Map<String, Integer> stats) {
		if (stats != null) {
			for (Map.Entry<String, Integer> entry : stats.entrySet()) {
				items.add(new Item(entry.getKey(), entry.getValue()));
			}
			items.sort(Comparator.comparingInt(Item::getCount).reversed());
		}
	}

	@XmlElement(name = "item")
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@XmlType(propOrder = { "value", "count" })
	public static class Item {
		private String value;
		private int count;

		public Item() {
		}

		public Item(String value, int count) {
			this.value = value;
			this.count = count;
		}

		@XmlElement
		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		@XmlElement
		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
	}

}
