package com.github.totoCastaldi.minecraft.bukkit.plugin.walkthrough;

import com.google.common.collect.Iterables;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Plugin extends JavaPlugin {

    public boolean onCommand(
            CommandSender sender,
            Command command,
            String commandLabel,
            String[] args
    ) {

        System.out.println("onCommand command [" + command + "], commandLabel [" + commandLabel + "] args [" + Arrays.asList(args) + "]");

        Player me = (Player) sender;

        if (StringUtils.equalsIgnoreCase("step", commandLabel)) {
            final String firstParameter = StringUtils.stripToEmpty(Iterables.getFirst(Arrays.asList(args), StringUtils.EMPTY));

            if ("1".equalsIgnoreCase(firstParameter)) step1(me);
            if ("2".equalsIgnoreCase(firstParameter)) step2(me);
            if ("3".equalsIgnoreCase(firstParameter)) step3(me);
            if ("4".equalsIgnoreCase(firstParameter)) step4(me);
        }

        if (StringUtils.equalsIgnoreCase("answer", commandLabel)) {
            final String firstParameter = StringUtils.stripToEmpty(Iterables.getFirst(Arrays.asList(args), StringUtils.EMPTY));

            if ("1".equalsIgnoreCase(firstParameter)) answer1(me);
            if ("2".equalsIgnoreCase(firstParameter)) answer2(me);
            if ("3".equalsIgnoreCase(firstParameter)) answer3(me);
        }

        return true;
    }

    private void step4(Player player) {
        Location location = player.getLocation();
        World world = location.getWorld();

        location = location.add(+2, 0, 0);

        final double startX = location.getX();
        final double startY = location.getY();
        final double startZ = location.getZ();

        final int length = 10;

        for (int x = 0; x < length; x++) {
            for (int z = 0; z < length; z++) {
                for (int y = 0; y < length; y++) {
                    location.setX(startX + x);
                    location.setY(startY + y);
                    location.setZ(startZ + z);

                    Block block = world.getBlockAt(location);
                    block.setType(Material.DIAMOND_BLOCK);
                }
            }
        }

    }

    private void answer3(Player player) {
        Location location = player.getLocation();
        World world = location.getWorld();

        location = location.add(+2, 0, 0);

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 20; i++) {
                Block block = world.getBlockAt(location);
                if (i % 2 == 0) {
                    block.setType(Material.DIAMOND_BLOCK);
                } else {
                    block.setType(Material.BRICK);
                }

                location = location.add(0, +1, 0);
            }
            location = location.add(+1, -20, 0);
        }

    }

    private void step3(Player player) {
        Location location = player.getLocation();
        World world = location.getWorld();

        location = location.add(+2, 0, 0);

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 20; i++) {
                Block block = world.getBlockAt(location);
                block.setType(Material.DIAMOND_BLOCK);

                location = location.add(0, +1, 0);
            }
            location = location.add(+1, -20, 0);
        }

    }

    private void answer2(Player player) {
        Location location = player.getLocation();
        World world = location.getWorld();

        location = location.add(+2, 0, 0);

        for (int i = 0; i < 30; i++) {
            Block block = world.getBlockAt(location);
            block.setType(Material.DIAMOND_BLOCK);

            location = location.add(0,+1,0);
        }
    }

    private void answer1(Player player) {
        Location location = player.getLocation();
        World world = location.getWorld();

        location = location.add(+2, 0, 0);

        Block block = world.getBlockAt(location);
        block.setType(Material.DIAMOND_BLOCK);

        location = location.add(0, 1, 0);

        block = world.getBlockAt(location);
        block.setType(Material.DIAMOND_BLOCK);
    }

    private void step2(Player player) {
        Location location = player.getLocation();
        World world = location.getWorld();

        location = location.add(+2, 0, 0);

        for (int i = 0; i < 30; i++) {
            Block block = world.getBlockAt(location);
            block.setType(Material.AIR);

            location = location.add(0,-1,0);
        }
    }

    private void step1(Player player) {
        Location location = player.getLocation();
        World world = location.getWorld();

        location = location.add(+2, 0, 0);

        Block block = world.getBlockAt(location);
        block.setType(Material.DIAMOND_BLOCK);
    }

    public void onEnable() {
        System.out.println("enEnable");
    }


    public void onLoad() {
        System.out.println("onLoad");
    }

    public void onDisable() {
        System.out.println("onDisable");
    }

    public List<String> onTabComplete(
            CommandSender sender,
            Command command,
            String alias,
            String[] args) {

        System.out.println("onTabComplete");
        return new ArrayList<String>();
    }
}