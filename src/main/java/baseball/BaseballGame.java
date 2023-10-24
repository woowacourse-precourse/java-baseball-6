package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {

    InputNumbers inputNumbers;
    int strike;
    int ball;
    List<Integer> computer;

    public void readInputNumbers() {
        this.inputNumbers = new InputNumbers(readLine());
    }


    public void start() {
        createComputerNumbers();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            readInputNumbers();
            compareNumbers();

            if (ball < 1 && strike < 1) {
                System.out.println("낫싱");
                continue;
            }
            if (ball > 0 && strike < 1) {
                System.out.println(ball + "볼");
                continue;
            }
            if (ball < 1 && strike > 0) {
                System.out.println(strike + "스트라이크");
                if (strike == 3) {
                    System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
                    System.out.println("게임 종료");
                    if (end() == 2) {
                        break;
                    }
                }
                continue;
            }
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public int end() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String end = readLine();
        validateEndNum(end);
        if(end == "1"){
            return 1;
        }
        return 2;
    }

    public void compareNumbers() {
        ball = 0;
        strike = 0;

        ballCount();
        strikeCount();
    }

    public void ballCount() {
        for (Integer computerNum : computer) {
            ball += inputNumbers.compareBallCount(computerNum);
        }

    }

    public void strikeCount() {
        for (int i = 0; i < 3; i++) {
            strike += inputNumbers.compareStrikeCount(computer, i);
            ball -= inputNumbers.compareStrikeCount(computer, i);
        }
    }

    public void createComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addComputer(computer, randomNumber);
        }
        this.computer = computer;
    }

    public void addComputer(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    public void validateEndNum(String num){
        if(num != "1" || num !="2"){
            throw new IllegalArgumentException("1혹은 2만 입력 가능합니다.");
        }
    }

}
