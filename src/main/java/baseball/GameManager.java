package baseball;

import baseball.number.GameNumber;

import java.io.BufferedReader;

public class GameManager {

    public GameManager(BufferedReader receiver) {

    }

    public void run() {
        // 게임 시작

        // 반복문
        // 게임 숫자 생성
        // playBall()
        // 재시작 숫자 요청

    }

    private void playBall(GameNumber gameNumber) {
        // 반복문
        // 입력 요청
        // checkUserNumber();
            // true -> 게임 끝
            // false -> 계속 진행
    }

    private boolean checkUserNumber(GameNumber gameNumber, GameNumber userNumber) {
        // userNumber 유효성 체크
         calculateBallCount(gameNumber, userNumber);
        return true;
    }

    private boolean calculateBallCount(GameNumber gameNumber, GameNumber userNumber) {
        Integer strikeCount;
        Integer ballCount;
        // 로직
        // GamePrinter로 출력
        return true;
    }
}
