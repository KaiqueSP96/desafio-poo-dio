package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		Curso curso1 = new Curso();
		
		curso1.setTitulo("Curso Java");
		curso1.setDescricao("É um curso de Java");
		curso1.setCargaHoraria(5);
		
		
		Curso curso2 = new Curso();
		
		curso2.setTitulo("Curso Java Poo");
		curso2.setDescricao("É um curso de Java voltado para POO");
		curso2.setCargaHoraria(3);
		
		
		Mentoria mentoria1 = new Mentoria();
		
		mentoria1.setTitulo("Camila Santos");
		mentoria1.setDescricao("Java");
		mentoria1.setData(LocalDate.now());
		
		
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("bootcamp javadeveloper");
		bootcamp.setDescricao("descrição : descrição aqui");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);

		Dev devKaique = new Dev();
		devKaique.setNome("Kaique");
		devKaique.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos Inscritos Kaique:" + devKaique.getConteudosEscritos());
		
		Dev devFernanda = new Dev();
		devFernanda.setNome("Fernanda");
		devFernanda.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos Inscritos Fernanda:" + devFernanda.getConteudosEscritos());

	}

}
