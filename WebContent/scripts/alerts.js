function deletar(){
	if (confirm("Deseja excluir ?")) {
		alert("Excluido com sucesso!")
    } else {
      return false;
	}
}

function login(){
	document.forms["frmLogin"].submit()
	alert("Login realizado com sucesso!")
	}