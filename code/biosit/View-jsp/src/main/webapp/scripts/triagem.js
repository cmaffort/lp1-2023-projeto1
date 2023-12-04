let opcaoSelecionada = '';

function selecionarOpcao(opcao) {
    opcaoSelecionada = opcao;
    document.querySelector('.dropbtn').innerText = opcao;
    document.querySelector('.dropdown-content').style.display = 'none';
}
function validar() {
    
}

 function enviarFormulario() {
        var formulario = document.getElementById("meuFormulario");
        var medicoSelecionado = document.getElementById("medico").value;

        // Adicione o valor selecionado como um novo campo oculto no formulário
        var campoMedico = document.createElement("input");
        campoMedico.type = "hidden";
        campoMedico.name = "medico";
        campoMedico.value = medicoSelecionado;
        formulario.appendChild(campoMedico);

        // Envie o formulário
        formulario.submit();
    }
    
    function prepararEnviarFormulario() {
    

        // Define o valor do campo oculto com a string
        document.getElementById("parametroString").value = gravidade;

        // Submete o formulário
        document.getElementById("meuFormulario").submit();
    }
    
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
             document.getElementById("urgenciaa").innerHTML = gravidade;
             if(gravidade === urgente) {
                 
             }
         }
         
         