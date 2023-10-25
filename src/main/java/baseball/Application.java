package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        boolean play = true;
        while (play) {
            playGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();

            if (input.equals("1")) play = true;
            else play = false;
        }
    }

    private static void playGame() {
        int[] randomNumber; // 랜덤 숫자
        int[] inputNumber = new int[3]; // 입력 숫자
        int strike = 0; // 스트라이크 개수
        int ball = 0; // 볼 개수

        randomNumber = getRandomNumber(); // 컴퓨터 랜덤 3자리 숫자

        System.out.println("숫자 야구 게임을 시작합니다");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            if (input.length() > 3) throw new IllegalArgumentException(); // 잘못된 값 입력

            for (int i = 0; i < input.length(); i++) {
                inputNumber[i] = Character.getNumericValue(input.charAt(i));
            }

            for (int i = 0; i < randomNumber.length; i++) {
                for (int j = 0; j < inputNumber.length; j++) {
                    if (randomNumber[i] == inputNumber[j]) {
                        if (i == j) strike++;
                        else ball++;
                    }
                }
            }

            if (strike == 3) {
                System.out.println("3스트라이크");
                break;
            } else if (strike == 0 && ball == 0) System.out.println("낫싱");
            else System.out.println(+ball + "볼 " + strike + "스트라이크");

            strike = 0;
            ball = 0;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static int[] getRandomNumber() {
        int[] randomNumber;
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(number)) {
                computer.add(number);
            }
        }
        randomNumber = computer.stream().mapToInt(i -> i).toArray();
        return randomNumber;
    }
}
