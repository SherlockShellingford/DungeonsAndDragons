import javafx.util.Pair;
import java.util.List;

public class Rogue extends Player{
    private final int maxEnergy = 100;
    private final int range = 2;
    private int currentEnergy;
    private int cost;

    public Rogue(String name, /*UIDataContext observer,8*/ int health, int attack, int defense, Pair<Integer, Integer> position, int cost){
        this.name = name;
        //this.observer = observer;
        this.health = health;
        this.currentHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.position = position;
        this.XP = 0;
        this.level = 1;
        this.currentEnergy = maxEnergy;
        this.cost = cost;
    }

    @Override
    public void levelUp(){
        XP -= 50*level;
        level++;
        health += 10*level;
        currentHealth = health;
        attack += 8*level;
        defense += 2*level;
        currentEnergy = maxEnergy;
    }

    @Override
    public boolean ability(List<Enemy> enemies){
        if (currentEnergy < cost) {
            return false;
        }
        currentEnergy -= cost;
        Enemy[] a = new Enemy[enemies.size()];
        int i = 0;
        for (Enemy enemy : enemies) {
            if ((int) range(enemy) <= range) {
                a[i] = enemy;
                i++;
            }
        }
        i--;
        while (i > 0){
            int dmg = attack - RandomNumber.getInstance().nextInt(a[r].defense);
            if (dmg > 0){
                a[i].health -= dmg;
            }
        }
        return true;
    }

    @Override
    public void onGameTick() {
        currentEnergy += 10;
        if (currentEnergy > maxEnergy){
            currentEnergy = maxEnergy;
        }
    }
}
