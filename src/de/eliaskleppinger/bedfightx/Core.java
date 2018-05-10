package de.eliaskleppinger.bedfightx;

import cn.nukkit.plugin.PluginBase;
import de.eliaskleppinger.bedfightx.listener.Listeners;
import de.eliaskleppinger.bedfightx.state.GameState;

public class Core extends PluginBase{
	
	public static Core core;
	
	public static int MIN_PLAYERS;
	public static int MAX_PLAYERS;
	
	public static String PREFIX = "§8[§cBedFight§8] §7";
	
	public static GameState state = GameState.LOBBY;
	
	@Override
	public void onEnable() {
		MIN_PLAYERS = 4;
		MAX_PLAYERS = 16;
		getServer().getPluginManager().registerEvents(new Listeners(), this);
	}

}
