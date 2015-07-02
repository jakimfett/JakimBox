package jakimbox;

import net.minecraftforge.common.config.Configuration;

/**
 * Configuration class for JakimBox
 *
 * @author jakimfett
 */
public class Config
{
    public static Configuration config;

    // Enable or disable extra debug info and logging
    public static boolean debugMode = true;

    // Adjust the diffusion rate of gases
    public static int gasDiffusionRate = 3;
}
