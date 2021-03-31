package me.moutarde.spigot.mcjukeboxqrcode.Listeners;

import me.moutarde.spigot.mcjukeboxqrcode.Utils.MapUtils;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class QRCodeDrop implements Listener {
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onDrop(PlayerDropItemEvent dropItemEvent) {
        Item itemDrop = dropItemEvent.getItemDrop();
        ItemStack mapItem = itemDrop.getItemStack();
        if (MapUtils.isQRCode(mapItem)) {
            itemDrop.remove();
        }
    }
}
