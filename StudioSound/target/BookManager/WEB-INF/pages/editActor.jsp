<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                            <li><a href="/allProject">Проекты</a></li>
                            <li><a href="/allActor" class="active">Актеры</a></li>
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
    <form:form method="post" action="../editActor" commandName="actor" id="contacts-form">
        <table>
            <tr>
                <td><form:input path="idActor" readonly="true" hidden="true"/></td>
            </tr>
            <tr>
                <td><form:label path="Surname">
                    Фамилия
                </form:label></td>&nbsp;&nbsp;
                <td><form:input path="surname" pattern="^[А-Яа-яЁё]+$" required="required"/></td>&nbsp;&nbsp;
            </tr>
            <tr>
                <td><form:label path="Name">
                    Имя
                </form:label></td>&nbsp;&nbsp;
                <td><form:input path="name" pattern="^[А-Яа-яЁё]+$" required="required"/></td>&nbsp;&nbsp;
            </tr>
            <tr>
                <td><form:label path="Lastname">
                    Отчество
                </form:label></td>&nbsp;&nbsp;
                <td><form:input path="lastname" pattern="^[А-Яа-яЁё]+$" required="required"/></td>&nbsp;&nbsp;
            </tr>
            <tr>
                <td><form:label path="DateOfBirth">
                    Дата рождения
                </form:label></td>&nbsp;&nbsp;
                <td><form:input path="dateOfBirth" required="required" pattern="[0-3][0-9].[0-1][0-9].[1-2][9,0][4-9][0-9]"/></td>&nbsp;&nbsp;
            </tr>
            <tr>
                <td><form:label path="Experience">
                    Стаж
                </form:label></td>&nbsp;&nbsp;
                <td><form:input path="experience" required="required" pattern="[с]\s[1-2][9,0][4-9][0-9]\s[г][о][д][а]"/></td>&nbsp;&nbsp;
            </tr>

        </table><br>
        <input type="submit" value="Редактировать"/>
    </form:form>
</t:template>
