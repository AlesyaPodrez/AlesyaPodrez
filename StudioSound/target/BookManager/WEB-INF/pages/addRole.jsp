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
                            <li><a href="/allProject" class="active">Проекты</a></li>
                            <li><a href="/allActor">Актеры</a></li>
                            <li><a href="/allStaff">Сотрудники</a></li>
                            <li class="last"><a href="/siteMap">Карта сайта</a></li>
                        </ul>
                    </div>
                </div>
            </header>
        </div>
    </div>
</div>

<t:template>
    <form:form method="post" action="../addRole" commandName="role" id="contacts-form">
        <table>
            <tr>
                <td><form:label path="NameRole">
                    Название
                </form:label></td>&nbsp;&nbsp;
                <td><form:input path="nameRole" pattern="^[А-Яа-яЁё\s]+$" required="required"/></td>&nbsp;&nbsp;
            </tr>
            <tr>
                <td><form:label path="IdActor">
                    Исполнитель
                </form:label></td>
                &nbsp;&nbsp;
                <td>
                    <form:select path="idActor" required="required">
                        <option></option>
                        <c:forEach items = "${allActor}" var = "actor">
                            <option value="${actor.idActor}">${actor.name} ${actor.surname}</option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="IdProject">
                    Проект
                </form:label></td>
                <td>
                    <form:select path="idProject">
                        <c:forEach items = "${allProject}" var = "project">
                            <option value="${project.idProject}">${project.nameProject}</option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr><br>
        </table><br>
        <input type="submit" value="Добавить"/>
    </form:form>
</t:template>
