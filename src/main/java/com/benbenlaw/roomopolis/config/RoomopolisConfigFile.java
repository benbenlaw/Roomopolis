package com.benbenlaw.roomopolis.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class RoomopolisConfigFile {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<String> fireShrineTreasureBlock;
    public static final ForgeConfigSpec.ConfigValue<String> waterShrineTreasureBlock;
    public static final ForgeConfigSpec.ConfigValue<String> earthShrineTreasureBlock;
    public static final ForgeConfigSpec.ConfigValue<String> airShrineTreasureBlock;
    public static final ForgeConfigSpec.ConfigValue<Integer> roomPlacementLowestBlockY;

    static {
        BUILDER.push("Roomopolis Config File");

        fireShrineTreasureBlock = BUILDER.comment("The block that will be used as the treasure block for the fire shrine")
                .define("Fire Shrine Treasure Block", "minecraft:gold_block");

        waterShrineTreasureBlock = BUILDER.comment("The block that will be used as the treasure block for the water shrine")
                .define("Water Shrine Treasure Block", "minecraft:gold_block");

        earthShrineTreasureBlock = BUILDER.comment("The block that will be used as the treasure block for the earth shrine")
                .define("Earth Shrine Treasure Block", "minecraft:gold_block");

        airShrineTreasureBlock = BUILDER.comment("The block that will be used as the treasure block for the air shrine")
                .define("Air Shrine Treasure Block", "minecraft:gold_block");
        roomPlacementLowestBlockY = BUILDER.comment("Lowest Y Level for room placement using keys on the bottom of room blocks")
                .define("Lowest Y Level for room placement", 0);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
