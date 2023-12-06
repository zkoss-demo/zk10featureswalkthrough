package org.zkoss.test;

import org.zkoss.test.service.ItemService;
import org.zkoss.zul.ListModelList;

public class SearchboxVM {

    private ListModelList model;

    public SearchboxVM() {
        ItemService.getInstance().produceItems(5000);
        this.model = new ListModelList(ItemService.getInstance().getItems());
    }
    public ListModelList getModel() {
        return model;
    }

}