package Game;

import static Text.StringText.*;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class PlayGame {
    List<Integer> list = new ArrayList<>();

    public PlayGame() {
        while(list.size() < 3) {
            int computerNumber = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(computerNumber)) {
                list.add(computerNumber);
            }
        }
    }

    public static void run() {
        PlayGame game;
        do {
            game = new PlayGame();
            game.play();
        } while(game.restart());
    }

    private void play() {
        String inputNumber;
        do {
            System.out.println(inputText);
            inputNumber = Console.readLine();
        } while(!checkNumber(inputNumber));
    }

    private boolean restart() {
        System.out.println(restartText);
        String inputNumber = Console.readLine();
        if(inputNumber.equals("1")) {
            return true;
        } else if(inputNumber.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.\n");
        }
    }

    private boolean checkNumber(String inputNumber) {
        int[] inputArray = changeNumberIntoArray(inputNumber);
        int s = strike(inputArray);
        int b = ball(inputArray);
        if(s == 0 && b == 0) {
            System.out.println("낫싱");
        } else if(s == 0) {
            System.out.println(b + "볼");
        } else if(b == 0) {
            System.out.println(s + "스트라이크");
        } else {
            System.out.println(b + "볼 " + s + "스트라이크");
        }
        if(s == 3) {
            System.out.println(correctText);
            return true;
        }
        return false;
    }

    private int[] changeNumberIntoArray(String inputNumber) {
        int[] inputArray = new int[3];
        validLength(inputNumber);
        for(int i = 0; i < inputNumber.length(); i++) {
            if(inputNumber.charAt(i) < '0' || inputNumber.charAt(i) > '9') {
                throw new IllegalArgumentException("잘못된 입력입니다.\n");
            }
            inputArray[i] = inputNumber.charAt(i) - '0';
        }
        return inputArray;
    }

    private void validLength(String inputNumber) {
        if(inputNumber.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.\n");
        }
    }

    private int strike(int[] playerNumber) {
        int s = 0;
        for(int i = 0; i < list.size(); i++) {
            if(playerNumber[i] == list.get(i)) {
                s++;
            }
        }
        return s;
    }

    private int ball(int[] playerNumber) {
        int b = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.contains(playerNumber[i]) && playerNumber[i] != list.get(i)) {
                b++;
            }
        }
        return b;
    }
}