package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isGameOn = true;
        while (isGameOn) {
            List<Integer> computerNumbers = getComputerNumbers();
            System.out.println(computerNumbers);

            while (true) {
                List<Integer> userNumbers = getUserNumbers();
                int strikeCount = 0;
                for (int i = 0; i < computerNumbers.size(); i++) {
                    if (computerNumbers.get(i) == userNumbers.get(i)) {
                        strikeCount++;
                    }
                }
                int ballCount = 0;
                for (int j = 0; j < computerNumbers.size(); j++) {
                    if (computerNumbers.get(j) != userNumbers.get(j) && computerNumbers.contains(userNumbers.get(j))) {
                        ballCount++;
                    }
                }
                if (strikeCount == 0 && ballCount == 0) {
                    System.out.println("낫싱");
                } else if (strikeCount == 0 && ballCount != 0) {
                    System.out.println(ballCount + "볼");
                } else if (strikeCount != 0 && ballCount == 0) {
                    System.out.println(strikeCount + "스트라이크");
                } else {
                    System.out.print(ballCount + "볼 ");
                    System.out.println(strikeCount + "스트라이크");
                }
                if (strikeCount == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String putNumber = Console.readLine();
            if (putNumber.equals("1")) {
                isGameOn = true;
            } else if (putNumber.equals("2")) {
                isGameOn = false;
            } else {
                throw new IllegalArgumentException(" 1이나 2를 입력하세요.");
            }

        }

    }

    private static List<Integer> getComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> getUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userInputNumbers = new ArrayList<>();
        try {
            String[] inputs = Console.readLine().split(""); // inputs = ["1","2","3","4"]
            for (String numberStr : inputs) {
                int numberInt = Integer.parseInt(numberStr);
                if (userInputNumbers.contains(numberInt)) {
                    throw new IllegalArgumentException("중복된 수를 넣을 수 없습니다.");
                }
                userInputNumbers.add(numberInt);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 것이 섞여 있을 때");
        }
        if (userInputNumbers.size() != 3) {
            throw new IllegalArgumentException("3자리 수여야 합니다.");
        }
        return userInputNumbers;
    }
}