<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>home</title>

</head>
<body>
<jsp:include page="_menu.jsp"/>
<h1>
    Home
</h1>

${user.userName}
${user.password}


</body>
</html>