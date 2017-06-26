<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>
<body>
<body>
	<div class="container">
		<h3>書籍情報登録画面</h3>
<%-- 		<form:form action="${pageContext.request.contextPath}/book/save" modelAttribute="bookSaveForm"> --%>
		<form:form action="${pageContext.request.contextPath}/book/save" 
			modelAttribute="bookSaveForm" enctype="multipart/form-data">
			
			<input type="hidden" name="id" value="-1">
			<table class="table table-striped">
				<tr>
					<th>書籍名</th>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<th>著者</th>
					<td><form:input path="author" /></td>
				</tr>
				<tr>
					<th>出版社</th>
					<td><form:input path="publisher" /></td>
				</tr>
				<tr>
					<th>価格</th>
					<td><form:input path="price" /></td>
				</tr>
				<tr>
					<th>ISBNコード</th>
					<td><form:input path="isbncode" /></td>
				</tr>
				<tr>
					<th>発売日</th>
					<td><form:input	path="saledate" /></td>
				</tr>
				<tr>
					<th>説明</th>
					<td><form:input path="explanation" /></td>
				</tr>
				<tr>
					<th>画像</th>
					<td><input name="image" type="file" /></td>
					
				</tr>
				<tr>
					<th>在庫数</th>
					<td><form:input path="stock" /></td>
				</tr>
				<tr>
					<td colspan="3">
						<input class="btn" type="submit" value="登録">
						<input class="btn" type="reset" value="リセット">
					</td>
				</tr>
				<tr>
					<td colspan="3">
					<a href="${pageContext.request.contextPath}/book/list">戻る</a>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>