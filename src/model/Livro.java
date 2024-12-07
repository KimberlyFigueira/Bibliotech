package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Livro {
	private String nome;
	private String autor;
	private String sinopse;
	private LocalDate dataLancamento;
	private int isbn;
	private Aluno aluno;
	private ArrayList<Administrador> administrador;
	
	public Livro() {
		super();
	}

	public Livro(String nome, String autor, String sinopse, LocalDate dataLancamento, int isbn, Aluno aluno,
			ArrayList<Administrador> administrador) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.sinopse = sinopse;
		this.dataLancamento = dataLancamento;
		this.isbn = isbn;
		this.aluno = aluno;
		this.administrador = administrador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public ArrayList<Administrador> getAdministrador() {
		return administrador;
	}

	public void setAdministrador(ArrayList<Administrador> administrador) {
		this.administrador = administrador;
	}

	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", autor=" + autor + ", sinopse=" + sinopse + ", dataLancamento="
				+ dataLancamento + ", isbn=" + isbn + ", aluno=" + aluno + ", administrador=" + administrador + "]";
	}
	
	
}
