package fr.td8.minetrace.obsels;

import org.json.simple.JSONObject;

import fr.td8.minetrace.Utils;
import fr.td8.minetrace.json.JSONable;

public class Obsel implements JSONable
{
	private static int currentId = 1;

	protected int id;
	protected long start;

	public Obsel(long start)
	{
		super();
		this.id = currentId++;
		this.start = start;
	}

	public JSONObject toJSONObject()
	{
		JSONObject obj = new JSONObject();
		StringBuilder fields = new StringBuilder();
		Class c = getClass();
		obj.put("type", c.getSimpleName());
		do
		{
//			fields.insert(0,(Utils.fields(this, c)));
			obj.putAll(Utils.fieldsJSON(this, c));
		}
		while((c = c.getSuperclass()) != null);
		
		return obj;
	}
}
