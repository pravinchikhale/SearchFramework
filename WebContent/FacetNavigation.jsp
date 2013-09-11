<%@page import="com.search.bean.FacetBean"%>
<%@page import="com.search.bean.ResultBean"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h3>Facets are here</h3>

<c:set value="${requestScope.result.facetGroupList}" var="facetMap" />
<c:forEach items="${facetMap}" var="Facets">
	<c:set var="FacetName" value="${Facets.key}" />
	</br><b><c:out value="${FacetName}"></c:out></b></br>
	
	<c:set var="facetValues" value="${Facets.value}"></c:set>
	<c:forEach items="${facetValues}" var="facetValue">
		<c:set var="facetBean" value="${facetValue}"></c:set>
		<c:out value="${facetBean.facetName}"></c:out></br>
	</c:forEach>
	
</c:forEach>

