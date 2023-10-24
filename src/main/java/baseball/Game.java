package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;


public class Game {
    ComNumber comNumber[];
    UserNumber userNumber[];

    int countStrike = 0;
    int countBall = 0;

    int replay;
    const RESTART = 1;
    const END = 2;

    public startGame() {
        // 정답인 3가지 숫자 만들기
        comNumber.makeComNumber();

        // 게임 시작
        while (countStrike < 3) {
            // 새로운 회차를 위해 0으로 초기화
            countStrike = 0;
            countBall = 0;

            // 사용자에게 3가지 숫자 입력받기
            System.out.print("숫자를 입력해주세요 : ");
            userNumber.inputUserNumber();

            compareNumber();
        }

        // 정답이면 재시작할지 종료할지 정함
        if (countStrike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

    }
    

    public compareNumber() {
        // 두 배열의 숫자들을 비교
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && comNumber[i] == userNumber[j])
                    countStrike++;
                else if (comNumber[i] == userNumber[j])
                    countBall++;
            }
        }

        // 스트라이크, 볼, 낫싱 여부 출력
        if (countStrike != 0 && countBall == 0) {
            System.out.println(countStrike + "스트라이크");
        }
        else if (countStrike == 0 && countBall != 0) {
            System.out.println(countBall + "볼");
        }
        else if (countStrike != 0 && countBall != 0) {
            System.out.println(countBall + "볼 " + countStrike + "스트라이크");
        }
        else {
            System.out.println("낫싱");
        }
    }

    // 재식
    public decideReplay() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        
        int answer = Console.readLine();
    
        if (answer == RESTART) {
            startGame();
        }
    
        else if (answer == END) {
            return;
        }
        //예외 : 1, 2가 아닌 다른 수일 경우
        try {
            if (answer != 1 || answer != 2) {
                throw new IllegalArgumentException("1 또는 2 중에 입력해주세요.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

