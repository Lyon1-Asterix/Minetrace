package fr.td8.minetrace;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MinetraceMain extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(new MinetraceListener(), this);
	}
	
	@Override
	public void onDisable()
	{
		JSONObselManager.getInstance().writeObsels();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if(command.getName().equalsIgnoreCase("trace"))
		{
			if(args.length == 0) //yaptetmieux
			{
				return false; //on affiche l'usage
			}
			if(args[0].equalsIgnoreCase("start"))
			{
				sender.sendMessage("Starting trace...");
				JSONObselManager.getInstance().start();
				return true;
			}
			else if(args[0].equalsIgnoreCase("stop"))
			{
				sender.sendMessage("Stopping trace.");
				JSONObselManager.getInstance().stop();
				JSONObselManager.getInstance().writeObsels();
				sender.sendMessage("It has been logged in "+ JSONObselManager.getInstance().getLastFileWritten());
				return true;
			}
			else if(args[0].equalsIgnoreCase("write"))
			{
				JSONObselManager.getInstance().writeObsels();
				sender.sendMessage("The trace has been logged in "+ JSONObselManager.getInstance().getLastFileWritten());
				return true;
			}
			else
			{
				return false;
			}
					
		}
		return false;
	}
}
