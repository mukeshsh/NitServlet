<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"
	import="java.util.*,com.nt.dto.BookDetailsDTO"%>

<script language="JavaScript">
function showPrint(){
frames.focus();
frames.print();
}
</script>

<%
	List<BookDetailsDTO> listDTO = null;
	listDTO = (List<BookDetailsDTO>)request.getAttribute("booksList");
	//Display Databases
	if (listDTO.size() != 0) {
%>
<h1 style='color:red;text-align: center'>
	Books Report For<%=request.getParameter("category")%>
</h1>
<table border="1">
	<tr>
		<th>BookId</th>
		<th>bookName</th>
		<th>author</th>
		<th>price</th>
		<th>publisher</th>
		<th>status</th>
		<th>category</th>
	</tr>
	<%
		for (BookDetailsDTO dto : listDTO) {
	%>
	<tr>
		<td><%=dto.getBookid()%></td>
		<td><%=dto.getBookName()%></td>
		<td><%=dto.getAuthor()%></td>
		<td><%=dto.getPrice()%></td>
		<td><%=dto.getPublisher()%></td>
		<td><%=dto.getStatus()%></td>
		<td><%=dto.getCategory()%></td>
	</tr>
	<%
		}
	%>
</table>
<a href='javascript:showPrint()'>print</a>
<%
	} else {
%>
<h1 style='color: red; text-align: center'>No Books Found</h1>
<%}
  %>
<br>
<a href="search.html">Home</a>
