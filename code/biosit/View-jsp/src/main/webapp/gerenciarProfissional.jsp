<%-- 
    Document   : gerenciarProfissional
    Created on : 15 de nov. de 2023, 21:57:36
    Author     : Pedro Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profissionais da saúde</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/paciente.css">
        <link rel="stylesheet" href="estilos/profissional.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="profissional">
            <section>
                <form id="cadastro" action="Facade" method="GET">
                    <h3>Cadastrar</h3>
                    <label class="nome-pro">Nome: <br>
                        <input type="text" name="nome">
                    </label>
                    <label class="nasc-pro">Nascimento: <br>
                        <input type="date" name="nascimento">
                    </label>
                    <label class="cpf-pro">CPF: <br>
                        <input type="number" name="cpf">
                    </label>
                    <label class="email-pro">Email: <br>
                        <input type="email" name="email">
                    </label>
                    <label class="reg-pro">Telefone: <br>
                        <input type="text" name="tel">
                    </label>
                    <label class="cargo-pro">Cargo: <br>
                        <select name="cargo">
                            <option value="gerente">Gerente</option>
                            <option value="secretario">Secretário</option>
                            <option value="medico">Médico</option>
                        </select>
                    </label>
                    <button type="submit" name="act" value="cadastrarProfissional">Cadastrar</button>
                    
                    <%
                    String errorr = (String) request.getAttribute("error");
                    if (errorr != null && !errorr.isEmpty()) {
                    %>
                    <div class="mensagem-erro">
                        <%= errorr %>
                    </div>
                    <%
                    } else {
                        String sucess = (String) request.getAttribute("sucess");
                        if(sucess != null && !sucess.isEmpty()) {
                    %>
                    <div class="mensagem-sucesso">
                        <%= sucess %>
                    </div>
                    <%
                        } }
                    %>
                    
                </form>
                
                <form id="pesquisa" action="Facade" method="GET">
                    <h3>Pesquisar</h3>
                    <label class="nome-pro">Nome: <br>
                        <input type="text" name="nome">
                    </label>
                    <label class="cpf-pro">CPF: <br>
                        <input type="number" name="cpf">
                    </label>
                    <label class="reg-pro">Registro: <br>
                        <input type="text" name="registro">
                    </label>
                    <label class="cargo-pro">Cargo: <br>
                        <select name="cargo">
                            <option value="">Selecionar</option>
                            <option value="gerente">Gerente</option>
                            <option value="secretario">Secretário</option>
                            <option value="medico">Médico</option>
                        </select>
                    </label>
                    <label class="esp-pro">Especialidade: <br>
                        <select name="especialidade">
                            <option value="">Selecionar</option>
                            <option value="cardiologia">Cardiologia</option>
                            <option value="cirurgia">Cirurgia</option>
                            <option value="pediatria">Pediatria</option>
                        </select>
                    </label>
                    <button type="submit" name="act" value="pesquisarProfissional">Pesquisar</button>
                </form>
            </section>
        </main>
    </body>
</html>
