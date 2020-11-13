<%--
  Created by IntelliJ IDEA.
  User: arkadiusz
  Date: 13.11.2020
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <%@ include file="../fragments/header.jsp" %>
    <title>Add donation - step 1</title>
</head>
<body>
<%@ include file="../fragments/formHead.jsp" %>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter"><h3>Krok 1/4</h3></div>
        <form action="/donation/add-step-1" method="post">
            <div data-step="1" class="active" id="form">
                <h3>Zaznacz co chcesz oddać:</h3>
                <c:forEach items="${categories}" var="category">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="checkbox" name="category" value="${category.id}"
                                    <c:forEach items="${donationInSession.categories}" var="categoryChosen">
                                        <c:if test="${category.id == categoryChosen.id}"> checked </c:if>
                                    </c:forEach>

                            />
                            <span class="checkbox"></span>
                            <span class="description">${category.name}</span>
                        </label>
                    </div>
                </c:forEach>
                <div class="test-warning" style="font-size: 20px; color: red">${errorNothingChecked}</div>
                <br>
                <div>
                    <input type="submit" class="btn" value="Dalej">
                </div>
            </div>
        </form>
    </div>
</section>
<%@ include file="../fragments/footer.jsp" %>
<script src="/js/scroll.js" type="text/javascript"></script>

</body>
</html>
