package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        //구현
        boolean flag = true;

        while (flag) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3)
            {
                int randomNum = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNum))
                    computer.add(randomNum);
            }

            boolean play = baseballGame(computer);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String check = Console.readLine();
            if ("2".equals(check.trim()))
                flag = false;
        }
    }

    private static boolean baseballGame(List<Integer> computer) {
        boolean flag = false;

        while (!flag) {
            System.out.print("숫자를 입력해주세요: ");
            String inputLine = Console.readLine();

            try {
                int input = Integer.parseInt(inputLine);
                if (input < 111 || input > 999)
                    System.out.println("3개의 숫자만 입력 가능 합니다.");
                else {
                    int first = input / 100;
                    int second = (input / 10) % 10;
                    int third = input % 10;

                    if (first == second || second == third || first == third)
                        System.out.println("잘못된 입력입니다. 중복된 숫자를 입력하지 마세요.");
                    else {
                        int strikeCount = 0;
                        int ballCount = 0;
                        if (computer.contains(first)) {
                            if (first == computer.get(0))
                                strikeCount += 1;
                            else
                                ballCount += 1;
                        }
                        if (computer.contains(second)) {
                            if (second == computer.get(1))
                                strikeCount += 1;
                            else
                                ballCount += 1;
                        }
                        if (computer.contains(third)) {
                            if (third == computer.get(2))
                                strikeCount += 1;
                            else
                                ballCount += 1;
                        }

                        if (strikeCount == 3) {
                            System.out.println("3스트라이크\n" +
                                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료.");
                            flag = true;
                        } else if (strikeCount > 0 || ballCount > 0)
                            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                        else
                            System.out.println("낫싱");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다.");
            }
        }
        return true;
    }
}
