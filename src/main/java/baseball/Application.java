package baseball;

import static baseball.Compare.CompareNumbers;
import static baseball.Restart.restartGame;


public class Application {
    // TODO: 프로그램 구현
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean restartFlag = true;
        while (restartFlag) {
            CompareNumbers();
            restartFlag = restartGame();
            }
        }
    }




