package com.search.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.endeca.navigation.ENEQueryResults;
import com.search.bean.QueryParamBean;
import com.search.bean.ResultBean;
import com.search.query.process.QueryBuilder;
import com.search.query.process.QueryProcessor;
import com.search.result.process.ResultProcessor;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String searchTerm = request.getParameter("searchTerm");
		System.out.println("You searched for: "	+ searchTerm);
		QueryParamBean queryParam = new QueryParamBean();
		queryParam.setSearchTerm(searchTerm);
		QueryBuilder queryBuilder = new QueryBuilder();
		queryBuilder.buildQuery(queryParam);

		QueryProcessor queryProcessor = new QueryProcessor();
		ENEQueryResults queryResults = queryProcessor.processRequest(queryBuilder.getEneQuery());
		
		ResultProcessor resultProcessor = new ResultProcessor();
		ResultBean result = resultProcessor.processResult(queryResults);
		
		System.out.println("Done");
		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
	}

}
