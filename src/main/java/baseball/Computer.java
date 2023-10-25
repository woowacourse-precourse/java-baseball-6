package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.CommandLine.*;
import static baseball.CommandLine.showln;

public class Computer {

    Computer() {}

    public static Computer create() {
        return new Computer();
    }

    public void runBaseballGame(){
        showln("숫자 야구 게임을 시작합니다.");
        run();
    }

    private void run() {
        List<Integer> computer = settingGame();
        if (endGame(computer)) {
            // 게임 재시작
            String in = inputln("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            validateRegameCommand(in);
            if (in.equals("1")) {
                run();
            }
        }
    }

    private static void validateRegameCommand(String in) {
        if (in.isBlank()) {
            throwIllegalArgumentException();
        }
        if (isNotOneOrTwo(in)) {
            throwIllegalArgumentException();
        }
    }

    private static boolean isNotOneOrTwo(String in) {
        return !in.equals("1")
                && !in.equals("2");
    }

    private static boolean endGame(List<Integer> computer) {
        String in = input("숫자를 입력해주세요: ");
        validateInputNumbers(in);
        Counter counter = Counter.of(
                in.split(""),
                computer
        );
        if (threeStrike(counter)) {
            return true;
        }
        return endGame(computer);
    }

    private static void validateInputNumbers(String in) {
        if (in.isBlank()) {
            throwIllegalArgumentException();
        }
        if (in.length() != 3) {
            throwIllegalArgumentException();
        }
    }

    private static void throwIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    private static boolean threeStrike(Counter counter) {
        if (counter.isNothing()) {
            showln("낫싱");
        }
        if (counter.matchAny()) {
            if (counter.isOnlyBall()) {
                showln(counter.getcountBall() + "볼");
            }
            if (counter.isOnlyStrike()) {
                showln(counter.getcountStrike() + "스트라이크");
            }
            if (counter.isBallAndStrike()) {
                showln(counter.getcountBall() + "볼 " + counter.getcountStrike() + "스트라이크");
            }
            return strikeCountIsThree(counter.getcountStrike());
        }
        return false;
    }

    private static boolean strikeCountIsThree(int countStrike) {
        if (countStrike == 3) {
            showln("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static List<Integer> settingGame() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        // 테스트를 위해 숫자 미리 보여주기
        // showln("answer for test : " + String.join("", computer.stream().map(String::valueOf).toList()));
        return computer;
    }
}
