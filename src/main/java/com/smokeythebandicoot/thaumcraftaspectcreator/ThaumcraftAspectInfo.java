package com.smokeythebandicoot.thaumcraftaspectcreator;

import thaumcraft.api.aspects.Aspect;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Resource;

public class ThaumcraftAspectInfo {
    private String name;
    private Integer color;
    private Aspect ingredient1;
    private Aspect ingredient2;
    private ResourceLocation resourceLocation;

    public ThaumcraftAspectInfo(String _name, Integer color, Aspect ingredient1, Aspect ingredient2, ResourceLocation resourceLocation) {
        this.name = _name;
        this.color = color;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.resourceLocation = resourceLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Aspect getIngredient1() {
        return ingredient1;
    }

    public void setIngredient1(Aspect ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public Aspect getIngredient2() {
        return ingredient2;
    }

    public void setIngredient2(Aspect ingredient2) {
        this.ingredient2 = ingredient2;
    }

    public ResourceLocation getResourceLocation() {
        return resourceLocation;
    }

    public void setResourceLocation(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }
}
