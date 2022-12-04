<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <br>
        <br>
        <br>
        <br>
        <div class="carousel slide" data-bs-ride="carousel" id="carouselExampleIndicators">
            <div class="carousel-indicators">
                <button aria-label="Slide 1" class="active" data-bs-slide-to="0"
                        data-bs-target="#carouselExampleIndicators" type="button"></button>
                <button aria-label="Slide 2" data-bs-slide-to="1" data-bs-target="#carouselExampleIndicators"
                        type="button"></button>
                <button aria-label="Slide 3" data-bs-slide-to="2" data-bs-target="#carouselExampleIndicators"
                        type="button"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img alt="..." class="d-block w-100" src="images/2022-engerikatalog-vejleder-prio.jpg">
                    <div class="carousel-caption">
                        <h5>Spar stort ved efterisolering</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maxime, nulla, tempore. Deserunt
                            excepturi quas vero.</p>
                        <p><a class="btn btn-primary mt-3" href="#">Kom i gang her</a></p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img alt="..." class="d-block w-100" src="images/fog-dobbelt-carport-car01du-large.jpeg">
                    <div class="carousel-caption">
                        <h5>Intresseret i carporte?</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maxime, nulla, tempore. Deserunt
                            excepturi quas vero.</p>
                        <p><a class="btn btn-primary mt-3" href="#">Se tilbud her</a></p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img alt="..." class="d-block w-100" src="images/media.jpg">
                    <div class="carousel-caption">
                        <h5>Flytte salg</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maxime, nulla, tempore. Deserunt
                            excepturi quas vero.</p>
                        <p><a class="btn btn-primary mt-3" href="#">Se avisen her</a></p>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" data-bs-slide="prev" data-bs-target="#carouselExampleIndicators"
                    type="button"><span aria-hidden="true" class="carousel-control-prev-icon"></span> <span
                    class="visually-hidden">Previous</span></button>
            <button class="carousel-control-next" data-bs-slide="next" data-bs-target="#carouselExampleIndicators"
                    type="button"><span aria-hidden="true" class="carousel-control-next-icon"></span> <span
                    class="visually-hidden">Next</span></button>
        </div>
        <!-- about section starts -->
        <section class="about section-padding" id="about">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-12 col-12">
                        <div class="about-img"><img alt="" class="img-fluid" src="images/fog_kundeapp_1920x1080.jpg"></div>
                    </div>
                    <div class="col-lg-8 col-md-12 col-12 ps-lg-5 mt-md-5">
                        <div class="about-text">
                            <h2>Unik service for Fogs kontokunder</h2>
                            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Totam, labore reiciendis.
                                Assumenda eos quod animi! Soluta nesciunt inventore dolores excepturi provident, culpa
                                beatae tempora, explicabo corporis quibusdam corrupti. Autem, quaerat. Assumenda quo
                                aliquam vel, nostrum explicabo ipsum dolor, ipsa perferendis porro doloribus obcaecati
                                placeat natus iste odio est non earum?</p><a class="btn btn-warning" href="#">Læs
                            mere</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- about section Ends -->



    </jsp:body>

</t:pagetemplate>
