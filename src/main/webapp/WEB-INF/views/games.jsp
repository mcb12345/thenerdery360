<%@ include file="/WEB-INF/views/header.jsp" %>
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
                <%--<th>Vote</th>--%>
        </tr>
        <c:url var="owned" value="/games/owned"></c:url>
        <c:forEach var="game" items="${wantIt}">
            <tr>
                <td>${game.title}</td>
                <td>
                    <form action="${owned}" method="POST">
                        <input type="hidden" name="gameId" value="${game.id}"/>
                        <input type="submit" value="Mark As Owned"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<%@ include file="/WEB-INF/views/footer.jsp" %>
