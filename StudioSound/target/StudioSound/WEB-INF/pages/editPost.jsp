<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                            <li><a href="/allProject">Проекты</a></li>
                            <li><a href="/allActor">Актеры</a></li>
                            <li><a href="/allStaff" class="active">Сотрудники</a></li>
                            <li class="last"><a href="/siteMap">Карта сайта</a></li>
                        </ul>
                    </div>
                </div>
            </header>
        </div>
    </div>
</div>

<t:template>
    <form:form method="post" action="../editPost" commandName="post" id="contacts-form">
        <table>
            <tr>
                <td><form:input path="idPost" readonly="true" hidden="true"/></td>
            </tr>
            <tr>
                <td><form:label path="NamePost">
                    Название
                </form:label></td>
                <td><form:input path="namePost" pattern="^[А-Яа-яЁё\s]+$" /></td>&nbsp;&nbsp;
                <td><form:errors path="namePost"></form:errors> </td>
            </tr>
        </table><br>
        <input type="submit" value="Редактировать"/>
    </form:form>
</t:template>
