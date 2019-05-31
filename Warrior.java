import javafx.util.Pair;
import java.util.List;

public class Warrior extends Player {
    private int CD;
    private int remainingCD;

    public Warrior(String name, UIDataContext observer, int health, int attack, int defense, int CD, Pair<Integer, Integer> position){
        this.name = name;
        this.observer = observer;
        this.health = health;
        this.currentHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.position = position;
        this.XP = 0;
        this.level = 1;
        this.CD = CD;
        this.remainingCD = 0;
    }

    @Override
    public void levelUp(){
        remainingCD = 0;
        XP -= 50*level;
        level++;
        health += 15*level;
        currentHealth = health;
        attack += 5*level;
        defense += 3*level;
    }

    @Override
    public boolean ability(List<Enemy> enemies){    //TODO: update uml
        if (remainingCD > 0) {
            return false;
        }
        remainingCD  = CD;
        currentHealth += 2 * defense;
        if (currentHealth > health){
            currentHealth = health;
        }
        return true;
    }

    @Override
    public void onGameTick() {
        remainingCD -= 1;
        if (remainingCD < 0){
            remainingCD = 0;
        }
    }
    @Override
    public String toString(){
        return name+"      Health: "+currentHealth+"/"+health+"     Attack: "+attack+"    Defense: "+defense+"     XP: "+XP+"/"+50*level+"\n   Cooldown "+remainingCD+"/"+CD+"         Level: "+level;
    }
}
