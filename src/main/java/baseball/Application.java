package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean playGame = true;

        while (playGame) {
            List<Integer> computer = computerRandomNumber();
            List<Integer> userNumber = new ArrayList<>();

            while (true) {
                System.out.println("숫자를 입력하세요: ");
                String input = Console.readLine();
                userNumber.clear();

                try {
                    String[] inputNumbers = input.split("");
                    boolean isDuplicate = false; // 중복 여부를 체크
                    
                    if (inputNumbers.length != 3) {
                        System.out.println("3자리 숫자를 입력해야 합니다.");
                        continue;
                    }

                    for (String num : inputNumbers) {
                        int numInt = Integer.parseInt(num);
                        if (userNumber.contains(numInt)) {
                            System.out.println("중복된 숫자를 제거해주세요.");
                            isDuplicate = true;
                            break;
                        }
                        userNumber.add(numInt);
                    }

                    if (isDuplicate) {
                        continue; // 중복된 숫자를 발견
                    }
                } catch (NumberFormatException e) {
                    System.out.println("숫자만 입력하세요.");
                    continue;
                }

                List<Integer> result = checkNumber(computer, userNumber);
                int strikes = result.get(0);
                int balls = result.get(1);

                if (strikes == 0 && balls == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.println(strikes + " 스트라이크, " + balls + " 볼");
                }

                if (strikes == 3) {
                    System.out.println("3 스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String playAgainInput = Console.readLine();

            if (playAgainInput.equals("2")) {
                System.out.println("게임을 종료합니다.");
                playGame = false;
            } else if (!playAgainInput.equals("1")) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다. 애플리케이션을 종료합니다.");
            }
        }
    }

    public static List<Integer> computerRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> checkNumber(List<Integer> target, List<Integer> guess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (target.get(i).equals(guess.get(i))) {
                strikes++;
            } else if (target.contains(guess.get(i))) {
                balls++;
            }
        }

        return List.of(strikes, balls);
    }
}
