package persistencia;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Aluno;
import model.Livro;

public class AlunoDAO {
	
	private static List<Aluno> alunos;
	private static Aluno alunoLogado;
	
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
        System.out.println("Email ou senha incorretos.");
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
}
