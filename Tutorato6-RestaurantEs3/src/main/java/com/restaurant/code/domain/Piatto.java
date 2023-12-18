package com.restaurant.code.domain;

public class Piatto {
	
	// Per ogni piatto memorizziamo solamente il nome ed il prezzo
	String nome;
	float prezzo;

	/**
	 * @param nome
	 * @param prezzo
	 */
	public Piatto(String nome, float prezzo) {
		this.nome = nome;
		this.prezzo = prezzo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the prezzo
	 */
	public float getPrezzo() {
		return prezzo;
	}

	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

}
