package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
	
	private String nome;
	private Set<Conteudo> conteudosEscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
		
	public void inscreverBootcamp(Bootcamp bootcamp) {
		
		this.conteudosEscritos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);
	}
	
	public void progredir() {
		
		Optional<Conteudo> conteudo =  this.conteudosConcluidos.stream().findFirst();
		if(conteudo.isPresent()) {
			this.conteudosConcluidos.add(conteudo.get());
			this.conteudosEscritos.remove(conteudo.get());
		} else {
			System.err.println("você não esta matriculado em nenhum conteudo.!");
		}
	}
	
	public double calcularxp() {
		
		return this.conteudosConcluidos
				.stream()
				.mapToDouble (Conteudo :: calcularXP)
				.sum();		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudosEscritos() {
		return conteudosEscritos;
	}

	public void setConteudosEscritos(Set<Conteudo> conteudosEscritos) {
		this.conteudosEscritos = conteudosEscritos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudosConcluidos, conteudosEscritos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudosConcluidos, other.conteudosConcluidos)
				&& Objects.equals(conteudosEscritos, other.conteudosEscritos) && Objects.equals(nome, other.nome);
	}
	
	
}
