package com.mobiquityinc.packageapp.entity;

import java.util.List;

public class Pack {

	private Integer packageId;
	private Double maxWeight;
	private List<Item> items;

	public Pack() {

	}

	public Pack(Integer packageId, Double maxWeight, List<Item> items) {
		this.packageId = packageId;
		this.items = items;
		this.maxWeight = maxWeight;
	}

	@Override
	public String toString() {
		return "[ packageId = " + packageId + " maxWeight = " + maxWeight + " items [ " + items + " ]";
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public Double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(Double maxWeight) {
		this.maxWeight = maxWeight;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}