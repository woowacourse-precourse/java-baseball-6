package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //숫자 야구 게임 시작
        begin();
    }

    //숫자 야구 게임 시작
    private static void begin() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = new ArrayList<>();

        //맞춰야 할 임의의 세 자리 수 생성
        makingNumbers(computer);

        boolean repeat = true;

        while (repeat) {
            System.out.print("숫자를 입력해주세요 : ");


            String readLine = Console.readLine();

            //입력이 세자리가 아니거나 숫자가 아닐 경우 -> IllegalArgumentException()
            if (readLine.length() != 3 || !readLine.matches("\\d+")) {
                throw new IllegalArgumentException();
            }

            List<Integer> input = new ArrayList<>();
            input.add(Integer.parseInt(readLine.substring(0, 1)));
            input.add(Integer.parseInt(readLine.substring(1, 2)));
            input.add(Integer.parseInt(readLine.substring(2, 3)));


            //ball과 strike 갯수
            int ball = 0;
            int strike = 0;

            for (int i = 0; i < 3; i++) {
                int number = computer.get(i);

                if (number == input.get(i)) {
                    strike += 1;
                } else if (input.contains(number)) {
                    ball += 1;
                }
            }

            //"낫싱", "스트라이크", "볼" 출력
            repeat = printResult(repeat, ball, strike);

        }

        //게임을 새로 시작할 것인지, 종료할 것인지
        restart(repeat);
    }


    //맞춰야 할 임의의 세 자리 수 생성
    private static void makingNumbers(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    //"낫싱", "스트라이크", "볼" 출력
    private static boolean printResult(boolean repeat, int ball, int strike) {
        if (strike == 3) {
            System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            repeat = false;
        } else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return repeat;
    }

    //게임을 새로 시작할 것인지, 종료할 것인지
    private static void restart(boolean repeat) {
        if (!repeat) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String restart = Console.readLine();

            if (restart.equals("1")) {
                begin();
            } else if (!restart.equals("2")) {
                throw new IllegalArgumentException();
            }
        }
    }
}
