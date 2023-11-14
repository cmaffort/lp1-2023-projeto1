<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Consulta</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/consulta.css">
        <%@ page import="br.cefetmg.biosit.dto.Consulta" %>
        <%@ page import="java.util.ArrayList" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="consulta-att">
            <section class="atualizacao">
                <form id="frm" action="Facade" method="GET">
                        <h3>Dados Gerais</h3>
                        <% Consulta consulta = (Consulta) request.getAttribute("consulta_exib");
                            if(consulta != null){
                        %>                         
                            <label id="nome-paciente-att">Paciente:<br>
                                <input type="text" name="nomePaciente" value='<%=consulta.getNomePaciente()%>'>
                            </label>
                            <label id="descricao-att">Descrição:<br>
                                <input type="text" name="descricao" value='<%=consulta.getDescricao()%>'>
                            </label>
                            <label id="urgencia-att">Urgência:<br>
                                <input type="text" name="urgencia" value='<%=consulta.getUrgencia()%>'>
                            </label>
                            <label id="nome-medico-att">Médico:<br>
                                <input type="text" name="medico" value='<%=consulta.getMedico()%>'>
                            </label> 
                            <label id="data-att">Data:<br>
                                <input type="text" name="data" value='<%=consulta.getData()%>'>
                            </label>
                            <label id="hora-att">Horário:<br>
                                <input type="text" name="horario" value='<%=consulta.getHorario()%>'>
                            </label>
                    <section id="att-btn">
                        <a id="btn-voltar" onclick="location.href = 'index.jsp'">Voltar</a>
                        <button id="atualiza-consulta" type="submit" name="act" value="atualizarConsulta">Atualizar</button>
                        <a id="btn-delete" onclick="window.location='/biosit/Facade?act=excluirConsulta&nomeExcluir=<%=consulta.getNomePaciente()%>'">Excluir</a>
                    </section>
                    <%
                        }
                        String erro = (String) request.getAttribute("error");
                        if (erro != null && !erro.isEmpty()) {
                    %>
                    <div class="mensagem-erro">
                        <%= erro %>
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
            </section>
        </main>
    </body>
</html>
