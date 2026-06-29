package lyrellion.ars_elemancy;


import com.hollingsworth.arsnouveau.api.ArsNouveauAPI;
import com.hollingsworth.arsnouveau.api.perk.PerkSlot;
import com.hollingsworth.arsnouveau.api.registry.*;
import com.hollingsworth.arsnouveau.api.ritual.AbstractRitual;
import com.hollingsworth.arsnouveau.api.spell.*;
import lyrellion.ars_elemancy.common.items.armor.ArmorSet;
import lyrellion.ars_elemancy.registry.ModItems;
import lyrellion.ars_elemancy.registry.ModRegistry;
import net.neoforged.fml.ModList;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArsNouveauRegistry {
    public static final List<AbstractSpellPart> registeredSpells = new ArrayList<>();

    public static void init() {
        registerGlyphs();
        registerPerks();
        linkDamageResistances();
    }

    public static final PerkSlot PERK_FOUR = registerPerkSlot( "four", 4);
    public static final PerkSlot PERK_FIVE = registerPerkSlot( "five", 5);
    public static final PerkSlot PERK_SIX = registerPerkSlot( "six", 6);

    private static PerkSlot registerPerkSlot(String name, int value) {
        PerkSlot slot = new PerkSlot(ArsElemancy.prefix(name), value);
        PerkSlot.PERK_SLOTS.put(slot.id(), slot);
        return slot;
    }

    private static void linkDamageResistances() {
    }


    public static void registerGlyphs() {

        //effects

    }


    public static void registerRitual(AbstractRitual ritual) {
        RitualRegistry.registerRitual(ritual);
    }

    public static void postInit() {
        ArsNouveauRegistry.addPerkSlots();
        ArsNouveauAPI.getInstance().getEnchantingRecipeTypes().add(ModRegistry.ELEMANCY_ARMOR_UP.get());
    }

    public static void addSchool(AbstractSpellPart part, SpellSchool school) {
        part.spellSchools.add(school);
        school.addSpellPart(part);
    }

    public static void register(AbstractSpellPart spellPart) {
        GlyphRegistry.registerSpell(spellPart);
        registeredSpells.add(spellPart);
    }


    public static void registerPerks() {

    }

    public static ArmorSet[] medium_armors = {ModItems.TEMPEST_ARMOR, ModItems.SILT_ARMOR, ModItems.MIRE_ARMOR, ModItems.VAPOR_ARMOR, ModItems.CINDER_ARMOR, ModItems.LAVA_ARMOR};
    public static ArmorSet[] heavy_armors = {ModItems.TEMPEST_ARMOR_H, ModItems.SILT_ARMOR_H, ModItems.MIRE_ARMOR_H, ModItems.VAPOR_ARMOR_H, ModItems.CINDER_ARMOR_H, ModItems.LAVA_ARMOR_H};
    public static ArmorSet[] light_armors = {ModItems.TEMPEST_ARMOR_L, ModItems.SILT_ARMOR_L, ModItems.MIRE_ARMOR_L, ModItems.VAPOR_ARMOR_L, ModItems.CINDER_ARMOR_L, ModItems.LAVA_ARMOR_L};
    public static ArmorSet[] ultimate_medium = {ModItems.ELEMANCER_ARMOR};
    public static ArmorSet[] ultimate_heavy = {ModItems.ELEMANCER_ARMOR_H};
    public static ArmorSet[] ultimate_light = {ModItems.ELEMANCER_ARMOR_L};


    private static void addPerkSlots() {

        if (ModList.get().isLoaded("allthearcanistgear")) {
        for (ArmorSet set : medium_armors) {
            PerkRegistry.registerPerkProvider(set.getHat(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.THREE, PERK_FOUR)));
            PerkRegistry.registerPerkProvider(set.getChest(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.THREE, PERK_FOUR)));
            PerkRegistry.registerPerkProvider(set.getLegs(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.THREE, PERK_FOUR)));
            PerkRegistry.registerPerkProvider(set.getBoots(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.THREE, PERK_FOUR)));
        }

        for (ArmorSet set : light_armors) {
            PerkRegistry.registerPerkProvider(set.getHat(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.THREE, PERK_FOUR)));
            PerkRegistry.registerPerkProvider(set.getChest(), makePerkList(Arrays.asList(PerkSlot.THREE, PerkSlot.THREE, PERK_FOUR)));
            PerkRegistry.registerPerkProvider(set.getLegs(), makePerkList(Arrays.asList(PerkSlot.THREE, PerkSlot.THREE, PERK_FOUR)));
            PerkRegistry.registerPerkProvider(set.getBoots(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.THREE, PERK_FOUR)));
        }

        for (ArmorSet set : heavy_armors) {
            PerkRegistry.registerPerkProvider(set.getHat(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.THREE, PerkSlot.THREE)));
            PerkRegistry.registerPerkProvider(set.getChest(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.THREE, PERK_FOUR)));
            PerkRegistry.registerPerkProvider(set.getLegs(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.THREE, PERK_FOUR)));
            PerkRegistry.registerPerkProvider(set.getBoots(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.THREE, PerkSlot.THREE)));
        }

        for (ArmorSet set : ultimate_medium) {
            PerkRegistry.registerPerkProvider(set.getHat(), makePerkList(Arrays.asList(PerkSlot.THREE, PERK_FOUR, PERK_FIVE)));
            PerkRegistry.registerPerkProvider(set.getChest(), makePerkList(Arrays.asList(PerkSlot.THREE, PERK_FOUR, PERK_FIVE)));
            PerkRegistry.registerPerkProvider(set.getLegs(), makePerkList(Arrays.asList(PerkSlot.THREE, PERK_FOUR, PERK_FIVE)));
            PerkRegistry.registerPerkProvider(set.getBoots(), makePerkList(Arrays.asList(PerkSlot.THREE, PERK_FOUR, PERK_FIVE)));
        }

        for (ArmorSet set : ultimate_heavy) {
            PerkRegistry.registerPerkProvider(set.getHat(), makePerkList(Arrays.asList(PerkSlot.THREE, PERK_FOUR, PERK_FOUR)));
            PerkRegistry.registerPerkProvider(set.getChest(), makePerkList(Arrays.asList(PerkSlot.THREE, PERK_FOUR, PERK_FIVE)));
            PerkRegistry.registerPerkProvider(set.getLegs(), makePerkList(Arrays.asList(PerkSlot.THREE, PERK_FOUR, PERK_FIVE)));
            PerkRegistry.registerPerkProvider(set.getBoots(), makePerkList(Arrays.asList(PerkSlot.THREE, PERK_FOUR, PERK_FOUR)));
        }

        for (ArmorSet set : ultimate_light) {
            PerkRegistry.registerPerkProvider(set.getHat(), makePerkList(Arrays.asList(PerkSlot.THREE, PERK_FOUR, PERK_FIVE)));
            PerkRegistry.registerPerkProvider(set.getChest(), makePerkList(Arrays.asList(PERK_FOUR, PERK_FOUR, PERK_FIVE)));
            PerkRegistry.registerPerkProvider(set.getLegs(), makePerkList(Arrays.asList(PERK_FOUR, PERK_FOUR, PERK_FIVE)));
            PerkRegistry.registerPerkProvider(set.getBoots(), makePerkList(Arrays.asList(PerkSlot.THREE, PERK_FOUR, PERK_FIVE)));
        }

        } else {
            for (ArmorSet set : medium_armors) {
                PerkRegistry.registerPerkProvider(set.getHat(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getChest(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getLegs(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getBoots(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
            }

            for (ArmorSet set : light_armors) {
                PerkRegistry.registerPerkProvider(set.getHat(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getChest(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getLegs(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getBoots(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
            }

            for (ArmorSet set : heavy_armors) {
                PerkRegistry.registerPerkProvider(set.getHat(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.TWO)));
                PerkRegistry.registerPerkProvider(set.getChest(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getLegs(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getBoots(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.TWO)));
            }

            for (ArmorSet set : ultimate_medium) {
                PerkRegistry.registerPerkProvider(set.getHat(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getChest(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getLegs(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getBoots(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
            }

            for (ArmorSet set : ultimate_light) {
                PerkRegistry.registerPerkProvider(set.getHat(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getChest(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getLegs(), makePerkList(Arrays.asList(PerkSlot.TWO, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getBoots(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
            }

            for (ArmorSet set : ultimate_heavy) {
                PerkRegistry.registerPerkProvider(set.getHat(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.TWO)));
                PerkRegistry.registerPerkProvider(set.getChest(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getLegs(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.THREE)));
                PerkRegistry.registerPerkProvider(set.getBoots(), makePerkList(Arrays.asList(PerkSlot.ONE, PerkSlot.TWO, PerkSlot.TWO)));
            }
        }
    }

    private static @NotNull List<List<PerkSlot>> makePerkList(List<PerkSlot> perkSlots) {
        return List.of(perkSlots, perkSlots, perkSlots, perkSlots);
    }

}
