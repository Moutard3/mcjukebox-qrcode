package me.moutarde.spigot.mcjukeboxqrcode.Utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;

public class MapUtils {
    public static boolean isQRCode(ItemStack mapItem) {
        if (mapItem == null || mapItem.getType() != Material.FILLED_MAP) {
            return false;
        }

        MapMeta mapMeta = (MapMeta) mapItem.getItemMeta();

        MapView mapView = null;
        if (mapMeta != null) {
            mapView = mapMeta.getMapView();
        }

        return mapView != null && mapView.getRenderers().stream()
                .anyMatch(QRCodeRenderer.class::isInstance);
    }
}
