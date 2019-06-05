
import javafx.util.Pair;
import org.junit.Test;



import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class Tests {

    @Test
    public void TestNonLethalCombat() {
        UIDataContext DT=new UIDataContext();
        int[] arr={6,3,200,0,10,200,0};
        RandomNumber.setRandom(arr);
        Warrior tester = new Warrior("a",DT,200,15,4,5,new Pair<Integer,Integer>(1,1)); // MyClass is tested
        Warrior tester2 = new Warrior("a",DT,200,15,4,5,new Pair<Integer,Integer>(1,1)); // MyClass is tested
        tester.combat(tester2);

        assertEquals(197, tester.getCurrentHealth());


    }
    @Test
    public void TestPlayerMoveUp() {
        UIDataContext DT=new UIDataContext();
        int[] arr={6,3,200,0,10,200,0};
        RandomNumber.setRandom(arr);
        Warrior tester = new Warrior("a",DT,200,15,4,5,new Pair<Integer,Integer>(1,1)); // MyClass is tested

        tester.move("w");
        assertEquals(new Pair<Integer,Integer>(0,1), tester.getPosition());


    }

    @Test
    public void TestPlayerMoveDown() {
        UIDataContext DT=new UIDataContext();
        int[] arr={6,3,200,0,10,200,0};
        RandomNumber.setRandom(arr);
        Warrior tester = new Warrior("a",DT,200,15,4,5,new Pair<Integer,Integer>(1,1)); // MyClass is tested

        tester.move("s");
        assertEquals(new Pair<Integer,Integer>(2,1), tester.getPosition());


    }

    @Test
    public void TestPlayerMoveLeft() {
        UIDataContext DT=new UIDataContext();
        int[] arr={6,3,200,0,10,200,0};
        RandomNumber.setRandom(arr);
        Warrior tester = new Warrior("a",DT,200,15,4,5,new Pair<Integer,Integer>(1,1)); // MyClass is tested

        tester.move("a");
        assertEquals(new Pair<Integer,Integer>(1,0), tester.getPosition());


    }

    @Test
    public void TestPlayerRight() {
        UIDataContext DT=new UIDataContext();
        int[] arr={6,3,200,0,10,200,0};
        RandomNumber.setRandom(arr);
        Warrior tester = new Warrior("a",DT,200,15,4,5,new Pair<Integer,Integer>(1,1)); // MyClass is tested

        tester.move("d");
        assertEquals(new Pair<Integer,Integer>(1,2), tester.getPosition());


    }
    @Test
    public void KillInCombat() {
        UIDataContext DT = new UIDataContext();
        int[] arr = {200, 0};
        RandomNumber.setRandom(arr);
        Warrior tester = new Warrior("a",DT,200,15,4,5,new Pair<Integer,Integer>(1,1)); // MyClass is tested 
        Warrior tester2 = new Warrior("a",DT,200,15,4,5,new Pair<Integer,Integer>(1,1));

        assertEquals(true,tester.combat(tester2));
    }
    @Test
    public void TestMonsterMoveTowardsPlayer() {
        UIDataContext DT=new UIDataContext();
        int[] arr={3};
        RandomNumber.setRandom(arr);
        Monster tester = new Monster("a",DT,200,15,4,new Pair<Integer,Integer>(1,1),1,'c',2); // MyClass is tested
        Warrior tester2 = new Warrior("a",DT,200,15,4,5,new Pair<Integer,Integer>(1,2));

        tester.move(tester2);
        assertEquals(new Pair<Integer,Integer>(1,2), tester.getPosition());


    }
    @Test
    public void TestMonsterMoveAlone() {
        UIDataContext DT=new UIDataContext();
        int[] arr={3};
        RandomNumber.setRandom(arr);
        Monster tester = new Monster("a",DT,200,15,4,new Pair<Integer,Integer>(1,1),1,'c',1); // MyClass is tested
        Warrior tester2 = new Warrior("a",DT,200,15,4,5,new Pair<Integer,Integer>(1,100));

        tester.move(tester2);
        assertEquals(new Pair<Integer,Integer>(1,0), tester.getPosition());


    }
    @Test
    public void NormalWarriorAbillity(){
        UIDataContext DT = new UIDataContext();
        int[] arr = {10};
        RandomNumber.setRandom(arr);
        Warrior tester = new Warrior("a",DT,200,15,4,5,new Pair<Integer,Integer>(1,1)); // MyClass is tested
        tester.setCurrentHealth(50);
        tester.ability(null);
        assertEquals(58,tester.getCurrentHealth());
    }
    @Test
    public void OverhealWarriorAbillity(){
        UIDataContext DT = new UIDataContext();
        int[] arr = {4000};
        RandomNumber.setRandom(arr);
        Warrior tester = new Warrior("a",DT,200,15,200,5,new Pair<Integer,Integer>(1,1)); // MyClass is tested
        tester.setCurrentHealth(50);
        tester.ability(null);
        assertEquals(200,tester.getCurrentHealth());
    }
    @Test
    public void NormalMageAbillity() {
        UIDataContext DT = new UIDataContext();
        int[] arr = {0,0};
        RandomNumber.setRandom(arr);

        Mage testMage=new Mage("a",DT,200,15,4,new Pair<Integer,Integer>(1,1),10,200,10,1,4);
        Monster target1 = new Monster("a",DT,200,15,4,new Pair<Integer,Integer>(1,2),1,'c',4);
        List<Enemy> targetlst=new LinkedList<>();
        targetlst.add(target1);
        testMage.ability(targetlst);
        assertEquals(190,target1.getCurrentHealth());
    }

    @Test
    public void NumOfHitsMageAbillity() {
        UIDataContext DT = new UIDataContext();
        int[] arr = {0,0};
        RandomNumber.setRandom(arr);

        Mage testMage=new Mage("a",DT,200,15,4,new Pair<Integer,Integer>(1,1),10,200,10,1,4);
        Monster target1 = new Monster("a",DT,200,15,4,new Pair<Integer,Integer>(1,2),1,'c',4);
        Monster target2 = new Monster("a",DT,200,15,4,new Pair<Integer,Integer>(1,2),1,'c',4);
        List<Enemy> targetlst=new LinkedList<>();
        targetlst.add(target1);
        targetlst.add(target2);
        testMage.ability(targetlst);
        assertEquals(200,target2.getCurrentHealth());
    }
    @Test
    public void OutOfRangeMageAbillity() {
        UIDataContext DT = new UIDataContext();
        int[] arr = {0,0};RandomNumber.setRandom(arr);

        Mage testMage=new Mage("a",DT,200,15,4,new Pair<Integer,Integer>(1,1),10,200,10,1,4);
        Monster target1 = new Monster("a",DT,200,15,4,new Pair<Integer,Integer>(1,200),1,'c',4);
        List<Enemy> targetlst=new LinkedList<>();
        targetlst.add(target1);
        testMage.ability(targetlst);
        assertEquals(200,target1.getCurrentHealth());
    }
    @Test
    public void OutOfManaMageAbillity() {
        UIDataContext DT = new UIDataContext();
        int[] arr = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        RandomNumber.setRandom(arr);

        Mage testMage=new Mage("a",DT,200,15,4,new Pair<Integer,Integer>(1,1),10,200,50,1,4);
        Monster target1 = new Monster("a",DT,200,15,4,new Pair<Integer,Integer>(1,2),1,'c',4);
        List<Enemy> targetlst=new LinkedList<>();
        targetlst.add(target1);
        for(int i=0;i<5;++i){
            testMage.ability(targetlst);
        }
        assertEquals(160,target1.getCurrentHealth());
    }
    @Test
    public void RogueNormalAbillity() {
        UIDataContext DT = new UIDataContext();
        int[] arr = {10, 10};
        RandomNumber.setRandom(arr);

        Rogue testRogue=new Rogue("a",DT,200,15,4,new Pair<Integer,Integer>(1,1),10);
        Monster target1 = new Monster("a",DT,200,15,4,new Pair<Integer,Integer>(1,2),1,'c',4);
        Monster target2 = new Monster("a",DT,200,15,4,new Pair<Integer,Integer>(1,2),1,'c',4);
        List<Enemy> targetlst=new LinkedList<>();
        targetlst.add(target1);
        targetlst.add(target2);
        testRogue.ability(targetlst);

        assertEquals(195,target1.getCurrentHealth());
        assertEquals(195,target2.getCurrentHealth());
    }
    @Test
    public void RogueOutOfRangeAbillity() {
        UIDataContext DT = new UIDataContext();
        int[] arr = {10, 10};
        RandomNumber.setRandom(arr);

        Rogue testRogue=new Rogue("a",DT,200,15,4,new Pair<Integer,Integer>(1,1),10);
        Monster target1 = new Monster("a",DT,200,15,4,new Pair<Integer,Integer>(1,3),1,'c',4);
        Monster target2 = new Monster("a",DT,200,15,4,new Pair<Integer,Integer>(1,2),1,'c',4);
        List<Enemy> targetlst=new LinkedList<>();
        targetlst.add(target1);
        targetlst.add(target2);
        testRogue.ability(targetlst);

        assertEquals(200,target1.getCurrentHealth());

    }

    @Test
    public void RogueOutOfEnergyAbillity() {
        UIDataContext DT = new UIDataContext();
        int[] arr = {10, 10,10};
        RandomNumber.setRandom(arr);

        Rogue testRogue=new Rogue("a",DT,200,20,4,new Pair<Integer,Integer>(1,1),50);
        Monster target1 = new Monster("a",DT,200,15,4,new Pair<Integer,Integer>(1,2),1,'c',4);
        List<Enemy> targetlst=new LinkedList<>();
        targetlst.add(target1);

        testRogue.ability(targetlst);
        for(int i=0;i<3;++i){
            testRogue.ability(targetlst);
        }
        assertEquals(180,target1.getCurrentHealth());

    }




}