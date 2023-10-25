package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame game = new BaseballGame();
        game.play();
    }
}

class BaseballGame {
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> user = new ArrayList<>();
    private boolean isPlaying = true;
    void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        makeComNum();
        while (isPlaying) {
            getUserNum();
            printResult(countStrike(), countBall());
        }
    }
    private void makeComNum() {
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    private void getUserNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine().replaceAll(" ", "");
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        user.clear();
        for (int i=0; i<3; i++) {
            int userNumber = Character.getNumericValue(userInput.charAt(i));
            if (user.contains(userNumber)) {
                throw new IllegalArgumentException();
            }
            user.add(userNumber);
        }
    }
    private int countStrike() {
        int strike = 0;
        for (int i=0; i<3; i++) {
            if (user.get(i) == computer.get(i)) {
                strike++;
            }
        }
        return strike;
    }
    private int countBall() {
        int ball = 0;
        for (int computerNum : computer) {
            if (user.contains(computerNum)) {
                ball++;
            }
        }
        return ball;
    }
    private void printResult(int strike, int ball) {
        if (ball == 0) {
            System.out.println("낫싱");
            return;
        }

        String result = "";
        ball -= strike;

        if (ball > 0) {
            result += (ball + "볼 ");
        }
        if (strike > 0 ){
            result += (strike + "스트라이크");
        }
        System.out.println(result);

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            checkRestart();
        }
    }
    private void checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userAns = Console.readLine().replaceAll(" ", "");
        try {
            Integer.parseInt(userAns);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        if (userAns.length() != 1) {
            throw new IllegalArgumentException();
        }
        
        if (userAns.equals("2")) {
            isPlaying = false;
        } else {
            makeComNum();
        }
    }
}