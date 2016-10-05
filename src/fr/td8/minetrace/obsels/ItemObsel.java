package fr.td8.minetrace.obsels;

public class ItemObsel extends Obsel
{
	private String itemName;

	private int amount;
	private byte data;
	private int x,y,z;
	private String dimension;
	private String playerName;
	
	public ItemObsel(long start, String itemName, int amount, byte data, int x, int y, int z, String dimension, String playerName)
	{
		super(start);
		this.itemName = itemName;
		this.amount = amount;
		this.data = data;
		this.x = x;
		this.y = y;
		this.z = z;
		this.dimension = dimension;
		this.playerName = playerName;
	}

}
