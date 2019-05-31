
import org.junit.platform.*;
public class Runner {

    public static void main(String[] args){
        JUnitCore.runClasses(MyClassTest.class);
        for (Authenticator.Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        RandomNumber.setRandom('n');
        UI ui=new UI();
        ui.startGame();
        while(true) {
            ui.cycle();
        }
    }
}
