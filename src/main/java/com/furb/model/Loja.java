package com.furb.model;

import java.util.Collection;

import javax.activity.InvalidActivityException;

import org.omg.PortableServer.POAPackage.ServantNotActive;

public interface Loja {

	boolean conectar(String usuario, String senha) throws Exception;

	void desconectar();

	Collection<CD> procurar(String chave) throws InvalidActivityException, ServantNotActive;
}
