package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Administrador extends Usuario{
	private ArrayList<Emprestimo> historicoEmprestimoAlunos;

	public Administrador() {
		super();
	}

	public Administrador(String tipo, String nome, String sobrenome, String matricula, String senha, LocalDate dataContratacao, ArrayList<Emprestimo> historicoEmprestimoAlunos) {
		super("Administrador", nome, sobrenome, matricula, senha);
		this.historicoEmprestimoAlunos = historicoEmprestimoAlunos;
	}

	public ArrayList<Emprestimo> getHistoricoEmprestimoAlunos() {
		return historicoEmprestimoAlunos;
	}

	public void setHistoricoEmprestimoAlunos(ArrayList<Emprestimo> historicoEmprestimoAlunos) {
		this.historicoEmprestimoAlunos = historicoEmprestimoAlunos;
	}

	@Override
	public String toString() {
		return "Administrador [ historicoEmprestimoAlunos="
				+ historicoEmprestimoAlunos + "]";
	}
	
}
