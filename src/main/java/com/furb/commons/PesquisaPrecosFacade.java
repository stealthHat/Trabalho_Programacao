package com.furb.commons;

import java.util.Collection;

import javax.activity.InvalidActivityException;

import org.omg.PortableServer.POAPackage.ServantNotActive;

import com.furb.model.CD;
import com.furb.model.Instance;
import com.furb.model.Loja;

public class PesquisaPrecosFacade extends Instance implements Loja {

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
		PesquisaPrecosFacade a = new PesquisaPrecosFacade();
		try {
			a.conectar("furb", "furb");
			a.procurar("ad");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
