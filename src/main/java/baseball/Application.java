package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = generateComputerNumbers();
            int ballCount = 0;
            int strikeCount = 0;

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                if (input.length() != 3 || !input.matches("[1-9]+")) {
                    throw new IllegalArgumentException("유효하지 않은 값입니다. 프로그램 종료");
                }
                List<Integer> user = input.chars().mapToObj(Character::getNumericValue).toList();

                if (user.stream().distinct().count() < 3) {
                    throw new IllegalArgumentException("유효하지 않은 값입니다. 프로그램 종료");
                }

                ballCount = countBalls(user, computer);
                strikeCount = countStrikes(user, computer);

                if (ballCount > 0) {
                    System.out.printf("%d볼 ", ballCount);
                }
                if (strikeCount > 0) {
                    System.out.printf("%d스트라이크 ", strikeCount);
                }
                if(ballCount==0&&strikeCount==0){
                    System.out.println("낫싱");
                }
                    System.out.println();

                if (strikeCount == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
                    String select = Console.readLine();

                    if (select.equals("1")) {
                        computer = generateComputerNumbers();
                    } else if (select.equals("2")) {
                        break;
                    } else {
                        throw new IllegalArgumentException("유효하지 않은 값입니다. 프로그램 종료");

                    }
                }
            }
        }catch(IllegalArgumentException e){
            return;
        }catch (Exception e) {
            return; // 정상 종료
        }
    }

    private static List<Integer> generateComputerNumbers() {
        return IntStream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .boxed()
                .toList();
    }

    private static int countBalls(List<Integer> user, List<Integer> computer) {
        int ballCount = 0;
        for (int i = 0; i < user.size(); i++) {
            for (int j = 0; j < computer.size(); j++) {
                if (user.get(i).equals(computer.get(j)) && i != j) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    private static int countStrikes(List<Integer> user, List<Integer> computer) {
        int strikeCount = 0;
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).equals(computer.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
