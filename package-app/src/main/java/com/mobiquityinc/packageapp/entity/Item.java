package com.mobiquityinc.packageapp.entity;

public class Item implements Comparable<Item> {

	private Integer index;
	private Double weight;
	private Double price;

	public Item () {

	}

	public Item (Integer index, Double weight, Double price) {
		this.index = index;
		this.weight = weight;
		this.price = price;
	}

	@Override
	public int compareTo(Item item1) {
		if (this.getIndex() > item1.getIndex()) {
			return 1;
		}
		if (this.getIndex() < item1.getIndex()) {
			return -1;
		}

		return 0;
	}

	@Override
	public String toString() {
		return this.index.toString(); 
	}

	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

}
