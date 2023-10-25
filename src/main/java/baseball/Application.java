package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int INPUT_SIZE = 3;
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < INPUT_SIZE) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String user = Console.readLine();

                if (user.length() != INPUT_SIZE || !isInteger(user)) {
                    throw new IllegalArgumentException();
                }

                ArrayList<Integer> userInputList = user.chars()
                        .mapToObj(Character::getNumericValue)
                        .collect(Collectors.toCollection(ArrayList::new));

                HashSet<Integer> uniqueSet = new HashSet<>();
                for (Integer input : userInputList) {
                    if (!uniqueSet.add(input)) {
                        throw new IllegalArgumentException();
                    }
                }
                int strikeCount = 0;
                int ballCount = 0;
                for (int i = 0; i < INPUT_SIZE; i++) {
                    if (userInputList.get(i) == computer.get(i)) {
                        strikeCount++;
                    } else if (computer.contains(userInputList.get(i))) {
                        ballCount++;
                    }
                }


                if (strikeCount == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                if (strikeCount == 0 && ballCount == 0) {
                    System.out.println("낫싱");
                } else if (strikeCount > 0 && ballCount == 0) {
                    System.out.println(strikeCount + "스트라이크");
                } else if (strikeCount == 0 && ballCount > 0) {
                    System.out.println(ballCount + "볼");
                } else if (strikeCount > 0 && ballCount > 0) {
                    System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int wantMoreGame = Integer.parseInt(Console.readLine());
            if (wantMoreGame == 2) {
                break;
            }
        }


    }

    private static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
