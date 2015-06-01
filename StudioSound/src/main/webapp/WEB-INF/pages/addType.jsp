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
    <form:form method="post" action="addType" commandName="type" id="contacts-form">
        <table>
            <tr>
                <td><form:label path="NameType">
                    Название
                </form:label></td>
                <td><form:input path="nameType"  pattern="^[А-Яа-яЁё\s]+$" required="required"/></td>&nbsp;&nbsp;
            </tr><br>

        </table><br>
        <input type="submit" value="Добавить"/>
    </form:form>
</t:template>
