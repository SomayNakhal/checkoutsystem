package com.checkoutsystem.offer;

import java.util.List;

public interface Offer {
	
	public List<OfferPrerequisite> getOfferPrerequisites();
	public int getOfferAmount();
}
