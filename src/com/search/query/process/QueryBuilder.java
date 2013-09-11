package com.search.query.process;

import com.endeca.navigation.DimValIdList;
import com.endeca.navigation.ENEQuery;
import com.endeca.navigation.ERecSearch;
import com.endeca.navigation.ERecSearchList;
import com.search.bean.QueryParamBean;
import com.search.constant.EndecaConstant;

public class QueryBuilder {

	ENEQuery eneQuery = null;

	public void buildQuery(QueryParamBean queryParam) {

		ERecSearch eRecSearch = new ERecSearch(EndecaConstant.NTK,
				queryParam.searchTerm, EndecaConstant.NTX);
		ERecSearchList list = new ERecSearchList();
		list.add(0, eRecSearch);

		eneQuery = new ENEQuery();
		eneQuery.setNavAllRefinements(true);
		eneQuery.setNavDescriptors(new DimValIdList("0"));
		eneQuery.setNavNumERecs(10);
		eneQuery.setNavERecSearches(list);

	}

	public ENEQuery getEneQuery() {
		return eneQuery;
	}

	public void setEneQuery(ENEQuery eneQuery) {
		this.eneQuery = eneQuery;
	}

}
