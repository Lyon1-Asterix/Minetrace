package fr.td8.minetrace.obsels;

public class PlayerObsel extends Obsel
{

	private int x, y, z;
	private String dimension;
	private String playerName;

	public PlayerObsel(long start, int x, int y, int z, String dimension, String playerName)
	{
		super(start);
		this.x = x;
		this.y = y;
		this.z = z;
		this.dimension = dimension;
		this.playerName = playerName;
	}

}
