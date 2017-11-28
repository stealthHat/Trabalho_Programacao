/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furb.controller;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import com.furb.model.CD;
import com.furb.model.Loja;

import conexao.SomLivreServidor;

/**
 *
 * @author Nemo
 */
public class SomLivreAdapter extends SomLivreServidor implements Loja {

	// SomLivreServidor somLivre = new SomLivreServidor();

	@Override
	public boolean conectar(String usuario, String senha) throws Exception {
		return registrar(usuario);
	}

	@Override
	public void desconectar() {
		// Não precisa desconectar portanto esse método não faz nada.
	}

	@Override
	public Collection<CD> procurar(String chave) {

		LinkedHashSet<CD> produtos = new LinkedHashSet<>();
		String[] resultadoBusca = buscaCD();

		for (String s : resultadoBusca) {
			String[] valor = s.split("\\|");
			produtos.add(new CD(valor[1], valor[0], Double.parseDouble(valor[2]), "SomLivre"));
		}

		return produtos.stream().filter(u -> u.getArtista().contains(chave) || u.getTitulo().contains(chave))
				.collect(Collectors.toList());
	}

}
