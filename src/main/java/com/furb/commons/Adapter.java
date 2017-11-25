package com.furb.commons;

import java.util.ArrayList;

import org.omg.PortableServer.POAPackage.ServantNotActive;

import com.furb.model.CD;
import com.furb.model.Instance;

public class Adapter extends Instance {

	public ArrayList<CD> allCDs() throws ServantNotActive {
		ArrayList<CD> arrayList = new ArrayList<>();
		String[][] matrix = submarino.getCDProducts();

		String[] somLivreCd = buscaCD();

		for (String[] strings : matrix)
			arrayList.add(new CD("Submarino", strings[0], strings[2], Double.parseDouble(strings[3])));

		for (String string : somLivreCd) {
			String[] array = string.split("\\|");
			arrayList.add(new CD("SomLivre", array[1], array[0], Double.parseDouble(array[2])));
		}

		return arrayList;
	}
}
