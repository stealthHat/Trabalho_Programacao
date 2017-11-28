package com.furb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.omg.PortableServer.POAPackage.ServantNotActive;

import com.furb.model.CD;

public class OrdenaCds {

	public ArrayList<CD> ordenarPorPreco(ArrayList<CD> arrayList) throws ServantNotActive {
		Collections.sort(arrayList, Comparator.comparing(CD::getPreco));
		return arrayList;
	}

	public ArrayList<CD> ordenarPorPrecoDecre(ArrayList<CD> arrayList) throws ServantNotActive {
		Collections.sort(arrayList, Comparator.comparing(CD::getPreco).reversed());
		return arrayList;
	}

	public ArrayList<CD> ordenarPorAlbumEPreco(ArrayList<CD> arrayList) {
		Collections.sort(arrayList, Comparator.comparing(CD::getTitulo).thenComparing(CD::getPreco));
		return arrayList;
	}

	public ArrayList<CD> ordenarPorArtistaEPreco(ArrayList<CD> arrayList) {
		Collections.sort(arrayList,
				Comparator.comparing(CD::getArtista).thenComparing(Comparator.comparing(CD::getPreco).reversed()));
		return arrayList;
	}

}
