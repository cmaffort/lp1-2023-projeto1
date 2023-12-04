<%-- 
   Document   : triagem
   Created on : 16 de out. de 2023, 15:18:46
   Author     : Aluno
   --%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@page import="java.util.ArrayList"%>
            <%@page import="br.cefetmg.biosit.dto.Triagem"%>
                <% ArrayList<Triagem> lista = (ArrayList<Triagem>)
request.getAttribute("contatos");
                boolean Modal = (Boolean) request.getAttribute("Modal");
                boolean Modalapagar = (Boolean) request.getAttribute("Modalapagar");
%>
                    <!DOCTYPE html>
                    <html>

                    <head>

                        <title>Triagem</title>
                        <link rel="stylesheet" href="estilos/mae.css">
                        <link rel="stylesheet" href="estilos/triagem.css">
                        <style>
                            table {
                                  
                              }
                          th {
                                
                        background-color: var(--azul);
                        border:1px solid gray;
                            border:none;
                                
                        
                                 
                             }
                             td {border:none;
                             background-color: #eeeee4;
                             
                             padding:1%;}
                             
                             #icone {
                                 width:45%;
                             }
                             
                             #myModal {
                            display: none;
                            position: fixed;
                            top: 50%;
                            left: 50%;
                            transform: translate(-50%, -50%);
                            padding: 20px;
                            background-color: #fff;
                            border: 1px solid #ddd;
                            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                            z-index: 2; /* Alterado para 2 para aparecer acima do fundo escuro */
                        }
                        
                        #myModalapagar {
                            display: none;
                            position: fixed;
                            top: 50%;
                            left: 50%;
                            transform: translate(-50%, -50%);
                            padding: 20px;
                            background-color: #fff;
                            border: 1px solid #ddd;
                            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                            z-index: 2; /* Alterado para 2 para aparecer acima do fundo escuro */
                        }
                    
                        /* Estilos para o fundo escuro quando o modal é exibido */
                        #myModalBackground {
                            display: none;
                            position: fixed;
                            top: 0;
                            left: 0;
                            width: 100%;
                            height: 100%;
                            background-color: rgba(0, 0, 0, 0.5);
                            z-index: 1;
                        }
                        
                        #botaomodal {
                            border: none;
    background-color: var(--azul);
    height: 50px;
    width: 48%;
                        }
                        
                        #labelmodal {
                                display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: flex-start;
                        }
                        
                        #meuFormulario {
                            display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: flex-start;
                        }
                        
                        select {
             border: none;
             background-color: #d9d9d9; 
             height: 60%;
         }
                        
                        
                        </style>
                    </head>

                    <body>
                        <script>
                            
                            
                            
                        window.onload = abrirModal;
                        
                        function abrirModal() {
                            // Exibir o modal e o fundo escuro
                            <%  
                                if(Modal) {%>
                            document.getElementById('myModal').style.display = 'block';
                            document.getElementById('myModalBackground').style.display = 'block';
                             <% } %>
                                 <%  
                                if(Modalapagar) {%>
                            document.getElementById('myModalapagar').style.display = 'block';
                            document.getElementById('myModalBackground').style.display = 'block';
                             <% } %>
                            
                        }
                        
                        
                        function fecharModal() {
                            // Fechar o modal e ocultar o fundo escuro
                            window.location.href = "ExibirTriagem";
                        }
                        
        function submitForm() {
            // Obtém o formulário pelo ID
            var formulario = document.getElementById("meuFormulario");

            // Envia o formulário
            formulario.submit();
        }
        
        function submitFormapagar() {
            // Obtém o formulário pelo ID
            var formularioapagar = document.getElementById("formularioapagar");

            // Envia o formulário
            formularioapagar.submit();
        }
    </script>
                        </script>
                        <%@include file="header.jsp" %>
                            
                            <div id="myModalapagar">
                                <label  id="labelmodal2">
                                    <h2 style="width:100%; text-align: center; margin-bottom: 3%;">Remover Item</h2> 
                                    <form action="ExcluirTriagem" id="formularioapagar"><div style="margin-left:2%;">Você tem certeza que deseja remover permanentemente esse item da fila?</div> <br>
                                        <input hidden type="text" name="idcon" value="<%out.print(request.getAttribute("idconmodal"));%>";>
                                    </form>
                                        <label id="labelmodal">
                                    
                                    <button id="botaomodal" onclick="fecharModal()">Cancelar</button>
                                    
                                    <button style="margin-left: 3%;"id= "botaomodal" onclick="submitFormapagar()">Confirmar</button>               
                                </label>
                                </label>
                            </div>
                        
                            <div id="myModal">
                                <label id="labelmodal2">
                                <label id="labelmodal">
                                    <h2 style="width:100%; text-align: center; margin-bottom: 3%;">Editar Item</h2> 
                                <form style="width:100%; display: flex; margin-bottom: 6%;" action="AtualizarTriagem" id="meuFormulario">
                                    <label id="labelmodal" style="width:100%; margin-bottom: 2%;"> 
                                    Nome:
                                    <input type="text" name="nome" value="<%out.print(request.getAttribute("nomemodal"));%>";>
                                    </label> 
                                    
                                    
                                    
                                    <input hidden type="text" name="idcon" value="<%out.print(request.getAttribute("idconmodal"));%>";>
                                    
                                    
                                    <label style="width:55%;"> 
                                    CPF:
                                    <input readonly id="inputmodal"type="text" name="cpf" value="<%out.print(request.getAttribute("cpfmodal"));%>";> 
                                    </label>
                                    
                                    <label style="width:38%; margin-left: 6%;"> 
                                    Data de nascimento:
                                    <input id="inputmodal"type="date" name="dtnasc" value="<%out.print(request.getAttribute("dtnascmodal"));%>";> <br> 
                                    </label>
                                    
                                    <label for="esp" style="margin: 0px; margin-top: 3%"> *Especialidade:
                                <br>
                                <select id="esp" name="esp" style="margin-top: 4%; width: 100%;">>
                                    <% String espmodal = (String)request.getAttribute("espmodal"); %>
                                    <option value="Selecionar" <%= "Selecionar".equals(espmodal) ? "selected" : "" %>>Selecionar</option>
                                    <option value="Cardiologista" <%= "Cardiologista".equals(espmodal) ? "selected" : "" %>>Cardiologista</option>
                                    <option value="Pneumologista" <%= "Pneumologista".equals(espmodal) ? "selected" : "" %>>Pneumologista</option>
                                    <option value="Neurologista" <%= "Neurologista".equals(espmodal) ? "selected" : "" %>>Neurologista</option>
                                    <option value="Gastroenterologista" <%= "Gastroenterologista".equals(espmodal) ? "selected" : "" %>>Gastroenterologista</option>
                                    <option value="Reumatologista" <%= "Reumatologista".equals(espmodal) ? "selected" : "" %>>Reumatologista</option>
                                    <option value="Urologista" <%= "Urologista".equals(espmodal) ? "selected" : "" %>>Urologista</option>
                                    <option value="Dermatologista" <%= "Dermatologista".equals(espmodal) ? "selected" : "" %>>Dermatologista</option>
                                    <option value="Psiquiatra" <%= "Psiquiatra".equals(espmodal) ? "selected" : "" %>>Psiquiatra</option>
                                    <option value="---" <%= "---".equals(espmodal) ? "selected" : "" %>>---</option>
                                </select>
                                
                                
                            </label>
                                
                                <label for="urg" style="margin: 0px; margin-top: 3%; margin-left: 5%;"> Urgência:
                                <br>
                                <select id="esp" name="urg" style="margin-top: 6%; width: 100%; ">>
                                    <% String urgmodal = (String)request.getAttribute("urgmodal"); %>
                                    <option value="Baixo" <%= "Baixo".equals(urgmodal) ? "selected" : "" %>> Baixa</option>
                                    <option value="Moderado" <%= "Moderado".equals(urgmodal) ? "selected" : "" %>>Moderado</option>
                                    <option value="Urgente" <%= "Urgente".equals(urgmodal) ? "selected" : "" %>>Urgente</option>
                                    
                                </select>
                                
                                
                            </label>
                                
                                
                                
                               <!-- <label for="medico" style="margin: 0px; margin-top: 3%; margin-left: 6%;"> Médico:
                                <br>
                                <select hidden id="medico" name="medico" id=cbPais style="margin-top: 7%; width: 100%; ">
                                    <option value="Selecionar">Selecionar</option>
                                    <option value="Marquinhos">Marquinhos</option>
                                    <option value="Pedro">Pedro</option>
                                    <option value="Niltom">Niltom</option>
                                    <option value="Jeferson">Jeferson</option>
                                    <option value="---" hidden></option>
                                </select>
                            </label> -->
                                    <br>
                                    
                                    
                                </form>
                                    <br>
                                    <button id="botaomodal" onclick="fecharModal()">Voltar</button>
                                    <button style="margin-left: 3%;"id= "botaomodal" onclick="submitForm()">Confirmar</button> 
                                    
                                
                                </label>
                                </label>
                            </div>
                        
                            <div id="myModalBackground"></div>
                            <div class="cinza" style="background-color: rgb(209, 209, 209);">
                                <div class="cadastro" style="display: flex;">

                                    <div style="width:90%;" class="div-cadastro">
                                        <h3>Fila da Triagem</h3>
                                        <table>
                                            <thead>
                                                <tr>

                                                    <th>Nome</th>
                                                    <th>Dt. Nasc.</th>
                                                    <th>CPF</th>
                                                    
                                                    <th>Esp.</th>
                                                    
                                                    <th>Hr. Entrada</th>
                                                    <th>Prev. Atend.</th>
                                                    <th>Urgência</th>
                                                    <th style="padding:0.5%; background-color: white; color: white;">Opções</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                                <%
for(int i = 0; i <lista.size(); i++) {%>
                                                    <tr>

                                                        <td style="width:20%;">
                                                            
                                                            <%=lista.get(i).getNome()%>
                                                            
                                                        </td>
                                                        <td style="text-align: center;">
                                                            <%=lista.get(i).getDtnasc()%>
                                                        </td>
                                                        <td style="text-align: center;">
                                                            <%=lista.get(i).getCpf()%>
                                                        </td>
                                                        
                                                        <td style="text-align: center; width:5%;">
                                                            <%=lista.get(i).getEsp()%>
                                                        </td>
                                                        
                                                        <td style="text-align: center;">
                                                            <%=lista.get(i).getHora_ent()%>
                                                        </td>
                                                        <td style="text-align: center;">
                                                            <%=lista.get(i).getHora_prev()%>
                                                        </td>
                                                        <td style="text-align: center; width:50%;">
                                                            <%=lista.get(i).getUrg()%>
                                                        </td>
                                                        <td style="padding:0.5%; background-color: white;">
                                                            <a href="editarcontato?idcon=<%=lista.get(i).getIdcon()%>" class="botao"><img src="imgs/editar.png" id="icone"> </a>
                                                            <a href="apagarcontato?idcon=<%=lista.get(i).getIdcon()%>" class="botao"><img src="imgs/lixeira.png" id="icone"> </a>
                                                        </td>
                                                    </tr>
                                                    <% } %>


                                            </tbody>
                                        </table>
                                        <br>

                                        <a href="novopacienteTriagem.jsp" class="botaotriagem"><button type="button" style="border: none;
    background-color: var(--azul);
    height: 50px;
    width: 49%">Novo Paciente</button></a>
                                        <a href="novopacienteTriagem.jsp" class="botaotriagem" style="background-color: white;"><button type="button" style="border: none;
    background-color: var(--azul);
    height: 50px;
    width: 49%; margin-left: 1%;">Limpar Fila</button></a>



                                    </div>
                                </div>
                            </div>
                            <script src="scripts/triagem.js"></script>
                    </body>

                    </html>