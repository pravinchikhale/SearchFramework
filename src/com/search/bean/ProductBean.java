package com.search.bean;

import java.util.List;

public class ProductBean {

	public String sku;
	public List<PropertyBean> properties;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public List<PropertyBean> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyBean> propertyBeanList) {
		this.properties = propertyBeanList;
	}
}
