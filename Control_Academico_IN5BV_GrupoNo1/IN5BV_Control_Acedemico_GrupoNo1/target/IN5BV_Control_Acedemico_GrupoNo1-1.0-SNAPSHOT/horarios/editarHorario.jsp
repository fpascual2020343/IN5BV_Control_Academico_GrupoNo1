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
                            <i class="far fa-clock"></i> Editar Horario <i class="far fa-clock"></i>
                        </h1>
                    </div>
                </div>
            </div>
        </header>

        <section>
            <div class="container" >
                <div class="row-cols-1" style="background-color: #5E2129">
                    <div class="col-9">
                        <a href=" horarios/listarHorario.jsp"  class="btn text-light"   >
                            <i class="far fa-clock"></i> Regresar a  Horarios </a>
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
                                <h4>Editar Registro</h4>
                            </div>
                            <div class="card-body">       
                                <form  method="POST" action="${pageContext.request.contextPath}/ServletHorario">
                                    <div class="modal-body">

                                        <div class="mb-3">                                   
                                            <label>El formato de horas es el siguiente: hh:mm:ss</label><br>
                                            <label>Ejemplo: 12:00:00</label> 
                                            </br>
                                            </br>
                                            <label for="horario_final" class="form-label" > Hora de Final </label>
                                            <input type="text" id="horario_final" name="horario_final"  calss="form-control" value="${horario.horario_final}" >
                                        </div>

                                        <div class="mb-3">  
                                            <label for="horario_inicio" class="form-label" > Hora de Inicio </label>
                                            <input type="text" id="horario_inicio" name="horario_inicio"  calss="form-control" value="${horario.horario_inicio}" >
                                        </div>
                                        <input type="hidden" name="horario_id" value="${horario.horario_id}">
                                        <input type="hidden" name="accion" value="actualizar">
                                       

                                        

                                    </div>
                                    <div class="modal-footer" style="background-color: #5E2129">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                        <button type="submit" class="btn btn-success">Guardar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>>
   

     

        <jsp:include page="/WEB-INF/Paginas/comunes/Pie-Pagina.jsp"/>
        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>

    </body>
</html>