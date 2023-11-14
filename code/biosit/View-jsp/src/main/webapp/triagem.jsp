<%-- 
   Document   : triagem
   Created on : 16 de out. de 2023, 15:18:46
   Author     : Aluno
   --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <link rel="stylesheet" href="estilos/triagem.css">
      <title>Triagem</title>
      <link rel="stylesheet" href="estilos/mae.css">
      <style>
         @import url('https://fonts.googleapis.com/css2?family=Raleway:wght@200&display=swap');
         
         .cadastro  {
             
         
        
         
         
         }
         
         .div-cadastro {
             margin: 0 auto;
             width:25%; /* Altere para o valor da largura desejada. */
             box-shadow: 1px 1px 17px 1px #7a8383;
             font-family: 'Raleway', sans-serif;
             background-color: white;
             padding: 20px;
             margin-top: 70px;
             margin-bottom: 70px;
      
         }
         .cadastro h3 {
         text-align: center;
         font-size: 30px;
         }
         .cadastro button {
         width: 100%;}
         .cadastro form {
 
         }
         input {
         width: 100%;
         font-size: 22px;
         border: none;
         background-color: #d9d9d9;}
         textarea {
         resize: none;
         border: none;
         width: 100%;
         background-color: #d9d9d9;
         font-size: 22px;}
         
         
         
         label {
         margin-bottom: 0; /* Remove a margem na parte inferior da label */
         font-family: 'Raleway', sans-serif;
         }
         
         .botaotriagem {
             border: none;
             background-color: var(--azul);
             height: 50px;
         }
         .dropdown {
         position: relative;
         display: inline-block;
         }
         .dropbtn {
         background-color: #f9f9f9;
         padding: 10px 20px;
         font-size: 16px;
         border: none;
         cursor: pointer;
         }
         .dropdown-content {
         display: none;
         position: absolute;
         background-color: #f9f9f9;
         min-width: 160px;
         box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
         z-index: 1;
         }
         .dropdown-content img {
         width: 15px; /* ou qualquer outra unidade que você preferir */
         height: 15px;
         }
         .dropdown-content a {
         padding: 5px 10px;
         text-decoration: none;
         font-size: 20px;
         display: block;
         }
         .dropdown-content a:hover {
         background-color: #f1f1f1;
         }
         .dropdown:hover .dropdown-content {
         display: block;
         }
         
         
      </style>
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
