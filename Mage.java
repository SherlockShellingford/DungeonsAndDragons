import javafx.util.Pair;
import java.util.List;
import java.util.Random;


public class Mage extends Player {
    private int spellPower;
    private int manaPool;
    private int currentMana;
    private int cost;
    private int hitTimes;
    private int range;


    public Mage(String name, /*UIDataContext observer,8*/ int health, int attack, int defense, Pair<Integer, Integer> position,
                int spellPower, int manaPool, int cost, int hitTimes, int range){
        this.name = name;
        //this.observer = observer;
        this.health = health;
        this.currentHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.position = position;
        this.XP = 0;
        this.level = 1;
        this.spellPower = spellPower;
        this.manaPool = manaPool;
        this.currentMana = manaPool;
        this.cost = cost;
        this.hitTimes = hitTimes;
        this.range = range;
    }

    @Override
    public void levelUp(){
        manaPool += 25*level;
        XP -= 50*level;
        level++;
        health += 10*level;
        currentHealth = health;
        attack += 5*level;
        defense += 2*level;
        manaPool += 25*level;
        currentMana += manaPool/4;
        spellPower += 10*level;
        if (currentMana > manaPool){
            currentMana = manaPool;
        }
    }

    @Override
    public boolean ability(List<Enemy> enemies){
        if (currentMana < cost) {
            return false;
        }
        currentMana -= cost;
        int hits = 0;
        Enemy[] a = new Enemy[enemies.size()];
        int i = 0;
        for (Enemy enemy : enemies) {
            if ((int) range(enemy) < range) {
                a[i] = enemy;
                i++;
            }
        }
        i--;
        while (hits < hitTimes | hits == i + 1){
            int r = RandomNumber.getInstance().nextInt(i);
            int dmg = spellPower - RandomNumber.getInstance().nextInt(a[r].defense);
            if (a[r] != null){
                if (dmg > 0){
                    a[r].health -= dmg;
                }
                a[r] = null;
                hits++;
            }
        }
        return true;
    }

    @Override
    public void onGameTick() {
        currentMana += 1;
        if (currentMana > manaPool){
            currentMana = manaPool;
        }
    }
}
