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
    <form:form method="post" action="../showStaff" modelAttribute="staff">
        <div>
            <img src="${pageContext.request.contextPath}${staff.image}" align="left" width="150" height="200" style="margin-right:20px;"/>
        </div>
        <div>
            <b>Должность :</b> ${staff.idPost.namePost} <br />
            <b>Фамилия :</b> ${staff.surname} <br />
            <b>Имя :</b> ${staff.name} <br />
            <b>Отчество :</b> ${staff.lastname} <br />
            <b>Дата рождения :</b> ${staff.dateOfBirth} <br />
            <b>Стаж работы :</b> ${staff.experience}<br />
            &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;<b>Проекты :</b><br>
            <c:forEach items="${allProject}" var="project">
                    ${project.idProject.nameProject} <br />
                    </c:forEach>
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
    </form:form>
</t:template>
