package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        Game.start();
    }
}
class Computer {
    private static final int START_OF_RANGE = 1;
    private static final int END_OF_RANGE = 9;
    static int[] answer = new int[Game.NUMBERS];
    static int getRandomNumber() {
        return Randoms.pickNumberInRange(START_OF_RANGE, END_OF_RANGE);
    }
    static void generateAnswer() {
        for(int i = 0; i<Game.NUMBERS; i++) {
            answer[i] = getRandomNumber();
            for(int j = 0; j < i; j++){
                while(answer[i]==answer[j]) answer[i] = getRandomNumber();
            }
        }
    }

}
class User {
    static int[] answer = new int[Game.NUMBERS];
    static void getUserNumbers() {
        String strNum = Console.readLine();
        if(strNum.length()> Game.NUMBERS) {
            throw new IllegalArgumentException("Invalid input");
        }
        for(int i = 0; i < Game.NUMBERS; i++) {
            answer[i]=strNum.charAt(i) - '0';
            if(answer[i]<1==answer[i]>9) {
                throw new IllegalArgumentException("Invalid input");
            }
        }
        for(int i = 0; i< Game.NUMBERS; i++){
            for(int j = 0; j < Game.NUMBERS; j++){
                if(i == j) {
                    continue;
                }
                if(answer[i]==answer[j]) {
                    throw new IllegalArgumentException("Invalid input");
                }
            }
        }
    }
}
class Result {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    static final int NEW_START = 1;
    static final int EXIT_GAME = 2;
    static final String END_MESSAGE = Game.NUMBERS + STRIKE + "\n" + Game.NUMBERS + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
            + "게임을 새로 시작하려면 " + NEW_START + ", 종료하려면 " + EXIT_GAME + "를 입력하세요.\n";

    static String getResult(int[] arr1, int[] arr2){
        int countBall = 0;
        int countStrike = 0;
        for(int i=0; i<Game.NUMBERS; i++) {
            for(int j=0; j<Game.NUMBERS; j++) {
                if (arr1[i] == arr2[j]){
                    if(i==j) {
                        countStrike++;
                    }
                    else {
                        countBall++;
                    }
                }
            }
        }
        if(countStrike==0 && countBall==0) {
            return NOTHING + "\n";
        }
        else if(countStrike==3) {
            return END_MESSAGE;
        }
        else {
            return countBall + BALL + " " + countStrike + STRIKE + "\n";
        }
    }
}
class Game {
    public static final int NUMBERS = 3;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    static String getResult() {
        return Result.getResult(Computer.answer, User.answer);
    }
    static void restart() {
        int num = Integer.parseInt(Console.readLine());
        if(num == 1) {
            start();
        }
    }
    public static void start() {
        System.out.print(START_MESSAGE);
        Computer.generateAnswer();
        while (!Objects.equals(getResult(), Result.END_MESSAGE)) {
            System.out.print(INPUT_MESSAGE);
            User.getUserNumbers();
            System.out.print(getResult());
        }
        restart();
    }

}