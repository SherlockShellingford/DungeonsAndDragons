import java.util.List;

public abstract class Enemy extends GameUnit {
    private int experienceValue;
    private char tile;

    public abstract void move(GameUnit unit);

}
