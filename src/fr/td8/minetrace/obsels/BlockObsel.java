package fr.td8.minetrace.obsels;

public class BlockObsel extends Obsel
{
	private String blockName;
	private byte data;
	private int x,y,z;
	private String dimension;
	private String playerName;
	
	public BlockObsel(long start, String blockName, byte data, int x, int y, int z, String dimension, String playerName)
	{
		super(start);
		this.blockName = blockName;
		this.data = data;
		this.x = x;
		this.y = y;
		this.z = z;
		this.dimension = dimension;
		this.playerName = playerName;
	}

}
