package com.furb.commons;

import java.util.ArrayList;
import java.util.Collection;

import javax.activity.InvalidActivityException;

import org.omg.PortableServer.POAPackage.ServantNotActive;

import com.furb.controller.Sort;
import com.furb.model.CD;

public class PesquisaPrecosFacade extends Adapter {

	public boolean conectar(String usuario, String senha) throws Exception {
		submarino.connect(usuario, senha);
		registrar(usuario);
		return submarino.isConnected();
	}

	public void desconectar() {
		submarino.disconnect();
	}

	public Collection<CD> procurar(String chave) throws InvalidActivityException, ServantNotActive {
		if (!submarino.isConnected())
			throw new InvalidActivityException("Uma conecxao deve ser feita antes de qualquer pesquisa");

		try {

			return null;
		} finally {
			desconectar();
		}
	}

	public void pesquisar(String chave) {

	}

	public void salvar() {

	}

	public void ler() {

	}

	public static void main(String[] args) {
		Adapter a = new PesquisaPrecosFacade();
		Sort b = new Sort();
		try {
			a.conectar("furb", "furb");
			ArrayList<CD> g = b.artistaPreco(a.allCDs());

			for (CD cd : g) {
				System.out.println(cd.getArtista() + " " + cd.getPreco());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
