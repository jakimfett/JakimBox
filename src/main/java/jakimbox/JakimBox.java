package jakimbox;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import jakimbox.network.MessageHandler;
import jakimbox.proxy.CommonProxyBase;
import jakimbox.registry.BlockRegistry;
import jakimbox.registry.CreativeTabRegistry;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author jakimfett
 * @version @MAJOR@.@MINOR@
 */
@Mod(modid = JakimBox.modID, name = JakimBox.prettyName, version = JakimBox.version, useMetadata = false, acceptedMinecraftVersions = "[1.7.10,)")
public class JakimBox
{
    public static final String modID = "jakimbox";
    public static final String prettyName = "Jakim In A Box";
    public static final String version = "@MAJOR@.@MINOR@.@BUILD@";

    public static Random random = new Random();

    @Mod.Metadata(JakimBox.modID)
    public static ModMetadata metadata;

    @SidedProxy(clientSide = "jakimbox.proxy.client.ClientProxyBase", serverSide = "jakimbox.proxy.CommonProxyBase")
    public static CommonProxyBase proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        BlockRegistry.init();
        CreativeTabRegistry.init();
        Config.init();
        MessageHandler.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        JakimBox.metadata = JakimBox.setupModMetaData(metadata);
        proxy.registerRenderers();
    }

    public static ModMetadata setupModMetaData(ModMetadata meta)
    {
        meta.modId = JakimBox.modID;
        meta.name = JakimBox.prettyName;
        meta.description = "I got tired of re-creating a Block/TileEntity/Item framework for every single mod I worked on. So I made this.";
        meta.url = "https://github.com/jakimfett/JakimBox";
        meta.logoFile = "assets/" + JakimBox.modID + "/logo.png";
        meta.version = JakimBox.version;
        meta.authorList = Arrays.asList("jakimfett");
        meta.autogenerated = false;
        return meta;
    }

}
