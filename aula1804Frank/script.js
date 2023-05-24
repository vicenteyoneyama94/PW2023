var listaAlunos=[];

function cadastrar(){    
    let nome = document.querySelector("#nome");
    let nota1 = document.querySelector("#nota1");
    let nota2 = document.querySelector("#nota2");
    let nota3 = document.querySelector("#nota3");

    if(validarCampos(nome, "Nome") && 
    validarCampos(nota1, "Nota 1") &&
    validarCampos(nota2, "Nota 2") &&
    validarCampos(nota3, "Nota 3")){
        let aluno = {nome:nome.value, 
            nota1:nota1.valueAsNumber,
            nota2:parseFloat(nota2.value),
            nota3:nota3.valueAsNumber};
        aluno.media = calcularMedia(aluno);    
        listaAlunos.push(aluno);
    mostrarDados();
    }
}

function mostrarDados(){

    let informacoes = document.querySelector("#informacaoesAdicionais");
    informacoes.innerHTML="Media turma: "+mediaTurma().toFixed(2)+" / Aprovados: "+
        verificarAprovadosReprovados('Aprovado')+" / Reprovados: "+
        verificarAprovadosReprovados('Reprovado');

    let tabela = document.querySelector("#tabela");
    //Nome, Nota 1, Nota 2, Nota 3, Media, Situação
    let cabecalho = '<tr><th>Nome</th><th>Nota 1</th>'+
    '<th>Nota 2</th><th>Nota 3</th><th>Media</th>'+
    '<th>Situação</th></tr>';
    let conteudo="";
    listaAlunos.forEach(el => {
        conteudo += '<tr><td>' + el.nome + '</td><td>' + 
        el.nota1 + '</td><td>' + el.nota2 + '</td><td>' + 
        el.nota3 + '</td><td>' + el.media + '</td><td>' + 
        verificarSituacao(el) +'</td></tr>'; 
    });
    tabela.innerHTML=cabecalho+conteudo;
    tabela.setAttribute('style', "border-collapse:collapse; width:100%");
    tabela.querySelectorAll("th, td").forEach(e => e.setAttribute('style','text-align:center; '+ 
                    'padding:8px; border-bottom:1px solid #ddd'));
    tabela.querySelectorAll("th").forEach(e => e.setAttribute('style', 'background-color:#555; ' +
        'color:#fff'));

}

function mediaTurma(){
    let total=0;
    listaAlunos.forEach(element => {
        total+=element.media;
    });
    return total/listaAlunos.length;
}
//tipo: Aprovado ou Reprovado
function verificarAprovadosReprovados(tipo){
    let total=0;
    listaAlunos.forEach(element => {
        if(verificarSituacao(element)==tipo){
            total+=1;
        }
    });
    return total;
}

function verificarSituacao(aluno){
    return aluno.media<7?"Reprovado":"Aprovado";
}

function calcularMedia(aluno){
    return (aluno.nota1+aluno.nota2+aluno.nota3)/3;
}

function validarCampos(campo, nomeCampo){
    if(!campo.value){
        alert(nomeCampo+" preenchimento obrigatório");
        return false;
    }
    return true;
}