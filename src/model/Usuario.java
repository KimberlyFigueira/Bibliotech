package model;

public abstract class Usuario {
	private String tipo;
	private String nome;
	private String sobrenome;
	private String matricula;
	private String senha;
	
	public Usuario() {
		super();
	}

	public Usuario(String tipo, String nome, String sobrenome, String matricula, String senha) {
		super();
		this.tipo = tipo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.matricula = matricula;
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [tipo=" + tipo + ", nome=" + nome + ", sobrenome=" + sobrenome + ", matricula=" + matricula
				+ ", senha=" + senha + "]";
	}
	
	
}
