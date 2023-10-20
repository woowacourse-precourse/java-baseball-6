package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;


public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            if (playGame()) {
                continue;
            } else {
                break;
            }
        }
    }

    private static boolean playGame() {
        boolean again = false;

        ArrayList<Integer> computer = getRandomInt();
        //System.out.println(computer);

        while (true) {
            ArrayList<Integer> responseArray = getUserInput();
            // TODO : 계산로직 출력로직 재시작여부로직 구현
        }
    }

    private static ArrayList<Integer> getUserInput() {
        ArrayList<Integer> userGuess = new ArrayList<>();
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String response = Console.readLine();
            if (response.length() != 3) {
                throw new IllegalArgumentException();
            }

            for (char digit : response.toCharArray()) {
                int digitInt = Integer.parseInt(String.valueOf(digit));
                if (userGuess.contains(digitInt)) {
                    throw new IllegalArgumentException();
                }
                userGuess.add(digitInt);
            }

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return userGuess;
    }

    private static ArrayList<Integer> getRandomInt() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
