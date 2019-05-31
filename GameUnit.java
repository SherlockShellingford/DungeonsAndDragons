import javafx.util.Pair;

public abstract class GameUnit {
    protected String name;
    protected UIDataContext observer;
    protected int health;
    protected int currentHealth;
    protected int attack;
    protected int defense;
    protected Pair<Integer,Integer> position;
    protected Pair<Integer,Integer> Formerposition;

    public String getName() {
        return name;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setPosition(Pair<Integer, Integer> position) {
        this.position = position;
    }

    public int getHealth() {
        return health;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public boolean combat(GameUnit enemy){
        observer.update(enemy.name+" engaged in battle with "+this.name+":");
        observer.AddCharacter(enemy);
        observer.AddCharacter(this);

        int atk=RandomNumber.getInstance().nextInt(enemy.attack);
        observer.update(enemy.name+" rolled "+atk+" attack points.");
        int def=RandomNumber.getInstance().nextInt(defense);
        observer.update(name+" rolled "+def+" defense points");
        int damage=atk-def;
        if(damage<0){
            damage=0;
        }
        observer.update(enemy.name+" hit "+this.name+" for "+damage+" damage.");
        currentHealth=currentHealth-damage;
        //observer.update(enemy.Name+" attacked "+this.Name+" ! Dealing "+damage+" damage!");
        if(currentHealth<=0){
            observer.update(this.name+" died.");
            return true;
        }
        return false;
    }

    public void returnToFormerLocation(){
        position=Formerposition;
    }


    protected double range(GameUnit other){
        int xdist=position.getValue()-other.position.getValue();
        int ydist=position.getKey()-other.position.getKey();
        return Math.sqrt(xdist*xdist+ydist*ydist);
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }
    public Pair<Integer,Integer> getFormerposition(){
        return Formerposition;
    }
}
