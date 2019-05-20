import javafx.util.Pair;

public abstract class GameUnit {
    protected String name;
    //private UIDataContext observer;
    protected int health;
    protected int currentHealth;
    protected int attack;
    protected int defense;
    protected Pair<Integer,Integer> position;
    protected Pair<Integer,Integer> Formerposition;

    public boolean combat(GameUnit enemy, GameRandom rand){
        int atk=RandomNumber.getInstance().nextInt(enemy.attack);
        int def=RandomNumber.getInstance().nextInt(defense);
        int damage=atk-def;
        currentHealth=currentHealth-damage;
        //observer.update(enemy.Name+" attacked "+this.Name+" ! Dealing "+damage+" damage!");
        if(currentHealth<=0){
        //    observer.update(this.Name+" died!");
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



}
