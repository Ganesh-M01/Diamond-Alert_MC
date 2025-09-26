package me.cherry;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class DiamondAlert extends JavaPlugin implements Listener {

    private final Map<UUID, List<Long>> diamondBreaks = new HashMap<>();
    private final int TIME_WINDOW = 60; // seconds
    private final int MAX_DIAMONDS = 5;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("DiamondAlert enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("DiamondAlert disabled");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Material block = event.getBlock().getType();

        if (block == Material.DIAMOND_ORE || block == Material.DEEPSLATE_DIAMOND_ORE) {
            broadcastToStaff("§b[Alert] §f" + player.getName() + " found a diamond at " +
                    event.getBlock().getLocation().toVector());

            long now = System.currentTimeMillis() / 1000;
            UUID uuid = player.getUniqueId();

            diamondBreaks.putIfAbsent(uuid, new ArrayList<>());
            List<Long> times = diamondBreaks.get(uuid);

            times.add(now);
            times.removeIf(t -> now - t > TIME_WINDOW);

            if (times.size() > MAX_DIAMONDS) {
                broadcastToStaff("§c[Suspicious] " + player.getName() + " broke " +
                        times.size() + " diamonds in " + TIME_WINDOW + " seconds!");
            }
        }
    }

    private void broadcastToStaff(String message) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission("diamondalert.notify")) {
                p.sendMessage(message);
            }
        }
    }
}
