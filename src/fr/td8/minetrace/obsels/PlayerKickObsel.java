package fr.td8.minetrace.obsels;

public class PlayerKickObsel extends PlayerObsel
{
	private String reason;

	public PlayerKickObsel(long start, int x, int y, int z, String dimension, String playerName, String reason)
	{
		super(start, x, y, z, dimension, playerName);
		this.reason = reason;
	}

}
