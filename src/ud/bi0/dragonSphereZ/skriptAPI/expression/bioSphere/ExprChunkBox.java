package ud.bi0.dragonSphereZ.skriptAPI.expression.bioSphere;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprChunkBox extends SimpleExpression<Chunk>{
	private Expression<Location> loc1;
	private Expression<Location> loc2;
	@Override
	public Class<? extends Chunk> getReturnType() {
		return Chunk.class;
	}

	@Override
	public boolean isSingle() {
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int arg1, Kleenean arg2, ParseResult arg3) {
		loc1 = (Expression<Location>) expr[0];
		loc2 = (Expression<Location>) expr[1];
		return true;
	}

	@Override
	public String toString(@Nullable Event arg0, boolean arg1) {
		return "chunks between %location% and %location%";
	}

	@Override
	@Nullable
	protected Chunk[] get(Event e) {
		return new BiosphereTrigLib().getChunksBox(loc1.getSingle(e),loc2.getSingle(e));
	}

}
