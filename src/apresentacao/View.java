package apresentacao;

import java.util.Scanner;

import model.Aluno;
import persistencia.AdministradorDAO;
import persistencia.AlunoDAO;
import model.Administrador;

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
	
	private static void realizarLoginAdm() {
		Scanner input = new Scanner(System.in);
	    System.out.println("|-------- Login -------|");
	    System.out.println("| Digite sua matrícula |");
	    System.out.println("|----------------------|");
	    String matricula = input.next();

	    System.out.println("|------------------|");
	    System.out.println("| Digite sua senha |");
	    System.out.println("|------------------|");
	    String senha = input.next();

	    // Valida o login e acessa as opções do adm se o login for bem-sucedido
	    if (AdministradorDAO.login(matricula, senha)) {
	        opcoesAdm(input);
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
		System.out.println("| 2 - Alterar dados    |");
		System.out.println("| 3 - Doar livro       |");
		System.out.println("| 4 - Consultar Acervo |");
		System.out.println("| 5 - Pegar Livro      |");
		System.out.println("| 6 - Sair             |");
		System.out.println("| 7 - Deletar conta    |");
		System.out.println("|----------------------|");
		
		int opcaoFuncaoAluno = input.nextInt();

	    switch (opcaoFuncaoAluno) {
	        case 1:
	            AlunoDAO.mostrarDadosAluno();
	            voltarSair(input);
	            break;
	        case 2:
	        	System.out.println("Digite sua matrícula: ");
	        	String matricula = input.next();
	            AlunoDAO.alterarDados(input, matricula);
	            voltarSair(input);
	            break;
	        case 3:
	            AlunoDAO.doarLivro();
	            voltarSair(input);
	            break;
	        case 4: AlunoDAO.consultarAcervo();
	        	voltarSair(input);
	        	break;
	        case 5: System.out.println("Digite sua matricula para realizar o empréstimo:");
            	matricula = input.next();
            	Aluno aluno = new Aluno();
            	aluno.setMatricula(matricula);
            	AlunoDAO.pegarLivroEmprestado(aluno);
            	voltarSair(input);
            	break;
	        case 6: System.out.println("Saindo... Até mais.");
	        		bemVindo();;
	        	break;
	        case 7: System.out.println("Digite sua matrícula para deletar a conta");
	        	matricula = input.next();
	        	AlunoDAO.deletarConta(matricula);
	        	voltarSair(input);
	        default:
	            System.out.println("Opção inválida! Tente novamente.");
	            opcoesAluno(input);
	    }
	}
	
	public static void opcoesAdm(Scanner input) {
		System.out.println("Seja muito bem vinde ");
		System.out.println("Oque você deseja fazer?");
		System.out.println("|----------------------|");
		System.out.println("| 1 - Mostrar dados    |");
		System.out.println("| 2 - Editar dados     |");
		System.out.println("| 3 - Consultar Acervo |");
		System.out.println("| 4 - Adicionar livro  |");
		System.out.println("| 5 - Deletar livro    |");
		System.out.println("| 6 - Deletar conta    |");
		System.out.println("| 7 - Sair             |");
		System.out.println("|----------------------|");
		
		int opcaoFuncaoADM = input.nextInt();

	    switch (opcaoFuncaoADM) {
	        case 1:
	            AdministradorDAO.mostrarDadosAdm();;
	            voltarSair(input);
	            break;
	        case 2:
	        	System.out.println("Digite sua matrícula: ");
	        	String matricula = input.next();
	            AdministradorDAO.alterarDados(input, matricula);
	            voltarSair(input);
	            break;
	        case 3:
	            AdministradorDAO.adicionarLivro();;
	            voltarSair(input);
	            break;
	        case 4: AdministradorDAO.consultarAcervo();
	        	voltarSair(input);
	        	break;
	        case 5: AdministradorDAO.deletarLivro();
            	voltarSair(input);
            	break;
	        case 6: System.out.println("Digite sua matrícula para deletar a conta: ");
	        	matricula = input.next();
	        	AdministradorDAO.deletarConta(matricula);
	        	bemVindo();
	        	break;
	        case 7: System.out.println("Saindo... Até mais!");
	        default:
	            System.out.println("Opção inválida! Tente novamente.");
	            opcoesAluno(input);
	    }
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
		Scanner input =  new Scanner (System.in);
		while (true) {
            bemVindo();
            int escolhaInicial = input.nextInt();

            switch (escolhaInicial) {
            case 1: // Login
                tipoUser();
                int tipoUsuario = input.nextInt();

                if (tipoUsuario == 1) {
                    realizarLoginAluno();
                } else if (tipoUsuario == 2) {
                    realizarLoginAdm();
                } else {
                    System.out.println("Opção inválida.");
                }
                break;

            case 2: // Cadastro
                tipoUser();
                tipoUsuario = input.nextInt();

                if (tipoUsuario == 1) {
                    AlunoDAO.Cadastrar();
                } else if (tipoUsuario == 2) {
                    AdministradorDAO.Cadastrar();
                } else {
                    System.out.println("Opção inválida.");
                }
                break;

            default:
                System.out.println("Opção inválida.");
				
			}
		
		}
	}
}
