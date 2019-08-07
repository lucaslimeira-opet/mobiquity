package com.mobiquityinc.packageapp.comparator;

import java.util.Comparator;

import com.mobiquityinc.packageapp.entity.Item;

/*
 * Comparator Class used for sorting the Items by price and considering the less weight
 * */
public class ItemComparatorPrice implements Comparator<Item> {

	@Override
	public int compare(Item item0, Item item1) {
		if (item0.getPrice() > item1.getPrice()) {
			return 1;
		}
		if (item0.getPrice() < item1.getPrice() || item0.getPrice().equals(item1.getPrice()) && item0.getWeight() < item1.getWeight() ) {
			return -1;
		}
		return 0;
	}

}


