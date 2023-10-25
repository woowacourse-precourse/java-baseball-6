package baseball.view;

import baseball.domain.GameResult;

import java.util.List;

public class ResultView {

    public static void printResult(GameResult gameResult){

        if(gameResult.getBall() != 0)
            System.out.print(gameResult.getBall() + "볼 ");
        if(gameResult.getStrike() != 0)
            System.out.print(gameResult.getStrike() + "스트라이크 ");

        if(gameResult.getBall() == 0 && gameResult.getStrike() == 0)
            System.out.print("낫싱");
        System.out.println();

        if(gameResult.getSuccess() == true)
            System.out.println(gameResult.getStrike() + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
    }

}
