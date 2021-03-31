package me.moutarde.spigot.mcjukeboxqrcode;

import co.aikar.commands.PaperCommandManager;
import kr.entree.spigradle.annotations.PluginMain;
import lombok.Getter;
import me.moutarde.spigot.mcjukeboxqrcode.Commands.JukeboxQR;
import me.moutarde.spigot.mcjukeboxqrcode.Listeners.QRCodeDrop;
import net.mcjukebox.plugin.bukkit.MCJukebox;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;

@PluginMain
public class MCJukeboxQRCode extends JavaPlugin implements Listener {

  @Getter private static MCJukeboxQRCode plugin;
  @Getter private static MCJukebox mcJukebox;
  private static PaperCommandManager commandManager;

  public MCJukeboxQRCode() {}

  public MCJukeboxQRCode(
      JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
    super(loader, description, dataFolder, file);
  }

  @Override
  public void onEnable() {
    mcJukebox = (MCJukebox) getServer().getPluginManager().getPlugin("MCJukebox");
    plugin = this;
    registerCommands();
    registerListeners();
  }

  private void registerCommands() {
    commandManager = new PaperCommandManager(this);
    commandManager.registerCommand(new JukeboxQR());
  }

  private void registerListeners() {
    getServer().getPluginManager().registerEvents(new QRCodeDrop(), this);
  }
}
