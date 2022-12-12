package org.pizzeria.italy.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String nome;
	

	@Lob
	private String descrizione;
	
	
	@NotNull
	private Integer prezzo;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}
	
	
	public Pizza() { }
	public Pizza(String nome, String descrizione, int prezzo) {
		
		this.setDescrizione(descrizione);
		this.setNome(nome);
		this.setPrezzo(prezzo);
		
	}
	
	@Override
	public String toString() {
		
		return getId() + " NOME: " + getNome()
			+ "\nDESCRIZIONE: " + getDescrizione()
			+ "\nPREZZO: " + getPrezzo();
			
	}
}
