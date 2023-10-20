package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        try {

            while (true) {
                List<Integer> computer = new ArrayList<>();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }

                if (computer.size() == 3) {

                    while (true) {
                        int ball = 0;
                        int strike = 0;
                        System.out.print("숫자를 입력해주세요 : ");
                        String[] str = Console.readLine().split("");

                        if (str.length != 3) {
                            throw new IllegalArgumentException();
                        }

                        for (int i = 0; i < computer.size(); i++) {
                            for (int j = 0; j < str.length; j++) {
                                if (computer.get(i) == Integer.parseInt(str[j]) && i == j) {
                                    strike++;
                                } else if (computer.get(i) == Integer.parseInt(str[j])) {
                                    ball++;
                                }
                            }
                        }
                        if (strike == 3) {
                            System.out.println(strike + "스트라이크");
                            break;
                        }
                        if (ball > 0 && strike > 0) System.out.println(ball + "볼 " + strike + "스트라이크");
                        else if (ball > 0) System.out.println(ball + "볼");
                        else if (strike > 0) System.out.println(strike + "스트라이크");
                        else if (ball == 0 && strike == 0) System.out.println("낫싱");
                    }
                }

                System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String check = Console.readLine();

                if (check.equals("1")) {
                    continue;
                } else if (check.equals("2")) {
                    break;
                } else {
                    throw new IllegalArgumentException();
                }
            }

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
