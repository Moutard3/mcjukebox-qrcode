package me.moutarde.spigot.mcjukeboxqrcode.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import me.moutarde.spigot.mcjukeboxqrcode.MCJukeboxQRCode;
import me.moutarde.spigot.mcjukeboxqrcode.Utils.QRCodeGenerator;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("jukeboxqr")
@Description("Generate Jukebox link as QR Code.")
public class JukeboxQR extends BaseCommand {
    @Default
    public void onCommand(Player sender) {
        sender.sendMessage("Generating QR Code...");

        Runnable qrcodeGenerator = new QRCodeGenerator(sender);
        MCJukeboxQRCode.getPlugin().getServer().getScheduler().runTaskAsynchronously(MCJukeboxQRCode.getPlugin(), qrcodeGenerator);
    }

    @HelpCommand
    public void onHelp(CommandSender sender, CommandHelp help) {
        help.showHelp();
    }
}
