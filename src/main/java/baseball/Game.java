package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Scanner;

public class Game {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public void startGame() {
        ArrayList<Integer> computerNumber;
        System.out.println(START_MESSAGE);
        computerNumber = setRandomNumber();
        System.out.println(computerNumber);
        playGame();
    }

    private ArrayList<Integer> setRandomNumber() {
        int MAX_LENGTH = 3;
        int MAX_NUM = 9;
        int MIN_NUM = 1;

        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();

        do {
            int digit = random.nextInt(MAX_NUM - MIN_NUM + 1) + MIN_NUM;
            if(!arrayList.contains(digit)) {
                arrayList.add(digit);
            }
        } while (arrayList.size() < MAX_LENGTH);

        return arrayList;
    }

    public void playGame() {
        Scanner input = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        int number = input.nextInt();
        ArrayList<Integer> userNumber = convertIntToArrayList(number);
        illegalNumber(userNumber);
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

    private static void illegalNumber(ArrayList<Integer> arrayList) {
        if (arrayList.size() != 3 || arrayList.contains(0) || isDuplicated(arrayList)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicated(ArrayList<Integer> arrayList) {
        Set<Integer> set = new HashSet<>();
        for (int element : arrayList) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }
}