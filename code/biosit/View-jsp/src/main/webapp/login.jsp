
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/login.css">
        <link rel="stylesheet" href="estilos/header.css">        
    </head>
    <body>
        <header>
            <div class="bloco">
                <img src="imgs/icone.png" id="icone">
                <div>
                    <h1>HospitalLegal</h1>
                    <h3>MEDICAL</h3>
                </div>
            </div>
        </header>
        <main id="login">           
            <section class="secao">
                <h3>Faça seu Login</h3>
                <form action="Facade" method="POST">
                    <label id="usuario">Usuário:
                        <input type="text" name="nome" >
                    </label>
                    <br>
                    <label id="senha">Senha:
                        <input type="password" name="senha">
                    </label>
                    <br>                   
                    <button type="submit" id="" name="act" value="fazerLogin">Entrar</button>
                    <% String error2 = (String) request.getAttribute("error");
                     if (error2 != null && !error2.isEmpty()) {%>
                    <div class="mensagem-erro">
                        <%= error2 %><% } %>
                    </div>
                </form>
            </section>                     
        </main>
    </body>
</html>
