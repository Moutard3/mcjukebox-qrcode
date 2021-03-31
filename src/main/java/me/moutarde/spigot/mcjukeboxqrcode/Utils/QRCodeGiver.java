package me.moutarde.spigot.mcjukeboxqrcode.Utils;

import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;

import java.awt.image.BufferedImage;

@RequiredArgsConstructor
public class QRCodeGiver implements Runnable {
    private final Player player;
    private final BufferedImage resultImage;

    @Override
    public void run() {
        MapView mapView = installRenderer(player, resultImage);
        ItemStack mapItem = new ItemStack(Material.FILLED_MAP, 1);
        MapMeta mapMeta = (MapMeta) mapItem.getItemMeta();

        if (mapMeta != null) {
            mapMeta.setMapView(mapView);
            mapItem.setItemMeta(mapMeta);
            player.getInventory().addItem(mapItem);
        }
    }

    private MapView installRenderer(Player player, BufferedImage image) {
        MapView mapView = Bukkit.createMap(player.getWorld());
        mapView.getRenderers().forEach(mapView::removeRenderer);

        mapView.addRenderer(new QRCodeRenderer(player, image));
        return mapView;
    }
}
