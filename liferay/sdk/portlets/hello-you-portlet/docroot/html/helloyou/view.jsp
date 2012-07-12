<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<jsp:useBean id="userName" class="java.lang.String" scope="request" />
This is the <b>Hello You</b> portlet in View mode.<br/>
<p>Hello <%= userName %>!</p>
This was created using Liferay IDE 1.5x.<br/>
Created: May.28/2012<br>
Modified: May.28/2012<br>
Version: 1.0.0.10<br>
Cool.
