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
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>   
    </head>
    <body id = "contenido">
        <jsp:include page="/WEB-INF/Paginas/comunes/cabecera.jsp"/>

        <section id="actions" class="py-4 mb-4 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <a href="listarCarrera.jsp" class="btn btn-light btn-block">
                            <i class="fa fa-arrow-left"></i> Regresar a carerras
                        </a>
                    </div>
                    <div class="col-md-3">
                        <a href=""></a>
                    </div>
                    <div class="col-md-3">
                        <a href=""></a>
                    </div>
                </div>
            </div>

        </section>

        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Carrera</h4>
                            </div>
                            <div class="card-body">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletCarreraTecnica">

                                    <div class="mb-3">
                                        <label for="nombre" class="form-label">Ingrese un codigo</label>
                                        <input type="text" id="nombre" name="nombre" class="form-control" value = "${carrera.codigo_carrera}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="nombre" class="form-label">Ingrese una carrera</label>
                                        <input type="text" id="nombre" name="nombre" class="form-control" value="${carrera.nombre}">
                                    </div>

                                    <input type="hidden" name="accion" value="agregar">
                                    <input type="hidden" name="codigo_carrera" value="${carrera.codigo_estudiante}">

                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                    <button type="submit" class="btn btn-success">Guardar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <jsp:include page="/WEB-INF/Paginas/comunes/Pie-Pagina.jsp"/>
        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>

    </body>
</html>
