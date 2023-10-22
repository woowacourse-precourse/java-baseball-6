package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Game {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static ArrayList<Integer> computerNumber;
    private boolean exit = false;

    public void startGame() {
        System.out.println(START_MESSAGE);
        computerNumber = setRandomNumber();
        System.out.println(computerNumber);
        playGame();
    }

    private ArrayList<Integer> setRandomNumber() {
        int MAX_LENGTH = 3;

        ArrayList<Integer> arrayList = new ArrayList<>();

        do {
            int digit = Randoms.pickNumberInRange(1, 9);
            if (!arrayList.contains(digit)) {
                arrayList.add(digit);
            }
        } while (arrayList.size() < MAX_LENGTH);

        return arrayList;
    }

    public void playGame() {
        while (!exit) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            int number = Integer.parseInt(input);
            ArrayList<Integer> userNumber = convertIntToArrayList(number);
            checkIllegalNumber(userNumber);
            printAnswer(computerNumber, userNumber);
        }
    }

    public static ArrayList<Integer> convertIntToArrayList(int number) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(number > 0) {
            int element = number % 10;
            number /= 10;
            arrayList.add(0, element);
        }

        return arrayList;
    }

    private static void checkIllegalNumber(ArrayList<Integer> arrayList) {
        if (arrayList.size() != 3 || arrayList.contains(0) || isDuplicated(arrayList)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicated(ArrayList<Integer> arrayList) {
        HashSet<Integer> set = new HashSet<>();
        for (int element : arrayList) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }

    private void printAnswer(ArrayList<Integer> computerNumber, ArrayList<Integer> userNumber) {
        final String BALL = "볼 ";
        final String STRIKE = "스트라이크";
        final String NOTHING = "낫싱";

        int ballCounter = 0;
        int strikeCounter = 0;
        String answer = "";

        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strikeCounter++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                ballCounter++;
            }
        }

        if (ballCounter > 0) {
            answer += ballCounter + BALL;
        }
        if (strikeCounter > 0) {
            answer += strikeCounter + STRIKE;
        }
        if (ballCounter == 0 && strikeCounter == 0) {
            answer = NOTHING;
        }
        System.out.println(answer);

        if (strikeCounter == 3) {
            exit = true;
        }
    }
}