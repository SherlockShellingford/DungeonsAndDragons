import javafx.util.Pair;

import java.text.Normalizer;

public class Trap extends Enemy {
    private int relocationRange;
    private int relocationTime;
    private int visibillityTime;
    private int numTicks;
    private char previousTile;
    public Trap(int relocationRange, int relocationTime, int visibillityTime, String Name, int health, int currenthealth, int attack, int defense, Pair<Integer,Integer> position, int expirienceValue, char tile, int visionRange){
        this.name=Name;
        this.health=health;
        this.currentHealth=currenthealth;
        this.attack=attack;
        this.defense=defense;
        this.position=position;
        this.Formerposition=position;
        this.tile=tile;
        this.experienceValue=relocationRange;
        this.relocationRange=relocationTime;
        this.visibillityTime=visibillityTime;
        numTicks=0;
        previousTile=tile;
    }
    @Override
    public void returnToFormerLocation(){
        this.position= Formerposition;
        numTicks=relocationTime-1;
        tile='.';


    }
    public void move(GameUnit player){
        this.Formerposition=this.position;
        numTicks=numTicks+1;
        if(numTicks==visibillityTime){
            tile='.';
        }
        if(numTicks==relocationTime){

            int angle=RandomNumber.getInstance().nextInt(360);
            int r=RandomNumber.getInstance().nextInt(relocationRange);
            int x= r*((int)Math.cos(angle));
            int y= r*((int)Math.sin(angle));
            position=new Pair<Integer,Integer>(position.getKey()+y,position.getValue()+x);

        }
    }


}
