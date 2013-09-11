package com.search.bean;

public class FacetBean {

	public String facetName;
	public long facetID;
	public String facetURL;
	public int binCount;

	public String getFacetName() {
		return facetName;
	}

	public void setFacetName(String facetName) {
		this.facetName = facetName;
	}

	public long getFacetID() {
		return facetID;
	}

	public void setFacetID(long facetID) {
		this.facetID = facetID;
	}

	public String getFacetURL() {
		return facetURL;
	}

	public void setFacetURL(String facetURL) {
		this.facetURL = facetURL;
	}

	public int getBinCount() {
		return binCount;
	}

	public void setBinCount(int binCount) {
		this.binCount = binCount;
	}
}
