<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de paciente</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/consulta.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="consulta">
            <section class="agendamento">
              <form action="Facade" method="GET"> 
                    <h3>AGENDAR CONSULTA</h3>
                    <label id="nome-paciente">Paciente:<br>
                        <input type="text" name="nomePaciente">
                    </label>
                    <label id="descricao">Descrição:<br>
                        <input type="text" name="descricao" maxlength="50">
                    </label>
                    <label id="urgencia">Urgência:<br>
                        <input type="text" name="urgencia">
                    </label>
                    <label id="nome-medico">Médico:<br>
                        <input type="text" name="medico" maxlength="50">
                    </label> 
                    <label id="data-hora">Data:<br>
                        <input type="text" name="data" maxlength="50">
                    </label>
                    <label id="data-hora">Horário:<br>
                        <input type="text" name="horario" maxlength="50">
                    </label>
                 
                    <button id="enviaConsulta" type="submit" name="act" value="cadastroConsulta">Agendar</button>
              </form>
                    
              
                    