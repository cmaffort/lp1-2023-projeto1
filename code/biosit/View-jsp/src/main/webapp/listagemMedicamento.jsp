
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medicamentos Encontrados</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/medicamentos.css">
        <%@ page import="br.cefetmg.biosit.dto.Medicamento" %>
        <%@ page import="java.util.ArrayList" %>
        <%@page import="br.cefetmg.biosit.service.util.Util" %>

    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="listagemMedicamento">
            <section id="container-lista-paciente">
                <%
                        ArrayList<Medicamento> medicamentos = (ArrayList<Medicamento>) request.getAttribute("pacientes");
                        if(medicamentos.size() == 0) {
                %>
                    <div>Nenhum medicamento encontrado.</div>
                <%
                        } else {
                            for (Medicamento medicamento: medicamentos) {
                %>
                    <article class="unidadeListaMed" onclick="window.location='/biosit/Facade?act=exibirMedicamento&nomeExibir=<%=medicamento.getNome()%>'">
                        <section class="cont-esq">
                            <div class="lpnome"><%=medicamento.getNome()%></div>
                            <div class="lpsetor"><%=medicamento.getSetor()%></div>
                            <div class="lpfornecedora"><%=medicamento.getFornecedora()%></div>
                            
                        </section>
                        <section class="cont-dir">
                            <div class="lpquantidade"><%=medicamento.getQuantidade()%></div>
                            <div class="lpvalidade"><%=Util.converter(medicamento.getValidade())%></div>
                        </section>
                    </article>
                <%   }} %>
            </section>
            <button class="btn-voltar" onclick="window.location='/biosit/medicamento.jsp'">Voltar</button>
        </main>
    </body>
</html>
