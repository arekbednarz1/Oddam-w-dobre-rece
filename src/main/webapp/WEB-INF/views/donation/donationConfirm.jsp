<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Confirmation</title>
    <%@ include file="../fragments/header.jsp" %>
</head>
<body>
<header class="header--form-page">
    <%@ include file="../fragments/formHead.jsp" %>

    <div class="container" style="margin-top: 300px">
        <h2>
            Dziękujemy za przesłanie formularza. <br> Na maila prześlemy wszelkie informacje o odbiorze.
        </h2>
    </div>
</header>

<%@ include file="../fragments/footer.jsp" %>

</body>
</html>