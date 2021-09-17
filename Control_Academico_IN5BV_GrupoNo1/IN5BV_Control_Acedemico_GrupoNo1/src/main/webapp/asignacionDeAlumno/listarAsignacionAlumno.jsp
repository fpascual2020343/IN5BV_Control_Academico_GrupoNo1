<%-- 
    Document   : ListarAsignaciondeAlumno
    Created on : 3/09/2021, 11:22:44 AM
    Author     : Usuario
--%>
<%@page import="com.grupono1.models.dao.AsignaciondeAlumnoDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.List"%>
<%@page import="com.grupono1.models.domain.Alumno"%>
<%@page import="com.grupono1.models.domain.Curso"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--BootStrap -->
        <link rel="stylesheet" href="../assets/css/style.css">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>
        <title>Listado de Asignacion de Alumnos</title>
    </head>
    <body id = "contenido">

        <!-- Cabecera (Header y nav)-->
        <jsp:include page="/WEB-INF/Paginas/comunes/cabecera.jsp"/>

        <header d="main-header">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1 class="text-light text-center" style="background-color: #5E2129">
                            <i class="fas fa-graduation-cap"></i> Asignacion de Alumnos <i class="fas fa-graduation-cap"></i>
                        </h1>
                    </div>
                </div>
            </div>
        </header>

        <section id="acciones" class="py-4 mb-4">
            <div class="container">
                <div class="row-cols-1" >
                    <div class="col-12 col-md-3">
                        <a class="btn text-light" id="btn-agregar-asignacion"  data-bs-toggle="modal" data-bs-target="#agregar-asignacion-modal">
                            <i class="fas fa-user-plus"></i> Agregar Asignacion de Alumnos
                        </a>
                    </div>
                </div>
            </div>
        </section>

        <!-- Modal -->
        <div class="modal fade" id="agregar-asignacion-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header" style="background-color: #5E2129">
                        <h5 class="modal-title text-white" id="exampleModalLabel">Agregar Asignacion</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletAsignaciondeAlumnos">
                        <div class="modal-body">

                            <div class="mb-3">
                                <label for="asignacion_id" class="form-label">Asignacion</label>
                                <input type="text" id="asignacion_id" name="asignacion_id" class="form-control">    
                            </div>
                            <div class="mb-3">
                                <label for="carne_alumno" class="form-label">Alumno</label>                      
                                <input type="text" id="carne_alumno" name="carne_alumno" class="form-control"> 
                                <label><a href="${pageContext.request.contextPath}/ServletAlumno?accion=listar" style="text-decoration: None">
                                        Para consultar los alumnos presiona aquí</a></label>
                                <label>Para ingresar el alumno debe de colocar el carne</label>

                            </div>
                            <div class="mb-3">
                                <label for="id_curso" class="form-label">Curso</label>
                                <input type="number" id="id_curso" name="id_curso" class="form-control">
                                <label><a href="${pageContext.request.contextPath}/ServletCurso?accion=listar" style="text-decoration: None">
                                        Para consultar los Cursos presiona aquí</a></label>
                                <label>Para ingresar el curso debe de colocar el id</label>
                            </div>
                            <div class="mb-3">
                                <label for="fecha_asignacion" class="form-label">Fecha Asignada</label>
                                <input type="datetime" id="fecha_asignacion" name="fecha_asignacion" class="form-control">   
                                <label>Formato para ingresar fechas es: año-mes-dia formato</label><br>
                                <label>Formato para ingresar hora es: hh:mn:ss</label><br>
                                <label>Ejemplo: 2021-10-05 12:50:15</label>
                            </div>

                            <input type="hidden" name="accion" value="insertar"> 

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">Guardar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <section id="Salon">
            <div class="container">
                <div class="row" >
                    <div  class="align-content-center" class="col-2" >
                        <table class="table table-striped table-hover"  style="background-color: #5E2129">
                            <thead class="text-light" >
                                <tr>
                                    <th>#</th>
                                    <th>Carne de Alumno </th>
                                    <th>Curso</th>
                                    <th>Fecha de Asignacion</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>

                            <tbody style="background-color: #000000">
                                <c:forEach var="asignacionAlumno" items="${listadoAsignacionAlumnos}">

                                    <tr class="text-light">
                                        <td><i class="fas fa-user"></i>${asignacionAlumno.asignacion_id}</td>
                                        <td>${asignacionAlumno.carne_alumno}</td>
                                        <td>${asignacionAlumno.id_curso}</td>
                                        <td>${asignacionAlumno.fecha_asignacion}</td>
                                        <td>
                                            <a style="background-color: #5e2129 " class="btn text-light " href="${pageContext.request.contextPath}/ServletAsignaciondeAlumnos?accion=editar&asignacion_id=${asignacionAlumno.asignacion_id}"><i class="far fa-edit"></i></a>
                                        </td>
                                        <td>
                                            <a style="background-color: #5e2129 " class="btn text-light" href="${pageContext.request.contextPath}/ServletAsignaciondeAlumnos?accion=eliminar&asignacion_id=${asignacionAlumno.asignacion_id}"><i class="fas fa-trash"></i></a>
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
