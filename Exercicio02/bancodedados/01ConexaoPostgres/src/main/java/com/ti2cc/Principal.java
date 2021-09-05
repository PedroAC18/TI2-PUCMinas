package com.ti2cc;

public class Principal {

	public static void mostrarMenu(){
		System.out.println("------MENU------");
		System.out.println("Digite o numero da opcao desejada");
		System.out.println("1 - Listar Usuarios");
		System.out.println("2 - Inserir Usuario");
		System.out.println("3 - Excluir Usuario");
		System.out.println("4 - Atualizar Usuarios");
		System.out.println("0 - Sair");
	}

	public static void listar(DAO dao){

		//Mostrar usuários
		Usuario[] usuarios = dao.getUsuarios();
		System.out.println("==== Mostrar usuários === ");		
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}


	}
	public static void inserir(DAO dao){

		//Inserir um elemento na tabela
		int codigo = MyIO.readInt();
		int login = MyIO.readString();
		int senha = MyIO.readString();
		int sexo = MyIO.readChar();
		Usuario usuario = new Usuario(codigo, login, senha, sexo);
		if(dao.inserirUsuario(usuario) == true) {
			System.out.println("Inserção com sucesso -> " + usuario.toString());
		}
	
	}
	public static void excluir(DAO dao){

		//Excluir usuário
		System.out.println("Qual o codigo do usuario a ser excluido? ");
		int codigo = MyIO.readInt();

		dao.excluirUsuario(codigo);
	
	}
	public static void atualizar(DAO dao){

		System.out.println("Digite o codigo do usuario: ");
		int codigo = MyIO.readInt();
		Usuario[] usuarios = dao.getUsuariosId(codigo);

		//Atualizar usuário
		System.out.println("Digite a nova senha: ");
		int senha = MyIO.readInt();
		usuarios[0].setSenha(senha);
		dao.atualizarUsuario(usuario[0]);
	
	}
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();
		
		int opcao = -1;

		while(opcao!=0){

			mostrarMenu();
			opcao = MyIO.readInt();

			switch(opcao){

				case 1:
					listar(dao);	
					break;

				case 2:
					inserir(dao);
					break;

				case 3:
					excluir(dao);
					break;

				case 4:
					atualizar(dao);
					break;
				case 0:
					dao.close();
					break;
				default:
					System.out.println("Opcao Invalida");
					mostrarMenu();
			}
		}
		
		
	}
}