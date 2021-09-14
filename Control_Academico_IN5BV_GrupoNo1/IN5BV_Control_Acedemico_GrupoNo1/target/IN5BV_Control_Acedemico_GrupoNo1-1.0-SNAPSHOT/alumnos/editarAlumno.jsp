<%-- 
    Document   : editarAlumno
    Created on : 14/09/2021, 04:06:40 AM
    Author     : klbmo
--%>

<%@page import="com.grupono1.models.domain.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <link rel="stylesheet" href="./assets/css/style.css">

        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>
        <title>Editar alumno</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/Paginas/comunes/cabecera.jsp"/>

        <section id="actions" class="py-4 mb-4 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <a href="listarAlumnos.jsp" class="btn btn-light btn-block">
                            <i class="fa fa-arrow-left"></i>  Regresar a alumnos
                        </a>
                    </div>
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-3">

                    </div>
                </div>

            </div>
        </section>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Estudiante</h4>
                            </div>
                            <div class="card-body">
                                <!-- Modal -->
                                <form method="POST" action="${pageContext.request.contextPath}/ServletAlumno">
                                    <!--div class="modal-body"-->
                                    <div class="mb-3">
                                        <label for="carne" class="form-label">Carne</label>
                                        <input type="text" id="carne" name="carne" class="form-control" value="${alumno.carne}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="nombres" class="form-label">Nombre</label>
                                        <input type="text" id="nombres" name="nombres" class="form-control" value="${alumno.nombres}">
                                    </div><!-- esto crea un cuadro de texto -->
                                    <div class="mb-3">
                                        <label for="apellidos" class="form-label">Apellido</label>
                                        <input type="text" id="apellidos" name="apellidos" class="form-control" value="${alumno.apellidos}">
                                    </div>
                                    <div class="mb-3">
                                        <label for="email" class="form-label">Email</label>
                                        <input type="email" id="email" name="email" class="form-control" value="${alumno.email}">
                                    </div>

                                    <input type="hidden" name="carne" value="${alumno.carne}">
                                    <input type="hidden" name="accion" value="actualizar" >

                                    <!--/div-->
                                    <button type="button" class="btn btn-secundary" data-bs-dismiss="modal">Cancelar</button>
                                    <button type="submit" class="btn btn-success">Guardar</button>

                                </form> 
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </section>





        <h1>Listado de alumno</h1>
        <jsp:include page="/WEB-INF/Paginas/comunes/Pie-Pagina.jsp"/>


        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script>
    </body>

</html>