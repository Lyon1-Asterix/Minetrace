package fr.td8.minetrace.obsels;

public class PlayerDamageObsel extends PlayerObsel
{

	private String cause;
	private double damage;

	public PlayerDamageObsel(long start, int x, int y, int z, String dimension, String playerName, String cause,
			double damage)
	{
		super(start, x, y, z, dimension, playerName);
		this.cause = cause;
		this.damage = damage;
	}

}
