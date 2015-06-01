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

    <form:form method="post" action="../editProject" commandName="project" id="contacts-form">
        <table>
            <tr>
                <td> <form:input path="idProject" readonly="true" hidden="true"/></td>
            </tr>
            <tr>
                <td><form:label path="Year">
                    Год выпуска
                </form:label></td>&nbsp;&nbsp;
                <td><form:input path="year" pattern="[0-9]{4}" required="required"/></td>&nbsp;&nbsp;
            </tr>
            <tr>
                <td><form:label path="NameProject">
                    Название
                </form:label></td>&nbsp;&nbsp;
                <td><form:input path="nameProject" pattern="^[А-Яа-яЁё]+$" required="required"/></td>&nbsp;&nbsp;
            </tr>
            <tr>
                <td><form:label path="Country">
                    Страна
                </form:label></td>&nbsp;&nbsp;
                <td><form:input path="country" pattern="^[А-Яа-яЁё]+$" required="required"/></td>&nbsp;&nbsp;
            </tr>
            <tr>
                <td><form:label path="IdType">
                    Тип
                </form:label></td>&nbsp;&nbsp;
                <td>
                    <form:select path="idType" required="required">
                        <option selected value="${project.idType.idType}">${project.idType.nameType}</option>
                        <c:forEach items = "${allType}" var = "type">
                            <option value="${type.idType}">${type.nameType}</option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
        </table><br>
        <input type="submit" value="Редактировать"/>
    </form:form>
</t:template>
