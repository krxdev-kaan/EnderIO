package com.enderio.machines.common.init;

import com.enderio.EnderIO;
import com.enderio.base.common.init.EIOBlocks;
import com.enderio.machines.client.rendering.blockentity.ObeliskBER;
import com.enderio.machines.common.blockentity.AlloySmelterBlockEntity;
import com.enderio.machines.common.blockentity.AversionObeliskBlockEntity;
import com.enderio.machines.common.blockentity.CrafterBlockEntity;
import com.enderio.machines.common.blockentity.CreativePowerBlockEntity;
import com.enderio.machines.common.blockentity.DrainBlockEntity;
import com.enderio.machines.common.blockentity.EnchanterBlockEntity;
import com.enderio.machines.common.blockentity.FluidTankBlockEntity;
import com.enderio.machines.common.blockentity.ImpulseHopperBlockEntity;
import com.enderio.machines.common.blockentity.PaintedTravelAnchorBlockEntity;
import com.enderio.machines.common.blockentity.PaintingMachineBlockEntity;
import com.enderio.machines.common.blockentity.PoweredSpawnerBlockEntity;
import com.enderio.machines.common.blockentity.PrimitiveAlloySmelterBlockEntity;
import com.enderio.machines.common.blockentity.SagMillBlockEntity;
import com.enderio.machines.common.blockentity.SlicerBlockEntity;
import com.enderio.machines.common.blockentity.SoulBinderBlockEntity;
import com.enderio.machines.common.blockentity.SoulEngineBlockEntity;
import com.enderio.machines.common.blockentity.StirlingGeneratorBlockEntity;
import com.enderio.machines.common.blockentity.TravelAnchorBlockEntity;
import com.enderio.machines.common.blockentity.VacuumChestBlockEntity;
import com.enderio.machines.common.blockentity.WiredChargerBlockEntity;
import com.enderio.machines.common.blockentity.XPObeliskBlockEntity;
import com.enderio.machines.common.blockentity.XPVacuumBlockEntity;
import com.enderio.machines.common.blockentity.capacitorbank.CapacitorBankBlockEntity;
import com.enderio.machines.common.blockentity.capacitorbank.CapacitorTier;
import com.enderio.machines.common.blockentity.solar.SolarPanelBlockEntity;
import com.enderio.machines.common.blockentity.solar.SolarPanelTier;
import com.google.common.collect.ImmutableMap;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.BlockEntityBuilder;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.Util;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MachineBlockEntities {
    private static final Registrate REGISTRATE = EnderIO.registrate();

    public static final BlockEntityEntry<FluidTankBlockEntity.Standard> FLUID_TANK = register("fluid_tank", FluidTankBlockEntity.Standard::new,
        MachineBlocks.FLUID_TANK);

    public static final BlockEntityEntry<FluidTankBlockEntity.Enhanced> PRESSURIZED_FLUID_TANK = register("pressurized_fluid_tank",
        FluidTankBlockEntity.Enhanced::new, MachineBlocks.PRESSURIZED_FLUID_TANK);

    public static final BlockEntityEntry<EnchanterBlockEntity> ENCHANTER = register("enchanter", EnchanterBlockEntity::new, MachineBlocks.ENCHANTER);

    public static final BlockEntityEntry<PrimitiveAlloySmelterBlockEntity> PRIMITIVE_ALLOY_SMELTER = register("primitive_alloy_smelter", PrimitiveAlloySmelterBlockEntity::new,
        MachineBlocks.PRIMITIVE_ALLOY_SMELTER);

    public static final BlockEntityEntry<AlloySmelterBlockEntity> ALLOY_SMELTER = register("alloy_smelter", AlloySmelterBlockEntity::new,
        MachineBlocks.ALLOY_SMELTER);

    public static final BlockEntityEntry<CreativePowerBlockEntity> CREATIVE_POWER = register("creative_power", CreativePowerBlockEntity::new,
        MachineBlocks.CREATIVE_POWER);
    public static final BlockEntityEntry<StirlingGeneratorBlockEntity> STIRLING_GENERATOR = register("stirling_generator",
        StirlingGeneratorBlockEntity::new, MachineBlocks.STIRLING_GENERATOR);
    public static final BlockEntityEntry<SagMillBlockEntity> SAG_MILL = register("sag_mill", SagMillBlockEntity::new, MachineBlocks.SAG_MILL);

    public static final BlockEntityEntry<SlicerBlockEntity> SLICE_AND_SPLICE = register("slice_and_splice", SlicerBlockEntity::new,
        MachineBlocks.SLICE_AND_SPLICE);

    public static final BlockEntityEntry<ImpulseHopperBlockEntity> IMPULSE_HOPPER = register("impulse_hopper", ImpulseHopperBlockEntity::new,
        MachineBlocks.IMPULSE_HOPPER);
    public static final BlockEntityEntry<VacuumChestBlockEntity> VACUUM_CHEST = register("vacuum_chest", VacuumChestBlockEntity::new,
        MachineBlocks.VACUUM_CHEST);
    public static final BlockEntityEntry<XPVacuumBlockEntity> XP_VACUUM = register("xp_vacuum", XPVacuumBlockEntity::new, MachineBlocks.XP_VACUUM);
    public static final BlockEntityEntry<TravelAnchorBlockEntity> TRAVEL_ANCHOR = register("travel_anchor", TravelAnchorBlockEntity::new,
        MachineBlocks.TRAVEL_ANCHOR);

    public static final BlockEntityEntry<PaintedTravelAnchorBlockEntity> PAINTED_TRAVEL_ANCHOR = register("painted_travel_anchor", PaintedTravelAnchorBlockEntity::new,
        MachineBlocks.PAINTED_TRAVEL_ANCHOR);

    public static final BlockEntityEntry<CrafterBlockEntity> CRAFTER = register("crafter", CrafterBlockEntity::new, MachineBlocks.CRAFTER);

    public static final BlockEntityEntry<DrainBlockEntity> DRAIN = register("drain", DrainBlockEntity::new, MachineBlocks.DRAIN);

    public static final BlockEntityEntry<SoulBinderBlockEntity> SOUL_BINDER = register("soul_binder", SoulBinderBlockEntity::new, MachineBlocks.SOUL_BINDER);

    public static final BlockEntityEntry<WiredChargerBlockEntity> WIRED_CHARGER = register("wired_charger",
       WiredChargerBlockEntity::new, MachineBlocks.WIRED_CHARGER);

    public static final BlockEntityEntry<PaintingMachineBlockEntity> PAINTING_MACHINE = register("painting_machine", PaintingMachineBlockEntity::new, MachineBlocks.PAINTING_MACHINE);

    public static final BlockEntityEntry<PoweredSpawnerBlockEntity> POWERED_SPAWNER = register("powered_spawner", PoweredSpawnerBlockEntity::new, MachineBlocks.POWERED_SPAWNER);

    public static final Map<SolarPanelTier, BlockEntityEntry<SolarPanelBlockEntity>> SOLAR_PANELS = Util.make(() -> {
       Map<SolarPanelTier, BlockEntityEntry<SolarPanelBlockEntity>> map = new HashMap<>();
       for (SolarPanelTier tier : SolarPanelTier.values()) {
           map.put(tier, register(tier.name().toLowerCase(Locale.ROOT) + "_photovoltaic_cell", (type, worldPosition,
               blockState) -> new SolarPanelBlockEntity(type, worldPosition, blockState, tier), () -> MachineBlocks.SOLAR_PANELS.get(tier).get()));
       }
       return ImmutableMap.copyOf(map);
    });

    public static final Map<CapacitorTier, BlockEntityEntry<CapacitorBankBlockEntity>> CAPACITOR_BANKS = Util.make(() -> {
       Map<CapacitorTier, BlockEntityEntry<CapacitorBankBlockEntity>> map = new HashMap<>();
       for (CapacitorTier tier : CapacitorTier.values()) {
           map.put(tier, register(tier.name().toLowerCase(Locale.ROOT) + "_capacitor_bank", (type, worldPosition,
               blockState) -> new CapacitorBankBlockEntity(type, worldPosition, blockState, tier), () -> MachineBlocks.CAPACITOR_BANKS.get(tier).get()));
       }
       return ImmutableMap.copyOf(map);
    });

    public static final BlockEntityEntry<SoulEngineBlockEntity> SOUL_ENGINE = register("soul_engine", SoulEngineBlockEntity::new, MachineBlocks.SOUL_ENGINE);
    public static final BlockEntityEntry<XPObeliskBlockEntity> XP_OBELISK = register("xp_obelisk", XPObeliskBlockEntity::new, MachineBlocks.XP_OBELISK);

    public static final BlockEntityEntry<AversionObeliskBlockEntity> AVERSION_OBELISK = register("aversion_obelisk", AversionObeliskBlockEntity::new, MachineBlocks.AVERSION_OBELISK);

    @SafeVarargs
    private static <B extends BlockEntity> BlockEntityEntry<B> register(String name, BlockEntityBuilder.BlockEntityFactory<B> beFactory,
        NonNullSupplier<? extends Block>... blocks) {
        return REGISTRATE.blockEntity(name, beFactory).validBlocks(blocks).register();
    }

    public static void register() {}
}
