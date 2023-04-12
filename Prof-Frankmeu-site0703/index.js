document.getElementById("botaoImprimir").hidden = true;
function calcular() {
    var altura = document.getElementById("altura").value;
    var peso = document.getElementById("peso").value;
    var resultado;
    if (validarCampos()) {
        resultado = peso / (altura * altura);
        resultado = resultado.toFixed(2);
    }
    var divResultado = document.getElementById("resultado");
    divResultado.innerHTML = resultado;
}

function calculoDinamico() {
    var altura = document.getElementById("altura").value;
    var peso = document.getElementById("peso").value;
    var resultado;
    if (altura > 0 && peso > 0) {
        resultado = peso / (altura * altura);
        resultado = resultado.toFixed(2);
        var divResultado = document.getElementById("resultado");
        divResultado.innerHTML = resultado;
    }
}

function validarCampos() {
    var altura = document.getElementById("altura");
    var peso = document.getElementById("peso");
    if (altura.value <= 0) {
        altura.style.border = "1px solid red";
        altura.style.outline = "1px solid red";
        altura.focus();
        return false;
    } else {
        altura.style.border = "";
        altura.style.outline = "";
    }
    if (peso.value <= 0) {
        peso.style.border = "1px solid red";
        peso.style.outline = "1px solid red";
        peso.focus();
        return false;
    } else {
        altura.style.border = "";
        altura.style.outline = "";
    }
    return true;
}

function mostrarDados() {
    var altura = document.getElementById("altura").value;
    var peso = document.getElementById("peso").value;
    var dadosAltura = document.getElementById("dadosAltura");
    var dadosPeso = document.getElementById("dadosPeso");
    dadosAltura.innerHTML = altura;
    dadosPeso.innerHTML = peso;
}

function mudarEstado(el) {
    mostrarDados();
    var display = document.getElementById(el).style.display;
    var botao = document.getElementById("botaoMostrar");
    if (display == "none") {
        document.getElementById(el).style.display = 'block';
        botao.innerHTML = "Ocultar";
        document.getElementById("botaoImprimir").hidden = false;
    }
    else {
        botao.innerHTML = "Mostrar";
        document.getElementById(el).style.display = 'none';
        document.getElementById("botaoImprimir").hidden = true;

    }
}

//https://www.geeksforgeeks.org/print-the-contents-of-a-div-element-using-javascript/
function printDiv(id) {
    var divContents = document.getElementById(id).innerHTML;
    var a = window.open('', '', 'height=500, width=500');
    a.document.write('<html><body>');
    a.document.write(divContents);
    a.document.write('</body></html>');
    a.document.close();
    a.print();
}