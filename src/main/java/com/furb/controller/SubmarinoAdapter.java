/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furb.controller;

import com.furb.model.CD;
import com.furb.model.Loja;
import didatico.SubmarinoProducts;
import java.util.Collection;
import java.util.LinkedHashSet;
import org.omg.PortableServer.POAPackage.ServantNotActive;

/**
 *
 * @author Nemo
 */
public class SubmarinoAdapter implements Loja{
    
    @Override
    public boolean conectar(String usuario, String senha) throws Exception {
        SubmarinoProducts.getInstance().connect(usuario, senha);
        return SubmarinoProducts.getInstance().isConnected();
    }

    @Override
    public void desconectar() {
         SubmarinoProducts.getInstance().disconnect();
    }

    @Override
    public Collection<CD> procurar(String chave) throws ServantNotActive {
        LinkedHashSet <CD> produtos = new LinkedHashSet <>();
        
        String[][] resultadoBusca = SubmarinoProducts.getInstance().getCDProducts();
        
         for (String[] valor : resultadoBusca)
            produtos.add(new CD(valor[2], valor[0], Double.parseDouble(valor[3]), "Submarino"));
        
        return produtos;
    }
    
}
