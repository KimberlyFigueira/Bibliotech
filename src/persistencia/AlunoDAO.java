package persistencia;
import model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Aluno;
import model.Livro;

public class AlunoDAO {
	
	private static List<Aluno> alunos;
	private static Aluno alunoLogado;
	private static List<Livro> acervoLivros = new ArrayList<>();
	
	public AlunoDAO() {
		this.alunos = new ArrayList<>();
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
		System.out.println("|-------------------|");
		System.out.println("| Digite seu curso  |");
		System.out.println("|-------------------|");
		String curso = input.next();
		System.out.println("|---------------------|");
		System.out.println("| Digite seu periodo  |");
		System.out.println("|---------------------|");
		int periodo = input.nextInt();
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
			Aluno novoAluno = new Aluno();
	        novoAluno.setNome(nome);
	        novoAluno.setSobrenome(sobrenome);
	        novoAluno.setMatricula(matricula);
	        novoAluno.setCurso(curso);
	        novoAluno.setPeriodo(periodo);
	        novoAluno.setSenha(senha);
	        
	        AlunoDAO alunoDAO = new AlunoDAO();
	        //alunoDAO.aluno acessa a lista de alunos da instancia alunoDAO
	        alunoDAO.alunos.add(novoAluno);
	        System.out.println("Aluno cadastrado com sucesso!");
		}
	}
	
	public static boolean login(String matricula, String senha) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equalsIgnoreCase(matricula) && aluno.getSenha().equalsIgnoreCase(senha)) {
            	alunoLogado = aluno;
                return true; // Login válido
            }
        }
        System.out.println("Matricula ou senha incorretos.");
        return false; // Login inválido
	}
	
	public static Aluno getAlunoLogado() {
        return alunoLogado; // Retorna o aluno logado
    }
	
	public static void mostrarDadosAluno() {
		if (alunoLogado == null) {
	        System.out.println("Nenhum aluno logado.");
	        return;
	    }
	    // Exibe os dados do aluno logado
	    System.out.println("Dados do Aluno Logado:");
	    System.out.println("--------------------------------");
	    System.out.println("Nome: " + alunoLogado.getNome() + " " + alunoLogado.getSobrenome());
	    System.out.println("Matrícula: " + alunoLogado.getMatricula());
	    System.out.println("Curso: " + alunoLogado.getCurso());
	    System.out.println("Período: " + alunoLogado.getPeriodo() + "º período");
	    System.out.println("--------------------------------");
    }
	
	public static void alterarDados(Scanner input, String matricula) {
	    // Procurar o aluno pela matrícula
	    Aluno alunoEncontrado = null;
	    for (Aluno aluno : alunos) {
	        if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
	            alunoEncontrado = aluno;
	            break;
	        }
	    }
	    // Verificar se o aluno foi encontrado
	    if (alunoEncontrado == null) {
	        System.out.println("Aluno com a matrícula " + matricula + " não encontrado.");
	        return;
	    }
	    System.out.println("Qual dado você deseja alterar?");
	    System.out.println("|----------------------------|");
	    System.out.println("| 1 - Nome                   |");
	    System.out.println("| 2 - Sobrenome              |");
	    System.out.println("| 3 - Curso                  |");
	    System.out.println("| 4 - Período                |");
	    System.out.println("| 5 - Senha                  |");
	    System.out.println("|----------------------------|");
	    
	    int opcao = input.nextInt();
	    input.nextLine(); // Consumir a quebra de linha pendente

	    switch (opcao) {
	        case 1:
	            System.out.println("Digite o novo nome:");
	            String novoNome = input.nextLine();
	            alunoEncontrado.setNome(novoNome);
	            System.out.println("Nome atualizado com sucesso!");
	            break;
	        case 2:
	            System.out.println("Digite o novo sobrenome:");
	            String novoSobrenome = input.nextLine();
	            alunoEncontrado.setSobrenome(novoSobrenome);
	            System.out.println("Sobrenome atualizado com sucesso!");
	            break;
	        case 3:
	            System.out.println("Digite o novo curso:");
	            String novoCurso = input.nextLine();
	            alunoEncontrado.setCurso(novoCurso);
	            System.out.println("Curso atualizado com sucesso!");
	            break;
	        case 4:
	            System.out.println("Digite o novo período:");
	            int novoPeriodo = input.nextInt();
	            alunoEncontrado.setPeriodo(novoPeriodo);
	            System.out.println("Período atualizado com sucesso!");
	            break;
	        case 5:
	            System.out.println("Digite a nova senha:");
	            String novaSenha = input.nextLine();
	            alunoEncontrado.setSenha(novaSenha);
	            System.out.println("Senha atualizada com sucesso!");
	            break;
	        default:
	            System.out.println("Opção inválida!");
	            break;
	    }}
	    
	    public static void doarLivro() {
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
	    
	    public static void pegarLivroEmprestado(Aluno aluno) {
	        if (acervoLivros.isEmpty()) {
	            System.out.println("O acervo está vazio. Nenhum livro disponível para empréstimo.");
	            return;
	        }
	        Scanner input = new Scanner(System.in);
	        System.out.println("Digite o título do livro que deseja pegar emprestado:");
	        String titulo = input.nextLine();
	        for (Livro livro : acervoLivros) {
	            if (livro.getNome().equalsIgnoreCase(titulo)) {
	                if (livro.getAluno() == null) {
	                    livro.setAluno(aluno);
	                    System.out.println("Livro emprestado com sucesso! Aproveite sua leitura, " + aluno.getNome());
	                } else {
	                    System.out.println("O livro já está emprestado para outro aluno.");
	                } return;
	            }
	        }
	        System.out.println("Livro não encontrado no acervo.");
	    }
	    
	    public static void deletarConta(String matricula) {
	        for (Aluno aluno : alunos) {
	            if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
	                alunos.remove(aluno);
	                System.out.println("Conta deletada com sucesso.");
	                return;
	            }
	        }
	        System.out.println("Aluno com a matrícula fornecida não encontrado.");
	    }
}
