<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>biosit</title>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/index.css">
    </head>

    <body>
        <%@include file="header.jsp" %>
        <main>
            <div id="centro">
                <article id="calendario" class="sombreado">
                    <div id="cabecalhoCalendario">
                        <h1 id="mesAno"></h1>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <th>Dom</th>
                                <th>Seg</th>
                                <th>Ter</th>
                                <th>Qua</th>
                                <th>Qui</th>
                                <th>Sex</th>
                                <th>Sab</th>
                            </tr>
                        </thead>
                        <tbody id="corpoCalendario"></tbody>
                    </table>
                <a href="consulta.jsp"><button id="agendar">Agendar Consulta</button></a>
                </article>
                <article id="agenda" class="sombreado">
                    <h1 id="dataPorExtenso"></h1>
                    <h3 id="diaDaSemana"></h3>
                    <h3>BUSCAR CONSULTA</h3>
                    <section class="busca">
                    <form action="Facade" method="GET"> 
                    <label id="nome-paciente-busca">Paciente:
                        <input type="text" name="nomePaciente">
                    </label>
                    <label id="descricao-busca">Descrição:
                        <input type="text" name="descricao" maxlength="50">
                    </label>
                    <label id="urgencia-busca">Urgência:
                        <input type="text" name="urgencia">
                    </label>
                    <label id="nome-medico-busca">Médico:
                        <input type="text" name="medico" maxlength="50">
                    </label>
                    <label id="data-busca">Data:
                        <input type="text" name="data" maxlength="50">
                    </label>
                    <label id="hora-busca">Horário:
                        <input type="text" name="horario" maxlength="50">
                    </label>
                 
                    <button id="buscaConsulta" type="submit" name="act" value="buscarConsulta">Buscar</button>
                    
              </form>
                    </section>
                </article>
            </div>
        </main>

    </body>
    <script src="scripts/calendario.js"></script>
    <script src="scripts/agenda.js"></script>

</html>
