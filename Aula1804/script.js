var listaAlunos = [];
function cadastrar() {

    let nome = document.querySelector("#nome");
    let nota1 = document.querySelector("#nota1");
    let nota2 = document.querySelector("#nota2");
    let nota3 = document.querySelector("#nota3");

    if (validarCampos(nome, "Nome")
        && validarCampos(nota1, "nota1")
        && validarCampos(nota2, "nota2")
        && validarCampos(nota3, "nota3")) {
        let aluno = {
            nome: nome.value,
            nota1: nota1.valueAsNumber,
            nota2: parseFloat(nota2.value),
            nota3: nota3.valueAsNumber
        }

        aluno.media = calcularMedia(aluno);

        listaAlunos.push(aluno);
        mostrarDados();
    }
}

function mostrarDados() {

    let informacoes = document.querySelector("#informacoesadicionais");
    informacoes.innerHTML = "Media turma:" + mediaTurma().toFixed(2) + " / Aprovados;" +
        verificaAprovadosReprovados('Aprovado') + " / Reprovados:" +
        verificaAprovadosReprovados('reprovado');

    let tabela = document.querySelector("#tabela");
    let cabeçalho = '<tr><th>Nome</th><th>nota1</th><th>nota2</th><th>nota3</th><th>media</th><th>Situação</th></tr>'

    let conteudo = "";
    listaAlunos.forEach(el => {
        conteudo += '<tr><td>' + el.nome + '</td><td>' +
            el.nota1 + '</td><td>' + el.nota2 + '</td><td>' +
            el.nota3 + '</td><td>' + el.media + '</td><td>' +
            verificarSituacao(el) + '</td><tr>';
    });
    tabela.innerHTML = cabeçalho + conteudo;
}

function mediaTurma() {
    let total = 0;
    listaAlunos.forEach(element => {
        total += element.media;
    });
    return total / listaAlunos.length;
}

function verificarSituacao(aluno) {
    return aluno.media < 7 ? "Reprovado" : "Aprovado";
}

function verificaAprovadosReprovados(tipo) {

    let total = 0;
    listaAlunos.forEach(element => {
        if (verificarSituacao(element) == tipo) {
            total += 1;
        }
    });
    return total;

}

function validarCampos(campo, mensagem) {
    if (!campo.value) {
        alert(nomeCampo + "preenchimento obrigatório");
        return false;
    }
    return true;
}

function calcularMedia(aluno) {
    return (aluno.nota1 + aluno.nota2 + aluno.nota3)
}