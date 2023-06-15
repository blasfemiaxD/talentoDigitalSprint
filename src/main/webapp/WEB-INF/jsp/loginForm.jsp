<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">    
    <title>Login</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" />
    <style>
        .Login-form{
            max-width: 28rem;
            margin: auto;
            margin-top: 10%;
        }
    </style>
</head>
<body>
    <div class="Login-form">

        <c:if test = "${not empty errorMsg}">
            <div class="alert alert-danger" role="alert">${errorMsg}</div>
        </c:if>

        <div class="container-fluid">
            <div class="card text-center rounded">
                <div class="card-header">
                    <!--p>${errorMsg}</p-->
                    Ingrese a la aplicacion
                  </div>
                <div class="card-body">                    
                    <form method="post" action="login">
                        <div class="mt-3">
                            <input type="text" name="userName" class="form-control" placeholder="User name"/>
                        </div>
                        <div class="mt-3">                        
                            <input type="password" name="password" class="form-control mt-3" placeholder="password"/>
                        </div>
                        <button type="submit" class="btn btn-block btn-dark mt-3">Login</button>
                        <div class="mt-3">
                            <a href="/register" class="btn btn-success btn-block">Crear Cuenta</a>
                        </div>                        
                    </form>
                </div>        
            </div>
        </div>
    </div>
</body>
</html>