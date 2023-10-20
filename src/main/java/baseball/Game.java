package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Player user;
    Player computer;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.user = new Player();
        this.computer = new Player();
        initComputerNumbers();
        while (true) {
            inputUser();
            System.out.println(printResult());
        }
    }

    public void inputUser() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputData = Console.readLine();
        String[] inputNumbers = inputData.split("");
        List<Integer> userNumbers = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            int tempNumber = Integer.parseInt(inputNumbers[i]); //
            userNumbers.add(tempNumber);
        }
        this.user.setPlayerNumbers(userNumbers);
    }

    public void initComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>(3);
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9); //
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        this.computer.setPlayerNumbers(computerNumbers);
    }

    public int countStrike() {
        int strikeCount = 0;
        List<Integer> computerNumbers = this.computer.getPlayerNumbers();
        List<Integer> userNumbers = this.user.getPlayerNumbers();
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i) == userNumbers.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall() {
        int ballCount = 0;
        List<Integer> computerNumbers = this.computer.getPlayerNumbers();
        List<Integer> userNumbers = this.user.getPlayerNumbers();
        for (int i = 0; i < 3; i++) {
            int currentNumber = userNumbers.get(i);
            if (computerNumbers.contains(currentNumber) && userNumbers.indexOf(currentNumber) != computerNumbers.indexOf(currentNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public boolean checkNothing() {
        if (countBall() == 0 && countStrike() == 0) {
            return true;
        }
        return false;
    }

    public String printResult() {
        String result = "";
        if (checkNothing()) {
            return "낫싱";
        }
        if (countBall() != 0) {
            result += countBall() + "볼";
        }
        if (countStrike() != 0) {
            result += countStrike() + "스트라이크";
        }
        return result;
    }

    public boolean checkEndGame() {
        if (countStrike() == 3) {
            return true;
        }
        return false;
    }

}
