import javafx.util.Pair;

public class Monster extends Enemy{
    private int visionRange;
    private boolean moved;
    public Monster(String Name, UIDataContext observer, int health, int attack, int defense, Pair<Integer,Integer> position, int expirienceValue, char tile, int visionRange){
        this.name=Name;
        this.health=health;
        this.currentHealth=health;
        this.attack=attack;
        this.defense=defense;
        this.position=position;
        this.Formerposition=position;
        this.tile=tile;
        this.experienceValue=expirienceValue;
        this.visionRange=visionRange;
        this.observer=observer;
        moved=false;
    }

    @Override
    public void returnToFormerLocation(){
        moved=true;
        position=Formerposition;
    }

    @Override
    public void move(GameUnit player) {
        if(moved){
            moved=false;
            return;
        }
        Formerposition=position;
        if(range(player)<visionRange){
            int xdist=position.getValue()-player.position.getValue();
            int ydist=position.getKey()-player.position.getKey();
            if(Math.abs(ydist)>Math.abs(xdist)){
                if(ydist>0){
                    position=new Pair<Integer, Integer>(Formerposition.getKey()-1, Formerposition.getValue());
                }
                else {
                    position = new Pair<Integer, Integer>(Formerposition.getKey() + 1, Formerposition.getValue());
                }
            }
            else{
                if(xdist>0){
                    position=new Pair<Integer, Integer>(Formerposition.getKey(), Formerposition.getValue()-1);
                }
                else {
                    position = new Pair<Integer, Integer>(Formerposition.getKey(), Formerposition.getValue() + 1);
                }
            }
        }
        else{
            int rand=RandomNumber.getInstance().nextInt(4);
            switch(rand){
                case 0:
                    position=new Pair<Integer, Integer>(Formerposition.getKey()-1, Formerposition.getValue());
                    break;
                case 1:
                    position=new Pair<Integer, Integer>(Formerposition.getKey()+1, Formerposition.getValue());
                    break;
                case 2:
                    position=new Pair<Integer, Integer>(Formerposition.getKey(), Formerposition.getValue()+1);
                    break;
                case 3:
                    position=new Pair<Integer, Integer>(Formerposition.getKey(), Formerposition.getValue()-1);
                    break;
                default:


            }
        }
    }
}
