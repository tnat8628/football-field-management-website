<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<form action="/admin/categories/save" method="post">
	<input type="hidden" value="${category.isEdit }" name=isEdit>
	<input type="hidden" value="${category.categoryId }" name=categoryId>
	<label>Category Name</label><br>
	<input type="text" name=categoryName value="${category.categoryName }"><br>
	
	<c:if test="${category.isEdit }">
		<input type="submit" value="Update">
	</c:if>
	<c:if test="${!category.isEdit }">
		<input type="submit" value="Save">
	</c:if>
</form>