package model;

import java.util.ArrayList;

public class Aluno extends Usuario{
	private String curso;
	private int periodo;
	private ArrayList<Livro> livrosPegos;
	private ArrayList<Emprestimo> livroAtual;
	
	public Aluno() {
		super();
	}

	public Aluno(String tipo, String nome, String sobrenome, String matricula, String senha, String curso, int periodo, ArrayList<Livro> livrosPegos, ArrayList<Emprestimo> livroAtual) {
		super("Aluno", nome, sobrenome, matricula, senha);
		this.curso = curso;
		this.periodo = periodo;
		this.livrosPegos = livrosPegos;
		this.livroAtual = livroAtual;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public ArrayList<Livro> getLivrosPegos() {
		return livrosPegos;
	}

	public void setLivrosPegos(ArrayList<Livro> livrosPegos) {
		this.livrosPegos = livrosPegos;
	}

	public ArrayList<Emprestimo> getLivroAtual() {
		return livroAtual;
	}

	public void setLivroAtual(ArrayList<Emprestimo> livroAtual) {
		this.livroAtual = livroAtual;
	}

	@Override
	public String toString() {
		return "Aluno [curso=" + curso + ", periodo=" + periodo + ", livrosPegos=" + livrosPegos + ", livroAtual="
				+ livroAtual + "]";
	}
	
}
