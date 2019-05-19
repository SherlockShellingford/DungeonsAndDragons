import javafx.util.Pair;

import java.util.List;

public class Warrior extends Player {
    private int CD;
    private int remainingCD;

    public Warrior(String name, UIDataContext observer, int health, int currentHealth,
                   int attack, int defense, Pair<Integer, Integer> position, int XP, int level, int CD, int remainingCD){
        this.name = name;
        this.observer = observer;
        this.health = health;
        this.currentHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.position = position;
        this.XP = XP;
        this.level = level;
        this.CD = CD;
        this.remainingCD = remainingCD;
    }

    public void levelUp(){
        remainingCD = 0;
        XP -= 50*level;
        level++;
        health += 15*level;
        currentHealth = health;
        attack += 5*level;
        defense += 3*level;
    }

    public boolean ability(List<Enemy> enemies){
        if (remainingCD > 0) {
            return false;
        }
        else {
            remainingCD  = CD;
            currentHealth += 2 * defense;
        }
        if (currentHealth>)
    }
}
