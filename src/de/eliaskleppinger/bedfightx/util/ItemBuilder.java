package de.eliaskleppinger.bedfightx.util;

import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;

public class ItemBuilder {
	
	private Item item;
	
	public ItemBuilder(Item item) {
		this.item = item;
	}
	
	public ItemBuilder setCustomName(String name) {
		item.setCustomName(name);
		return this;
	}
	
	public ItemBuilder setCount(String name) {
		item.setCustomName(name);
	
		return this;
	}
	
	public ItemBuilder setLore(String... lore) {
		item.setLore(lore);
		return this;
	}
	
	public ItemBuilder addEnchantment(Enchantment...enchantments) {
		item.addEnchantment(enchantments);
		return this;
	}
	
	public Item build() {
		return item;
	}

}
