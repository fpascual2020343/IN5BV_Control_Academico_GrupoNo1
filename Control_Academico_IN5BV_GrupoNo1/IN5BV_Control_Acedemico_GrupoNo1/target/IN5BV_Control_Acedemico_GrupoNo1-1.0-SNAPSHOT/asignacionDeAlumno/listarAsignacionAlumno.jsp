<%-- 
    Document   : ListarAsignaciondeAlumno
    Created on : 3/09/2021, 11:22:44 AM
    Author     : Usuario
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

        <section  >
            <div class="container" >
                <div class="row-cols-1" style="background-color: #5E2129">
                    <div class="col-9">
<<<<<<< HEAD:Control_Academico_IN5BV_GrupoNo1/IN5BV_Control_Acedemico_GrupoNo1/src/main/webapp/asignacionDeAlumno/listarAsignacionAlumno.jsp
                        <a  class="btn text-light" href="${pageContext.request.contextPath}/ServletAsignaciondeAlumnos?accion=agregar&asignacionAlumno=${asignacion_Alumno.asignacionAlumno}" ><i class="fas fa-user-plus"></i> Agregar Asignacion Alumno</i></a>
=======
                        <a  class="btn text-light" href="${pageContext.request.contextPath}/ServletEstudiante?accion=agregar&idEstudiante=${estudiante.idEstudiante}" ><i class="fas fa-user-plus"></i> Agregar Asignacion</i></a>
>>>>>>> origin/pedro:Control_Academico_IN5BV_GrupoNo1/IN5BV_Control_Acedemico_GrupoNo1/src/main/webapp/Asignacion_de_Alumno/ListarAsignaciondeAlumno.jsp
                    </div>
                </div>
            </div>
        </section>


        <section id="asignacionAlumno" class="mt-5 mb-5">
            <div class="container">
                <div class="row" >
                    <div  class="align-content-center" class="col-12 col-md-9" >

                        <div class="card">
                            <div class="card-header">
                                <h4>Listado de Asignaciones</h4>
                            </div>
                        </div>



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
                                            <a style="background-color: #5e2129 " class="btn text-light " href="${pageContext.request.contextPath}/ServletAsignaciondeAlumnos?accion=editar&asignacion_id=${asignacionAlumnoasignacion_id}"><i class="far fa-edit"></i></a>
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