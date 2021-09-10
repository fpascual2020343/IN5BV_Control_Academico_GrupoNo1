<%-- 
    Document   : listarHorario
    Created on : 3/09/2021, 06:04:29 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--BootStrap -->
        <link rel="stylesheet" href="../assets/css/style.css">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script> 
    </head>


    <body id = "contenido">
        <jsp:include page="/WEB-INF/Paginas/comunes/cabecera.jsp"/>

        <header d="main-header">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1 class="text-light text-center" style="background-color: #5E2129">
                            <i class="far fa-clock"></i> Horarios <i class="far fa-clock"></i>
                        </h1>
                    </div>
                </div>
            </div>
        </header>

        <section  >
            <div class="container" >
                <div class="row-cols-1" style="background-color: #5E2129">
                    <div class="col-9">
<<<<<<< HEAD:Control_Academico_IN5BV_GrupoNo1/IN5BV_Control_Acedemico_GrupoNo1/target/IN5BV_Control_Acedemico_GrupoNo1-1.0-SNAPSHOT/listarHorario.jsp
                        <a  class="btn text-light" href="${pageContext.request.contextPath}/ServletEstudiante?accion=agregar&idEstudiante=${estudiante.idEstudiante}" ><i class="fas fa-user-plus"></i> Agregar Horario</i></a>
=======
                        <a  class="btn text-light" href="${pageContext.request.contextPath}/ServletEstudiante?accion=agregar&idEstudiante=${estudiante.idEstudiante}" ><i class="fas fa-user-plus"></i> Agregar Horario </a>
>>>>>>> origin/miguel:Control_Academico_IN5BV_GrupoNo1/IN5BV_Control_Acedemico_GrupoNo1/src/main/webapp/horarios/listarHorario.jsp
                    </div>
                </div>
            </div>
        </section>


        <section id="Salon">
            <div class="container">
                <div class="row" >
                    <div  class="align-content-center" class="col-2" >
                        <table class="table table-striped table-hover"  style="background-color: #5E2129">
                            <thead class="text-light" >
                                <tr>
                                    <th> #</th>
                                    <th>Final</th>
                                    <th>Inicio</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody style="background-color: #000000">
                            <c:forEach  var  = "horario" items = "${listadoHorario}"> 
                                <tr class="text-light">
                                    <td>${horario.horario_id}</td>
                                    <td>${horario.horario_final}</td>
                                    <td>${horario.horario_inicio}</td>>   
                                    <td> <a style="background-color: #5e2129 " class="btn text-light " href="${pageContext.request.contextPath}/ServletHorario?accion=eliminar&horario_id=${horario.horario_id}"><i class="fas fa-trash"></i></a>
                                    <td> <a style="background-color: #5e2129 " class="btn text-light " href="${pageContext.request.contextPath}/ServletHorario?accion=editarr&horario_id=${horario.horario_id}"><i class="fas fa-edit"></i></a>
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