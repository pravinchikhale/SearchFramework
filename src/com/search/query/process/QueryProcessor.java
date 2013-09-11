package com.search.query.process;

import com.endeca.navigation.ENEConnection;
import com.endeca.navigation.ENEQuery;
import com.endeca.navigation.ENEQueryException;
import com.endeca.navigation.ENEQueryResults;

public class QueryProcessor {

	public ENEQueryResults processRequest(ENEQuery eneQuery) {

		ENEQueryResults queryResults = null;
		Connection connection = new Connection();
		ENEConnection eneConnection = connection.getConnection();

		try {
			queryResults = eneConnection.query(eneQuery);
		} catch (ENEQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queryResults;
	}
}
