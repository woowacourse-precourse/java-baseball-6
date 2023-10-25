package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;

public class Game {
    private static final int MAX_LENGTH = 3;
    private static ArrayList<Integer> computerNumber;
    private boolean endGame = false;

    public void startGame() {
        final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

        System.out.println(START_MESSAGE);
        playGame();
    }

    public void playGame() {
        final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

        computerNumber = setRandomNumber();

        while (!endGame) {
            System.out.print(INPUT_NUMBER_MESSAGE);
            String input = Console.readLine();
            int number = Integer.parseInt(input);
            ArrayList<Integer> userNumber = convertIntToArrayList(number);
            checkIllegalNumber(userNumber);
            printAnswer(computerNumber, userNumber);
        }
        selectEndOptions();
    }

    public void selectEndOptions() {
        final String END_OPTIONS_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

        System.out.println(END_OPTIONS_MESSAGE);
        String input = Console.readLine();
        int option = Integer.parseInt(input);
        if (option == 1) {
            endGame = false;
            playGame();
        }
    }

    private ArrayList<Integer> setRandomNumber() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        do {
            int digit = Randoms.pickNumberInRange(1, 9);
            if (!arrayList.contains(digit)) {
                arrayList.add(digit);
            }
        } while (arrayList.size() < MAX_LENGTH);

        return arrayList;
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
        if (arrayList.size() != MAX_LENGTH ||
                arrayList.contains(0) ||
                isDuplicated(arrayList)) {
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
        final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

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

        if (strikeCounter == MAX_LENGTH) {
            System.out.println(END_MESSAGE);
            endGame = true;
        }
    }
}