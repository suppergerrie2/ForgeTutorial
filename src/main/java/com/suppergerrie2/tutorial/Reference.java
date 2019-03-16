package com.suppergerrie2.tutorial;

/**
 * The Reference class keeps track of constants we need in multiple places.
 * For example the mod's id
 */
public class Reference {

    /**
     * The mod id is needed in lots of places, for example the @Mod annotation, @Mod.EventBusSubscriber annotation, registry names, etc. <br/>
     * The mod id can be 64 characters long and needs to be in the english local as defined in {@link net.minecraftforge.fml.common.Mod @Mod}
     */
    public static final String MODID = "sg2tutorial";


}
