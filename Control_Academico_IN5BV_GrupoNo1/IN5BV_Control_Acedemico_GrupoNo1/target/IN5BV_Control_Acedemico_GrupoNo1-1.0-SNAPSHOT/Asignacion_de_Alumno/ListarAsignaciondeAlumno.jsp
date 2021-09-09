<%-- 
    Document   : ListarAsignaciondeAlumno
    Created on : 3/09/2021, 11:22:44 AM
    Author     : Usuario
--%>

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
                        <a  class="btn text-light" href="${pageContext.request.contextPath}/ServletEstudiante?accion=agregar&idEstudiante=${estudiante.idEstudiante}" ><i class="fas fa-user-plus"></i> Agregar Salon</i></a>
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
                                    <th>id de asignacion</th>
                                    <th>Carne de Alumno </th>
                                    <th>Curso</th>
                                    <th>Fecha de Asignacion</th>
                                    <th></th>
                                </tr>
                            </thead>
                            
                           <tbody style="background-color: #000000">
                                <c:forEach var="Asignacion_Alumno" items="${listadoAsignacion_Alumnos}">
                                    <tr class="text-light">
                                        <td><i class="fas fa-user"></i>${Asignacion_Alumno.asignacionAlumno}</td>
                                        <td>${Asignacion_Alumno.carneAlumno}}</td>
                                        <td>${Asignacion_Alumno.idCurso}</td>
                                        <td>${Asignacion_Alumno.fechaAsigancion}</td>

                                        <td>
                                            
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
