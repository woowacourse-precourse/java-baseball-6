package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int answer = 1;

        while (answer != 2) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            Computer computer = new Computer();

            while (true) {

                List<Integer> my = inputNumbers();

                int[] compareResult = computer.compareNumber(my);

                int strike = compareResult[0];
                int ball = compareResult[1];

                String resultMessage = calculateResult(strike, ball);

                System.out.println(resultMessage);

                if (strike == 3) {
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                String inputAnswer = readLine();

                if (inputAnswer.length() != 1) {
                    throw new IllegalArgumentException("잘못 입력하셨습니다.");
                }

                answer = Integer.parseInt(inputAnswer);

                if (answer != 1 && answer != 2) {
                    throw new IllegalArgumentException("잘못 입력하셨습니다.");
                }

            } catch (Exception e){
                throw new IllegalArgumentException("잘못 입력하셨습니다.");
            }
        }
    }

    static List<Integer> inputNumbers() throws IllegalArgumentException {

        List<Integer> my = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbers = readLine();

        if (inputNumbers.length() != 3){
            throw new IllegalArgumentException("입력한 숫자 길이가 맞지 않습니다.");
        }

        for (int i = 0; i < inputNumbers.length(); i++){
            int number = Character.getNumericValue(inputNumbers.charAt(i));

            if ( 0 >= number || number > 9) {
                throw new IllegalArgumentException("입력한 문자는 숫자가 아닙니다.");
            }

            my.add(number);
        }

        return my;
    }

    static String calculateResult(int strike, int ball) {

        String resultMessage = ball + "볼 " + strike + "스트라이크";

        if (strike == 3) {
            resultMessage = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            return resultMessage;
        }

        if (strike == 0 && ball == 0){
            resultMessage = "낫싱";
            return resultMessage;
        }

        if (strike == 0){
            resultMessage = ball + "볼";
            return resultMessage;
        }

        if (ball == 0){
            resultMessage = strike + "스트라이크";
            return resultMessage;
        }

        return resultMessage;
    }
}
