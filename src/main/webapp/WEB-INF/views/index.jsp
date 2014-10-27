<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<h2>Xbox 360 Games</h2>

<c:if test="${not empty error}">
    <h2>${error}</h2>
</c:if>

<c:if test="${not empty gotIt}">

    <h2>Got It!</h2>
    <ul>
        <c:forEach var="game" items="${gotIt}">
            <li>${game.title}</li>

        </c:forEach>
    </ul>
</c:if>
<c:if test="${not empty wantIt}">

    <h2>Want It!</h2>
    <table>
        <tr>
            <th>Game Title</th>
            <th>Vote</th>
        </tr>

        <c:forEach var="game" items="${wantIt}">
            <tr>
                <td>${game.title}</td>
                <td>
                    <form action="<c:url value="/vote" />" method="POST">
                        <input type="hidden" name="gameId" value="${game.id}"/>
                        <input type="submit" value="Vote"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<br/>
<br/>
<br/>

<h3>Add Game</h3>
<c:url var="addGame" value="/addGame"/>

<form id="addGameForm" action="<c:url value="${addGame}" />" method="POST">
    <input type="text" name="title" value=""/>
    <input type="submit" value="Add Game"/>
</form>

<%@ include file="/WEB-INF/views/footer.jsp" %>