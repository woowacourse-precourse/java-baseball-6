package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

class MakeRandomNumber {

    private final List<Integer> computer = new ArrayList<>();

    public MakeRandomNumber() {

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public int pickNumberInRange() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

    List<Integer> getComputer() {
        return computer;
    }
}

public class Application {

    public static void main(String[] args) {

        MakeRandomNumber computerOutputNumber = new MakeRandomNumber();

        System.out.println("숫자야구 게임을 시작합니다.");

        while(true) {

            int userInputNumber;
            int[] userArray = new int[3];

            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            try {
                userInputNumber = Integer.parseInt(userInput);

                if (userInputNumber < 100 || userInputNumber > 999) {
                    throw new IllegalArgumentException("# 에러 메세지: 입력된 숫자의 자릿수를 확인해주세요.");
                }

                for(int i = 2; i >= 0; i--) {
                    userArray[i] = userInputNumber % 10;
                    userInputNumber /= 10;
                }
                if ((userArray[0] == userArray[1])
                        || (userArray[1] == userArray[2])
                        || (userArray[2] == userArray[0])) {
                    throw new IllegalArgumentException("# 에러 메세지: 중복된 숫자가 있는지 확인해주세요.");
                }

            } catch (NumberFormatException e) {
                System.out.println("# 에러 메세지: 숫자만 입력해주세요.");
                e.printStackTrace();
                return;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return;
            }

            List<Integer> userRandomNumbers = new ArrayList<>(3);
            for(int i = 0; i < 3; i++) {
                userRandomNumbers.add(userArray[i]);
            }

            List<Integer> computerRandomNumbers = computerOutputNumber.getComputer();

            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                if((computerRandomNumbers.get(i)).equals(userRandomNumbers.get(i))) {
                    strikes++;
                } else if (computerRandomNumbers.contains(userRandomNumbers.get(i))) {
                    balls++;
                }
            }

            if (strikes > 0 && balls > 0) {
                System.out.println(balls + "볼 " + strikes + "스트라이크");
            } else if (strikes > 0) {
                System.out.println(strikes + "스트라이크");
            } else if (balls > 0) {
                System.out.println(balls + "볼");
            } else {
                System.out.println("낫싱");
            }

            if (strikes == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String restart = Console.readLine();
                int answer = Integer.parseInt(restart);
                if (answer == 1) {
                    computerOutputNumber = new MakeRandomNumber();
                } else if (answer == 2) {
                    return;
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}