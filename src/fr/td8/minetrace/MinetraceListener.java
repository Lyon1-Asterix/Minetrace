package fr.td8.minetrace;

import java.util.Date;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import fr.td8.minetrace.obsels.BlockBreakObsel;
import fr.td8.minetrace.obsels.BlockPlaceObsel;
import fr.td8.minetrace.obsels.DropItemObsel;
import fr.td8.minetrace.obsels.PickupItemObsel;

public class MinetraceListener implements Listener
{
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
}
