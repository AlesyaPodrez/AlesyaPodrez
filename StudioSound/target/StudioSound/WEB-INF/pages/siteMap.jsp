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
                            <li><a href="/siteMap.jsp><img src="${pageContext.request.contextPath}/res/images/icon3.gif" alt="" /></a></li>
                        </ul>
                    </div>
                    <div class="row-2">
                        <ul>
                            <li><a href="/" >Главная</a></li>
                            <li><a href="allProject">Проекты</a></li>
                            <li><a href="allActor">Актеры</a></li>
                            <li><a href="allStaff" class="active">Сотрудники</a></li>
                            <li class="last"><a href="siteMap.jsp">Карта сайта</a></li>
                        </ul>
                    </div>
                </div>
            </header>
        </div>
    </div>
</div>

<t:template>
                    <h3>Карта <span>сайта</span></h3>
                    <ul class="sitemap-list">
                        <li><a href="/">Главная</a></li>
                        <li><a href="allProject">Проекты</a>
                            <ul>
                                <li><a href="addProject">Добавить проект</a></li>
                                <li><a href="allType">Типы проектов</a>
                                    <ul>
                                        <li><a href="addType">Добавить типы проектов</a></li>
                                    </ul></li>
                            </ul></li>
                        <li><a href="allActor">Актеры</a>
                            <ul>
                                <li><a href="addActor">Добавить актера</a></li>
                            </ul>
                        </li>
                        <li><a href="allStaff">Сотрудники</a>
                            <ul>
                                <li><a href="addStaff">Добавить сотрудников студии</a></li>
                                <li><a href="allPost">Должностной список</a>
                                    <ul>
                                        <li><a href="addPost">Добавить должность</a></li>
                                    </ul></li>
                            </ul></li>
                        <li><a href="siteMap">Карта сайта</a></li>
                    </ul>
</t:template>