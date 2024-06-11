package io.github.eggest.itemdupe.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static io.github.eggest.itemdupe.ItemDupe.ins;

public class DupeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        if (itemInMainHand != null){
            player.getInventory().addItem(itemInMainHand);
            ins.getLogger().info(player.getName() + " dupe once");
        }
        return true;
    }
}
