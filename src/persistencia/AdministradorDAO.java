package persistencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Administrador;
import model.Aluno;
import model.Livro;

public class AdministradorDAO {
	
	private static List<Administrador> administradores;
	private static Administrador admLogado;
	private static List<Livro> acervoLivros = new ArrayList<>();
	
	public AdministradorDAO() {
		this.administradores = new ArrayList<>();
	} 
	

	public static void Cadastrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("|------------------|");
		System.out.println("| Digite seu nome  |");
		System.out.println("|------------------|");
		String nome = input.next();
		System.out.println("|----------------------|");
		System.out.println("| Digite seu sobrenome |");
		System.out.println("|----------------------|");
		String sobrenome = input.next();
		System.out.println("|----------------------|");
		System.out.println("| Digite sua matricula |");
		System.out.println("|----------------------|");
		String matricula = input.next();
		System.out.println("|------------------|");
		System.out.println("| Digite sua senha |");
		System.out.println("|------------------|");
		String senha = input.next();
		if(nome.isEmpty() || senha.isEmpty()) {
			System.out.println("Email ou senha vazio. Tente novamente");
			Cadastrar();
		}else {
			Administrador novoAdm = new Administrador();
	        novoAdm.setNome(nome);
	        novoAdm.setSobrenome(sobrenome);
	        novoAdm.setMatricula(matricula);
	        novoAdm.setSenha(senha);
	        
	        AdministradorDAO administradorDAO = new AdministradorDAO();
	        AdministradorDAO.administradores.add(novoAdm);
	        System.out.println("Administrador cadastrado com sucesso!");
		}
	}
	
	public static boolean login(String matricula, String senha) {
        for (Administrador administrador : administradores) {
            if (administrador.getMatricula().equalsIgnoreCase(matricula) && administrador.getSenha().equalsIgnoreCase(senha)) {
            	admLogado = administrador;
                return true; // Login válido
            }
        }
        System.out.println("Matricula ou senha incorretos.");
        return false; // Login inválido
	}
	
	public static Administrador getAdmLogado() {
        return admLogado; // Retorna o adm logado
    }
	
	public static void mostrarDadosAdm() {
		if (admLogado == null) {
	        System.out.println("Nenhum administrador logado.");
	        return;
	    }
	    // Exibe os dados do adm logado
	    System.out.println("Dados do Administrador Logado:");
	    System.out.println("--------------------------------");
	    System.out.println("Nome: " + admLogado.getNome() + " " + admLogado.getSobrenome());
	    System.out.println("Matrícula: " + admLogado.getMatricula());
	    System.out.println("--------------------------------");
    }
	
	public static void alterarDados(Scanner input, String matricula) {
	    // Procurar o aluno pela matrícula
	    Administrador admEncontrado = null;
	    for (Administrador administrador : administradores) {
	        if (administrador.getMatricula().equalsIgnoreCase(matricula)) {
	            admEncontrado = administrador;
	            break;
	        }
	    }
	    // Verificar se o aluno foi encontrado
	    if (admEncontrado == null) {
	        System.out.println("Administrador com a matrícula " + matricula + " não encontrado.");
	        return;
	    }
	    System.out.println("Qual dado você deseja alterar?");
	    System.out.println("|----------------------------|");
	    System.out.println("| 1 - Nome                   |");
	    System.out.println("| 2 - Sobrenome              |");
	    System.out.println("| 3 - Senha                  |");
	    System.out.println("|----------------------------|");
	    
	    int opcao = input.nextInt();
	    input.nextLine(); // Consumir a quebra de linha pendente

	    switch (opcao) {
	        case 1:
	            System.out.println("Digite o novo nome:");
	            String novoNome = input.nextLine();
	            admEncontrado.setNome(novoNome);
	            System.out.println("Nome atualizado com sucesso!");
	            break;
	        case 2:
	            System.out.println("Digite o novo sobrenome:");
	            String novoSobrenome = input.nextLine();
	            admEncontrado.setSobrenome(novoSobrenome);
	            System.out.println("Sobrenome atualizado com sucesso!");
	            break;
	        case 3:
	            System.out.println("Digite a nova senha:");
	            String novaSenha = input.nextLine();
	            admEncontrado.setSenha(novaSenha);
	            System.out.println("Senha atualizada com sucesso!");
	            break;
	        default:
	            System.out.println("Opção inválida!");
	            break;
	    }}
	
	public static void adicionarLivro() {
    	Scanner input = new Scanner(System.in);

        System.out.println("Digite o título do livro:");
        String nome = input.nextLine();

        System.out.println("Digite o autor do livro:");
        String autor = input.nextLine();

        System.out.println("Digite a sinopse do livro:");
        String sinopse = input.nextLine();

        System.out.println("Digite a data de lançamento do livro (formato: yyyy-MM-dd):");
        String dataLancamentoStr = input.nextLine();
        LocalDate dataLancamento = LocalDate.parse(dataLancamentoStr);

        System.out.println("Digite o ISBN do livro:");
        int isbn = input.nextInt();
        input.nextLine(); // Consumir a quebra de linha

        Livro novoLivro = new Livro(nome, autor, sinopse, dataLancamento, isbn, null, new ArrayList<>());
        acervoLivros.add(novoLivro);

        System.out.println("Livro adicionado com sucesso ao acervo!");
}
	
	public static void consultarAcervo() {
        if (acervoLivros.isEmpty()) {
            System.out.println("O acervo está vazio. Nenhum livro cadastrado.");
        } else {
            System.out.println("Acervo de Livros:");
            for (Livro livro : acervoLivros) {
                System.out.println("Título: " + livro.getNome());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Sinopse: " + livro.getSinopse());
                System.out.println("Data de Lançamento: " + livro.getDataLancamento());
                System.out.println("ISBN: " + livro.getIsbn());
                System.out.println("Adicionado por: " + (livro.getAluno() != null ? livro.getAluno().getNome() : "Administrador"));
                System.out.println("-------------------------------");
            }
        }
    }
	
	public static void deletarLivro() {
        if (acervoLivros.isEmpty()) {
            System.out.println("O acervo está vazio. Nenhum livro disponível para exclusão.");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o título do livro que deseja deletar:");
        String titulo = input.nextLine();

        // Busca o livro pelo título
        for (Livro livro : acervoLivros) {
            if (livro.getNome().equalsIgnoreCase(titulo)) {
                acervoLivros.remove(livro);
                System.out.println("Livro '" + titulo + "' deletado com sucesso!");
                return;
            }
        }

        System.out.println("Livro com o título '" + titulo + "' não encontrado no acervo.");
    }
	
	 public static void deletarConta(String matricula) {
	        for (Administrador administrador : administradores) {
	            if (administrador.getMatricula().equalsIgnoreCase(matricula)) {
	                administradores.remove(administrador);
	                System.out.println("Conta deletada com sucesso.");
	                return;
	            }
	        }
	        System.out.println("Administrador com a matrícula fornecida não encontrado.");
	    }
	 
	    public static void visualizarLivrosEmprestados() {
	        boolean livrosEmprestados = false;

	        System.out.println("Livros Emprestados:");
	        for (Livro livro : acervoLivros) {
	            if (livro.getAluno() != null) {
	                System.out.println("Título: " + livro.getNome());
	                System.out.println("Autor: " + livro.getAutor());
	                System.out.println("Emprestado para: " + livro.getAluno().getNome());
	                System.out.println("Matrícula do aluno: " + livro.getAluno().getMatricula());
	                System.out.println("-------------------------------");
	                livrosEmprestados = true;
	            }
	        }

	        if (!livrosEmprestados) {
	            System.out.println("Nenhum livro está emprestado no momento.");
	        }
	    }

	    // Método para remover um empréstimo
	    public static void removerEmprestimo(String tituloLivro) {
	        for (Livro livro : acervoLivros) {
	            if (livro.getNome().equalsIgnoreCase(tituloLivro) && livro.getAluno() != null) {
	                livro.setAluno(null); // Remove o empréstimo ao desassociar o aluno
	                System.out.println("O empréstimo do livro '" + tituloLivro + "' foi removido com sucesso.");
	                return;
	            }
	        }

	        System.out.println("Livro não encontrado ou não está emprestado.");
	    }
}
