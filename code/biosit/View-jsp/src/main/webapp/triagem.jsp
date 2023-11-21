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
      <link rel="stylesheet" href="estilos/mae.css">
      <link rel="stylesheet" href="estilos/triagem.css">
     
   </head>
   <body>
      <%@include file="header.jsp" %>
      <div class="cinza" style="background-color: rgb(209, 209, 209);">
         <div class="cadastro" style="display: flex;">
            <div class= "div-cadastro">
               <form action="Facade" method="GET" >
                  <h3>Triagem</h3>
                  <label id="paciente-triagem">Paciente:</label><br>
                  <input type="text" id="paciente" name="nome" required><br>
                  <label id="sintomas-triagem">Sintomas:</label><br>
                  <textarea id="sintomas" name="sintomas" rows="4" cols="40" required></textarea>
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
                  <button class="botaotriagem" type="submit" name="act" value="cadastrarTriagem">Confirmar</button>
               </form>
            </div>
         </div>
      </div>
      <script src="scripts/triagem.js"></script>
   </body>
</html>
