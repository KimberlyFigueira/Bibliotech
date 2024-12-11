package apresentacao;

import java.util.Scanner;

import model.Aluno;
import persistencia.AlunoDAO;

public class View {
	
	public static void bemVindo() {
		System.out.println("Seja muito bem-vinde!");
		System.out.println("Oque deseja fazer?");
		System.out.println("|------------------|");
		System.out.println("| 1 - Entrar       |");
		System.out.println("| 2 - Cadastrar    |");
		System.out.println("|------------------|");
	}
	
	public static void tipoUser() {
		System.out.println("Você é:");
		System.out.println("|-------------------|");
		System.out.println("| 1 - Aluno         |");
		System.out.println("| 2 - Administrador |");
		System.out.println("|-------------------|");
	}
	
	private static void realizarLoginAluno() {
		Scanner input = new Scanner(System.in);
	    System.out.println("|-------- Login -------|");
	    System.out.println("| Digite sua matrícula |");
	    System.out.println("|----------------------|");
	    String matricula = input.next();

	    System.out.println("|------------------|");
	    System.out.println("| Digite sua senha |");
	    System.out.println("|------------------|");
	    String senha = input.next();

	    // Valida o login e acessa as opções do aluno se o login for bem-sucedido
	    if (AlunoDAO.login(matricula, senha)) {
	        opcoesAluno(input);
	    }
	}
	
	public static void opcoesAluno(Scanner input) {
		Aluno alunoLogado = AlunoDAO.getAlunoLogado();
		if (alunoLogado != null) {
	        System.out.println("Seja muito bem-vindo(a), " + alunoLogado.getNome() + "!");
	    } else {
	        System.out.println("Nenhum aluno logado.");
	        return;
	    }
		System.out.println("O que você deseja fazer?");
		System.out.println("|----------------------|");
		System.out.println("| 1 - Mostrar dados    |");
		System.out.println("| 2 - Consultar Acervo |");
		System.out.println("| 3 - Pegar Livro      |");
		System.out.println("| 4 - Doar livro       |");
		System.out.println("| 5 - Sair             |");
		System.out.println("|----------------------|");
		
		int opcaoFuncaoAluno = input.nextInt();

	    switch (opcaoFuncaoAluno) {
	        case 1:
	            AlunoDAO.mostrarDadosAluno();
	            voltarSair(input);
	            break;
	        case 2:
	            System.out.println("Funcionalidade de consultar acervo ainda não implementada.");
	            voltarSair(input);
	            break;
	        case 3:
	            System.out.println("Função de pegar livro emprestado sendo implementado");
	            break;
	        case 4: 
	        	System.out.println("Função de doar livro em implementação.");
	        	break;
	        case 5: System.out.println("Saindo do sistema. Até mais!");
	        default:
	            System.out.println("Opção inválida! Tente novamente.");
	            opcoesAluno(input);
	    }
	}
	
	public static void opcoesAdm() {
		System.out.println("Seja muito bem vinde ");
		System.out.println("Oque você deseja fazer?");
		System.out.println("|----------------------|");
		System.out.println("| 1 - Mostrar dados    |");
		System.out.println("| 2 - Consultar Acervo |");
		System.out.println("| 3 - Adicionar livro  |");
		System.out.println("| 4 - Deletar livro    |");
		System.out.println("|----------------------|");
	}
	
	public static void voltarSair(Scanner input) {
		System.out.println("|----------------|");
	    System.out.println("| 1 - Voltar     |");
	    System.out.println("| 2 - Sair       |");
	    System.out.println("|----------------|");

	    int escolha = input.nextInt();

	    if (escolha == 1) {
	        opcoesAluno(input);
	    } else if (escolha == 2) {
	        System.out.println("Saindo do sistema. Até mais!");
	    } else {
	        System.out.println("Opção inválida! Tente novamente.");
	        voltarSair(input);
	    }
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		bemVindo();
		int alunoOuAdm = input.nextInt();
		switch(alunoOuAdm) {
		case 1: 
			System.out.println("|-------- Login -------|");
		    System.out.println("| Digite sua matrícula |");
		    System.out.println("|----------------------|");
		    String matricula = input.next();
		    System.out.println("|------------------|");
		    System.out.println("| Digite sua senha |");
		    System.out.println("|------------------|");
		    String senha = input.next();
			AlunoDAO.login(matricula, senha);
			voltarSair(input);
		case 2: AlunoDAO.Cadastrar();
			bemVindo();;
			alunoOuAdm = input.nextInt();
			realizarLoginAluno();
		}
	}
}
