package dev.skymlg.customhelp.Commands;

import dev.skymlg.customhelp.CustomHelp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

public class HelpCommand implements CommandExecutor {

    private final CustomHelp plugin;

    public HelpCommand(CustomHelp plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("help")) {
            for (String line : plugin.getConfig().getStringList("help-message")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
            }
        }
        return false;
    }
}
