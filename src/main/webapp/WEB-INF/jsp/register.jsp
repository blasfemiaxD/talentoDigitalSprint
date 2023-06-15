<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
            <div class="alert alert-danger" role="alert">${errorMsg}
                <button type="button" class="close" data-dismiss="alert">
            </div>
        </c:if>

        <div class="container-fluid">
            <div class="card text-center rounded">
                <div class="card-header">
                    <p>${errorMsg}</p>
                    Ingrese datos del usuario.
                  </div>
                <div class="card-body">                    
                    <form:form method="post" modelAttribute="user">
                        <div class="mt-3">
                            <form:input type="text" path="userName" class="form-control" placeholder="User name"/>
                        </div>
                        <div class="mt-3">
                            <form:input type="password" path="password" class="form-control" placeholder="password"/>
                            <form:input type="hidden" path="rol" class="form-control" value="0"/>
                        </div>
                        <form:button type="submit" class="btn btn-block btn-dark mt-3">Register</form:button>
                    </form:form>
                </div>        
            </div>
        </div>
    </div>

</body>
</html>