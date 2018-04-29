package growthcraft.cellar.shared.booze;

import java.util.List;

import growthcraft.cellar.shared.CellarRegistry;
import growthcraft.cellar.shared.booze.BoozeEffect;
import growthcraft.cellar.shared.booze.BoozeTag;
import growthcraft.core.shared.CoreRegistry;
import growthcraft.core.shared.config.description.Describer;
import growthcraft.core.shared.fluids.UnitFormatter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

public class BoozeUtils
{
	private BoozeUtils() {}

	public static float alcoholToTipsy(float alcoholRate)
	{
		return alcoholRate * 4;
	}

	public static boolean isFermentedBooze(Fluid booze)
	{
		return CoreRegistry.instance().fluidDictionary().hasFluidTags(booze, BoozeTag.FERMENTED);
	}

	public static void addEffects(Fluid booze, ItemStack stack, World world, EntityPlayer player)
	{
		if (booze == null) return;

		final BoozeEffect effect = CellarRegistry.instance().booze().getEffect(booze);
		if (effect != null)
		{
			effect.apply(world, player, world.rand, null);
		}
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void addInformation(Fluid booze, ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		if (booze == null) return;
		final String s = UnitFormatter.fluidModifier(booze);
		if (s != null) list.add(s);
		Describer.getDescription((List<String>)list, booze);
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void addEffectInformation(Fluid booze, ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		if (booze == null) return;
		final BoozeEffect effect = CellarRegistry.instance().booze().getEffect(booze);
		if (effect != null)
		{
			effect.getDescription((List<String>)list);
		}
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void addBottleInformation(Fluid booze, ItemStack stack, EntityPlayer player, List list, boolean bool, boolean showDetailed)
	{
		if (booze == null) return;
		addInformation(booze, stack, player, list, bool);
		if (showDetailed)
			addEffectInformation(booze, stack, player, list, bool);
	}

	public static boolean hasEffect(Fluid booze)
	{
		final BoozeEffect effect = CellarRegistry.instance().booze().getEffect(booze);
		if (effect != null) return effect.isValid();
		return false;
	}
}