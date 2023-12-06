package org.zkoss.support.zk10featureswalkthrough.clientmvvm;

import java.util.Arrays;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;

public class SampleViewModel {

	private String stringValue = "foo";
	private ListModelList<String> model = new ListModelList<String>(Arrays.asList("abc","def","ghi"));
	private String selectedItem = model.get(0);

//	@Wire
//	private Textbox tb;
	
	@Command
	public void toServer() {
		Clients.log("did something in Java");
	}

	public String getSelectedItem() {
		return selectedItem;
	}
	
	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public ListModelList<String> getModel() {
		return model;
	}

	public void setModel(ListModelList<String> model) {
		this.model = model;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}
	

}
