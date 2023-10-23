package baseball;
/*
    클래스 명 : Application
    설명      : 프로그램 시작
    작성자	  : 김준태
	날짜	  : 2023. 10. 23.
 */
import camp.nextstep.edu.missionutils.Console;

public class Application {
    // TODO: 프로그램 구현
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        Compare compare = new Compare();
        Restart restart = new Restart();
        boolean restartFlag = true;
        // 사용자가 게임종료를 선택할 때까지 반복
        while (restartFlag) {
            compare.CompareNumbers();
            restartFlag = restart.restartGame();
        }
        Console.close();
    }
}

