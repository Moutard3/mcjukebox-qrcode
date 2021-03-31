package me.moutarde.spigot.mcjukeboxqrcode.Utils;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.jetbrains.annotations.NotNull;

import java.awt.image.BufferedImage;
import java.util.UUID;

public class QRCodeRenderer extends MapRenderer {
    private final UUID playerUUID;
    private BufferedImage image;

    public QRCodeRenderer(Player player, BufferedImage image) {
        super(true);

        this.playerUUID = player.getUniqueId();
        this.image = image;
    }

    @Override
    public void render(@NotNull MapView map, @NotNull MapCanvas canvas, @NotNull Player player) {
        if (image != null && player.getUniqueId().equals(playerUUID)) {
            canvas.drawImage(0, 0, image);
            image = null;
        }
    }
}
