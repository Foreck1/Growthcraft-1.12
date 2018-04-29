package growthcraft.milk.shared.init;

import java.util.HashMap;
import java.util.Map;

import growthcraft.core.shared.fluids.FluidFactory;
import growthcraft.core.shared.fluids.FluidFactory.FluidDetails;
import growthcraft.milk.shared.init.GrowthcraftMilkItems.AgedCheeseTypes;
import growthcraft.milk.shared.init.GrowthcraftMilkItems.SimpleCheeseTypes;
import growthcraft.milk.shared.init.GrowthcraftMilkItems.WaxedCheeseTypes;

public class GrowthcraftMilkFluids {
	
	public static FluidDetails butterMilk;
	public static FluidDetails cream;
	public static FluidDetails milk;
	public static FluidDetails curds;
	public static FluidDetails rennet;
	public static FluidDetails skimMilk;
	public static FluidDetails whey;
	public static FluidDetails pasteurizedMilk;
	public static Map<SimpleCheeseTypes, FluidFactory.FluidDetails> cheesesSimple = new HashMap<SimpleCheeseTypes, FluidFactory.FluidDetails>();
	public static Map<AgedCheeseTypes, FluidFactory.FluidDetails> cheesesAged = new HashMap<AgedCheeseTypes, FluidFactory.FluidDetails>();
	public static Map<WaxedCheeseTypes, FluidFactory.FluidDetails> cheesesWaxed = new HashMap<WaxedCheeseTypes, FluidFactory.FluidDetails>();
}