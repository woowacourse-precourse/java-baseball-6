package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> setCPU() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void play(List<Integer> target, String input) {
        List<Integer> reTarget = target;
        int strike = 0;
        int ball = 0;
        String message = "";
        char targetArr[] = {
                String.valueOf(target.get(0)).charAt(0),
                String.valueOf(target.get(1)).charAt(0),
                String.valueOf(target.get(2)).charAt(0)
        };
        char inputArr[] = {input.charAt(0), input.charAt(1), input.charAt(2)};
        for (int i = 0; i <= 2; i++) {
            if (inputArr[i] == targetArr[i]) {
                strike++;
                inputArr[i] = 'A';
                targetArr[i] = 'B';
            }
        }
        if (strike == 3) {
            System.out.println(
                    strike + "스트라이크\n"
                            + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String userDecide = readLine();
            if (userDecide.equals("1")) {
                List<Integer> cpuNewInput = setCPU();
                System.out.println("컴퓨터 숫자:" + cpuNewInput);
                System.out.print("숫자를 입력해주세요 : ");
                String userNewInput = readLine();
                play(cpuNewInput, userNewInput);
            } else if (userDecide.equals("2")) {

            }
        } else {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (targetArr[i] == inputArr[j]) {
                        if (i == j) {
                        } else {
                            ++ball;
                        }
                    }
                }
            }
            if (strike == 0 && ball == 0) {
                message = "낫싱";
            } else {
                if (strike == 0) {
                    message = ball + "볼";
                } else if (ball == 0) {
                    if (strike != 3) {
                        message = strike + "스트라이크";
                    }
                } else if (ball != 0 && strike != 0) {
                    message = ball + "볼 " + strike + "스트라이크";
                }

            }

            System.out.println(message);
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();
            play(reTarget, userInput);
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> cpuInput = setCPU();
        System.out.println("컴퓨터 숫자:" + cpuInput);
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        if (userInput.length() != 3 ||
                !Character.isDigit(userInput.charAt(0)) ||
                !Character.isDigit(userInput.charAt(1)) ||
                !Character.isDigit(userInput.charAt(2))) {
            throw new IllegalArgumentException("입력한 값이 세 자리 숫자가 아닙니다.");
        }
        play(cpuInput, userInput);
    }

}