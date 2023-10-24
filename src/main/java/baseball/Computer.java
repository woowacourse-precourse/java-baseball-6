package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer implements ComputerServer{
    private List<Integer> answers = new ArrayList<>();

    @Override
    public void startGame() {
        while (answers.size() < 3) {
            answers.add(Randoms.pickNumberInRange(1, 9));
        }
    }

    @Override
    public boolean endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String keepGoing = Console.readLine();
        if (keepGoing.equals("1")) {
            answers.clear();
            startGame();
            return true;
        }
        return false;
    }

    @Override
    public boolean hint(List<Integer> numbers) {
        String hintMessage = "";
        int notThing = 0;
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (numbers.get(i).equals(answers.get(i))) {
                strike++;
                continue;
            } else if (answers.contains(numbers.get(i))) {
                ball++;
                continue;
            }
            notThing++;
        }
        if (notThing == 3) {
            hintMessage += "낫싱";
        }
        if (ball > 0) {
            hintMessage += (ball + "볼");
        }
        if (strike > 0) {
            if (!hintMessage.isEmpty()) {
                hintMessage += " ";
            }
            hintMessage += (strike + "스트라이크");
        }
        System.out.println(hintMessage);
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
