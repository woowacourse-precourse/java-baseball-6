package baseball.game;

import java.util.List;
import java.util.Map;

import static baseball.game.GameCalculator.*;

public class GameService{

    static final NumberGenerator numberGenerator = new NumberGenerator();
    static final InputManager inputManager = new InputManager();

    static final GameCalculator gameCalculator = new GameCalculator();


    public void execute(){
        Map<Integer, Integer> answer = numberGenerator.randomNum();
        boolean next = false;
        while (true) {
            List<Integer> ballNumber = inputManager.getBallNumber();

            int ballCount = 0;
            int strikeCount = 0;

            Result result = gameCalculator.getResult(answer, ballNumber, ballCount, strikeCount);

            if (result.strikeCount() == 3) {
                show3Strike();
                next = inputManager.checkNext();
                break;

            } else {
                showDetails(result.ballCount(), result.strikeCount());
            }


        }
        if (next) {
            this.execute();
        }


    }

    private void show3Strike() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }



    private void showDetails(int ballCount, int strikeCount) {
        if (ballCount != 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");
        }


        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }

        System.out.println();
        
        
    }




}
