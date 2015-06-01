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
    <form:form method="post" action="../showProject" modelAttribute="project">
        <div >
            <img src="${pageContext.request.contextPath}${project.image}" align="left" width="150" height="200" style="margin-right:20px;"/><br/><br/>
        </div>
        <div >
        <b>Год выпуска :</b> ${project.year} <br />
            <b>Тип проекта:</b> ${project.idType.nameType}<br/>
        <b>Название :</b> ${project.nameProject} <br />
        <b>Страна :</b> ${project.country} <br />
        &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;<b>Роли :</b><br>
        <c:forEach items = "${idRole}" var = "role">
        ${role.nameRole} - ${role.idActor.name} ${role.idActor.surname} &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;
            <i><a href="/deleteRole/${role.idRole}">Удалить</a>/<a href="/editRole/${role.idRole}">Редактировать</a></i><br>
                </c:forEach>
        &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;  <b>Штат проекта :</b><br>
        <c:forEach items = "${idStaffProject}" var = "staffProject">
                       ${staffProject.idStaff.idPost.namePost} - ${staffProject.idStaff.name}&nbsp; ${staffProject.idStaff.surname}
            &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;
            <i><a href="/deleteStaffProject/${staffProject.idStaffProject}">Удалить</a>/<a href="/editStaffProject/${staffProject.idStaffProject}">Редактировать</a></i><br>
                       </c:forEach>
        </div>
    </form:form>
    <br/>
    <br/>
    <div id="contacts-s">
    <a href="/addRole/${project.idProject}">Добавить роль</a><br/><br/>
    <a href="/addStaffProject/${project.idProject}">Пополнить штат проекта</a><br>
    </div>
</t:template>
