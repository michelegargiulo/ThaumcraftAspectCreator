package com.smokeythebandicoot.thaumcraftaspectcreator;

import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Level;
import thaumcraft.api.aspects.Aspect;

public class AspectParser {
    public static void parse(String[] source) {

        try {
            for (String aspectDescription : source) {
                String[] properties = aspectDescription.split(";");

                // Aspect description parsing
                if (properties.length != 4) {
                    TACMod.logger.log(Level.WARN, "Error parsing the aspect description string: " +
                            aspectDescription + "; The aspect will be skipped");
                    continue;
                }

                // Check if aspect already exists
                String name = properties[0].replace("\t", "");
                if (Aspect.getAspect(name) != null) {
                    TACMod.logger.log(Level.WARN, "Error adding the aspect \"" + name + "\". Aspect already exists");
                }

                // Color parsing
                int color = 0;
                try {
                    color = Integer.decode(properties[1].replace("\t", ""));
                } catch (NumberFormatException nfex) {
                    TACMod.logger.log(Level.WARN, "Error parsing the aspect color string \"" + properties[1] +
                            "\" for the \"" + name + "\" aspect. Black will be the assigned color. Fix this issue in the configs");
                    color = 0;
                }

                // Aspect retrieval
                Aspect aspect1 = Aspect.getAspect(properties[2].replace("\t", ""));
                Aspect aspect2 = Aspect.getAspect(properties[3].replace("\t", ""));

                // Check if aspects DO exist
                if (aspect1 == null || aspect2 == null) {
                    TACMod.logger.log(Level.WARN, "Error parsing the aspect ingredients for aspect \"" + name + "\". "
                            + aspect1 == null ? "Aspect 1 does not exist; " : ""
                            + aspect2 == null ? "Aspect 2 does not exist; " : ""
                    );
                    continue;
                }

                Aspect a = new Aspect(
                        name,
                        color,
                        new Aspect[]{ aspect1, aspect2 },
                        new ResourceLocation(TACMod.MODID, "textures/" + name + ".png"), 1);
            }

        } catch (Exception ex) {
            TACMod.logger.log(Level.WARN, "A severe error occured in parsing the custom aspects. Could not proceed the loading. All aspects will be ignored");
        }
    }
}
