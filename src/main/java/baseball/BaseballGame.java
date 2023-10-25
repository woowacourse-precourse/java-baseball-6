package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballGame {

    private Integer strike;
    private Integer ball;
    private List<Integer> compNum;
    private List<Integer> userNum;

    public BaseballGame() {
        init();
    }

    public boolean gameOver() {
        if (strike != null && strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String response = Console.readLine();
            if (response.equals("1")) {
                init();
                return true;
            }
            if (response.equals("2")) {
                return false;
            }
            throw new IllegalArgumentException("잘 못 입력하셨습니다. 숫자 1 또는 2를 입력하세요.");
        }
        return true;
    }

    public void gameStart() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        this.userNum = createList(userInput);
        checkUserNum();
        checkAnswerNum();
        System.out.println(resultMessage());
    }

    public void checkUserNum() {
        if (userNum.size() != 3) {
            throw new IllegalArgumentException("잘 못 입력하셨습니다. 세자리 숫자를 입력해주세요.");
        }
        if (userNum.contains(0)) {
            throw new IllegalArgumentException("잘 못 입력하셨습니다. 1 에서 9 사이의 숫자를 입력해주세요.");
        }
        for (int i = 0; i < userNum.size(); i++) {
            if (Collections.frequency(userNum, userNum.get(i)) != 1) {
                throw new IllegalArgumentException("잘 못 입력하셨습니다. 서로 다른 숫자를 입력해야 합니다.");
            }
        }
    }

    public void checkAnswerNum() {
        this.strike = 0;
        this.ball = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if (compNum.indexOf(userNum.get(i)) == i) {
                strike++;
                continue;
            }
            if (compNum.contains(userNum.get(i))) {
                ball++;
            }
        }
    }

    public void init() {
        compNum = new ArrayList<>();
        for (int i = 0; i < 3; ) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!compNum.contains(num)) {
                compNum.add(num);
                i++;
            }
        }
    }

    public List<Integer> createList(String userInput) {
        String[] arrayInput = userInput.split("");
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            userNumbers.add(Integer.parseInt(arrayInput[i]));
        }
        return userNumbers;
    }

    public String resultMessage() {
        if (ball != 0 && strike != 0) {
            return (ball + "볼" + " " + strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            return (ball + "볼");
        }
        if (ball == 0 && strike != 0) {
            return (strike + "스트라이크");
        }
        return ("낫싱");
    }
}