package baseball;

import baseball.game.BaseballGame;
import baseball.game.NumBaseball;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new NumBaseball();

        boolean game = true;
        while (game) {
            //컴퓨터 숫자 생성
            ArrayList<Integer> computer = baseballGame.comNum();
            ArrayList<Integer> user;

            boolean round = true;

            System.out.println("숫자 야구 게임을 시작합니다.");
            while (round) {
                System.out.print("숫자를 입력하세요: ");
                //사용자로부터 입력받기 & 입력값 검증
                user = baseballGame.userInput();

                //숫자 비교 & 결과 출력
                int[] gameResult = baseballGame.result(computer, user);

                baseballGame.printResult(gameResult);

                if(gameResult[1] == 3) { // 게임 종료(3 스트라이크) 시
                    round = false;
                }
                user.clear();
            }

            if (!round) {
                int answer = baseballGame.userAnswer();
                if (answer == 2) {
                    game = false;
                }
            }

        }
    }


}
