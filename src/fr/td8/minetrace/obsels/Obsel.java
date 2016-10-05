package fr.td8.minetrace.obsels;

import org.json.simple.JSONObject;

import fr.td8.minetrace.Utils;

public class Obsel
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

	public JSONObject toJSON()
	{
		//TODO mettre des guillemets partout quand pas un int
		
//		StringBuilder sb = new StringBuilder();
		JSONObject obj = new JSONObject();
//		sb.append("{\n");
		StringBuilder fields = new StringBuilder();
		Class c = getClass();
//		sb.append("\ttype: "+ c.getSimpleName() + ",\n");
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
