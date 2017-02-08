package com.checkoutsystem.offer;

import java.util.List;

public class OfferImpl implements Offer {
	
	private List<OfferPrerequisite> prerequisites;
	private int offerAmount;

	public OfferImpl(List<OfferPrerequisite> prerequisites, int offerAmount) {
		this.prerequisites = prerequisites;
		this.offerAmount = offerAmount;
	}


	@Override
	public List<OfferPrerequisite> getOfferPrerequisites() {
		return this.prerequisites;
	}

	@Override
	public int getOfferAmount() {
		return this.offerAmount;
	}

}
