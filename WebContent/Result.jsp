<%@page import="com.search.bean.ProductBean"%>
<%@page import="com.search.bean.FacetBean"%>
<%@page import="java.util.*"%>
<%@page import="com.search.bean.ResultBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Resuls are here</h3>

<c:set value="${requestScope.result.productBean}" var="productList" />
<c:forEach items="${productList}" var="product">
	<c:set var="sku" value="${product.sku}" />
	</br><c:out value="${sku}"></c:out></br>
	
	<c:set var="props" value="${product.properties}"></c:set>
	<c:forEach items="${props}" var="property">
		<c:out value="${property.propertyKey}"></c:out>: <c:out value="${property.propertyValue}"></c:out></br>
	</c:forEach>
	
</c:forEach>