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
            let gravidade = "Baixo";

            if (sintomasSelecionados.includes("urgente")) {
                gravidade = "Urgente";
            } else if (sintomasSelecionados.includes("moderado")) {
                gravidade = "Moderado";
            } else if (sintomasSelecionados.some(sintoma => urgente.includes(sintoma))) {
                gravidade = "Urgente";
            }

            atualizarInterface(gravidade);
        }

        function atualizarInterface(gravidade) {
            // Atualiza o conteúdo do parágrafo com a gravidade calculada
            document.getElementById("gravidade").innerHTML = "Urgência: " + gravidade;
        }
    </script>
    
    
    
      <link rel="stylesheet" href="estilos/mae.css">
      <link rel="stylesheet" href="estilos/novopacienteTriagem.css">
     
   </head>
   <body>
      <%@include file="header.jsp" %>
      <main class="cinza" style="background-color: rgb(209, 209, 209);">
            <div class= "cadastrotriagem">
               <form action="Facade" method="GET" >
                  <h3>Novo Paciente</h3>
                  
  
                  
                  <label style="width:100%;" id="nome-cadastrotriagem">Nome:
                  <input style="width:100%;"type="text" id="nome" name="nome"><br></label>
                  
                  <label style="width:100%;" id="endereco-cadastrotriagem">Endereço:
                  <input style="width:100%;" type="text" id="rg" name="endereco"><br></label>
                  
                
                  <label style="width:48%;" id="datanasc-cadastrotriagem">Data de nascimento:
                  <input style="width:100%;"type="date" id="datanasc" name="datanasc"><br></label>
                  
                  
                  
                  <label style="width:48%;" id="cpf-cadastrotriagem">CPF:
                  <input style="width:100%;" type="number" id="rg" name="cpf"><br></label>
                  
                  <br>
                  
                  
                  
                  
                  
                  
                  <label style="width: 100%;">
                      Sintomas gerais:<br>
                      <label style="width:100%"> <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)">
                          Febre</label><br>
                      
                      <label style="width:100%"> <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)">
                          Calafrios</label><br>
                      
                      <label style="width:100%"> <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)">
                          Perda de Apetite</label><br>
                      
                       <label style="width:100%"> <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)">
                           Perda de peso</label><br><br>
                          
                          
                       Sintomas Respiratórios:<br>
                      <label style="width:100%"> <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)">
                          Tosse</label><br>
                      
                      <label style="width:100%"> <input type="checkbox" value="urgencia" onchange="atualizarSintomas(this, this.checked)">
                          Falta de ar</label><br>
                      
                      <label style="width:100%"> <input type="checkbox" value="urgencia" onchange="atualizarSintomas(this, this.checked)">
                          Dor no peito ao respirar</label><br>
                      
                       <label style="width:100%"> <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)">
                           Expectoração de catarro</label><br><br>
                           
                         
                           Sintomas Gastrointestinais:<br>
                      <label style="width:100%"> <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)">
                          Náuseas</label><br>
                           
                           <label style="width:100%"> <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)">
                          Vômitos</label><br>
                      
                      <label style="width:100%"> <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)">
                          Diarreia</label><br>
                      
                      <label style="width:100%"> <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)">
                          Dor abdominal</label><br>
                      
                       <label style="width:100%"> <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)">
                           Sangramento Gastrointestinal</label><br><br>
                           
                           
                         Sintomas Cardiovasculares:<br>
                      <label style="width:100%"> <input type="checkbox" value="urgente" onchange="atualizarSintomas(this, this.checked)">
                          Dor ou desconforto no peito</label><br>
                           
                           <label style="width:100%"> <input type="checkbox" value="urgente" onchange="atualizarSintomas(this, this.checked)">
                          Palpitações</label><br>
                      
                      <label style="width:100%"> <input type="checkbox" value="urgente" onchange="atualizarSintomas(this, this.checked)">
                          Tontura</label><br>
                      
                      <label style="width:100%"> <input type="checkbox" value="urgente" onchange="atualizarSintomas(this, this.checked)">
                          Desmaio</label><br><br>
                          
                          
                          Sintomas Neurológicos:<br>
                      <label style="width:100%"> <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)">
                          Dor de cabeça</label><br>
                           
                           <label style="width:100%"> <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)">
                          Tontura</label><br>
                      
                      <label style="width:100%"> <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)">
                          Fraqueza</label><br>
                      
                      <label style="width:100%"> <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)">
                          Problemas de visão</label><br>
                          
                          
                       <label style="width:100%"> <input type="checkbox" value="urgente" onchange="atualizarSintomas(this, this.checked)">
                           Confusão</label><br><br>
                           
                           
                           Sintomas Musculares e Articulares:<br>
            
                           
                           <label style="width:100%"> <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)">
                          Tontura</label><br>
                      
                      <label style="width:100%"> <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)">
                          Fraqueza</label><br>
                      
                      <label style="width:100%"> <input type="checkbox" value="baixo" onchange="atualizarSintomas(this, this.checked)">
                          Problemas de visão</label><br>
                          
                          
                       <label style="width:100%"> <input type="checkbox" value="moderado" onchange="atualizarSintomas(this, this.checked)">
                           Confusão</label><br><br>
                      
                       
                            
                  </label>
                  
                  
                  
                  
                  <label>
        
        Dor no Peito
    </label>
                  
                  
              
                  <label for="sintomas" style="display: block;"id="urgencia-triagem">Urgência:</label>
                  
                      
                  <div class="dropdown">
                     <button class="dropbtn">Selecionar</button>
                     <div class="dropdown-content">
                        <a href="#" onclick="selecionarOpcao('Leve')"> <img src="imgs/leve.png"> Leve </a>
                        <a href="#" onclick="selecionarOpcao('Moderado')"> <img src="imgs/moderado.png"> Moderado </a>
                        <a href="#" onclick="selecionarOpcao('Grave')"> <img src="imgs/grave.png"> Grave </a>
                     </div>
                  </div>
                  <br>
                  <br>
                  <p id="gravidade">Urgência: Baixo</p>
                  <label style="width:100%;" id="sintomas-triagem">Sintomas:
                      <textarea style="width:100%;" id="sintomas" name="sintomas" rows="4" cols="40" required></textarea><br></label>
                  <button class="botaotriagem" type="submit" name="act" value="cadastrarTriagem">Confirmar</button>
               </form>
            </div>
         
      </main>
      
      <script src="scripts/triagem.js"></script>
   </body>
</html>
