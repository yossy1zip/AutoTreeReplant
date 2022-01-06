package com.yiorno.autotreereplant;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import static com.yiorno.autotreereplant.AutoTreeReplant.saishu;
import static com.yiorno.autotreereplant.AutoTreeReplant.shigenNormal;

public class Event implements Listener {

    @EventHandler
    public void onCutLog(BlockBreakEvent e){

        Block b = e.getBlock();

        if(!isLog(b)){
            return;
        }

        if(!isShigen(b)){
            return;
        }

        if(!isOnTheGround(b)){
            return;
        }

        replantSapling(b, getSapling(b));
    }

    public void replantSapling(Block b, Material sap){

        (new BukkitRunnable() {

            public void run(){

                b.setType(sap);

            }

        }).runTaskLater((Plugin)AutoTreeReplant.getInstance(), 2L);

    }

    public boolean isShigen(Block b){
        return (b.getWorld() == saishu) ||
                (b.getWorld() == shigenNormal);
    }

    public boolean isLog(Block b){
        String matStr = b.getType().toString();
        return matStr.contains("_LOG");
    }

    public boolean isOnTheGround(Block b){
        Block lowerBlock = b.getRelative(0, -1, 0);
        return lowerBlock.getType() == Material.DIRT;
    }

    public Material getSapling(Block b){
        String matStr = b.getType().toString();

        if(matStr.contains("STRIPPED_")){
            matStr = matStr.replace("STRIPPED_", "");
        }

        String saplingStr = matStr.replace("_LOG", "_SAPLING");

        //try

        return Material.valueOf(saplingStr);
    }
}
