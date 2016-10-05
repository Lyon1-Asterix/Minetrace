package fr.td8.minetrace.obsels;

import java.util.List;

import fr.td8.minetrace.json.JSONableItem;

public class CraftObsel extends PlayerObsel
{
	private String resultType;
	private byte resultData;
	private int resultAmountByCraft;
	private List<JSONableItem> usedItems;
	private int numberOfCrafts;

	public CraftObsel(long start, int x, int y, int z, String dimension, String playerName, String resultType, byte resultData, int resultAmountByCraft, List<JSONableItem> usedItems,
			int numberOfCrafts)
	{
		super(start, x, y, z, dimension, playerName);
		this.resultType = resultType;
		this.resultData = resultData;
		this.resultAmountByCraft = resultAmountByCraft;
		this.usedItems = usedItems;
		this.numberOfCrafts = numberOfCrafts;
	}

}
