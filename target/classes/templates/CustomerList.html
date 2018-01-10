<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<title>ユーザー一覧</title>
<link href="stylesheets/bootstrap.css" rel="stylesheet" />
<link href="stylesheets/jquery.bootgrid.css" rel="stylesheet" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.js"></script>
<script src="javascript/jquery.bootgrid.js"></script>
</head>
<body>
		<table id="grid-basic" class="table table-condensed table-hover table-striped">
				<thead>
					<tr>
					   <th data-column-id="no" data-type="numeric" data-identifier="true" data-width="3%" data-order="desc">No</th>
		               <th data-column-id="custid" data-width="7%">ユーザーID</th>
		               <th data-column-id="custname"  data-width="10%">ユーザー名</th>
		               <th data-column-id="orgname"  data-width="20%">組織名</th>
		               <th data-column-id="effect"  data-width="10%">EFFECT</th>
		               <th data-column-id="role"  data-width="7%">役割</th>
		           </tr>
				</thead>
				<tbody>
					<tr th:each="custinfoEntity :${custinfoEntity}">
						<td th:text="${custinfoEntity.no}"></td>
						<td th:text="${custinfoEntity.custid}"></td>
						<td th:text="${custinfoEntity.custname}"></td>
						<td th:text="${custinfoEntity.orgname}"></td>
						<td th:text="${custinfoEntity.effect}"></td>
						<td th:text="${custinfoEntity.role}"></td>
					</tr>
				</tbody>
		</table>
 <form action="#" th:action="@{/CustomerList}" th:object="${customerListForm}" method="post">
 <input type="submit" value="選択行を削除" />
 <input type="hidden" name = "rowIds[]" value = "rowIds[]" />
 </form>
<script type="text/javascript" th:inline="javascript">
/*<![CDATA[*/
var rowIds = [];
$(function() {
	$("#grid-basic").bootgrid({
		selection: true, 
		multiSelect: true,
		rowSelect: true,
	    keepSelection: true
	}).on("selected.rs.jquery.bootgrid", function(e, rows)
	{
	    for (var i = 0; i < rows.length; i++)
	    {
	        rowIds.push(rows[i].no);
	    }
	}).on("deselected.rs.jquery.bootgrid", function(e, rows)
	{
		for (var i = 0; i < rows.length; i++)
	    {
	    	rowIds.some(function(v, ii){
	    	    if (v==rows[i].no) rowIds.splice(ii,1);
	    	}); 
	    }
	});
});
/*]]>*/
</script>
</body>
</html>
<!--
<form action="#" th:action="@{/CustomerList}" th:object="${customerListForm}" method="post">
 <input type="hidden" name = "rowIds[]" value = "rowIds[]" />
 <input type="submit" value="選択行を削除" />
 </form>
 /*<![CDATA[*/  /*]]>*/
 -->
