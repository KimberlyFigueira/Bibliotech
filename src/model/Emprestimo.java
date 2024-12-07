package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Emprestimo {
	private LocalDate dataEmprestimo;
	private String status;
	private ArrayList<Administrador> administrador;
	private ArrayList<Livro> livroEmprestado;
	private Aluno aluno;
	
	public Emprestimo() {
		super();
	}

	public Emprestimo(LocalDate dataEmprestimo, String status, ArrayList<Administrador> administrador,
			ArrayList<Livro> livroEmprestado, Aluno aluno) {
		super();
		this.dataEmprestimo = dataEmprestimo;
		this.status = status;
		this.administrador = administrador;
		this.livroEmprestado = livroEmprestado;
		this.aluno = aluno;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Administrador> getAdministrador() {
		return administrador;
	}

	public void setAdministrador(ArrayList<Administrador> administrador) {
		this.administrador = administrador;
	}

	public ArrayList<Livro> getLivroEmprestado() {
		return livroEmprestado;
	}

	public void setLivroEmprestado(ArrayList<Livro> livroEmprestado) {
		this.livroEmprestado = livroEmprestado;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "Emprestimo [dataEmprestimo=" + dataEmprestimo + ", status=" + status + ", administrador="
				+ administrador + ", livroEmprestado=" + livroEmprestado + ", aluno=" + aluno + "]";
	}
	
	
}
