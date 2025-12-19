package com.restaurant.domain;

import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class Piatto.
 */
public class Piatto {

	/** The nome. */
	private String nome;

	/** The prezzo. */
	private double prezzo;

	/**
	 * Instantiates a new piatto.
	 *
	 * @param nome   the nome
	 * @param prezzo the prezzo
	 */
	public Piatto(String nome, double prezzo) {
		this.nome = Objects.requireNonNull(nome, "nome must not be null");
		this.prezzo = prezzo;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = Objects.requireNonNull(nome, "nome must not be null");
	}

	/**
	 * Gets the prezzo.
	 *
	 * @return the prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	 * Sets the prezzo.
	 *
	 * @param prezzo the new prezzo
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Piatto{nome='" + nome + "', prezzo=" + prezzo + "}";
	}
}