package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game extends Text {

    private int strike = 0;
    private int ball = 0;

    public void gameStart() {
        List<Integer> computer = computerSet();
        while (true) {
            List<Integer> user = input();
            gameScore(user, computer);
            gameResult();

            if (strike == 3) {
                successMessage();
                restartOrExit();
                break;
            }
        }
    }

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

    public void gameResult() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball != 0) {
            System.out.println(ball + "볼 ");
        } else if (strike != 0) {
            System.out.println(strike + "스트라이크");
        }
    }

    public void restartOrExit() {
        //재시작 및 종료
        restartOrExitMessage();
        int set = Integer.parseInt(Console.readLine());
        if (set == 1) {
            gameStart();
        } else if (set == 2) {
        } else if (set != 1 && set != 2) {
            throw new IllegalArgumentException("숫자 1과 2만 입력할 수 있습니다.");
        }
    }
}


