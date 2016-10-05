package fr.td8.minetrace.json;

import org.json.simple.JSONObject;

public class JSONableItem implements JSONable
{
	private String type;
	private byte data;
	
	public JSONableItem(String type, byte data)
	{
		this.type = type;
		this.data = data;
	}

	@Override
	public JSONObject toJSONObject()
	{
		JSONObject obj = new JSONObject();
		
		obj.put("type", type);
		obj.put("data", data);
		
		return obj;
	}

}
