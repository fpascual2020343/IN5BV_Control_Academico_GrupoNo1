<%-- 
    Document   : listarCursos
    Created on : 2/09/2021, 11:08:57 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--BootStrap -->
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/bootstrap.css">

        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>   

    </head>
    <body id = "contenido">
        <jsp:include page="/WEB-INF/Paginas/comunes/cabecera.jsp"/>

        <header d="main-header">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1 class="text-light text-center" style="background-color: #5E2129">
                            <i class="fas fa-file-signature"></i> Cursos <i class="fas fa-file-signature"></i>
                        </h1>
                    </div>
                </div>
            </div>
        </header>

        <section  >
            <div class="container" >
                <div class="row-cols-1" style="background-color: #5E2129">
                    <div class="col-9">
                        <a  class="btn text-light" href="${pageContext.request.contextPath}/ServletEstudiante?accion=agregar&idEstudiante=${estudiante.idEstudiante}" ><i class="fas fa-user-plus"></i> Agregar Salon</i></a>
                    </div>
                </div>
            </div>
        </section>

        <section id="Cursos">
            <div class="container">
                <div class="row" >
                    <div  class="align-content-center" class="col-2" >
                        <table class="table table-striped table-hover"  style="background-color: #5E2129">
                            <thead class="text-light" >
                                <tr>
                                    <th> #</th>
                                    <th>Ciclo y Salon</th>
                                    <th>Descripcion</th>
                                    <th>Cupo Maximo</th>
                                    <th>Cupo Minimo</th>
                                    <th>Horario</th>
                                    <th>Codigo Carrera</th>
                                    <th>Instructor</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody style="background-color: #000000">
                                <c:forEach  var  = "curso" items = "${listadoCurso}"> 
                                    <tr class="text-light">
                                        <td> <i class="fas fa-user"></i> ${curso.curso_id}</td>
                                        <td>${curso.ciclo} ${curso.id_salon}</td>
                                        <td>${curso.descripcion}</td>
                                        <td>${curso.cupo_maximo}</td>
                                        <td>${curso.cupo_minimo}</td>
                                        <td>${curso.id_horario}</td>
                                        <td>${curso.id_codigo_carrera}</td>
                                        <td>${curso.id_instructor}</td>   
                                        <td>
                                            <a style="background-color: #5e2129 " class="btn text-light " href="${pageContext.request.contextPath}/ServletCurso?accion=editar&curso_id=${curso.curso_id}"><i class="far fa-edit"></i></a>
                                            <a style="background-color: #5e2129 " class="btn text-light " href="${pageContext.request.contextPath}/ServletCurso?accion=eliminar&curso_id=${curso.curso_id}"><i class="fas fa-trash"></i></a>
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
