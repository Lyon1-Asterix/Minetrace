package fr.td8.minetrace;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import fr.td8.minetrace.json.JSONable;

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
				if (f.get(o) instanceof List) // c'est une
																// collection
				{
					System.out.println("liste d'objets !");
					JSONArray array = new JSONArray();
					for (Object arrayObject : ((List) f.get(o)))
					{
						if (isPrimitiveOrPrimitiveWrapperOrString(arrayObject.getClass()))
						{
							array.add(arrayObject);
						} else if (arrayObject instanceof JSONable)
						{
							array.add(((JSONable) arrayObject).toJSONObject());
						}
					}
					
					obj.put(f.getName(), array);

				} else
				{
					if (f.get(o) instanceof JSONable)
						obj.put(f.getName(), ((JSONable) f.get(o)).toJSONObject());
					else
						obj.put(f.getName(), f.get(o));
				}
			} catch (IllegalArgumentException | IllegalAccessException e)
			{

			}
		}
		return obj;
	}

	public static boolean isPrimitiveOrPrimitiveWrapperOrString(Class<?> type)
	{
		return (type.isPrimitive() && type != void.class) || type == Double.class || type == Float.class || type == Long.class || type == Integer.class || type == Short.class
				|| type == Character.class || type == Byte.class || type == Boolean.class || type == String.class;
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

	/**
	 * Get the amount of items the player had just crafted. This method will
	 * take into consideration shift clicking & the amount of inventory space
	 * the player has left.
	 * 
	 * @param CraftItemEvent
	 * @return int: actual crafted item amount
	 */
	public static int getCraftAmount(CraftItemEvent e)
	{

		if (e.isCancelled())
		{
			return 0;
		}

		Player p = (Player) e.getWhoClicked();

		if (e.isShiftClick())
		{
			int itemsChecked = 0;
			int possibleCreations = 1;

			int amountCanBeMade = 0;

			for (ItemStack item : e.getInventory().getMatrix())
			{
				if (item != null && item.getType() != Material.AIR)
				{
					if (itemsChecked == 0)
					{
						possibleCreations = item.getAmount();
						itemsChecked++;
					} else
					{
						possibleCreations = Math.min(possibleCreations, item.getAmount());
					}
				}
			}

			int amountOfItems = e.getRecipe().getResult().getAmount() * possibleCreations;

			ItemStack i = e.getRecipe().getResult();

			for (int s = 0; s <= 35; s++)
			{
				ItemStack test = p.getInventory().getItem(s);
				if (test == null || test.getType() == Material.AIR)
				{
					amountCanBeMade += i.getMaxStackSize();
					continue;
				}
				if (test.isSimilar(i))
				{
					amountCanBeMade += i.getMaxStackSize() - test.getAmount();
				}
			}

			return amountOfItems > amountCanBeMade ? amountCanBeMade : amountOfItems;
		} else
		{
			return e.getRecipe().getResult().getAmount();
		}
	}
}
