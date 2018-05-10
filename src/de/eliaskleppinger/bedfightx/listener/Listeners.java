package de.eliaskleppinger.bedfightx.listener;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBed;
import cn.nukkit.item.ItemNetherStar;
import de.eliaskleppinger.bedfightx.Core;
import de.eliaskleppinger.bedfightx.countdown.LobbyCountdown;
import de.eliaskleppinger.bedfightx.state.GameState;
import de.eliaskleppinger.bedfightx.util.ItemBuilder;

public class Listeners implements Listener{
	
	@EventHandler
	public void on(PlayerJoinEvent e) {
		if(Core.state == GameState.LOBBY) {
			e.setJoinMessage(Core.PREFIX + "The Player §8" + e.getPlayer().getName() + " §7want's to fight! §8§o(" + Core.core.getServer().getOnlinePlayers().size() + "/" + Core.MAX_PLAYERS + ")");
			if(Core.core.getServer().getOnlinePlayers().size() == Core.MIN_PLAYERS || Core.core.getServer().getOnlinePlayers().size() > Core.MIN_PLAYERS) {
				LobbyCountdown.start();
			}
			Player p = e.getPlayer();
			p.setMaxHealth(20);
			p.heal(20);
			p.getFoodData().reset();
			PlayerInventory inv = p.getInventory();
			inv.clearAll();
			for(int i = 0; i < inv.getSize(); i++) {
				inv.setItem(i, new Item(160, 15, 1, " "));
				inv.setItem(3, new ItemBuilder(new ItemBed()).setCustomName("§8§l» §a§lSelect Team").setLore(new String[] {"§7Select your Team!"}).build());
				inv.setItem(5, new ItemBuilder(new ItemNetherStar()).setCustomName("§8§l» §6§lAchievements").setLore(new String[] {"§7View your Achievements!"}).build());
			}
			p.setDisplayName("§7" + p.getDisplayName());
			p.setNameTag("§7" + p.getDisplayName());
			
		} else if(Core.state == GameState.INGAME) {
			e.setJoinMessage("");
		} else {
			e.setCancelled(true);
		}
	}

}
