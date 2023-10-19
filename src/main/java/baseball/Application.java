package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            List<Integer> computer = generateComputerNumbers();
            System.out.println("숫자 야구 게임을 시작합니다.");
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();

                if (userInput.length() != 3) {
                    throw new IllegalArgumentException();
                }
                for (int i = 0; i < 3; i++) {
                    char c = userInput.charAt(i);
                    if(!Character.isDigit(c)) {
                        throw new IllegalArgumentException();
                    }
                }

                int strikeCount = 0, ballCount = 0;

                for (int i = 0; i < 3; i++) {
                    int number = Character.getNumericValue(userInput.charAt(i));
                    if (computer.contains(number)) {
                        if (computer.get(i) == number) {
                            strikeCount++;
                        } else {
                            ballCount++;
                        }
                    }
                }

                if (strikeCount == 0 && ballCount == 0) {
                    System.out.println("낫싱");
                } else if (strikeCount == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else if (strikeCount == 0){
                    System.out.println(ballCount+"볼");
                } else if (ballCount == 0) {
                    System.out.println(strikeCount+"스트라이크");
                } else {
                    System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restart = Integer.parseInt(Console.readLine());
            if (restart == 1) {
                continue;
            }
            if (restart == 2) {
                break;
            }
        }
    }
    private static List<Integer> generateComputerNumbers() {
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
