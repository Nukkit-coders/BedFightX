package de.eliaskleppinger.bedfightx.countdown;

import cn.nukkit.level.generator.task.GenerationTask;
import cn.nukkit.scheduler.ServerScheduler;
import cn.nukkit.scheduler.TaskHandler;
import de.eliaskleppinger.bedfightx.Core;

public class LobbyCountdown extends Countdown{


	public static int taskId;
	
	public static void start() {
		ServerScheduler sd = Core.core.getServer().getScheduler();
		
		taskId = sd.scheduleDelayedRepeatingTask(Core.core, new Runnable() {
			int countdown = 30;
			@Override
			public void run() {
				
				if(Core.core.getServer().getOnlinePlayers().size() == Core.MIN_PLAYERS || Core.core.getServer().getOnlinePlayers().size() > Core.MIN_PLAYERS) {
					Core.core.getServer().broadcastMessage(Core.PREFIX + "§7Game Starts in §b" + countdown + " §7seconds!");
					this.countdown -= 1;
					if(countdown == 20) {
						Core.core.getServer().broadcastMessage(Core.PREFIX + "§7Game Starts in §b" + countdown + " §7seconds!");
					}
					
					if(countdown == 15) {
						Core.core.getServer().broadcastMessage(Core.PREFIX + "§7Game Starts in §b" + countdown + " §7seconds!");
					}
					
					if(countdown == 10) {
						Core.core.getServer().broadcastMessage(Core.PREFIX + "§7Game Starts in §b" + countdown + " §7seconds!");
					}
					
					if(countdown == 5) {
						Core.core.getServer().broadcastMessage(Core.PREFIX + "§7Game Starts in §b" + countdown + " §7seconds!");
					}
					
					if(countdown == 4) {
						Core.core.getServer().broadcastMessage(Core.PREFIX + "§7Game Starts in §b" + countdown + " §7seconds!");
					}
					
					if(countdown == 3) {
						Core.core.getServer().broadcastMessage(Core.PREFIX + "§7Game Starts in §b" + countdown + " §7seconds!");
					}
					
					if(countdown == 2) {
						Core.core.getServer().broadcastMessage(Core.PREFIX + "§7Game Starts in §b" + countdown + " §7seconds!");
					}
					
					if(countdown == 1) {
						Core.core.getServer().broadcastMessage(Core.PREFIX + "§7Game Starts in §b" + countdown + " §7second!");
					}
					
					if(countdown == 0) {
						Core.core.getServer().broadcastMessage(Core.PREFIX + "§aGAME STARTS NOW!");
						
						//
					}
					sd.cancelTask(taskId);
				} else {
					Core.core.getServer().broadcastMessage(Core.PREFIX + "§cThere are not enough players online to start the game! Needed Players: " +  Core.MIN_PLAYERS);
					this.countdown = 30;
					stop();
				}
				
			}
		}, 20,20).getTaskId();
		
	}

	public static void stop() {
		ServerScheduler sd = Core.core.getServer().getScheduler();
		sd.cancelTask(taskId);
		
	}
	


}
