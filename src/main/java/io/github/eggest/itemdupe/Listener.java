package io.github.eggest.itemdupe;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

import static io.github.eggest.itemdupe.ItemDupe.ins;

public class Listener implements org.bukkit.event.Listener {
    //  展示框复制
    @EventHandler
    void ItemFrameDupe(PlayerInteractEntityEvent event) {
        if (ins.getConfig().getBoolean("EnableItemFrameDupe")) {
            if (event.getRightClicked().getType() == EntityType.ITEM_FRAME) {
                ItemFrame itemFrame = (ItemFrame) event.getRightClicked();
                if (itemFrame.getItem().getType() != Material.AIR) {
                    if (new Random().nextDouble() < ins.getConfig().getDouble("ItemFrameDupeProbability")) {
                        ItemStack itemStack = itemFrame.getItem();
                        itemFrame.getWorld().dropItemNaturally(itemFrame.getLocation(), itemStack);
                    }
                }
            }
        }
    }

    //  超级鸽鸽复制
    @EventHandler
    public void superChicken(PlayerInteractEntityEvent event) {
        ItemStack itemInMainHand = event.getPlayer().getInventory().getItemInMainHand();
        int dupeNum = ins.getConfig().getInt("SuperChickenDupeNum");
        if (ins.getConfig().getBoolean("EnableSuperChickenDupe")) {
            if (event.getRightClicked().getType().equals(EntityType.CHICKEN)) {
                for (int i = 0; i < ins.getConfig().getInt("SuperChickenDupeNum"); ++i) {
                    event.getPlayer().getWorld().dropItem(event.getPlayer().getLocation(), itemInMainHand);
                }
            }
        }
    }
}
