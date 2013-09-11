package com.search.bean;

import java.util.List;
import java.util.Map;

public class ResultBean {

	Map<String, List<FacetBean>>   facetGroupMap;
	List<ProductBean> productBean;
	
	public  Map<String, List<FacetBean>>   getFacetGroupList() {
		return facetGroupMap;
	}

	public void setFacetGroupList(Map<String, List<FacetBean>>  facetMap) {
		this.facetGroupMap = facetMap;
	}


	public List<ProductBean> getProductBean() {
		return productBean;
	}

	public void setProductBean(List<ProductBean> productBean) {
		this.productBean = productBean;
	}

}
