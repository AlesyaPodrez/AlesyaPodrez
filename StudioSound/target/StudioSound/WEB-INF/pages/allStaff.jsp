<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="tail-top">
    <div class="tail-bottom">
        <div id="main">
            <header>
                <div id="header">
                    <div class="row-1">
                        <div class="fleft"><a href="/">Cinema <span>World</span></a></div>
                        <ul>
                            <li><a href="/"><img src="${pageContext.request.contextPath}/res/images/icon1-act.gif" alt="" /></a></li>
                            <li><a href="/contacts"><img src="${pageContext.request.contextPath}/res/images/icon2.gif" alt="" /></a></li>
                            <li><a href="/siteMap"><img src="${pageContext.request.contextPath}/res/images/icon3.gif" alt="" /></a></li>
                        </ul>
                    </div>
                    <div class="row-2">
                        <ul>
                            <li><a href="/" >Главная</a></li>
                            <li><a href="allProject">Проекты</a></li>
                            <li><a href="allActor">Актеры</a></li>
                            <li><a href="allStaff" class="active">Сотрудники</a></li>
                            <li class="last"><a href="siteMap">Карта сайта</a></li>
                        </ul>
                    </div>
                </div>
            </header>
        </div>
    </div>
</div>

<t:template>
    <div id="contacts-s">
        <a href="addStaff">Добавить сотрудника</a><br/>
        <a href="allPost">Должностной список</a>
    </div>
        <table>
            <c:forEach items = "${staff}" var = "staff">
                <tr><td><a href="showStaff/${staff.getIdStaff()}">
                    ${staff.getSurname()}
                    ${staff.getName()}
                </a></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><i><a href="deleteStaff/${staff.getIdStaff()}">Удалить</a> / <a href="editStaff/${staff.getIdStaff()}">Редактировать</a></i><br></td>
                </tr>
            </c:forEach>
        </table><br>

</t:template>

