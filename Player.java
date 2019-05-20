import javafx.util.Pair;
import java.util.List;

public abstract class Player extends GameUnit {
    protected int XP;
    protected int level;

    public void move(String command){
        Pair<Integer, Integer> next;
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
    }

    abstract void onGameTick();

    abstract void levelUp();

    abstract boolean ability(List<Enemy> enemyList);
}
