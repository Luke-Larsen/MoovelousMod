package com.lukehanslarsen.Moovelous;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lukehanslarsen.Moovelous.setup.Registration;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoovelousMod.MOD_ID)
public class MoovelousMod
{
	public static final String MOD_ID = "moovelous";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public MoovelousMod() {
    	Registration.register();
    	
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
