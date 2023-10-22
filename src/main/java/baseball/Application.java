package baseball;

import baseball.game.BaseballGame;
import baseball.game.NumBaseball;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new NumBaseball();
        int[] gameResult;
        boolean game = true;

        while (game) {
            //컴퓨터 숫자 생성
            baseballGame.comNum();

            boolean round = true;

            System.out.println("숫자 야구 게임을 시작합니다.");
            while (round) {
                System.out.print("숫자를 입력하세요: ");
                //사용자로부터 입력받기 & 입력값 검증
                baseballGame.userInput();

                //숫자 비교 & 결과 출력
                gameResult = baseballGame.result();

                baseballGame.printResult(gameResult);

                if(baseballGame.getStrike() == 3) { // 게임 종료(3 스트라이크) 시
                    round = false;
                }
                baseballGame.gameInit(round);
            }

            if (!round) {
                int answer = baseballGame.userAnswer();
                if (answer == 2) {
                    game = false;
                }
                else {
                    baseballGame.gameInit(round);
                }
            }

        }
    }


}
