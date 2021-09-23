<%-- 
    Document   : login
    Created on : 15/09/2021, 10:14:07 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/css/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>
        <!--Bootstrap CSS -->
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <title>Login - Fundacion Kinal</title>
    </head>
    <body id="body_Kinal">
        <header id="kinal_header">
            <h1>Centro Educativo y Técnico Laboral KINAL</h1>
        </header>

        <div class="row g-0">

            <div class="col-12 bg-black d-flex flex-column align-items-end min-vh-100 black">
                <div class="align-self-center w-100 px-lg-5 py-lg-4 p-4">
                    <div class="card bg-transparent">


                        <form action="ServletLogin" method="POST">

                            <div class="card-header">
                                <h1 class="text-white text-center"><i class="fas fa-user-circle"></i>Iniciar Sesion</h1>
                            </div>


                            <div class="card-body">
                                <div class="form-floating mb-3">
                                    <input type="text" id="user" name="txtUser" class="form-control" placeholder="Username">


                                    <label for="user" class="form-label">Usuario</label>
                                </div>


                                <div class="form-floating mb-3">
                                    <input type="password" class="form-control" name="txtPass" class="form-control" placeholder="Password">

                                    <label for="password" class="form-label">Contraseña</label>
                                </div>


                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="flexSwitchCheckChecked">
                                    <label class="form-check-label text-white" for="flexSwitchCheckChecked">Recordar Usuario</label>
                                </div>


                                <div class="d-grid gap-5 col-6 mx-auto">

                                    <input type="submit" class="btn btn-outline-light" name="action" value="Ingresar">

                                </div>
                            </div>


                        </form>

                    </div>
                </div>
            </div>
        </div>  

        <!-- Pie de Pagina -->
        <jsp:include page="/WEB-INF/Paginas/comunes/Pie-Pagina.jsp"/>

        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script>
    </body>
</html>