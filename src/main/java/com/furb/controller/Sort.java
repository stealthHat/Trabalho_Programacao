package com.furb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.omg.PortableServer.POAPackage.ServantNotActive;

import com.furb.commons.Adapter;
import com.furb.model.CD;

public class Sort {

	public ArrayList<CD> preco(ArrayList<CD> arrayList) throws ServantNotActive {
		Collections.sort(arrayList, (p1, p2) -> p1.getPreco().compareTo(p2.getPreco()));
		return arrayList;
	}

	public ArrayList<CD> albumPreco(ArrayList<CD> arrayList) {
		Collections.sort(arrayList, Comparator.comparing(CD::getTitulo).thenComparing(CD::getPreco));
		return arrayList;
	}

	public ArrayList<CD> artistaPreco(ArrayList<CD> arrayList) {
		Collections.sort(arrayList,
				Comparator.comparing(CD::getArtista).thenComparing(Comparator.comparing(CD::getPreco).reversed()));
		return arrayList;
	}

}
