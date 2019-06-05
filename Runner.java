import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner {

    public static void main(String[] args){
        Result result=JUnitCore.runClasses(Tests.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        MemoryManager.setPath(args[0]);
        RandomNumber.setRandom('n');
        UI ui=new UI();
        if (args.length == 2){
            ui.startGame(args[1]);
            return;
        }
        ui.startGame("ND");
        while(true) {
            ui.cycle();
        }
    }
}
