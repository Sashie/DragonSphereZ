package ud.bi0.dragonSphereZ.skriptAPI.registers;

import ch.njol.skript.Skript;
import ud.bi0.dragonSphereZ.skriptAPI.effects.*;

public class RegisterEffects {

	public static void DragonSphereZ() {
		Skript.registerEffect(EffStop.class, new String[] {"stop effect with id %string%"});
		Skript.registerEffect(EffStop.class, new String[] {"stopEffect[ id] %string%"});
		Skript.registerEffect(EffSimpleDot.class, new String[] { "drawDot [count %-number%], particle %string%[, material %-itemstack%][, speed %-number%][, ([offset]XYZ|RGB) %-number%, %-number%, %-number%], center %locations/entities%[, onlyFor %-player%][, r[ainbow]M[ode] %-boolean%], visibleRange %number%" } );
		Skript.registerEffect(EffComplexCircle.class, new String[] { "drawComplexCircle particle %string%[, material %-itemstack%][, speed %-number%][, ([offset]XYZ|RGB) %-number%, %-number%, %-number%], center %entitys/locations%, id %string%[, onlyFor %-player%][, r[ainbow]M[ode] %-boolean%], randomRotation %boolean%, radius %number%, density %number%, start %number%, visibleRange %number%[, Rot[ation]XYZ %-number%, %-number%, %-number%][, dis[placement]XYZ %-number%, %-number%, %-number%][, [pulse]Delay %-number%]" } );
		
	}
	public static void BetaTests() {
		Skript.registerEffect(EffLineTest.class, new String[] {"linetest with id %string% from %location% to %players%"});
		Skript.registerEffect(EffComplexCircle2.class, new String[] { "drawComplexCircle2 particle %string%[, material %-itemstack%][, speed %-number%][, ([offset]XYZ|RGB) %-number%, %-number%, %-number%], center %locations/entitys%, id %string%[, onlyFor %-player%][, r[ainbow]M[ode] %-boolean%], randomRotation %boolean%, radius %number%, density %number%, start %number%, visibleRange %number%[, Rot[ation]XYZ %-number%, %-number%, %-number%][, dis[placement]XYZ %-number%, %-number%, %-number%][, [pulse]Delay %-number%]" } );

	}
}