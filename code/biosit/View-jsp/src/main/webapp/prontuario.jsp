<%-- 
    Document   : prontuario
    Created on : 22 de out. de 2023, 22:55:27
    Author     : Pedro Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Paciente/Prontuário</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/paciente.css">
        <link rel="stylesheet" href="estilos/prontuario.css">
        <%@ page import="br.cefetmg.biosit.dto.Paciente" %>
        <%@ page import="br.cefetmg.biosit.dto.Prontuario" %>
        <%@ page import="br.cefetmg.biosit.dto.RegistroProntuario" %>
        <%@ page import="java.util.ArrayList" %>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main id="pron">
            <section id="containerwt" class="">
            <form id="frm" action="Facade" method="POST">
                <section id="att-dados">
                    <section id="menu-att-paciente">
                        <div id="sec-geral" class="btn-secao selected">Dados Gerais</div>
                        <div id="sec-pron" class="btn-secao">Prontuário</div>
                        <div id="sec-cons" class="btn-secao">Consultas</div>
                        <div id="sec-exame" class="btn-secao">Exames</div>
                        <div id="sec-receita" class="btn-secao">Receitas</div>
                    </section>
                    <% Paciente paciente = (Paciente) request.getAttribute("paciente_exib");
                    if(paciente.getRG() == null) paciente.setRG("");
                    if(paciente.getTel() == null) paciente.setTel("");
                    %>
                    <section id="dados-gerais" class="secao-sel">
                        <section id="dados-principais">
                            <label id="nome-att">Nome:<br>
                                <input type="text" name="nome" value='<%=paciente.getNome()%>'>
                            </label>
                            <label id="cpf-att">CPF:<br>
                                <input type="number" name="cpf" readonly value=<%=paciente.getCPF()%>>
                            </label>
                            <label id="data-nascimento-att">Nascimento:<br>
                                <input type="date" name="data-nascimento" value="<%=paciente.getNascimento()%>">
                            </label>
                            <label id="endereco-att">Endereço:<br>
                                <input type="text" name="endereco" value='<%=paciente.getEndereco()%>'>
                            </label>
                        </section>
                        <section id="dados-secundarios">
                            <label id="rg-att">RG:<br>
                                <input type="text" name="rg" value='<%=paciente.getRG()%>'>
                            </label>
                            <label id="tel-att">Tel:<br>
                                <input type="text" name="tel" value='<%=paciente.getTel()%>'>
                            </label>
                        </section>
                    </section>
                    <section id="prontuario" class="secao-sel secao-oculta">
                        <section id="container-form-prontuario">
                            <article id="form-prontuario">
                                <label id="title-pron">Título<br>
                                    <input type="text" name="titulo-reg">
                                </label>
                                <label id="categoria-pron">Categoria<br>
                                    <select name="tipo-reg">
                                        <option value="Alergia">Alergia</option>
                                        <option value="Diagnostico">Diagnóstico</option>
                                        <option value="Observacao">Observação</option>
                                        <option value="Registro" selected>Registro</option>
                                    </select>
                                </label>
                                <label id="desc-pron">Descrição<br>
                                    <textarea name="desc-reg"></textarea>
                                </label>
                            </article>
                            <article id="cont-btn-pron-registrar">
                                <button type="submit" name="act" value="AdicionaRegistroProntuario">Registrar</button>
                            </article>
                        </section>
                        <section id="display-registros">
                            <%
                                ArrayList<RegistroProntuario> registros = paciente.getProntuario().listRegistros();
                                if(registros.size() == 0) {
                            %>
                                <div class="notfound">Nenhum registro encontrado.</div>
                            <%
                                    } else {
                                        for (RegistroProntuario reg: registros) {
                            %>
                                <article class="reg-exib-art">
                                    <div class="reg-exib-title"><%=reg.getTitulo()%></div>
                                    <div class="reg-exib-tipo"><%=reg.getTipo()%></div>
                                    <div class="reg-exib-data"><%=reg.getData()%></div>
                                    <div class="reg-exib-desc"><%=reg.getDescricao()%></div>
                                    <div class="container-btn-reg">
                                        <a data-id="<%=reg.getID()%>" class="btn-edit-reg btn-reg"
                                           data-titulo="<%=reg.getTitulo()%>"
                                           data-descricao="<%=reg.getDescricao()%>">
                                            Editar
                                        </a>
                                        <a class="btn-excluir-reg btn-reg"
                                           onclick="window.location='/biosit/Facade?act=excluirRegistro&cpf=<%=paciente.getCPF()%>&id=<%=reg.getID()%>'">Excluir</a>
                                    </div>
                                </article>
                            <%   }} %>
                        </section>
                    </section>
                    <section class="secao-sel secao-oculta">
                        <section>Consultas</section>
                    </section>
                    <section class="secao-sel secao-oculta">
                        <section>Exames</section>
                    </section>
                    <section class="secao-sel secao-oculta">
                        <section>Receitas</section>
                    </section>
                </section>
                <section id="att-btn">
                    <a id="btn-voltar" onclick="location.href = 'paciente.jsp'">Voltar</a>
                    <button id="atualiza-cadastro" type="submit" name="act" value="atualizaPaciente">Atualizar</button>
                    <a id="btn-delete" onclick="window.location='/biosit/Facade?act=excluirPaciente&cpfExcluir=<%=paciente.getCPF()%>'">Excluir</a>
                </section>
                <%
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
            <section id="container-editar-registro" class="editar-off">
                <i id="fechar-edicao" class="fa fa-times" aria-hidden="true"></i>
                <form id="form-editar-reg">
                    <input id="id-reg-edit" type="hidden" name="id" value="">
                    <input type="hidden" name="cpf" value="<%=paciente.getCPF()%>">
                    <article id="form-prontuario-edit">
                        <label id="title-pron-edit">Título<br>
                            <input type="text" name="titulo-reg">
                        </label>
                        <label id="categoria-pron-edit">Categoria<br>
                            <select name="tipo-reg">
                                <option value="alergia">Alergia</option>
                                <option value="diagnostico">Diagnóstico</option>
                                <option value="observacao">Observação</option>
                                <option value="registro" selected>Registro</option>
                            </select>
                        </label>
                        <label id="desc-pron-edit">Descrição<br>
                            <textarea name="desc-reg"></textarea>
                        </label>
                    </article>
                    <article id="cont-btn-pron-registrar-edit">
                        <button type="submit" name="act" value="EditarRegistroProntuario">Atualizar</button>
                    </article>
                </form>
            </section>
        </main>
        <script src="scripts/prontuario.js"></script>
    </body>
</html>
