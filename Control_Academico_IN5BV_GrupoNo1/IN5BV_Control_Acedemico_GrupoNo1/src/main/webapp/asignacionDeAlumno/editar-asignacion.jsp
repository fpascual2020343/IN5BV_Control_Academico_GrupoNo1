<%-- 
    Document   : editar-asignacion
    Created on : 15/09/2021, 11:09:52 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="./assets/css/style.css">
        <!-- Bootstrap CSS --> 
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>
        <title>Editar de Asignacion de Alumnos</title>
    </head>



    <body id = "contenido">

        <jsp:include page="/WEB-INF/Paginas/comunes/cabecera.jsp"/>

        <section>
            <div class="container"  >
                <div class="text-light"class="row-cols-1" style="background-color: #5E2129">
                    <div class="text-light"class="col-9">

                        <a href="${pageContext.request.contextPath}/ServletAsignaciondeAlumnos?accion=listar" class="btn btn-close-white btn-block">
                            <i class="fa fa-arrow-left"></i> Regresar a Asignacion de Alumnos
                        </a>
                    </div>
                    <div class="col-md-3">
                    </div>
                    <div class="col-md-3">
                    </div>
                </div>
            </div>
        </section>


        <main>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Asignacion de Alumnos</h4>
                            </div>  
                            <div class="card-body">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletAsignaciondeAlumnos">
                                    <div class="modal-body">

                                        <div class="mb-3">
                                            <label for="carne_alumno" class="form-label">Alumno</label>                      
                                            <input type="text" id="carne_alumno" name="carne_alumno" class="form-control" value="${asignacion.carne_alumno}">
                                            <label><a href="${pageContext.request.contextPath}/ServletAlumno?accion=listar" style="text-decoration: None">
                                                    Para consultar los alumnos presiona aquí</a></label><br>
                                            <label>Para ingresar el alumno debe de colocar el carne</label>

                                        </div>
                                        <div class="mb-3">
                                            <label for="id_curso" class="form-label">Curso</label>
                                            <input type="number" id="id_curso" name="id_curso" class="form-control" value="${asignacion.id_curso}">
                                            <label><a href="${pageContext.request.contextPath}/ServletCurso?accion=listar" style="text-decoration: None">
                                                    Para consultar los Cursos presiona aquí</a></label><br>
                                            <label>Para ingresar el curso debe de colocar el id</label>
                                        </div>
                                        <div class="mb-3">
                                            <label for="fecha_asignacion" class="form-label">Fecha Asignada</label>
                                            <input type="datetime" id="fecha_asignacion" name="fecha_asignacion" class="form-control" value="${asignacion.fecha_asignacion}">
                                            <label>Formato para ingresar fechas es: año-mes-dia formato</label><br>
                                            <label>Formato para ingresar hora es: hh:mn:ss</label><br>
                                            <label>Ejemplo: 2021-10-05 12:50:15</label>
                                        </div>

                                        <input type="hidden" name="asignacion_id" value="${asignacion.asignacion_id}">
                                        <input type="hidden" name="accion" value="actualizar"> 

                                        <a href="${pageContext.request.contextPath}/ServletAsignaciondeAlumnos?accion=listar"> <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button></a>
                                        <button type="submit" class="btn btn-success">Guardar</button>

                                </form>
                            </div> 
                        </div>  
                    </div>  
                </div>
            </div>
        </main>



        <jsp:include page="../WEB-INF/Paginas/comunes/Pie-Pagina.jsp"/>

        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>
    </body>
</html>  
