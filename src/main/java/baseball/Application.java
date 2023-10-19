package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

class Game {
    List<Integer> answer = new ArrayList<>();
    Game() {
        answer = makeRandomNumber();
    }

    public static void set() {
        Game game;
        do {
            game = new Game();
            game.start();
        } while(game.restart());
    }

    public void start() {
        guessNumber();
    }

    public List<Integer> makeRandomNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        return number;
    }

    public void guessNumber() {
        String inputNumber;
        do {
            inputNumber = Console.readLine();
            // 에러 처리 필요
        } while(checkInputNumber(inputNumber));
    }

    public static boolean checkInputNumber(String inputNumber) {

        return false;
    }

    public void endGame() {

    }

    public boolean restart() {
        return false;
    }
    // 예외. 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 종료한다.
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.set();
    }
}
