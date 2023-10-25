package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private RandomNum randomNumbers = new RandomNum(); // RandomNum 객체를 생성

    private ArrayList<Integer> randomNum = randomNumbers.getNum();
    private ArrayList<Integer> userNum = new ArrayList<>();
    boolean playing = true;


    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        play();
    }

    public void play() {
        while (playing) {
            guessNum();
            System.out.println(getResult());
        }
        endGame();
    }

    private void guessNum() {
        List<Integer> inputList = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = readLine();
        if (inputNum.length() != 3) {
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }

        String[] input = inputNum.split("");
        userNum.clear();
        for (String str: input) {
            int num = Integer.parseInt(str);
            if (!inputList.contains(num)) {
                userNum.add(num);
            } else {
                throw new IllegalArgumentException("같은 수가 포함되어 있습니다.");
            }
        }

        if (userNum.contains(0)) {
            throw new IllegalArgumentException("0이 포함되어 있습니다.");
        }

        if (!inputNum.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
        }

    }

    private String getResult() {
        String result = "";

        int ball = Result.getBall(randomNum, userNum);
        int strike = Result.getStrike(randomNum, userNum);

        if (ball != 0)
            result += ball + "볼 ";
        if (strike != 0)
            result += strike + "스트라이크";
        if (ball == 0 && strike == 0)
            result = "낫싱";
        if (strike == 3)
            playing = false;

        return result;
    }

    private void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        if ("1".equals(input)) {
            resetGame();
        } else if ("2".equals(input)) {
            playing = false;
        } else {
            throw new IllegalArgumentException("잘못된 값");
        }
    }

    private void resetGame() {
        userNum.clear();
        randomNum = new RandomNum().getNum();
        playing = true;
        play();
    }

}
