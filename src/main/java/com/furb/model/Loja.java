package com.furb.model;

import java.util.Collection;

import javax.activity.InvalidActivityException;

public interface Loja<T> {

	boolean conectar(Usuario usuario) throws Exception;

	void desconectar();

	Collection<T> procurar(String chave) throws InvalidActivityException;
}
