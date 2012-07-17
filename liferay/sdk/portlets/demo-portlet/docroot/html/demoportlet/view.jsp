<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<!DOCTYPE html>
 <html lang="en">
 <head>
   <meta charset="utf-8">
   <title>jQuery demo</title>
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>   
 </head>
 <body>
 This is the <b>Demo</b> portlet in View mode.<br/>
This was created using Liferay IDE 1.5x.<br/>
Created: Jul.02/2012<br>
Modified: Jul.16/2012<br>
Version: 1.0.0.25<br>
Cool.
   <p>País:</p><select id="originCountrySelectId">
   <option value="-1">Seleccione uno ...</option>
   <option value="1">Colombia</option>
   <option value="2">Estados Unidos</option>
   <option value="3">Canada</option>
   </select>
   <p>Departamento: </p><select id="originEstateSelectId"></select>
   <p>Ciudad: </p><select id="originCitySelectId"></select>
   <script>
     $(document).ready(function(){
    	 setupNewPortletInfo('http://localhost:8180/tccweb');
     });
   </script>   
 </body>
 </html>
