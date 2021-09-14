<%-- 
    Document   : listarAlumnos
    Created on : 3/09/2021, 05:47:31 PM
    Author     : klbmo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../assets/css/style.css">

        <title>Listado de alumnos</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/Paginas/comunes/cabecera.jsp"/>

        <header id="main header" class="py-2 bg-light pt-5">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            Control de alumnos
                        </h1>
                    </div>
                </div>
            </div>
        </header>

        <section id="alumnos">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-md-9">

                        <div class="card">
                            <div class="card-header">
                                <h4>Listado de alumnos</h4>
                            </div>
                        </div>



                        <table class="table table-striped">
                            <thead class="table-dark">
                                <tr>
                                    <th>#</th>
                                    <th>Nombre completo</th>
                                    <th>Email</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="alumno" items="${listadoAlumno}">
                                    <tr>
                                        <td>${alumno.carne}</td>
                                        <td>${alumno.apellidos}${alumno.nombres}</td>
                                        <td>${alumno.email}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/ServletAlumno?accion=eliminar&carne=${alumno.carne}">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>

                        </table>
                    </div>
                    </section>



                    <h1>Listado de alumnos</h1>
                    <jsp:include page="/WEB-INF/Paginas/comunes/Pie-Pagina.jsp"/>


                    <script src="../assets/js/jquery-3.6.0.js"></script>
                    <script src="../assets/js/bootstrap.bundle.js"></script>
                    </body>

                    </html>
