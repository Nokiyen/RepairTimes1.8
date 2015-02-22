package noki.repairtimes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


/**********
 * @Mod RepairTimes
 *
 * @author Nokiyen
 * 
 * @description 
 */
@Mod(modid = "RepairTimes", version = "1.0.0", name = "Repair Times")
public class RepairTimesCore {
	
	//******************************//
	// define member variables.
	//******************************//
	@Instance(value = "RepairTimes")
	public static RepairTimesCore instance;
	@Metadata
	public static ModMetadata metadata;	//	extract from mcmod.info file, not java internal coding.
	public static VersionInfo versionInfo;
	@SidedProxy(clientSide = "noki.repairtimes.ProxyClient", serverSide = "noki.repairtimes.ProxyCommon")
	public static ProxyCommon proxy;

	
	//******************************//
	// define member methods.
	//******************************//
	//----------
	//Core Event Methods.
	//----------
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		versionInfo = new VersionInfo(metadata.modId.toLowerCase(), metadata.version, metadata.updateUrl);
		
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		
		proxy.register();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		//	nothing to do.

	}
	
}
