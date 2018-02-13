<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div id="sitebody" class="col-sm-8 text-left">
	<tiles:insertAttribute name="message" />
	<tiles:insertAttribute name="search" />
	<tiles:insertAttribute name="body" />
</div>
</html>