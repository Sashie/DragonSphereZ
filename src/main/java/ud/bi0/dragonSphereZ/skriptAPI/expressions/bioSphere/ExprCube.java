package ud.bi0.dragonSphereZ.skriptAPI.expressions.bioSphere;

import org.bukkit.Location;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import ud.bi0.dragonSphereZ.maths.shape.Box;
import ud.bi0.dragonSphereZ.maths.vector.Vector3;

public class ExprCube extends SimpleExpression<Location>{
	private Expression<Location> loc;
	private Expression<Number> radius;
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
		return true;
	}

	@Override
	public String toString(@Nullable Event arg0, boolean arg1) {
		return "cube[s] at %locations%[ with] radius %number%";
	}

	@Override
	@Nullable
	protected Location[] get(Event e) {
		Vector3 vec = new Vector3(loc.getSingle(e));
		double r = radius.getSingle(e).doubleValue();
		Box cube = new Box(vec, r, r, r);
		Location[] locs = new Vector3().locationArray(loc.getSingle(e).getWorld(), cube.getVertices(-0.5, 0.5, -0.5, 0.5, -0.5, 0.5));
		return locs;
	}

}