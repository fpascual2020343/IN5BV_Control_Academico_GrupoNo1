<%-- 
    Document   : listarSalones
    Created on : 2/09/2021, 03:56:44 PM
    Author     : Dylan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>
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

        <section  >
            <div class="container"  >
                <div class="text-light"class="row-cols-1" style="background-color: #5E2129">
                    <div class="text-light"class="col-9">
                        <a href="/IN5BV_Control_Acedemico_GrupoNo1/salones/listarSalones.jsp"  class="btn btn-block text-light" >
                            <i class="fa fa-arrow-left" ></i> Regresar a salones 
                        </a>
                    </div>
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-3">
                    </div>
                </div>
            </div>

        </section>

        <section >
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="card" style="background-color: #5E2129">
                            <div class="card-header" style="background-color: #000000">
                                <h1 class="text-light text-center" style="background-color: #5E2129">
                                    <i class="fab fa-delicious"></i> Editar Salones <i class="fab fa-delicious"></i>
                                </h1>
                            </div>
                            <div class="card-body" style="background-color: #000000" >
                                <form class="text-center text-light" method="POST" action="${pageContext.request.contextPath}/ServletSalon" >

                                   <div class="modal-body text-light">

                                <div class="mb-3">
                                    <label for="nombre_salon" class="form-label">Ingrese nombre del salon:  </label> 
                                    <input type="text" id="nombre_salon" name="nombre_salon" class="form-control" value="${salon.nombre_salon}">
                                </div>

                                <div class="mb-3">
                                    <label for="descripcion" class="form-label">Ingrese una descripción:  </label> 
                                    <input type="text" id="descripcion" name="descripcion" class="form-control" value="${salon.descripcion}">
                                </div>

                                <div class="mb-3">
                                    <label for="capacidad" class="form-label">Ingrese la capacidad:  </label> 
                                    <input type="number" id="capacidad" name="capacidad" class="form-control" step="any" value="${salon.capacidad}">
                                </div>

                                <input type="hidden" name="salon_id" value="${salon.salon_id}">
                                <input type="hidden" name="accion" value="actualizar">
                            </div>

                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                <button type="submit" class="btn btn-danger" >Guardar cambios</button>

                                </form>  
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>

    </body>

</html>
