<%-- 
    Document   : newjsp
    Created on : 03-sep-2021, 1:34:21
    Author     : Sergio Javier López Pienda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content = "width=device-width, initial-scale=1">

        <link rel="stylesheet" href="../assets/css/style.css">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script> 




    <body id = "contenido">
        <jsp:include page="/WEB-INF/Paginas/comunes/cabecera.jsp"/>

        <header d="main-header">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1 class="text-light text-center" style="background-color: #5E2129">
                            <i class="fas fa-chalkboard-teacher"></i> Instructores <i class="fas fa-chalkboard-teacher"></i>
                        </h1>
                    </div>
                </div>
            </div>
        </header>

        <section  >
            <div class="container" >
                <div class="row-cols-1" style="background-color: #5E2129">
                    <div class="col-9">
                        <a  class="btn text-light" href="${pageContext.request.contextPath}/ServletEstudiante?accion=agregar&idEstudiante=${estudiante.idEstudiante}" ><i class="fas fa-user-plus"></i> Agregar </i></a>
                    </div>
                </div>
            </div>
        </section>
        <section id="instructores">
            <div class="container">
                <div class="row">
                    <div class="align-content-center" class="col-2">
                        <table class="table table-striped table-hover"  style="background-color: #5E2129">
                            <thead class="text-light"">
                                <tr>
                                    <th>#</th>
                                    <th>Nombre Completo</th>
                                    <th>Direccion</th>
                                    <th>Telefono</th>

                                    <th></th>
                                </tr>
                            </thead>
                            <tbody style="background-color: #000000">
                                <c:forEach var="instructor" items="${listadoInstructores}">
                                    <tr class="text-light">
                                        <td><i class="fas fa-user"></i>
                                            ${instructor.instructor_id}</td>

                                        <td>${instructor.apellidos} ${instructor.nombres}</td>
                                        <td>${instructor.direccion}</td>
                                        <td>${instructor.telefono}</td>
                                        <td> 
                                            <a style="background-color: #5e2129 " class="btn text-light" href="${pageContext.request.contextPath}/ServletInstructor?accion=ediar&instructor_id=${instructor.instructor_id}"><i class="far fa-edit"></i></i></a>
                                            <a style="background-color: #5e2129 " class="btn text-light"  href="${pageContext.request.contextPath}/ServletInstructor?accion=eliminar&instructor_id=${instructor.instructor_id}"><i class="fas fa-trash"></i></a>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>


                </div>

            </div>

        </section>

        <jsp:include page="/WEB-INF/Paginas/comunes/Pie-Pagina.jsp"/>
        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script>

    </body>
</html>

