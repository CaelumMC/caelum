package reoseah.caelum.common;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;
import reoseah.caelum.common.blocks.BarleyBlock;
import reoseah.caelum.common.blocks.BlossomingCaelumSproutsBlock;
import reoseah.caelum.common.blocks.CaelumFarmlandBlock;
import reoseah.caelum.common.blocks.CaelumFlowerBlock;
import reoseah.caelum.common.blocks.CaelumGrassBlock;
import reoseah.caelum.common.blocks.CaelumSproutsBlock;
import reoseah.caelum.common.blocks.ModCraftingTableBlock;
import reoseah.caelum.common.blocks.ModDoorBlock;
import reoseah.caelum.common.blocks.ModStairsBlock;
import reoseah.caelum.common.blocks.ModTrapdoorBlock;
import reoseah.caelum.common.blocks.SealstoneBlock;
import reoseah.caelum.common.blocks.SkyrootSaplingBlock;
import reoseah.caelum.common.blocks.SkyrootSaplingGenerator;

public class CaelumBlocks {
	public static final Block AERRACK = new Block(FabricBlockSettings.of(Material.STONE).strength(4.0F, 9.0F).breakByTool(FabricToolTags.PICKAXES, 0).sounds(BlockSoundGroup.STONE));
	public static final Block CERUCLASE_ORE = new Block(FabricBlockSettings.of(Material.STONE).lightLevel(7).nonOpaque().strength(5.0F, 9.0F).breakByTool(FabricToolTags.PICKAXES, 0).sounds(BlockSoundGroup.STONE));

	public static final Block AERRACK_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 10.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES, 0));
	public static final Block AERRACK_BRICK_STAIRS = new ModStairsBlock(AERRACK_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(AERRACK_BRICKS));
	public static final Block AERRACK_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(AERRACK_BRICKS));
	public static final Block AERRACK_PILLAR = new PillarBlock(FabricBlockSettings.copyOf(AERRACK_BRICKS));
	public static final Block AERRACK_LIGHTSTONE = new Block(FabricBlockSettings.copyOf(AERRACK_BRICKS).lightLevel(13));
	public static final Block CERUCLASE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MaterialColor.CYAN).lightLevel(15).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES, 0));

	public static final Block CAELUM_GRASS = new CaelumGrassBlock(FabricBlockSettings.of(Material.ORGANIC).ticksRandomly().strength(0.6F, 0.6F).sounds(BlockSoundGroup.GRASS).breakByTool(FabricToolTags.SHOVELS));
	public static final Block CAELUM_DIRT = new Block(FabricBlockSettings.of(Material.EARTH).strength(0.5F, 0.5F).sounds(BlockSoundGroup.GRAVEL).breakByTool(FabricToolTags.SHOVELS));
	public static final Block CAELUM_FARMLAND = new CaelumFarmlandBlock(FabricBlockSettings.of(Material.EARTH).ticksRandomly().strength(0.6F, 0.6F).sounds(BlockSoundGroup.GRAVEL).breakByTool(FabricToolTags.SHOVELS));

	public static final Block SKYROOT_LOG = new LogBlock(MaterialColor.WOOD, FabricBlockSettings.copyOf(Blocks.OAK_LOG));
	public static final Block STRIPPED_SKYROOT_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG));

	public static final Block SKYROOT_LEAVES = new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES));
	public static final Block SILVER_SKYROOT_LEAVES = new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES));
	public static final Block DWARF_PINE_LEAVES = new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES));
	public static final Block SKYROOT_SAPLING = new SkyrootSaplingBlock(new SkyrootSaplingGenerator(), FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
	public static final Block SILVER_SKYROOT_SAPLING = new SkyrootSaplingBlock(new SkyrootSaplingGenerator(), FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
	public static final Block DWARF_PINE_SAPLING = new SkyrootSaplingBlock(new SkyrootSaplingGenerator(), FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));

	public static final Block CAELUM_SPROUTS = new CaelumSproutsBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS));
	public static final Block BLOSSOMING_CAELUM_SPROUTS = new BlossomingCaelumSproutsBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS));
	public static final Block SKY_BLUE_FLOWER = new CaelumFlowerBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS));

	public static final Block SKYROOT_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 0));
	public static final Block SKYROOT_STAIRS = new ModStairsBlock(SKYROOT_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(SKYROOT_PLANKS));
	public static final Block SKYROOT_SLAB = new SlabBlock(FabricBlockSettings.copyOf(SKYROOT_PLANKS));

	public static final Block CAELUM_CRAFTING_TABLE = new ModCraftingTableBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).breakByHand(true));
	public static final Block CELESTIAL_ALTAR = new ModCraftingTableBlock(FabricBlockSettings.copyOf(AERRACK_BRICKS));

	public static final Block MOSSY_AERRACK = new Block(FabricBlockSettings.copyOf(AERRACK_BRICKS));
	public static final Block MOSSY_AERRACK_BRICKS = new Block(FabricBlockSettings.copyOf(AERRACK_BRICKS));
	public static final Block MOSSY_AERRACK_PILLAR = new PillarBlock(FabricBlockSettings.copyOf(AERRACK_BRICKS));

	public static final Block SEALSTONE = new SealstoneBlock(FabricBlockSettings.copyOf(AERRACK_BRICKS).lightLevel(8).resistance(15F));
	public static final Block INERT_SEALSTONE = new Block(FabricBlockSettings.copyOf(AERRACK_BRICKS));
	public static final Block MOSSY_SEALSTONE = new SealstoneBlock(FabricBlockSettings.copyOf(AERRACK_BRICKS).lightLevel(8).resistance(15F));
	public static final Block INERT_MOSSY_SEALSTONE = new Block(FabricBlockSettings.copyOf(AERRACK_BRICKS));

	public static final Block BARLEY = new BarleyBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));

	public static final Block SKYROOT_DOOR = new ModDoorBlock(FabricBlockSettings.of(Material.WOOD).strength(3.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
	public static final Block SKYROOT_TRAPDOOR = new ModTrapdoorBlock(FabricBlockSettings.of(Material.WOOD).strength(3.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());

	public static void register() {
		Registry.register(Registry.BLOCK, "caelum:aerrack", AERRACK);
		Registry.register(Registry.BLOCK, "caelum:ceruclase_ore", CERUCLASE_ORE);

		Registry.register(Registry.BLOCK, "caelum:aerrack_bricks", AERRACK_BRICKS);
		Registry.register(Registry.BLOCK, "caelum:aerrack_brick_stairs", AERRACK_BRICK_STAIRS);
		Registry.register(Registry.BLOCK, "caelum:aerrack_brick_slab", AERRACK_BRICK_SLAB);
		Registry.register(Registry.BLOCK, "caelum:aerrack_pillar", AERRACK_PILLAR);
		Registry.register(Registry.BLOCK, "caelum:aerrack_lightstone", AERRACK_LIGHTSTONE);
		Registry.register(Registry.BLOCK, "caelum:ceruclase_block", CERUCLASE_BLOCK);

		Registry.register(Registry.BLOCK, "caelum:caelum_grass", CAELUM_GRASS);
		Registry.register(Registry.BLOCK, "caelum:caelum_dirt", CAELUM_DIRT);
		Registry.register(Registry.BLOCK, "caelum:caelum_farmland", CAELUM_FARMLAND);

		Registry.register(Registry.BLOCK, "caelum:skylarch_log", SKYROOT_LOG);
		Registry.register(Registry.BLOCK, "caelum:stripped_skylarch_log", STRIPPED_SKYROOT_LOG);
		Registry.register(Registry.BLOCK, "caelum:skylarch_leaves", SKYROOT_LEAVES);
		Registry.register(Registry.BLOCK, "caelum:silver_skylarch_leaves", SILVER_SKYROOT_LEAVES);
		Registry.register(Registry.BLOCK, "caelum:dwarf_pine_leaves", DWARF_PINE_LEAVES);
		Registry.register(Registry.BLOCK, "caelum:skylarch_sapling", SKYROOT_SAPLING);
		Registry.register(Registry.BLOCK, "caelum:silver_skylarch_sapling", SILVER_SKYROOT_SAPLING);
		Registry.register(Registry.BLOCK, "caelum:dwarf_pine_sapling", DWARF_PINE_SAPLING);

		Registry.register(Registry.BLOCK, "caelum:caelum_sprouts", CAELUM_SPROUTS);
		Registry.register(Registry.BLOCK, "caelum:blossoming_caelum_sprouts", BLOSSOMING_CAELUM_SPROUTS);
		Registry.register(Registry.BLOCK, "caelum:sky_blue_flower", SKY_BLUE_FLOWER);

		Registry.register(Registry.BLOCK, "caelum:skylarch_planks", SKYROOT_PLANKS);
		Registry.register(Registry.BLOCK, "caelum:skylarch_stairs", SKYROOT_STAIRS);
		Registry.register(Registry.BLOCK, "caelum:skylarch_slab", SKYROOT_SLAB);

		Registry.register(Registry.BLOCK, "caelum:caelum_crafting_table", CAELUM_CRAFTING_TABLE);
		Registry.register(Registry.BLOCK, "caelum:celestial_altar", CELESTIAL_ALTAR);

		Registry.register(Registry.BLOCK, "caelum:mossy_aerrack", MOSSY_AERRACK);
		Registry.register(Registry.BLOCK, "caelum:mossy_aerrack_bricks", MOSSY_AERRACK_BRICKS);
		Registry.register(Registry.BLOCK, "caelum:mossy_aerrack_pillar", MOSSY_AERRACK_PILLAR);

		Registry.register(Registry.BLOCK, "caelum:sealstone", SEALSTONE);
		Registry.register(Registry.BLOCK, "caelum:inert_sealstone", INERT_SEALSTONE);
		Registry.register(Registry.BLOCK, "caelum:mossy_sealstone", MOSSY_SEALSTONE);
		Registry.register(Registry.BLOCK, "caelum:inert_mossy_sealstone", INERT_MOSSY_SEALSTONE);

		Registry.register(Registry.BLOCK, "caelum:barley", BARLEY);

		Registry.register(Registry.BLOCK, "caelum:skylarch_door", SKYROOT_DOOR);
		Registry.register(Registry.BLOCK, "caelum:skylarch_trapdoor", SKYROOT_TRAPDOOR);

		Registry.register(Registry.ITEM, "caelum:aerrack", new BlockItem(AERRACK, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:ceruclase_ore", new BlockItem(CERUCLASE_ORE, new Item.Settings().group(CaelumItems.GROUP)));

		Registry.register(Registry.ITEM, "caelum:aerrack_bricks", new BlockItem(AERRACK_BRICKS, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:aerrack_brick_stairs", new BlockItem(AERRACK_BRICK_STAIRS, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:aerrack_brick_slab", new BlockItem(AERRACK_BRICK_SLAB, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:aerrack_pillar", new BlockItem(AERRACK_PILLAR, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:aerrack_lightstone", new BlockItem(AERRACK_LIGHTSTONE, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:ceruclase_block", new BlockItem(CERUCLASE_BLOCK, new Item.Settings().group(CaelumItems.GROUP)));

		Registry.register(Registry.ITEM, "caelum:caelum_grass", new BlockItem(CAELUM_GRASS, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:caelum_dirt", new BlockItem(CAELUM_DIRT, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:caelum_farmland", new BlockItem(CAELUM_FARMLAND, new Item.Settings().group(CaelumItems.GROUP)));

		Registry.register(Registry.ITEM, "caelum:skylarch_log", new BlockItem(SKYROOT_LOG, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:stripped_skylarch_log", new BlockItem(STRIPPED_SKYROOT_LOG, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:skylarch_leaves", new BlockItem(SKYROOT_LEAVES, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:silver_skylarch_leaves", new BlockItem(SILVER_SKYROOT_LEAVES, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:dwarf_pine_leaves", new BlockItem(DWARF_PINE_LEAVES, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:skylarch_sapling", new BlockItem(SKYROOT_SAPLING, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:silver_skylarch_sapling", new BlockItem(SILVER_SKYROOT_SAPLING, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:dwarf_pine_sapling", new BlockItem(DWARF_PINE_SAPLING, new Item.Settings().group(CaelumItems.GROUP)));

		Registry.register(Registry.ITEM, "caelum:caelum_sprouts", new BlockItem(CAELUM_SPROUTS, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:blossoming_caelum_sprouts", new BlockItem(BLOSSOMING_CAELUM_SPROUTS, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:sky_blue_flower", new BlockItem(SKY_BLUE_FLOWER, new Item.Settings().group(CaelumItems.GROUP)));

		Registry.register(Registry.ITEM, "caelum:skylarch_planks", new BlockItem(SKYROOT_PLANKS, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:skylarch_stairs", new BlockItem(SKYROOT_STAIRS, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:skylarch_slab", new BlockItem(SKYROOT_SLAB, new Item.Settings().group(CaelumItems.GROUP)));

		Registry.register(Registry.ITEM, "caelum:caelum_crafting_table", new BlockItem(CAELUM_CRAFTING_TABLE, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:celestial_altar", new BlockItem(CELESTIAL_ALTAR, new Item.Settings().group(CaelumItems.GROUP)));

		Registry.register(Registry.ITEM, "caelum:mossy_aerrack", new BlockItem(MOSSY_AERRACK, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:mossy_aerrack_bricks", new BlockItem(MOSSY_AERRACK_BRICKS, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:mossy_aerrack_pillar", new BlockItem(MOSSY_AERRACK_PILLAR, new Item.Settings().group(CaelumItems.GROUP)));

		Registry.register(Registry.ITEM, "caelum:sealstone", new BlockItem(SEALSTONE, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:inert_sealstone", new BlockItem(INERT_SEALSTONE, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:mossy_sealstone", new BlockItem(MOSSY_SEALSTONE, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:inert_mossy_sealstone", new BlockItem(INERT_MOSSY_SEALSTONE, new Item.Settings().group(CaelumItems.GROUP)));

		Registry.register(Registry.ITEM, "caelum:skylarch_door", new BlockItem(SKYROOT_DOOR, new Item.Settings().group(CaelumItems.GROUP)));
		Registry.register(Registry.ITEM, "caelum:skylarch_trapdoor", new BlockItem(SKYROOT_TRAPDOOR, new Item.Settings().group(CaelumItems.GROUP)));
	}
}
