package dev.skymlg.customhelp;

import dev.skymlg.customhelp.Commands.HelpCommand;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class CustomHelp extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("CustomHelp Plugin wird geladen...");

        // Erstelle den Plugin-Ordner und die Config, falls sie nicht existieren
        createConfig();

        // Registriere den Help-Command
        getCommand("help").setExecutor(new HelpCommand(this));


        getLogger().info("CustomHelp Plugin erfolgreich gestartet!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomHelp Plugin wurde deaktiviert!");
    }

    /**
     * Erstellt die config.yml und den Ordner, falls sie nicht existieren.
     */
    private void createConfig() {
        File configFile = new File(getDataFolder(), "config.yml");

        if (!getDataFolder().exists()) {
            getDataFolder().mkdir(); // Erstellt den Plugin-Ordner
        }

        if (!configFile.exists()) {
            saveResource("config.yml", false); // Kopiert die Datei aus der .jar
            getLogger().info("Config wurde erstellt!");
        } else {
            getLogger().info("Config geladen.");
        }
    }
}