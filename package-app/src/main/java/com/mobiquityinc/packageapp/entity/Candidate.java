package com.mobiquityinc.packageapp.entity;

import java.util.ArrayList;
import java.util.List;

public class Candidate implements Comparable<Candidate> {

	private List<Item> candidateItems = new ArrayList<>();
	private double totalWeight;
	private double totalPrice;

	@Override
	public int compareTo(Candidate candidate1) {
		if (this.totalPrice > candidate1.getTotalPrice()) {
			return -1;
		}
		if (this.totalPrice < candidate1.getTotalPrice()) {
			return 1;
		}
		return 0;
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Item> getCandidateItems() {
		return candidateItems;
	}

	public void setCandidateItems(List<Item> candidateItems) {
		this.candidateItems = candidateItems;
	}

}