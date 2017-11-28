/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furb.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.activity.InvalidActivityException;

import org.omg.PortableServer.POAPackage.ServantNotActive;

import com.furb.model.CD;
import com.furb.model.Loja;

/**
 *
 * @author Nemo
 */
public class PesquisaPrecosFacade {

	/**
	 * Referencia para as classes SubmarinoAdapter e SomLivreAdapter As duas classes
	 * realizam Loja entao podem ser acessadas por ela.
	 */
	Loja loja;
	OrdenaCds ordena = new OrdenaCds();

	public List<CD> pesquisar(String chave) throws InvalidActivityException, ServantNotActive, Exception {
		
		String chaveLow = chave.toLowerCase();
		List<CD> produtos = null;

		loja = new SubmarinoAdapter();
		if (loja.conectar("furb", "furb")) {
			produtos.addAll(loja.procurar(chave));
			loja.desconectar();
		} else {
			throw new InvalidActivityException("Uma conexao deve ser feita antes de qualquer pesquisa");
		}
		loja = new SomLivreAdapter();
		if (loja.conectar("furb", "furb")) {
			produtos.addAll(loja.procurar(chave));
			loja.desconectar();
		} else {
			throw new InvalidActivityException("Uma conexao deve ser feita antes de qualquer pesquisa");
		}
		return produtos.stream().filter(u -> u.getArtista().toLowerCase().contains(chaveLow)
				|| u.getTitulo().toLowerCase().contains(chaveLow)).collect(Collectors.toList());
	}

	/**
	 * Responsável por salvar (serializar )todas as palavras pesquisadas junto com a
	 * data em que elas foram pesquisadas.
	 * 
	 * @param chave
	 *            a palavra que o usuário pesquisou
	 */
	public void salvar(String chave) {

	}

	/**
	 * Responsável por recuperar a lista de objetos pesquisados.
	 */
	public void ler() {

	}
}
