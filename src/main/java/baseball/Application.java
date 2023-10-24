package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        baseballStart();

    }

    public static void baseballStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        int gameSize = 3;

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < gameSize) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        userInputCompare(gameSize, computer);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String num = readLine();

        switch (num){
            case "1" :
                System.out.println("게임을 다시 시작합니다.");
                baseballStart();
            case "2" :
                System.out.println("프로그램을 종료합니다.");
                return;
            default :
                throw new IllegalArgumentException();
        }
    }

    public static void userInputCompare(int gameSize, List<Integer> computer){
        int strike = 0;
        int ball = 0;
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            String inputString = readLine();

            List<Integer> inputNumber = new ArrayList<>();
            if (inputString.length() != gameSize) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < gameSize; i++) {
                try {
                    int number = Integer.parseInt(inputString.substring(i, i + 1));
                    if (inputNumber.contains(number)) {
                        throw new IllegalArgumentException();
                    }
                    inputNumber.add(number);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }

            strike = 0;
            ball = 0;
            for (int i = 0; i < gameSize; i++) {
                if (computer.get(i).equals(inputNumber.get(i))) {
                    strike++;
                    continue;
                }
                if (computer.contains(inputNumber.get(i))) {
                    ball++;
                }
            }

            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            if (strike == 0 && ball == 0) {
                System.out.print("낫싱");
            }
            System.out.println();

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

}

