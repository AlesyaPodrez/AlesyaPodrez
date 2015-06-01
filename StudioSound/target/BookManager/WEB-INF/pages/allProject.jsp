<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="tail-top">
    <div class="tail-bottom">
        <div id="main">
            <!--==============================
                          header
            =================================-->
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
                            <li><a href="allProject" class="active">Проекты</a></li>
                            <li><a href="allActor">Актеры</a></li>
                            <li><a href="allStaff">Сотрудники</a></li>
                            <li class="last"><a href="siteMap">Карта сайта</a></li>
                        </ul>
                    </div>
                </div>
            </header>
        </div>
    </div>
</div>

<t:template>
    <form:form method="get" action="/search" commandName="project" id="contacts-project">

        Год выхода
        <select name = "year">
                        <option value="0">Фильтрация</option>
                        <c:forEach items = "${projectSearch}" var = "projectSearch">
                            <option value="${projectSearch.year}">${projectSearch.year}</option>
                        </c:forEach>
        </select>&nbsp;&nbsp;
        <input type="submit" value="Искать"/> &nbsp;&nbsp;  <c:if test="${not empty error}">${error}</c:if><br><br>
        <div id="contacts-s">
            <a href="addProject">Добавить проект</a><br/>
            <a href="allType">Типы проектов</a>
        </div>
        <table>
           <c:forEach items = "${project}" var = "project">
               <tr><td><a href="showProject/${project.idProject}">
                   [${project.getYear()}]&nbsp;&nbsp;
                    ${project.getNameProject()}
                   </a></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                  <td><i><a href="deleteProject/${project.getIdProject()}">Удалить</a>/<a href="editProject/${project.getIdProject()}">Редактировать</a></i>&nbsp;&nbsp;
                   </td></tr>
            </c:forEach>
        </table><br>
    </form:form>
</t:template>

