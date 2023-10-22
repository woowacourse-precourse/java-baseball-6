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

                if (strike == 3) {
                    System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

                if (strike == 0 && ball == 0){
                    System.out.println("낫싱");
                } else {

                    if (strike == 0){
                        System.out.println(ball + "볼 ");

                    } else if (ball == 0){
                        System.out.println(strike + "스트라이크");

                    } else {
                        System.out.println(ball + "볼 " + strike + "스트라이크");

                    }

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

    static List<Integer> inputNumbers() throws IllegalArgumentException{

        List<Integer> my = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbers = readLine();

        if (inputNumbers.length() != 3){
            throw new IllegalArgumentException("입력한 숫자 길이가 맞지 않습니다.");
        }

        for (int i = 0; i < inputNumbers.length(); i++){
            try {
                int number = Character.getNumericValue(inputNumbers.charAt(i));
                my.add(number);
            } catch (Exception e) {
                throw new IllegalArgumentException("입력한 문자가 숫자가 아닙니다.");
            }

        }

        return my;
    }
}
