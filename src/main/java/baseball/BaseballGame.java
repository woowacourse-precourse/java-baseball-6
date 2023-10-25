package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;

public class BaseballGame {
    public String pickCpuNumber() {
        ArrayList<Integer> computer = new ArrayList<>();
        int result = 0;
        while (computer.size() < InputValidation.CORRECT_INPUT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                result = result * 10 + randomNumber;
            }
        }
        return Integer.toString(result);
    }

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public boolean executeBaseballGame(String user, String cpu) {
        if (user.equals(cpu)) {
            System.out.printf("%d스트라이크\n", InputValidation.CORRECT_INPUT_SIZE);
            return true;
        }

        int ballCount, strikeCount = 0;
        HashSet<Character> checkDuplicate = new HashSet<>();
        for (int i = 0; i < InputValidation.CORRECT_INPUT_SIZE; ++i) {
            if (user.charAt(i) == cpu.charAt(i)) {
                strikeCount++;
            }
            checkDuplicate.add(user.charAt(i));
            checkDuplicate.add(cpu.charAt(i));
        }
        ballCount = user.length() + cpu.length() - checkDuplicate.size() - strikeCount;
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (ballCount != 0) {
            System.out.printf("%d볼 ", ballCount);
        }
        if (strikeCount != 0) {
            System.out.printf("%d스트라이크", strikeCount);
        }
        System.out.println();
        return false;
    }

    public void gameMain() {
        String cpuNumber = this.pickCpuNumber();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = InputValidation.validateUserInput();
            if (this.executeBaseballGame(userInput, cpuNumber)) {
                break;
            }
        }
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", InputValidation.CORRECT_INPUT_SIZE);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
