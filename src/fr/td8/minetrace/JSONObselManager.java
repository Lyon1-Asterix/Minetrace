package fr.td8.minetrace;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import org.json.simple.JSONArray;

import fr.td8.minetrace.obsels.Obsel;

class JSONObselManager
{
	private static JSONObselManager instance = null;
	private Queue<Obsel> obsels;
	private String fileName;
	private int nbObsels;
	private int nbObselsMax;
	private boolean running;
	
	private String lastFileWritten=null;

	private JSONObselManager()
	{
		this("./plugins//minetrace/minetrace", 100); // peut-être changer
	}

	private JSONObselManager(String fileName, int nbObselsMax)
	{
		obsels = new LinkedList<>();
		this.fileName = fileName;
		this.nbObselsMax = nbObselsMax;
		this.nbObsels = 0;
		this.running=true; //TODO changer pour la prod
	}

	void addObsel(Obsel o)
	{
		if(!running)
			return;
		
		obsels.add(o);
		if (++nbObsels >= nbObselsMax)
		{
			writeObsels();
		}

	}

	void writeObsels()
	{
		Obsel o;
		JSONArray array = new JSONArray();
		while ((o = obsels.poll()) != null)
		{
			array.add(o.toJSONObject());
			// System.out.println(o.toJSON());
		}
		String name = fileName + "_" + (new Date().getTime()) + ".json";
		lastFileWritten = name;
		File f = new File(name);
		try
		{
			f.getParentFile().mkdirs();
			f.createNewFile();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		FileWriter writer = null;
		try
		{
			writer = new FileWriter(f);
			array.writeJSONString(writer);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		if (writer != null)
			try
			{
				writer.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		
		nbObsels = obsels.size(); //au cas où rayon cosmique
	}

	public void start()
	{
		running = true;
	}
	
	void stop()
	{
		running = false;
	}
	
	String getLastFileWritten()
	{
		return lastFileWritten;
	}
	
	static JSONObselManager getInstance()
	{
		if (instance == null)
			instance = new JSONObselManager();
		return instance;
	}
}
