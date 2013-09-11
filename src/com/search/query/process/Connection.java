package com.search.query.process;

import com.endeca.navigation.HttpENEConnection;
import com.search.constant.EndecaConstant;

public class Connection {

	HttpENEConnection connection = null;

	public HttpENEConnection getConnection() {
		connection = new HttpENEConnection(EndecaConstant.ENDECA_HOST, EndecaConstant.ENDECA_PORT);
		return connection;
	}
	
	
}
