import javafx.util.Pair;

import java.text.Normalizer;

public class Trap extends Enemy {
    private int relocationRange;
    private int relocationTime;
    private int visibillityTime;
    private int numTicks;
    private char previousTile;
    private boolean combatMode;
    public Trap(int relocationRange, UIDataContext observer, int relocationTime, int visibillityTime, String Name, int health, int attack, int defense, Pair<Integer,Integer> position, int expirienceValue, char tile){
        this.name=Name;
        this.observer=observer;
        this.health=health;
        this.currentHealth=health;
        this.attack=attack;
        this.defense=defense;
        this.position=position;
        this.Formerposition=position;
        this.tile=tile;
        this.experienceValue=expirienceValue;
        this.relocationRange=relocationRange;
        this.relocationTime=relocationTime;
        this.visibillityTime=visibillityTime;
        numTicks=0;
        previousTile=tile;
        combatMode=false;
    }
    @Override
    public void returnToFormerLocation(){
        if(!combatMode) {
            this.position = Formerposition;
            numTicks = relocationTime - 1;
            tile = '.';
        }
        else{
            this.position = Formerposition;

        }


    }
    public void move(GameUnit player){
        if(combatMode){
            combatMode=false;
            return;
        }
        this.Formerposition=this.position;
        numTicks=numTicks+1;
        if(numTicks==visibillityTime){
            tile='.';
        }
        if(numTicks==relocationTime){

            int angle=RandomNumber.getInstance().nextInt(360);
            int r=RandomNumber.getInstance().nextInt(relocationRange+1);
            int x= (int) (r*(Math.cos(angle)));
            int y= (int) (r*(Math.sin(angle)));
            position=new Pair<Integer,Integer>(position.getKey()+y,position.getValue()+x);
            numTicks=0;
            tile=previousTile;

        }
        else{
            if(range(player)==1){
                position=player.position;
                combatMode=true;
            }
        }
    }



}
