package fr.td8.minetrace;

import java.util.Date;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import fr.td8.minetrace.obsels.BlockBreakObsel;
import fr.td8.minetrace.obsels.BlockPlaceObsel;
import fr.td8.minetrace.obsels.DropItemObsel;
import fr.td8.minetrace.obsels.PickupItemObsel;
import fr.td8.minetrace.obsels.PlayerDamageObsel;
import fr.td8.minetrace.obsels.PlayerDeathObsel;
import fr.td8.minetrace.obsels.PlayerJoinObsel;
import fr.td8.minetrace.obsels.PlayerKickObsel;
import fr.td8.minetrace.obsels.PlayerQuitObsel;

public class MinetraceListener implements Listener
{
	/*
	 * death
	 * inventory
	 * craft
	 * 
	 */
	private final String FILENAME = "/home/gus3000/minetrace.json";

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
		Block block = event.getBlock();
		Location location = block.getLocation();
		Player player = event.getPlayer();
		String playerName = player == null ? "null" : player.getName();
		
		BlockBreakObsel obsel = new BlockBreakObsel(
				new Date().getTime(),
				block.getType().toString(),
				block.getData(),
				location.getBlockX(),
				location.getBlockY(),
				location.getBlockZ(),
				location.getWorld().getName(),
				playerName);
		JSONObselManager.getInstance().addObsel(obsel);

	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event)
	{
		Block block = event.getBlock();
		Location location = block.getLocation();
		Player player = event.getPlayer();
		String playerName = player == null ? "null" : player.getName();
		
		BlockPlaceObsel obsel = new BlockPlaceObsel(
				new Date().getTime(),
				block.getType().toString(),
				block.getData(),
				location.getBlockX(),
				location.getBlockY(),
				location.getBlockZ(),
				location.getWorld().getName(),
				playerName);
		JSONObselManager.getInstance().addObsel(obsel);		
	}
	
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent event)
	{
		System.out.println("Item drop");
		Item item = event.getItemDrop();
		ItemStack stack = item.getItemStack();
		Location location = item.getLocation();
		Player player = event.getPlayer();
		String playerName = player == null ? "null" : player.getName();
		
		DropItemObsel obsel = new DropItemObsel(
				new Date().getTime(),
				stack.getType().toString(),
				stack.getAmount(),
				stack.getData().getData(),
				location.getBlockX(),
				location.getBlockY(),
				location.getBlockZ(),
				location.getWorld().getName(),
				playerName);
		JSONObselManager.getInstance().addObsel(obsel);
	}
	
	@EventHandler
	public void onItemPickup(PlayerPickupItemEvent event)
	{
		System.out.println("Item pickup");
		Item item = event.getItem();
		ItemStack stack = item.getItemStack();
		Location location = item.getLocation();
		Player player = event.getPlayer();
		String playerName = player == null ? "null" : player.getName();
		
		PickupItemObsel obsel = new PickupItemObsel(
				new Date().getTime(),
				stack.getType().toString(),
				stack.getAmount(),
				stack.getData().getData(),
				location.getBlockX(),
				location.getBlockY(),
				location.getBlockZ(),
				location.getWorld().getName(),
				playerName);
		JSONObselManager.getInstance().addObsel(obsel);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		Location location = player.getLocation();
		
		PlayerJoinObsel obsel = new PlayerJoinObsel(
				new Date().getTime(),
				location.getBlockX(),
				location.getBlockY(),
				location.getBlockZ(),
				location.getWorld().getName(),
				player.getName());
		
		JSONObselManager.getInstance().addObsel(obsel);
	}
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		Player player = event.getPlayer();
		Location location = player.getLocation();
		
		PlayerQuitObsel obsel = new PlayerQuitObsel(
				new Date().getTime(),
				location.getBlockX(),
				location.getBlockY(),
				location.getBlockZ(),
				location.getWorld().getName(),
				player.getName());
		
		JSONObselManager.getInstance().addObsel(obsel);
	}
	
	@EventHandler
	public void onPlayerKick(PlayerKickEvent event){
		Player player = event.getPlayer();
		Location location = player.getLocation();
		
		PlayerKickObsel obsel = new PlayerKickObsel(
				new Date().getTime(),
				location.getBlockX(),
				location.getBlockY(),
				location.getBlockZ(),
				location.getWorld().getName(),
				player.getName(),
				event.getReason());
		
		JSONObselManager.getInstance().addObsel(obsel);
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event){
		Entity entity = event.getEntity();
		if(! (entity instanceof Player))
			return;
		Player player = (Player)entity;
		Location location = player.getLocation();
		
		PlayerDamageObsel obsel = new PlayerDamageObsel(
				new Date().getTime(),
				location.getBlockX(),
				location.getBlockY(),
				location.getBlockZ(),
				location.getWorld().getName(),
				player.getName(),
				event.getCause().toString(),
				event.getFinalDamage());
		
		JSONObselManager.getInstance().addObsel(obsel);
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event){
		Player player = event.getEntity();
		Location location = player.getLocation();
		
		PlayerDeathObsel obsel = new PlayerDeathObsel(
				new Date().getTime(),
				location.getBlockX(),
				location.getBlockY(),
				location.getBlockZ(),
				location.getWorld().getName(),
				player.getName(),
				event.getKeepInventory());
		
		JSONObselManager.getInstance().addObsel(obsel);
	}
}
