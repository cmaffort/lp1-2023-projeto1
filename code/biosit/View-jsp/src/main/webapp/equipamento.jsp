
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estilos/mae.css">
        <link rel="stylesheet" href="estilos/equipamentos.css">
        <title>Cadastro de Equipamento</title>
    </head>
    <body>



        <!DOCTYPE html>
    <html>
        <head>
            <link rel="stylesheet" href="estilos/header.css">
        </head>
        <header>
            <div class="bloco">
                <img src="imgs/icone.png" id="icone">
                <div>
                    <h1>HospitalLegal</h1>
                    <h3>MEDICAL</h3>
                </div>
            </div>
            <div class="bloco" id="menu">
                <button id="mostrar-notificacoes"><img src="imgs/sino.png" id="sino"></button>
                <button id="mostrar-menu">?</button>
            </div>
        </header>
        <section id="opcoes" class="menu-escondido">
            <h1>Menu</h1>
            <ul class="lista">
                <a href="funcionarios.jsp"><li>Funcion√°rios</li></a>
                <a href="equipamento.jsp"><li>Equipamentos</li></a>
                <a href="medicamento.jsp"><li>Medicamento</li></a>
                <a href="paciente.jsp"><li>Paciente</li></a>
                <a href="triagem.jsp"><li>Triagem</li></a>
                <a href="financeiro.jsp"><li>Financeiro</li></a>
                <a href="encaminhamento.jsp"><li>Encaminhamento</li></a>
                <a href="requisicao.jsp"><li>Requisi√ß√£o de Exames</li></a>
            </ul>
        </section>
        <section id="notificacoes" class="menu-escondido">
            <h1>Notifica√ß√µes</h1>
            <p>Nenhuma notifica√ß√£o</p>
        </section>
        <script src="scripts/header.js"></script>
    </html>

    <main id="equipamento">
        <section class="cadastro">

            <div class="cadastro">
                <div>
                    <form action="Facade" method="GET" >
                        <h3>Cadastro de Equipamento</h3>
                        <label id="nome-equipamento">
                            Nome do Equipamento:
                            <input type="text" id="nome" name="nome" required>
                        </label>
                        <label id="fornecedora-equipamento">
                            Fornecedora:
                            <br>
                            <input type="text" id="fornecedora" name="fornecedora" required>
                        </label>


                        <label id="data-aquiscao-equipamento">
                            Data de AquisiÁ„o:
                            <br>
                            <input type="date" id="data" name="data" required>
                        </label>

                        <label id="quantidade-equipamento">
                            Quantidade:
                            <br>
                            <input type="number" id="quantidade" name="quantidade" required>
                        </label>
                        <label id="setor-equipamento">
                            Setor:
                            <br>
                            <input type="text" id="setor" name="setor" required>
                        </label>


                        <button id="cadastrar" type="submit" name="act" value="cadastrarEquipamento">Cadastrar</button>
                    </form>
                </div>
        </section>

        <section class="buscar">
            <form action="Facade" method="GET">
                <h3>PESQUISA</h3>
                <label id="nome-buscar">Nome:<br>
                    <input type="text" name="nome" maxlength="50">
                </label>
                <label id="fornecedora-buscar">Fornecedora:<br>
                    <input type="text" name="fornecedora">
                </label>
                <label id="data-buscar">Data de aquisiÁ„o:<br>
                    <input type="date" name="data">
                </label>
                <label id="quantidade-buscar">Quantidade:<br>
                    <input type="text" name="quantidade" maxlength="100">
                </label>
                <label id="setor-buscar">Setor:<br>
                    <input type="text" name="setor" maxlength="100">
                </label><br>
                <button type="submit" name="act" value="buscarEquipamento">Pesquisar</button>
                <button type="button" id="consultarHistorico">Consultar HistÛrico</button><br>
            </form>
        </section>
    </main>
</body>
</html>
