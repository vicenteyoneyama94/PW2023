function validarCampo(){
    var cpf = document.getElementById("cpf").value;
    var cnpj = document.getElementById("cnpj").value;

    if (cpf.value > 0){
        cnpj.document.getElementById("cnpj").disabled = true;
    }else if (cnpj.value > 0){
        cpf.document.getElementById("cpf").disabled = true;
    }
}

function printDiv(id) {
    var divContents = document.getElementById(id).innerHTML;
    var a = window.open('', '', 'height=500, width=500');
    a.document.write('<html><body>');
    a.document.write(divContents);
    a.document.write('</body></html>');
    a.document.close();
    a.print();
}