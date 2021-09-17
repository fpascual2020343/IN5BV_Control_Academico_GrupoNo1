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
                        <a  class="btn text-light" data-bs-target="#agregar-horario-modal" data-bs-toggle="modal"  >
                            <i class="fas fa-user-plus"></i> Agregar Horario </a>
                    </div>
                </div>
            </div>
        </section>
        
           <div class="modal fade" id="agregar-horario-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                  <div class="modal-content">
                      <div class="modal-header" style="background-color: #5E2129" >
                          <h5 class="modal-title  text-light" id="exampleModalLabel"  >Agregar Horario</h5>
                          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                      </div>
                      <form  method="POST" action="${pageContext.request.contextPath}/ServletHorario">
                          <div class="modal-body">

                              <div class="mb-3">                                   
                                  <label>El formato de horas es el siguiente: hh:mm:ss</label><br>
                                  <label>Ejemplo: 12:00:00</label> 
                                  </br>
                                  <label for="horario_final" class="form-label" > Hora de Final </label>
                                  <input type="text" id="horario_final" name="horario_final"  calss="form-control" >
                              </div>

                              <div class="mb-3">  
                                  <label for="horario_inicio" class="form-label" > Hora de Inicio </label>
                                  <input type="text" id="horario_inicio" name="horario_inicio"  calss="form-control" >
                              </div>
 
                              <input type="hidden" name="accion" value="insertar">

                          </div>
                          <div class="modal-footer" style="background-color: #5E2129">
                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                              <button type="submit" class="btn btn-success">Guardar</button>
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
                                    <td> <a style="background-color: #5e2129 " class="btn text-light " href="${pageContext.request.contextPath}/ServletHorario?accion=editar&horario_id=${horario.horario_id}"><i class="fas fa-edit"></i></a>
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
