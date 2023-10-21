package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            List<Integer> randomNum = makeRandomNum();

            while (true) {
                if (isGameEnd(checkStrikeBall(randomNum))) {
                    break;
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        } while (isContinue());
    }

    private static List<Integer> makeRandomNum() {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static int checkStrikeBall(List<Integer> randomNum) throws IllegalArgumentException {

        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        if (!isRightValInCheck(userInput)) {
            throw new IllegalArgumentException();
        }

        List<Integer> numList = convertInputToList(userInput);
        int strikeBall = calculateStrikeBall(randomNum, numList);
        printStrikeBallResult(strikeBall);
        return strikeBall;
    }

    private static boolean isRightValInCheck(String userInput) {
        return userInput != null && userInput.matches("[1-9]{3}");
    }

    private static List<Integer> convertInputToList(String userInput) {

        String[] inputArray = userInput.split("");
        List<Integer> numList = new ArrayList<>();
        for (String s : inputArray) {
            numList.add(Integer.parseInt(s));
        }
        return numList;
    }

    private static int calculateStrikeBall(List<Integer> randomNum, List<Integer> numList) {

        int strikeBall = 0;
        for (int i = 0; i < numList.size(); i++) {
            int num = numList.get(i);
            if (randomNum.contains(num)) {
                if (i == randomNum.indexOf(num)) {
                    strikeBall += 4;
                } else {
                    strikeBall += 1;
                }
            }
        }
        return strikeBall;
    }

    private static void printStrikeBallResult(int strikeBall) {

        int strike = strikeBall / 4;
        int ball = strikeBall % 4;

        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike != 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball != 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    private static boolean isGameEnd(int strikeBall) {

        return strikeBall == 12; // 3스트라이크는 12
    }

    private static boolean isContinue()  throws IllegalArgumentException  {

        String userInput = Console.readLine();
        if(!isRightValInContinue(userInput)) {
            throw new IllegalArgumentException();
        }
        return userInput.equals("1");
    }

    private static boolean isRightValInContinue(String userInput) {
        return userInput.equals("1") || userInput.equals("2");
    }
}