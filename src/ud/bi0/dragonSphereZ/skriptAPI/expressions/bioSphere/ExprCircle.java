package ud.bi0.dragonSphereZ.skriptAPI.expressions.bioSphere;

import org.bukkit.Location;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import ud.bi0.dragonSphereZ.maths.shape.Cylinder;
import ud.bi0.dragonSphereZ.maths.vector.Vector3;

public class ExprCircle extends SimpleExpression<Location> {
	private Expression<Location> loc;
	private Expression<Number> radius;
	private Expression<Number> density;
	@Override
	public Class<? extends Location> getReturnType() {
		return Location.class;
	}

	@Override
	public boolean isSingle() {
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int arg1, Kleenean arg2, ParseResult arg3) {
		loc = (Expression<Location>) expr[0];
		radius = (Expression<Number>) expr[1];
		density = (Expression<Number>) expr[2];
		return true;
	}

	@Override
	public String toString(@Nullable Event arg0, boolean arg1) {
		return "circle[s] at %locations%[ with] radius %number%(,| and) density %number%";
	}

	@Override
	@Nullable
	protected Location[] get(Event e) {
		Vector3 vec = new Vector3(loc.getSingle(e));
		double r = radius.getSingle(e).doubleValue();
		Cylinder circle = new Cylinder(vec, r, r);
		Location[] locs = new Vector3().locationArray(loc.getSingle(e).getWorld(), circle.renderEllipse(density.getSingle(e).doubleValue()));
		return locs;
	}

}