<%-- 
    Document   : listarCarrera
    Created on : 3/09/2021, 07:45:27 PM
    Author     : Pedro Alexander Lancerio Alvarado
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
    </head>
    <body id = "contenido">
        <jsp:include page="/WEB-INF/Paginas/comunes/cabecera.jsp"/>

        <header d="main-header">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1 class="text-light text-center" style="background-color: #5E2129">
                            <i class="fas fa-briefcase"></i> Carrera Técnica <i class="fas fa-briefcase"></i>
                        </h1>
                    </div>
                </div>
            </div>
        </header>

        <section  >
            <div class="container" >
                <div class="row-cols-1" style="background-color: #5E2129">
                    <div class="col-9">
                        <a  class="btn text-light" href="${pageContext.request.contextPath}/ServletCarreraTecnica?accion=listar&codigo_carrera=${carrera.codigo_estudiante}" ><i class="fas fa-user-plus"></i> Agregar Carrera</i></a>
                    </div>
                </div>
            </div>
        </section>


        <section id="CarreraTecnica">
            <div class="container">
                <div class="row" >
                    <div  class="align-content-center" class="col-2" >
                        <table class="table table-striped table-hover"  style="background-color: #5E2129">
                            <thead class="text-light" >
                                <tr>
                                    <th>#</th>
                                    <th>Nombre</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody style="background-color: #000000">
                                <c:forEach var="CarreraTecnica" items="${listadoCarreraTecnica}" > 
                                    <tr class="text-light">
                                        <td>
                                            <i class="fas fa-user"></i> ${CarreraTecnica.codigo_carrera}</td>
                                        <td>${CarreraTecnica.nombre}</td>
                                        <td>
<<<<<<< HEAD
                                            <a style="background-color: #5e2129 " class="btn text-light" href="${pageContext.request.contextPath}/ServletCarreraTecnica?accion=eliminar&codigo_carrera=${CarreraTecnica.codigo_carrera}"><i class="fas fa-trash"></i></a>
=======
                                            <a style="background-color: #5e2129 " class="btn text-light" href="${pageContext.request.contextPath}/ServletCarreraTecnica?accion=eliminar&codigo_carreraa=${CarreraTecnica.codigo_carrera}"><i class="fas fa-trash"></i></a>
>>>>>>> marck
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
