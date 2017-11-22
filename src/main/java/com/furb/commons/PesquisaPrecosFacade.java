package com.furb.commons;

import java.util.ArrayList;
import java.util.Collection;

import javax.activity.InvalidActivityException;

import com.furb.model.Loja;
import com.furb.model.Usuario;

import conexao.SomLivreServidor;
import didatico.SubmarinoProducts;

public class PesquisaPrecosFacade implements Loja {

	SomLivreServidor somLivre = new SomLivreServidor();
	SubmarinoProducts submarino = SubmarinoProducts.getInstance();

	public boolean conectar(Usuario usuario) throws Exception {
		submarino.connect(usuario.getNome(), usuario.getPassword());
		return submarino.isConnected();
	}

	public void desconectar() {
		submarino.disconnect();
	}

	public Collection procurar(String chave) throws InvalidActivityException {
		if (!submarino.isConnected())
			throw new InvalidActivityException("Uma conecxao deve ser feita antes de qualquer pesquisa");

		ArrayList<String> array = new ArrayList<>();
		String[] a = somLivre.buscaCD();
		for (String string : a) {
			array.add(string);
		}

		desconectar();
		return array;
	}

	public void pesquisar(String chave) {

	}

	public void salvar() {

	}

	public void ler() {

	}

	public static void main(String[] args) {
		PesquisaPrecosFacade a = new PesquisaPrecosFacade();
		try {
			Usuario u = new Usuario("Alo", "senha");
			a.conectar(u);
			a.procurar("ad");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
