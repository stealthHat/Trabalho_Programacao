package com.furb.model;

import conexao.SomLivreServidor;
import didatico.SubmarinoProducts;

public abstract class Instance extends SomLivreServidor {

	protected SubmarinoProducts submarino = SubmarinoProducts.getInstance();
}
