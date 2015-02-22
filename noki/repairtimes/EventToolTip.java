package noki.repairtimes;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;

public class EventToolTip {
	
	@SubscribeEvent
	public void onToolTip(ItemTooltipEvent event) {
		
		int repairTimes = event.itemStack.getRepairCost();
		if(repairTimes == 0) {
			return;
		}
		
		repairTimes = repairTimes/2;
		event.toolTip.add(EnumChatFormatting.GOLD + "[Repair Times] : " + repairTimes);
		
	}
	
	@SubscribeEvent
	public void onJoinWorld(EntityJoinWorldEvent event) {
		
		if(event.world.isRemote && event.entity instanceof EntityPlayer
				&& ((EntityPlayer)event.entity).getDisplayName() == Minecraft.getMinecraft().thePlayer.getDisplayName()) {			
			RepairTimesCore.versionInfo.notifyUpdate(Side.CLIENT);
		}
		
	}

}
