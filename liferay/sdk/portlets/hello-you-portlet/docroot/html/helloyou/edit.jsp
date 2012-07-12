<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<jsp:useBean class="java.lang.String" id="addNameURL" scope="request" />
<portlet:defineObjects />

This is the
<b>Hello You</b>
portlet in Edit mode. This was created using Liferay IDE 1.5x.<br />
Created: May.28/2012<br>
Modified: May.28/2012<br>
Cool.<br>
Version: 1.0.0.10<br>
<br>
<form id="<portlet:namespace />helloForm" action="<%=addNameURL%>"
	method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="username"></td>
		</tr>
	</table>
	<input type="submit" id="nameButton" title="Add Name" value="Add Name">
</form>