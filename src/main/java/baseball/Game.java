package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;


public class Game {
    final private List<Integer> computer;
    final private List<Integer> user;

    public Game() {
        computer = new ArrayList<>();
        user = new ArrayList<>();
    }

    private void createComputerNumber() {
        int randomNumber;
        computer.clear();

        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private boolean isNumber(char number) {
        if (number >= '1' && number <= '9') {
            return true;
        }

        return false;
    }

    public void checkBaseballNumber(String baseballNumber) {
        if (baseballNumber.length() == 3
                && isNumber(baseballNumber.charAt(0))
                && isNumber(baseballNumber.charAt(1))
                && isNumber(baseballNumber.charAt(2))) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private void inputUserNumber() {
        String input = readLine();
        checkBaseballNumber(input);

        String[] userNumber = input.split("");
        user.clear();

        for (int index = 0; index < 3; index++) {
            user.add(Integer.parseInt(userNumber[index]));
        }
    }

    private boolean isRetry() {
        String userInput = readLine();

        if (userInput.equals("1")) {
            return true;
        } else if (userInput.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public void play() {
        Script script = new Script();
        Judgment judgment = new Judgment();

        createComputerNumber();    //컴퓨터 난수 생성
        script.startGame();

        while (true) {
            script.inputNumber();  //유저 - 숫자입력
            inputUserNumber();

            judgment.judge(computer, user);      //숫자 야구 판정

            if (judgment.isUserWin()) {
                script.endGame();

                if (isRetry()) {               //정답을 맞힌 후 게임 종료 여부를 입력 받음
                    createComputerNumber();
                } else {
                    break;
                }
            }
        }
    }
}
