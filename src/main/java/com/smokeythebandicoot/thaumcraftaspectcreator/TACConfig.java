package com.smokeythebandicoot.thaumcraftaspectcreator;

import net.minecraftforge.common.config.Config;

@Config(modid = TACMod.MODID, name = "thaumcraft_aspect_creator", category = "aspect_creation")
public class TACConfig {

    @Config.RequiresMcRestart
    @Config.Name("Custom Aspects")
    @Config.Comment({
            "This is the list of custom aspects to add to Thaumcraft",
            "Add one aspect per line. The format is: <name>;<color>;<aspect1>;<aspect2>",
            "<name>: the name of the aspect. For example: \"tempestas\"",
            "<color>: the int color of the aspect, for example 6495ED. Use a website like https://htmlcolorcodes.com/ to pick the color",
            "<aspect1>: it is the first ingredient aspect. Should not be null",
            "<aspect2>: it is the second ingredient aspect. Should not be null",
            "A Complete example would be like this:",
            "tempestas;0x4C2773;volatus;aqua",
            "Note: for commodity, the string parser ignores tabs",
            "Note: registration of aspects which depend of previously defined aspects is possible. Just include them before.",
            "For example: ",
            "ventus;0xXXYYZZ;aer;perditio",
            "tempestas;0xAABBCC;aqua;ventus",
            "Download icons in Thaumcraft style at https://game-icons.net/",
            "Download them with white foreground and transparent background. Save as png and put it into your ",
            "<minecraft instance folder>/resources/thaumcraftaspectcreator/textures/<name>.png",
            "For the Tempestas aspect, it would be placed into <minecraft instance folder>/resources/thaumcraftaspectcreator/tempestas.png",
            "Localize the aspect short description using the unlocalized string tc.aspect.<name>",
            "(for example, add to en_us.lang the string \"tc.aspect.tempestas=Storm, Turbolence\"",
            "       --- Have fun :) ---"
    })
    public static String[] CustomAspects = { };

}
