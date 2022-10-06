package by.epam.hw12.remake.dao_project.entity;

import java.util.HashMap;
import java.util.Map;

public class Property {

	private String categoryName;

	private Map<String, Object> properties = new HashMap<>();

	public Property(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public void addProperty(String propertyName, Object propertyValue) {
		properties.put(propertyName, propertyValue);
	}

}
