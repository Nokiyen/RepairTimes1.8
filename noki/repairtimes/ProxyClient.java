package noki.repairtimes;

import net.minecraftforge.common.MinecraftForge;


/**********
 * @class ProxyClient
 *
 * @description クライアント用proxyクラス。
 * @description_en Proxy class for Client.
 */
public class ProxyClient extends ProxyCommon {
	
	//******************************//
	// define member variables.
	//******************************//


	//******************************//
	// define member methods.
	//******************************//
	@Override
	public void register() {
		
		MinecraftForge.EVENT_BUS.register(new EventToolTip());
		
	}
	
}
