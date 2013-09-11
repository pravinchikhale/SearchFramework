package com.search.result.process;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.endeca.navigation.DimGroup;
import com.endeca.navigation.DimGroupList;
import com.endeca.navigation.DimVal;
import com.endeca.navigation.DimValList;
import com.endeca.navigation.Dimension;
import com.endeca.navigation.ENEQueryResults;
import com.endeca.navigation.ERec;
import com.endeca.navigation.ERecList;
import com.endeca.navigation.Navigation;
import com.endeca.navigation.Property;
import com.endeca.navigation.PropertyMap;
import com.search.bean.FacetBean;
import com.search.bean.FacetGroupBean;
import com.search.bean.ProductBean;
import com.search.bean.PropertyBean;
import com.search.bean.ResultBean;

public class ResultProcessor {

	public ResultBean processResult(ENEQueryResults queryResults) {
		ResultBean resultBean = new ResultBean();

		Navigation nav = queryResults.getNavigation();

		// Getting refinements
		DimGroupList refDimGroupList = nav.getRefinementDimGroups();
		ERecList records = nav.getERecs();

		resultBean.setFacetGroupList(processFacet(refDimGroupList));
		resultBean.setProductBean(processProduct(records));
		
		return resultBean;
	}

	private List<ProductBean> processProduct(ERecList records) {
		List<ProductBean> productBeanList = new ArrayList<ProductBean>();
		ProductBean productBean = null;
		PropertyBean propertyBean = null;
		List<PropertyBean> propertyBeanList = null;
		String sku = null;

		for (Object record : records) {
			productBean = new ProductBean();
			propertyBeanList = new ArrayList<PropertyBean>();
			ERec rec = (ERec) record;
			sku = rec.getSpec();
			PropertyMap propsMap = rec.getProperties();
			// Get property iterator for record
			Iterator props = propsMap.entrySet().iterator();
			while (props.hasNext()) {
				propertyBean = new PropertyBean();
				Property property = (Property) props.next();
				propertyBean.setPropertyKey((String) property.getKey());
				propertyBean.setPropertyValue((String) property.getValue());
				propertyBeanList.add(propertyBean);
			}
			productBean.setSku(sku);
			productBean.setProperties(propertyBeanList);
			productBeanList.add(productBean);
		}

		return productBeanList;
	}

	private Map<String, List<FacetBean>> processFacet(DimGroupList refDimGroupList) {

		// FacetGroupBean facetGroupBean = null;
		List<List<FacetGroupBean>> facetGroupList = new ArrayList<List<FacetGroupBean>>();
		Map<String,  List<FacetBean>> facetMap = new HashMap<String,  List<FacetBean>>();

		// Loop over dimension groups
		for (Object dGroup : refDimGroupList) {
			DimGroup dimGroup = (DimGroup) dGroup;

			// facetGroupBean = new FacetGroupBean();
			//facetGroups = new ArrayList<FacetGroupBean>();
			String facetName = null;
			List<FacetBean> facetBeanList = null;
			FacetGroupBean groupBean = null;

			for (Object dim : dimGroup) {
				Dimension dimension = (Dimension) dim;
				DimValList dimValList = dimension.getRefinements();
				groupBean = new FacetGroupBean();
				facetBeanList = new ArrayList<FacetBean>();
				FacetBean facetBean = null;

				for (Object dVal : dimValList) {
					DimVal dimVal = (DimVal) dVal;
					facetBean = new FacetBean();
					facetBean.setFacetName(dimVal.getName());
					facetBean.setFacetID(dimVal.getId());
					if (dimVal.getProperties().get("DGraph.Bins") != null) {
						facetBean.setBinCount((int) dimVal.getProperties().get(
								"DGraph.Bins"));
					}
					facetBeanList.add(facetBean);
				}
				facetName = dimension.getName();
				groupBean.setFacetName(facetName);
				groupBean.setFacetBeanList(facetBeanList);
				facetMap.put(facetName, facetBeanList);
			}
		}
		return facetMap;
	}
}
