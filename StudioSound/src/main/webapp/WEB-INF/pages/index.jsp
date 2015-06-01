<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
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
                            <li><a href="/" class="active">Главная</a></li>
                            <li><a href="allProject">Проекты</a></li>
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
    <h3>O <span>компании</span></h3>
    <p>Комнания "CinemaWorld", работающая в сотрудничестве со многими зарубежными компаниями, была основана в 2012 году.</p>
    <p>Задача компании — выпуск изданий, приближенных по качеству изображения, упаковки и дополнительных материалов к
        европейским отраслевым стандартам качества. Мы ощущаем ответственность за развитие белорусского рынка лицензионных
        изданий и работаем над тем, чтобы сделать его более здоровым и гармоничным.</p>
    <p>Студия оказывает услуги традиционно высокого качества в своей области, что позволило ей все время существования
    работать с полной загрузкой, несмотря на растущую конкуренцию в области озвучивания.</p>
    <p>Основным конкурентным преимуществом студии является навык и опыт сотрудников - в течение 3 лет существования студия
    полностью сохранила состав звукорежиссеров, являющихся, без преувеличения, основой для производства качественного
    продукта в области звукозаписи.</p>
    <p>У студии весьма высокая репутация как среди заказчиков, так и среди актеров, режиссеров дубляжа, переводчиков, укладчиков,
    что позволяет ей привлекать для выполнения работ лучшие силы, имеющиеся на рынке.</p>
    <br/>
    <br/>
    <table>
        <tr><b>Беларусский офис:</b></tr><br/>
        <tr>ООО "СинемаУорлд Лтд."</tr><br/>
        <tr>Беларусь, г. Минск</tr><br/>
        <tr>E-mail: alesya_podrez@mail.ru </tr><br/>
        <tr>Телефон: (017) 9379992</tr><br/>
    </table>
</t:template>

