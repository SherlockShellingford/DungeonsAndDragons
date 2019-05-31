import javafx.util.Pair;

public class EnemyFactory {
    public static Enemy create(char c, UIDataContext DT, Pair<Integer,Integer> pos){
        if(c=='s'){
            return new Monster("Lanister Soldier",DT,80,8,3,pos,25,'s',3);
        }
        if(c=='k'){
            return new Monster("Lanister Knight",DT,200,14,8,pos,50,'k',4);
        }
        if(c=='q'){
            return new Monster("Queen's Guard",DT,600,20,15,pos,100,'q',5);
        }
        if(c=='z'){
            return new Monster("Wright",DT,600,30,15,pos,100,'z',3);
        }
        if(c=='b'){
            return new Monster("Bear-Wright",DT,1000,75,30,pos,250,'b',4);
        }
        if(c=='g'){
            return new Monster("Lanister Soldier",DT,80,8,3,pos,25,'g',500);
        }
        if(c=='w'){
            return new Monster("White Walker",DT,2000,150,50,pos,1000,'w',6);
        }
        if(c=='M'){
            return new Monster("The Mountain",DT,1000,60,25,pos,1000,'M',6);
        }
        if(c=='C'){
            return new Monster("Queen Cersei",DT,100,10,10,pos,1000,'C',1);
        }
        if(c=='K'){
            return new Monster("NightKing",DT,5000,300,150,pos,5000,'s',8);
        }
        if(c=='B'){
            return new Trap(6,DT,5,2,"Bonus Trap" ,1,1,1,pos,250, 'B');
        }
        if(c=='Q'){
            return new Trap(10,DT,4,4,"Queen's Trap" ,250,50,10,pos,100, 'Q');
        }
        if(c=='D'){
            return new Trap(10,DT,6,3,"Death Trap" ,500,100,20,pos,250, 'D');
        }
        return null;

    }

}
