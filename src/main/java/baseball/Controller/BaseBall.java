package baseball.Controller;

import baseball.Model.CountModel;
import baseball.Model.NumberModel;
import baseball.View.InputView;
import baseball.View.OutputView;

import static baseball.Model.CountModel.isStrike3;
import static baseball.Model.RandomModel.getRandom3Number;
import static baseball.View.InputView.getRestartValue;
import static baseball.util.Counter.baseballCount;

public class BaseBall {
    public static final String RESTART_VALUE = "1";
    public static InputView inputView;
    public static OutputView outputView;
    public BaseBall() {
        try{
            run();
        }
        catch (IllegalArgumentException e){
            throw e;
        }
    }

    public static void run(){
        gameStart();
        do{
            play();
        } while (game.equals(RESTART_VALUE));
    }

    public static void play(){
        NumberModel computer = getRandom3Number(); // 서로 다른 3자리수 생성
        do {
            NumberModel inputNumber = inputView.getUserInput();
            CountModel countModel = baseballCount(inputNumber, computer);

            String output = countModel.countOutput();
            outputView.resultOutput(output);

        } while(!isStrike3());
        gameOver();
    }


    public static void gameOver(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        game = getRestartValue();
    }

    public static void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        game = RESTART_VALUE;
    }

    private static String game;
}



