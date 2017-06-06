<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"  %>
<body>
<div class="container">
	<h3>メンバー登録画面</h3>
	<div class="span8">
		<div class="row">
		<c:out value="${message}"></c:out>
		<form:form modelAttribute="memberForm" action="${pageContext.request.contextPath}/member/create">

			<table class="table table-striped">
			  <tr>
			    <th>
			     	 氏名<br>
			     	 <form:errors path="name"/>
			    </th>
			    <td>
			    	<form:input path="name"  placeholder="Name"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      	メールアドレス<br>
			    	<form:errors path="mailAddress"/>
			    </th>
			    <td>
			      	<form:input path="mailAddress" placeholder="Email"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			     	 パスワード
			    </th>
			    <td>
			    	<form:password path="password" placeholder="Password"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			     	 パスワード(確認用)
			    </th>
			    <td>
			    	<form:password path="password2" placeholder="Password"/>
			    </td>
			  </tr>
			  <tr>
			  	<td></td>
			    <td>
					<input class="btn" type="submit" value="登録">
			    </td>
			  </tr>
			</table>
		  </form:form>
		</div>
	</div>
</div>
</body>
</html>