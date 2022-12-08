package com.smokeythebandicoot.thaumcraftaspectcreator;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectEventProxy;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.AspectRegistryEvent;

import java.util.List;

@Mod(modid = TACMod.MODID, name = TACMod.NAME, version = TACMod.VERSION, dependencies = TACMod.DEPENDENCIES)
public class TACMod
{
    public static final String MODID = "thaumcraftaspectcreator";
    public static final String NAME = "Thaumcraft Aspect Creator";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "required-after:thaumcraft@[6.1.BETA26,);";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // Initialization for Thaumcraft Aspect Creator
        logger.info("Initializing Thaumcraft Aspect Creator: the mod to add your custom Thaumcraft Aspects for your modpack!");

        if (!Loader.isModLoaded("thaumcraft")) {
            logger.error("Could not find Thaumcraft! This mod won't do anything");
            return;
        }

        // Read from config
        String[] aspects = TACConfig.CustomAspects;

        // No aspects defined
        if (aspects.length == 0) return;

        // Parse and register the new Aspect
        AspectParser.parse(aspects);

    }
}
