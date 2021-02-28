function deletar(){
	if (confirm("Deseja excluir ?")) {
		alert("Excluido com sucesso!")
    } else {
      return false;
	}
}

function logout(){
	if (confirm("Deseja sair e encerrar a sessão?")) {
	// Não faz nada e sai da sessão
    } else {
      return false;
	}
}