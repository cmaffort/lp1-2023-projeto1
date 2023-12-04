<%-- 
   Document   : triagem
   Created on : 16 de out. de 2023, 15:18:46
   Author     : Aluno
   --%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Triagem</title>
            <script>
                let sintomasSelecionados = [];

function atualizarSintomas(sintomaCheckbox, marcado) {
    if (marcado) {
        sintomasSelecionados.push(sintomaCheckbox.value);
    } else {
        sintomasSelecionados = sintomasSelecionados.filter(item => item !== sintomaCheckbox.value);
    }

    avaliarGravidade();
}

function avaliarGravidade() {
    var dataAtual = new Date();
    var hora = dataAtual.getHours();
    var minutos = dataAtual.getMinutes();
    var segundos = dataAtual.getSeconds();

    // Formata a hora, minutos e segundos para o formato desejado
    var horaFormatada = hora < 10 ? '0' + hora : hora;
    var minutosFormatados = minutos < 10 ? '0' + minutos : minutos;
    var segundosFormatados = segundos < 10 ? '0' + segundos : segundos;

    // Concatena os valores formatados em uma única string
    var horaCompleta = horaFormatada + ':' + minutosFormatados;
    let gravidade = "Baixo";

    if (sintomasSelecionados.includes("urgente")) {
        gravidade = "Urgente";
    } else if (sintomasSelecionados.includes("moderado")) {
        gravidade = "Moderado";
    } else if (sintomasSelecionados.some(sintoma => urgente.includes(sintoma))) {
        gravidade = "Urgente";
    }

    document.getElementById("urg").value = gravidade;
    document.getElementById("hora_ent").value = horaCompleta;

    atualizarInterface(gravidade);
}

function atualizarInterface(gravidade) {
    // Atualiza o conteúdo do parágrafo com a gravidade calculada
    document.getElementById("urgenciaa").innerHTML = gravidade;
    if (gravidade === urgente) {

    }
}

var dataAtual = new Date();

function formatarHora(data) {
    var hora = data.getHours();
    var minutos = data.getMinutes();
    var horaFormatada = hora < 10 ? '0' + hora : hora;
    var minutosFormatados = minutos < 10 ? '0' + minutos : minutos;
    return horaFormatada + ':' + minutosFormatados;
}

function atualizarHoraEntrada() {
    var dataAtual = new Date();
    var hora = dataAtual.getHours();
    var minutos = dataAtual.getMinutes();
    var segundos = dataAtual.getSeconds();

    // Formata a hora, minutos e segundos para o formato desejado
    var horaFormatada = hora < 10 ? '0' + hora : hora;
    var minutosFormatados = minutos < 10 ? '0' + minutos : minutos;
    var segundosFormatados = segundos < 10 ? '0' + segundos : segundos;

    var horaCompleta = horaFormatada + ':' + minutosFormatados;

    document.getElementById("hora_ent").value = horaCompleta;
}

function validarFormulario() {
    var nome = document.forms["formulario"]["nome"].value;
    var nomeInput = document.forms["formulario"]["nome"];
    var espInput = document.forms["formulario"]["esp"];
    var esp = document.forms["formulario"]["esp"].value;
    var dtnascinput = document.forms["formulario"]["dtnasc"];
    var dtnasc = document.forms["formulario"]["dtnasc"].value;
    var urgencia = document.getElementById("urg").value;
    var cpf = document.getElementById('cpf').value;
    var cpfinput = document.forms["formulario"]["cpf"];
    atualizarHoraEntrada();
    
    if (nome === "") {
        mensagemErro.style.display = "block";
        nomeInput.classList.add("input-invalido");
        return false;
    }
    if (esp === "Selecionar") {
        mensagemErro.style.display = "block";
        espInput.classList.add("select-invalido");
        return false;
    }
    if (dtnasc === "") {
        dtnascinput.type = "text";
        dtnascinput.value = '---';
    }
    if (cpf === "") {
        cpfinput.type = "text";
        cpfinput.value = '---';
    }
    if (urgencia === "") {
    var horaPrev = new Date(dataAtual.getTime() + 2 * 60 * 60 * 1000);
        document.getElementById("hora_prev").value = formatarHora(horaPrev);
    document.getElementById("urg").value = "Baixa";
    
    }
    if (urgencia === "Moderado") {
        // Adicione 50 minutos
        var horaPrev = new Date(dataAtual.getTime() + 50 * 60 * 1000);
        document.getElementById("hora_prev").value = formatarHora(horaPrev);
    }
    if (urgencia === "Urgente") {
        // Adicione 50 minutos
        var horaPrev = new Date(dataAtual.getTime() + 50 * 60 * 1000);
        document.getElementById("hora_prev").value = document.getElementById("hora_ent").value
    }
    else {
        mensagemErro.style.display = "none";
        return true;
    }
    
}

var inputDate = document.getElementById("dtnasc");

    // Obtém a data atual
    var dataAtual = new Date();

    // Formata a data no formato YYYY-MM-DD (o formato esperado pelo input date)
    var ano = dataAtual.getFullYear();
    var mes = (dataAtual.getMonth() + 1).toString().padStart(2, '0');
    var dia = dataAtual.getDate().toString().padStart(2, '0');
    inputDate.value = `${ano}-${mes}-${dia}`;

   // Obtém a hora, os minutos e os segundos do objeto Date
            </script>
            <style>
                .mensagem-erro {
                    color: red;
                    display: none;
                }
                
                .mensagem-erro-cpf {
                    color: red;
                    display: none;
                }
            </style>
            <link rel="stylesheet" href="estilos/mae.css">
            <link rel="stylesheet" href="estilos/novopacienteTriagem.css">
        </head>

        <body>
            <%@include file="header.jsp" %>
                <main class="cinza" style="background-color: rgb(209, 209, 209);">
                    <div class="cadastrotriagem">
                        <form name="formulario" action="CadastrarTriagem" onsubmit="return validarFormulario()" method="GET" id="form">
                            <h3>Novo Paciente</h3>
                            <label style="width:100%;" id="nome-cadastrotriagem">*Nome:
                                <input style="width:100%;" type="text" id="nome" name="nome">
                                <br> </label>
                            <label style="width:100%;" id="endereco-cadastrotriagem">Endereço:
                                <input style="width:100%;" type="text" id="rg" name="endereco">
                                <br> </label>
                            <label style="width:48%;" id="datanasc-cadastrotriagem">Data de nascimento:
                                <input style="width:100%;" type="date" id="dtnasc" name="dtnasc" value="">
                                <br> </label>
                            <label style="width:48%;" id="cpf-cadastrotriagem">CPF:
                                <input style="width:100%;" type="number" id="cpf" name="cpf">
                                <br> </label>
                            <br>
                            <label style="width:48%"> </label>
                            <br>
                            <label id="labelataamo" style="width: 100%;">
                                <div style="width:30%;">
                                    <h4> Sintomas Gerais: </h4>
                                    <label style="width:100%;">
                                        <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)"> Febre </label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)"> Calafrios </label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Perda de Apetite</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Perda de peso</label>
                                    <br>
                                    <br>
                                </div>
                                <div style="width:30%">
                                    <h4> Sintomas Respiratórios: </h4>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Tosse </label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="urgente" onchange="atualizarSintomas(this, this.checked)"> Falta de ar</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="urgente" onchange="atualizarSintomas(this, this.checked)"> Dor no peito ao respirar</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Expectoração de catarro</label>
                                    <br>
                                    <br>
                                </div>
                                <label style="width:30%">
                                    <h4> Sintomas Gastrointestinais: </h4>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Náuseas </label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)"> Vômitos </label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)"> Diarreia </label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Dor abdominal</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)"> Sangramento Gastrointestinal</label>
                                    <br>
                                    <br>
                                </label>
                                <label style="width:30%">
                                    <h4> Sintomas Cardiovasculares: </h4>
                                    <label style="width:100%">
                                        <input type="checkbox" value="urgente" onchange="atualizarSintomas(this, this.checked)"> Dor ou desconforto no peito</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="urgente" onchange="atualizarSintomas(this, this.checked)"> Palpitações </label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="urgente" onchange="atualizarSintomas(this, this.checked)"> Tontura </label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="urgente" onchange="atualizarSintomas(this, this.checked)"> Desmaio </label>
                                    <br>
                                    <br>
                                </label>
                                <label style="width:30%">
                                    <h4> Sintomas Neurológicos: </h4>
                                    <label style="width:100%">
                                        <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)"> Dor de cabeça</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Tontura </label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)"> Fraqueza </label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Problemas de visão</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="urgente" onchange="atualizarSintomas(this, this.checked)"> Confusão </label>
                                    <br>
                                    <br>
                                </label>
                                <label style="width:30%">
                                    <h4> Sintomas Musculares e Articulares: </h4>
                                    <label style="width:100%">
                                        <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)"> Dor muscular</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Rigidez nas articulações</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Inchaço nas articulações</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)"> Redução na mobilidade</label>
                                    <br>
                                    <br>
                                </label>
                                <label style="width:30%">
                                    <h4> Sintomas Urinários: </h4>
                                    <label style="width:100%">
                                        <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)"> Dificuldade em urinar</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)"> Dor ao urinar</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Aumento da frequência urinária</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Sangue na urina</label>
                                    <br>
                                    <br>
                                </label>
                                <label style="width:30%">
                                    <h4> Sintomas Dermatológicos: </h4>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Erupção Cutânea</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Coceira </label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Alterações na cor de pele</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Úlceras na pele</label>
                                    <br>
                                    <br>
                                </label>
                                <label style="width:30%">
                                    <h4> Sintomas Psicológicos: </h4>
                                    <label style="width:100%">
                                        <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)"> Ansiedade Intensa</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)"> Depressão Intensa</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="moderado" onchange="aixoatualizarSintomas(this, this.checked)"> Alterações de humor</label>
                                    <br>
                                    <label style="width:100%">
                                        <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)"> Insõnia </label>
                                    <br>
                                    <br>
                                    <br>
                                </label>
                            </label>
                            <label> </label>
                            <!--<label for="sintomas" style="display: block;" id="urgencia-triagem">Urgência:</label>
                  <div class="dropdown">
                      <button class="dropbtn">Selecionar</button>
                      <div class="dropdown-content">
                          <a href="#" onclick="selecionarOpcao('Leve')"> <img src="imgs/leve.png"> Leve </a>
                          <a href="#" onclick="selecionarOpcao('Moderado')"> <img src="imgs/moderado.png"> Moderado </a>
                          <a href="#" onclick="selecionarOpcao('Grave')"> <img src="imgs/grave.png"> Grave </a>
                      </div>
                  </div>-->
                            <br>
                            <!--<label for="medico" style="margin: 0px;"> Médico:
                                <br>
                                <select id="medico" name="medico" id=cbPais style="margin-top: 10%">
                                    <option value="Selecionar">Selecionar</option>
                                    <option value="Marquinhos">Marquinhos</option>
                                    <option value="Pedro">Pedro</option>
                                    <option value="Niltom">Niltom</option>
                                    <option value="Jeferson">Jeferson</option>
                                    <option value="---" hidden></option>
                                </select>
                            </label> -->
                            <label for="esp" style="margin: 0px;"> *Especialidade:
                                <br>
                                <select id="esp" name="esp" style="margin-top: 8%">>
                                    <option value="Selecionar">Selecionar</option>
                                    <option value="Cardiologista">Cardiologista</option>
                                    <option value="Pneumologista">Pneumologista</option>
                                    <option value="Neurologista">Neurologista</option>
                                    <option value="Gastroenterologista">Gastroenterologista</option>
                                    <option value="Reumatologista">Reumatologista</option>
                                    <option value="Urologista">Urologista</option>
                                    <option value="Dermatologista">Dermatologista</option>
                                    <option value="Psiquiatra">Psiquiatra</option>
                                    <option value="---" hidden></option>
                                </select>
                            </label>
                            <!--<label for="consult" style="margin: 0px; margin-left: 6%"> Consultório:
                                <br>
                                <select id="consult" name="consult" style="margin-top: 10%">>
                                    <option value="Selecionar">Selecionar</option>
                                    <option value="147">147</option>
                                    <option value="148">148</option>
                                    <option value="149">149</option>
                                    <option value="150">150</option>
                                    <option value="---" hidden></option>
                                </select>
                            </label> -->
                            <label style="width:100%;" id="sintomas-triagem">
                                <br>Sintomas Adicionais:
                                <textarea style="width:100%;" id="sintomas" name="sintomas" rows="4" cols="40"></textarea>
                                <br> </label>
                            <label id="socorrodeus"> Urgência: </label>
                            <label id="urgenciaa"> Baixa</label>
                            <br>
                            <br>
                            <div Style="width: 100%"> </div>
                            <input type="hidden" id="urg" name="urg" value="">
                            <input type="hidden" id="hora_ent" name="hora_ent" value="">
                            <input type="hidden" id="hora_prev" name="hora_prev" value="">
                            <input type="hidden" id="medicohidden" name="hora_prev" value="">
                            <div id="mensagemErroCpf" class="mensagem-erro-cpf">Por favor, verifique se o CPF preenchido é válido. </div>
                            <br>
                            <div id="mensagemErro" class="mensagem-erro">Por favor, preencha todos os campos obrigatórios. </div>
                            <br>
                            <button class="botaotriagem" type="submit" name="act" value="CadastrarTriagem" onclick="validarFormulario(); avaliarGravidade;">Confirmar</button>
                            <%
                    String nome = (String) request.getAttribute("nome");
                    String dtnasc = (String) request.getAttribute("dtnasc");
                    String cpf = (String) request.getAttribute("cpf");
                    String medico = (String) request.getAttribute("medico");
                    String consult = (String) request.getAttribute("consult");
                    String esp = (String) request.getAttribute("esp");
                    String hora_ent = (String) request.getAttribute("hora_ent");
                    String hora_prev = (String) request.getAttribute("hora_prev");
                    String urg = (String) request.getAttribute("urg");
                    
                    
                    %>
                                <div class="mensagem-erro">
                                    <%= nome %>
                                        <%= dtnasc %>
                                            <%= cpf %>
                                                <%= medico %>
                                                    <%= consult %>
                                                        <%= esp %>
                                                            <%= hora_ent %>
                                                                <%= hora_prev %>
                                                                    <%= urg %>
                                </div>
                        </form>
                    </div>
                </main>
                <script src="scripts/triagem.js"></script>
        </body>

        </html>