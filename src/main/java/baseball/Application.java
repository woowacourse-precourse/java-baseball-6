package baseball;
import java.util.ArrayList;
import java.util.List;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = makeRandomNumber();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            int strike = 0;
            int ball = 0;

            char[] tmp = Console.readLine().toCharArray();
            List<Integer> clientInput = new ArrayList<>();

            if (tmp.length != 3) {
                throw new IllegalArgumentException();
            }

            for(char c : tmp) {
                if(!Character.isDigit(c) || Character.getNumericValue(c) < 0 || clientInput.contains(Character.getNumericValue(c))){
                    throw new IllegalArgumentException();
                }
                clientInput.add(Character.getNumericValue(c));
            }

            for (int a : clientInput) {
                if (computer.contains(a)) {
                    if (computer.indexOf(a) == clientInput.indexOf(a)) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }

            if (ball == 0 && strike > 0){
                System.out.println(strike + "스트라이크");
            } else if (ball > 0 && strike == 0) {
                System.out.println(ball + "볼");
            } else if (ball > 0 && strike > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else {
                System.out.println("낫싱");
            }

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String restart = Console.readLine();
                if (restart.equals("1")) {
                    computer = makeRandomNumber();
                    continue;
                }
                else if (restart.equals("2")) {
                    break;
                }
                throw new IllegalArgumentException();
            }
        }
    }

    private static List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
