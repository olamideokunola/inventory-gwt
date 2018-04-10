package com.aeryinnovations.client.event;

import java.util.List;

import com.aeryinnovations.shared.coredomain.SparePartSpecification;
import com.google.gwt.event.shared.GwtEvent;

public class SparesSpecsSearchDoneEvent extends GwtEvent<SparesSpecsSearchDoneEventHandler> {
	public static Type<SparesSpecsSearchDoneEventHandler> TYPE = new Type<SparesSpecsSearchDoneEventHandler>();
	private final List<SparePartSpecification> spSpecsSearchResultList;
	
	public SparesSpecsSearchDoneEvent(List<SparePartSpecification> spSpecsSearchResultList) {
		this.spSpecsSearchResultList = spSpecsSearchResultList;
	}
	
	public List<SparePartSpecification> getSpSpecsSearchResultList() { 
		return spSpecsSearchResultList; 
	}
	
	@Override
	public Type<SparesSpecsSearchDoneEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(SparesSpecsSearchDoneEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onSparesSpecsSearchDone(this);
	}

}
