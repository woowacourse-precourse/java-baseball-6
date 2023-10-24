package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameStarter {

    List<Integer> computer = new ArrayList<>();
    boolean isGameOver = false;
    public GameStarter() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    void startGame() throws IllegalArgumentException{
        while (!isGameOver) {
            startRound();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    void startRound() throws IllegalArgumentException{
        System.out.print("숫자를 입력해주세요 : ");
        String person = Console.readLine();
        checkInputValidity(person);
        compareNum(person);
    }

    void compareNum(String person) {
        int ball = 0;
        int strike = 0;

        for (int index = 0; index < 3; index++) {
            int num = person.charAt(index) - '0';
            ball += isBall(num, index);
            strike += isStrike(num, index);
        }
        printResult(ball, strike);
        if (strike == 3) isGameOver = true;
    }

    int isBall(int num, int index) {
        if ((computer.contains(num)) && (num != computer.get(index))) {
            return 1;
        }
        return 0;
    }

    int isStrike(int num, int index) {
        if (num == computer.get(index)) {
            return 1;
        }
        return 0;
    }

    void printResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }
        if (strike == 0) {
            System.out.printf("%d볼\n", ball);
            return;
        }

        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    }

    void checkInputValidity(String person) {
        if (person.length() != 3) {
            throw new IllegalArgumentException();
        }

        char first = person.charAt(0);
        char second = person.charAt(1);
        char third = person.charAt(2);

        if ((first == second) || (second == third) || (first == third)) {
            throw new IllegalArgumentException();
        }
    }
}
