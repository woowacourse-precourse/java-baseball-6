package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        boolean gameCondition = false;

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 숫자야구 시작
        while (!gameCondition) {
            // 랜덤 숫자 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while (true) {
                int strikes = 0;
                int balls = 0;

                // 숫자야구 입력 로직
                System.out.print("숫자를 입력해 주세요 : ");
                String input = inputForGaming();
                Map<Integer, Integer> map = new HashMap<>();
                int i = 0;
                for (String s : input.split("")) {
                    map.put(Integer.parseInt(s), i++);
                }

                // 조건 확인
                for (Integer integer : computer) {
                    Integer index = map.get(integer);

                    if (index != null) {
                        boolean b = Objects.equals(integer, computer.get(index));
                        if (b) {
                            strikes++;
                        } else {
                            balls++;
                        }
                    }
                }

                // 입력 결과
                printResult(strikes, balls);
                if (strikes == 3) {
                    String progressOrNot = inputForProgress();
                    gameCondition = progressOrNot.equals("2");
                    break;
                }
            }
        }
    }

    public static void printResult(int strikes, int balls) {
        switch (strikes) {
            case 3 -> {
                System.out.printf("%d스트라이크\n", strikes);
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            }
            case 0 -> {
                if (balls == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.printf("%d볼\n", balls);
                }
            }
            default -> {
                if (balls == 0) {
                    System.out.printf("%d스트라이크\n", strikes);
                } else {
                    System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
                }
            }
        }
    }

    public static String inputForProgress() {
        String input = Console.readLine();
        if (!(input.equals("1") || input.equals("2"))) {
            throwError();
        }
        return input;
    }

    public static String inputForGaming() {
        String input = Console.readLine();
        HashSet<String> set = new HashSet<>(Arrays.asList(input.split("")));
        try {
            // 숫자가 아닌 입력 or 공백 포함한 수 제거
            int numbers = Integer.parseInt(input);

            // 음수 or 3자리가 아닌 입력
            // 중복 확인 or 0 포함 수 제거
            if (set.size() < 3 || set.contains("0") || numbers <= 100 || numbers > 999) {
                throwError();
            }
        } catch (NumberFormatException e) {
            throwError();
        }

        return input;
    }

    public static void throwError() {
        throw new IllegalArgumentException("올바르지 않은 입력입니다. 게임 종료");
    }
}
