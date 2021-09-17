<%-- 
    Document   : index
    Created on : 2/09/2021, 12:08:54 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Control Academico</title>
        <link rel="stylesheet" href="./assets/css/style.css">
        <!--BootStrap -->
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>
    </head>
    
    <body class="text-light text-center">
        <!-- Cabecera (Header y nav)-->
        <jsp:include page="/WEB-INF/Paginas/comunes/cabecera.jsp"/>

        <main>
            <section id = "contenido">
                
                <p class = "descripcion">
                    Kinal es un Centro Educativo privado, no lucrativo, dirigido a la formacion tecnica profesional de
                    jovenes y adultos, de beneficio colectivo y asistencia social en favor de los sectores mas necesitados
                    de la comunidad.
                </p>

                <img id="kinal_img_principal" src="./assets/images/principal.png">

                <p class = "descripcion">
                    Nuestro valor fundamental es enseñar a realizar el trabajo bien hecho, que sea la base de la
                    superación de alumnos y el medio para servir a los demas.
                </p>

                <br>

            </section>
        </main>



        <!-- Footer -->
        <jsp:include page="/WEB-INF/Paginas/comunes/Pie-Pagina.jsp"/>

        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>
    </body>
</html>
