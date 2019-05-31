import javafx.util.Pair;
import java.util.List;

public abstract class Player extends GameUnit {
    protected int XP;
    protected int level;

    public int getXP() {
        return XP;
    }

    public int getLevel() {
        return level;
    }

    public void move(String command){
        Formerposition=position;
        Pair<Integer, Integer> next=null;
        switch (command){
            case "w":
                next = new Pair<>(position.getKey() - 1, position.getValue());
                break;
            case "s":
                next = new Pair<>(position.getKey() + 1, position.getValue());
                break;
            case "a":
                next = new Pair<>(position.getKey(), position.getValue() - 1);
                break;
            case "d":
                next = new Pair<>(position.getKey(), position.getValue() + 1);
                break;
        }
        position=next;
    }
    public void gainExperience(Enemy defeated){
        this.XP+=defeated.experienceValue;
    }
    abstract void onGameTick();

    abstract void levelUp();

    abstract boolean ability(List<Enemy> enemyList);
}
