package me.ryanhamshire.GPFlags;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;

public class FlagDef_NoFireDamage extends FlagDefinition {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onFireSpread(BlockBurnEvent e) {
        Block fire = e.getBlock();
        Flag flag = this.GetFlagInstanceAtLocation(fire.getLocation(), null);
        if (flag == null) return;

        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockIgnite(BlockIgniteEvent e) {
        Block fire = e.getBlock();
        Flag flag = this.GetFlagInstanceAtLocation(fire.getLocation(), null);
        if (flag == null) return;
        if (e.getCause() == BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL) return;

        e.setCancelled(true);
    }

    public FlagDef_NoFireDamage(FlagManager manager, GPFlags plugin)
    {
        super(manager, plugin);
    }

    @Override
    String getName()
    {
        return "NoFireDamage";
    }

    @Override
    MessageSpecifier GetSetMessage(String parameters)
    {
        return new MessageSpecifier(Messages.EnableNoFireDamage);
    }

    @Override
    MessageSpecifier GetUnSetMessage()
    {
        return new MessageSpecifier(Messages.DisableNoFireDamage);
    }

}