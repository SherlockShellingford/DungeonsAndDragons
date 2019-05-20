import javafx.util.Pair;

public class Monster extends Enemy{
    private int visionRange;
    public Monster(String Name, int health, int currenthealth, int attack, int defense, Pair<Integer,Integer> position, int expirienceValue, char tile, int visionRange){
        this.name=Name;
        this.health=health;
        this.currentHealth=currenthealth;
        this.attack=attack;
        this.defense=defense;
        this.position=position;
        this.Formerposition=position;
        this.tile=tile;
        this.experienceValue=expirienceValue;
        this.visionRange=visionRange;
    }
    @Override
    public void move(GameUnit unit) {
        Formerposition=position;
        if(range(unit)<visionRange){
            int xdist=position.getValue()-unit.position.getValue();
            int ydist=position.getKey()-unit.position.getKey();
            if(Math.abs(ydist)<Math.abs(xdist)){
                position=new Pair<Integer, Integer>(Formerposition.getKey()+1, Formerposition.getValue());
            }
            else{
                position=new Pair<Integer, Integer>(Formerposition.getKey(), Formerposition.getValue()+1);
            }
        }
    }
}
