import java.util.List;

public abstract class Enemy extends GameUnit {
    protected int experienceValue;
    protected char tile;

    public abstract void move(GameUnit unit);
    @Override
    public String toString(){
        return name+"      Health: "+currentHealth+"     Attack: "+attack+"      Defense: "+defense;
    }

    public int getExperienceValue() {
        return experienceValue;
    }

    public char getTile() {
        return tile;
    }
}
