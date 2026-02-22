package lyrellion.ars_elemancy.common.items.armor;

import alexthw.ars_elemental.ArsElemental;
import alexthw.ars_elemental.ConfigHandler;
import com.alexthw.sauce.event.AttributeEventHandler;
import com.hollingsworth.arsnouveau.api.spell.SpellSchool;
import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import lyrellion.ars_elemancy.ArsElemancy;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static lyrellion.ars_elemancy.common.items.armor.ArmorSet.weaknessMap;

public class LightArmorE extends ElemancyArmor {

    public LightArmorE(ArmorItem.Type slot, SpellSchool element, Properties builder) {
        super(slot, element, schoolToMaterial(element.getId() + "_light"), builder.durability(slot.getDurability(30)), "light_armor_e");
    }

//    @Override
//    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flags) {
//        super.appendHoverText(stack, context, tooltip, flags);
//        tooltip.add(Component.literal("Set bonus, Model and Texture still work in progress, currently same as medium variant." + (ConfigHandler.Startup.ENABLE_ARMOR_REWORK.get() ? " Thread slots will change with beta features enabled." : "")).withStyle(ChatFormatting.RED));
//    }

    @Override
    public String getTier() {
        return "light";
    }

    @Override
    public @NotNull ItemAttributeModifiers getDefaultAttributeModifiers(@NotNull ItemStack stack) {
        ItemAttributeModifiers itemAttributeModifiers = super.getDefaultAttributeModifiers(stack);

        if (element == SpellSchools.ELEMENTAL)
            return itemAttributeModifiers.withModifierAdded(AttributeEventHandler.schoolToDefenseAttribute.get(this.element), new AttributeModifier(ArsElemental.prefix("elemental_defense_armor_" + this.type.getName()), 12.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.bySlot(this.type.getSlot()))
                    .withModifierAdded(AttributeEventHandler.schoolToPowerAttribute.get(this.element), new AttributeModifier(ArsElemental.prefix("elemental_power_armor_" + this.type.getName()), 2, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.bySlot(this.type.getSlot()));

        for (var school : this.element.getSubSchools()) {
            if (school == SpellSchools.ELEMENTAL) continue;
            itemAttributeModifiers = itemAttributeModifiers.withModifierAdded(AttributeEventHandler.schoolToDefenseAttribute.get(weaknessMap.getOrDefault(school, SpellSchools.ELEMENTAL)), new AttributeModifier(ArsElemental.prefix("elemental_weakness_armor_" + this.type.getName()), -25, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.bySlot(this.type.getSlot()))
                    .withModifierAdded(AttributeEventHandler.schoolToDefenseAttribute.get(school), new AttributeModifier(ArsElemental.prefix("elemental_defense_armor_" + this.type.getName()), 12.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.bySlot(this.type.getSlot()))
                    .withModifierAdded(AttributeEventHandler.schoolToPowerAttribute.get(school), new AttributeModifier(ArsElemental.prefix("elemental_power_armor_" + this.type.getName()), 2, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.bySlot(this.type.getSlot()));
        }

        return itemAttributeModifiers;
    }
}