package fr.td8.minetrace.obsels;

public class PlayerDeathObsel extends PlayerObsel
{

	private boolean keepInventory;

	public PlayerDeathObsel(long start, int x, int y, int z, String dimension, String playerName, boolean keepInventory)
	{
		super(start, x, y, z, dimension, playerName);
		this.keepInventory = keepInventory;
	}

}
