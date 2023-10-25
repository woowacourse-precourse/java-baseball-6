package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        boolean start_or_not = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (start_or_not) {
            List<Integer> choiceComputerNumber = createComputerNumber();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String predictedValue_String = Console.readLine();

                if (isValidInput(predictedValue_String)) {
                    int predictedValue = Integer.parseInt(predictedValue_String);
                    int first_digit = predictedValue / 100;
                    int second_digit = (predictedValue % 100) / 10;
                    int third_digit = predictedValue % 10;

                    int[] predictDigits = {first_digit, second_digit, third_digit};

                    int ball = 0;
                    int strike = 0;

                    for (int i = 0; i < choiceComputerNumber.size(); i++) {
                        for (int j = 0; j < predictDigits.length; j++) {
                            if (choiceComputerNumber.get(i) == predictDigits[j]) {
                                if (i == j)
                                    strike += 1;
                                else
                                    ball += 1;
                            }
                        }
                    }
                    if (ball == 0 && strike == 0)
                        System.out.println("낫싱");
                    else if (strike == 3) {
                        System.out.println(strike + "스트라이크");
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        String gameSituation_String = Console.readLine();
                        int gameSituation = Integer.parseInt(gameSituation_String);
                        if (isValidInput2(gameSituation))
                        {
                            if (gameSituation == 2)
                                start_or_not = false;
                            break;
                        }
                        else {
                            throw new IllegalArgumentException("1과 2중에 입력하세요.");
                        }

                    } else {
                        if (ball == 0)
                            System.out.println(strike + "스트라이크");
                        else if (strike == 0)
                            System.out.println(ball + "볼");
                        else
                            System.out.println(ball + "볼 " + strike + "스트라이크");
                    }
                } else {
                    throw new IllegalArgumentException("세 자리 숫자를 입력하세요.");
                }
            }
        }
    }
    private static List<Integer> createComputerNumber () {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    private static boolean isValidInput (String input){
        return input.matches("\\d{3}");
    }
    private static boolean isValidInput2 (int input){
        return input == 1 || input == 2;
    }
}
