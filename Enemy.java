import java.util.List;

public abstract class Enemy extends GameUnit {
    protected int experienceValue;
    protected char tile;

    public abstract void move(GameUnit unit);

}
