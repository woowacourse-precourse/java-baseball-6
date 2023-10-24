package baseball.Controller;

import baseball.Common.Messages;
import baseball.GameService;
import baseball.View.GameView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {
    private static final GameController instance = new GameController();
    private GameService service = GameService.getInstance();
    public static GameController getInstance(){
        return instance;
    }

    public void run(){
        System.out.println(Messages.START_GAME);

        int mode = 1;

        while(mode == 1) {
            GameService baseball = new GameService();
            try {
                play();
                mode = inputMode();
            }catch (IllegalArgumentException e){
                break;
            }
        }
    }

    private void play() throws IllegalArgumentException{
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0));

        service.initGame();
        while(result.get(0) != 3) {
            service.inputNumber();
            result = service.referee();
            GameView.printResult(result);
        }
    }

    private static int inputMode(){
        System.out.println(Messages.SELECT_MODE);
        return Integer.parseInt(Console.readLine());
    }
}
