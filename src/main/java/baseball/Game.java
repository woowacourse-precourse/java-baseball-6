package baseball;
import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static Game game;

    private Game(){
    }

    public static Game getInstance() {
        if (game == null)
            game = new Game();
        return game;
    }


    public void run() {
        start();
        ask();
    }

    private void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        play();
    }

    // 재시작을 물음
    private void ask() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        if (input.equals("1")) {
            play();
        }
        else if (input.equals("2")) {

        }
        else {
            throw new IllegalArgumentException();
        }
    }

    // 계산
    private void play() {
        int strikeBall = 0;
        List<Integer> answerList = createRandom();
        while (strikeBall != 30) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();
            List<Integer> inputToInt = verifyInput(input);
            if (inputToInt == null) {
                throw new IllegalArgumentException();
            }

            strikeBall = calc(inputToInt, answerList);
            int ball = strikeBall % 10;
            int strike = strikeBall / 10;

            if (ball != 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike != 0) {
                System.out.print(strike + "스트라이크");
            }
            if (ball == 0 && strike == 0) {
                System.out.print("낫싱");
            }
            System.out.println("");
        }
    }

    private List<Integer> createRandom() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    // 검증
    private List<Integer> verifyInput(String input) {
        if (input.matches("[1-9]{3}")) {
            List<Integer> result = new ArrayList<>();
            char[] chars = input.toCharArray();
            if (chars[0] != chars[1] && chars[1] != chars[2] && chars[0] != chars[2]) {
                for (char c : chars) {
                    result.add(Character.getNumericValue(c));
                }
                return result;
            }
        }
        return null;
    }

    private int calc(List<Integer> input, List<Integer> answerList) {
        int returnValue = 0;
        for (int i=0; i<3; i++) {
            int idx = answerList.indexOf(input.get(i));
            if (idx == i)
                returnValue += 10;
            else if (idx == -1) {

            }
            else {
                returnValue += 1;
            }
        }
        return returnValue;
    }
}
