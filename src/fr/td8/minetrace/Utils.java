package fr.td8.minetrace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.json.simple.JSONObject;

public class Utils
{
	public static String fields(Object o, Class c)
	{
		StringBuilder sb = new StringBuilder();
		Field[] fields = c.getDeclaredFields();
		for (Field f : fields)
		{
			if ((f.getModifiers() & Modifier.STATIC) != 0)
				continue;

			sb.append('\t');
			sb.append(f.getName());
			sb.append(": ");
			f.setAccessible(true);
			try
			{
				sb.append(f.get(o).toString());
			} catch (IllegalArgumentException | IllegalAccessException e)
			{
				sb.append("null");
			}
			sb.append(",\n");
		}
		return sb.toString();
	}

	public static JSONObject fieldsJSON(Object o, Class c)
	{
		JSONObject obj = new JSONObject();
		Field[] fields = c.getDeclaredFields();
		for (Field f : fields)
		{
			if ((f.getModifiers() & Modifier.STATIC) != 0)
				continue;

			f.setAccessible(true);
			try
			{
				// sb.append(f.get(o).toString());
				obj.put(f.getName(), f.get(o));
			} catch (IllegalArgumentException | IllegalAccessException e)
			{

			}
		}
		return obj;
	}

	public static void AppendToFile(String filename, String toAppend)
	{
		try
		{
			File file = new File(filename);
			if (!file.exists())
				file.createNewFile();
			Files.write(Paths.get(filename), toAppend.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * try {
		 * 
		 * 
		 * 
		 * FileWriter fw = new FileWriter(file); fw.append(toAppend);
		 * fw.close(); } catch(IOException e) { e.printStackTrace(); }
		 */
	}
}
