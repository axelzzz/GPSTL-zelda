package impl;

import impl.agent.Entity;
import interfaces.IItem;
import utils.TypeItem;

public class Item extends Entity implements IItem {
	
	TypeItem typeItem;
	
	public Item(double x, double y) {
		super(x, y);
		typeItem = TypeItem.BOIS;
	}
	
	public TypeItem getTypeItem() { return typeItem; }

	
}
