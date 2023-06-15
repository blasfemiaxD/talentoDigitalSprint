<%@ page contentType="text/html; charset=UTF-8"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link
      rel="stylesheet"
      href="/webjars/bootstrap/4.6.0/css/bootstrap.min.css"
    />

    <link rel="stylesheet" href="/css/user.css" type="text/css" />
    <script type="text/javascript" src="/js/user.js"></script>

    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css"
    />
    <link
      rel="stylesheet"
      href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css"
    />
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>

    <title>Modulo Usuario</title>
  </head>
  <body>

    <div class="container">
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">SAN</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <!--li class="nav-item active">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li-->
            <li class="nav-item">
              <a class="nav-link" href="/nemu">Modulo Usuarios</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown</a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Separated link</a>
              </div>
            </li>

            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                Mantenedores
              </a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Usuarios</a>
                <a class="dropdown-item" href="#">Nutricionistas</a>
                <a class="dropdown-item" href="#">Pacientes</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled">Welcome ${userModel.getUserName()}</a>
            </li>
          </ul>
            <a>Welcome ${userModel.getUserName()}</a>
            <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Log Out</button>
        </div>
      </nav>
    </div>

    <!--h2>Welcome to Site usuario: ${userModel.getUserName()}</h2>
    <h2>Welcome to Site usuario: ${userModel.getIdUser()}</h2>
    <h2>Welcome to Site usuario: ${userModel.getPassword()}</h2>
    <h2>Welcome to Site usuario: ${userModel.getRol()}</h2-->

    <div class="container">
      <h1 class="p-3">Modulo Usuarios</h1>
      <button type="button" class="btn btn-outline-primary">
        <a href="/addUser">+ Crear Usuario</a>
      </button>
      <form:form>
        <div>
          <table
            id="dtUser"
            class="table table-hover table-dark table-sm"
          >
            <thead class="thead-light">
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Usuario</th>
                <th scope="col">Rol</th>
                <th scope="col">Editar</th>
                <th scope="col">Borrar</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="user" items="${listUser}">
                <tr>
                  <th scope="row">${user.getIdUser()}</th>
                  <td>${user.getUserName()}</td>
                  <td>${user.getRol()}</td>
                  <td><button type="button" class="btn btn-outline-success">
                		    <a href="/editUser/${user.getIdUser()}">Edit</a>
                		</button></td>
                		<td><button type="button" class="btn btn-outline-warning">
                			<a href="/deleteUser/${user.getIdUser()}">Delete</a>
                		</button></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </form:form>
    </div>

    <script>
      $(document).ready(function () {
        $("#dtUser").DataTable({
          scrollY: "600px",
          scrollCollapse: true,
        });
        $(".dataTables_length").addClass("bs-select");
      });
    </script>
  </body>

</html>
