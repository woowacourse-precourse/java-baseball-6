package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game extends Text {

    private int strike = 0;
    private int ball = 0;

    public List<Integer> computerSet() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> input() {
        inputMessage();
        String input = Console.readLine();
        String[] numberStrings = input.split("");
        int[] number = new int[numberStrings.length];
        List<Integer> userList = new ArrayList<>();

        try {
            for (int i = 0; i < numberStrings.length; i++) {
                number[i] = Integer.parseInt(numberStrings[i]);

                if (number[i] < 1 || number[i] > 9) {
                    throw new IllegalArgumentException("1에서 9 사이의 숫자를 입력하세요.");
                }
                if (userList.contains(number[i])) {
                    throw new IllegalArgumentException("중복된 숫자가 있습니다.");
                }
                userList.add(number[i]);
            }
            if (number.length > 3) {
                throw new IllegalArgumentException("3개 이상의 숫자를 입력하지 마세요.");
            }

        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력할 수 있습니다.");
            throw e;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return userList;
    }

    public void gameScore(List<Integer> userList, List<Integer> computer) {
        strike = 0;
        ball = 0;
        for (int number : userList) {
            int strikeScore = userList.indexOf(number);
            int ballScore = computer.indexOf(number);
            if (strikeScore == ballScore) {
                strike++;
            } else if (ballScore != -1) {
                ball++;
            }
        }
    }
}


