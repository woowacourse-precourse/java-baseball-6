package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {


        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computer = pickNumberInRange();

            while (true) {
                try {
                    List<Integer> userNum = userNumber();
                    int[] result = calculateScore(computer, userNum);
                    printResult(result);

                    if (result[0] == 3) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        if (play()) {
                            break;
                        } else {
                            System.out.println("게임을 종료합니다.");
                            return;
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("오류: " + e.getMessage());
                    System.out.println("게임을 종료합니다.");
                    return;
                }
            }
        }

    }

    public static List<Integer> pickNumberInRange() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> userNumber() {
        List<Integer> check = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();

        if (userInput.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력하세요.");
        }

        for (int i = 0; i < 3; i++) {
            check.add(Character.getNumericValue(userInput.charAt(i)));
        }

        return check;
    }


    public static int[] calculateScore(List<Integer> computer, List<Integer> check) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(check.get(i))) {
                result[0]++;
            } else if (computer.contains(check.get(i))) {
                result[1]++;
            }
        }

        return result;
    }

    public static void printResult(int[] result) {
        int strikes = result[0];
        int balls = result[1];

        String output = (strikes > 0) ? strikes + "스트라이크 " : "";
        output += (balls > 0) ? balls + "볼" : "";

        if (output.isEmpty()) {
            System.out.println("낫싱");
        } else {
            System.out.println(output);
        }
    }

    public static boolean play() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        return input.equals("1");
    }
}


