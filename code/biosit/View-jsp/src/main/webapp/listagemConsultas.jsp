<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultas Encontradas</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/consulta.css">
        <%@ page import="br.cefetmg.biosit.dto.Consulta" %>
        <%@ page import="java.util.ArrayList" %>
        <%@page import="br.cefetmg.biosit.service.util.Util" %>

    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="listagemConsulta">
            <section id="container-lista-consulta">
                <%
                        ArrayList<Consulta> consultas = (ArrayList<Consulta>) request.getAttribute("consultas");
                        if(consultas == null) { %>
                <div>Nenhuma consulta encontrada.</div>  
                <% 
            }else if(consultas.size() == 0) {
                %>
                <div>Nenhuma consulta encontrada.</div>
                <%
                        } else {
                            for (Consulta consulta: consultas) {
                %> 
                <article class="unidadeListaCon" onclick="window.location = '/biosit/Facade?act=exibirConsulta&idExibir=<%=consulta.getId()%>'">
                    <section class="cont-esq">
                        <div class="lcnomePaciente"><%=consulta.getNomePaciente()%></div>
                        <div class="lcdescricao"><%=consulta.getDescricao()%></div>
                        <div class="lcurgencia"><%=consulta.getUrgencia()%></div>
                    </section>
                    <section class="cont-dir">
                        <div class="lcmedico"><%=consulta.getMedico()%></div>
                        <div class="lcdata"><%=consulta.getData()%></div>
                        <div class="lchora"><%=consulta.getHorario()%></div>
                    </section>
                </article>
                <%   }} %>
            </section>
            <button class="btn-voltar" onclick="window.location = '/biosit/index.jsp'">Voltar</button>
        </main>
    </body>
</html>
