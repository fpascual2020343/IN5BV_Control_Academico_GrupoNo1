<%-- 
    Document   : cabecera
    Created on : 2/09/2021, 10:59:05 AM
    Author     : Franshesco Pascual
--%>
<header id="kinal_header">
    <h1>Centro Educativo y Técnico Laboral KINAL</h1>
</header>

<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #5e2129" >
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Menu</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <div >
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/inicio.jsp">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="${pageContext.request.contextPath}/ServletAlumno?accion=listar"><i class="fas fa-user-graduate"></i> Alumno <i class="fas fa-user-graduate"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/ServletAsignaciondeEstudiantes?accion=listar"><i class="fas fa-graduation-cap"></i> Asignacion Alumno <i class="fas fa-graduation-cap"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href=""><i class="fas fa-briefcase"></i> Carreras Tecnicas <i class="fas fa-briefcase"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="${pageContext.request.contextPath}/ServletCurso?accion=listar"><i class="fas fa-file-signature"></i> Curso <i class="fas fa-file-signature"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/ServletHorario?accion=listar"><i class="far fa-clock"></i> Horario <i class="far fa-clock"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="${pageContext.request.contextPath}/ServletInstructor?accion=listar"><i class="fas fa-chalkboard-teacher"></i> Instructor <i class="fas fa-chalkboard-teacher"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/ServletSalon?accion=listar"><i class="fab fa-delicious"></i> Salon <i class="fab fa-delicious"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/login.jsp"><i class="fas fa-sign-out-alt"></i> Cerrar Sesión</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
