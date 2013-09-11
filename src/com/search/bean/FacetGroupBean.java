package com.search.bean;

import java.util.List;

public class FacetGroupBean {

	public String facetName;
	public List<FacetBean> facetBeanList;

	public String getFacetName() {
		return facetName;
	}

	public void setFacetName(String facetName) {
		this.facetName = facetName;
	}

	public List<FacetBean> getFacetBeanList() {
		return facetBeanList;
	}

	public void setFacetBeanList(List<FacetBean> facetBeanList) {
		this.facetBeanList = facetBeanList;
	}

	
}
