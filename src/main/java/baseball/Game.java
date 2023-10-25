package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * run -> 전체 프로그램 실행
 * playOneGame -> 게임 실행
 * ckeckRestart -> 재시작 여부
 * getStrike -> 스트라이크 개수
 * getBall -> 볼 개수
 */
public class Game {
    List<Integer> answer = new ArrayList<>();
    public Game() {
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }
    public static void Run() {
        Game game;

        do {
            game = new Game();
            game.playGame();
        }while(game.restart());
    }
    private boolean restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        if(inputString.equals("1")){
            return true;
        }else if(inputString.equals("2")){
            return false;
        }else{
            throw new IllegalArgumentException("[Game.restart()]:"+ "잘못된 입력입니다.");
        }
    }
    public void playGame() {
        String inputString;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            inputString = Console.readLine();
        } while (!checkResult(inputString));
    }
    private boolean checkResult(String inputNumberString) {
        int[] inputNumberArray = changeStringToIntArray(inputNumberString);
        int strike = getStrike(inputNumberArray);
        int ballWithStrike = getBall(inputNumberArray);
        printResult(strike, ballWithStrike);

        if(strike == 3) {
            return true;
        } else {
            return false;
        }
    }

    private void printResult(int strike, int ballWithStrike) {
        if(ballWithStrike == 0){
            System.out.println("낫싱");
        }
        else {
            int ball = ballWithStrike - strike;
            if (ball != 0) {
                System.out.print(ball + "볼");
            }
            if (strike != 0) {
                System.out.print(strike + "스트라이크");
            }
            System.out.println();
        }
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
    private int[] changeStringToIntArray(String inputString) { //
        int[] intArray = new int[3];
        verifyInputLength(inputString);

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) < '0' || inputString.charAt(i) > '9') {
                throw new IllegalArgumentException("잘못된 타입의 입력입니다.");
            }
            intArray[i] = Integer.parseInt(inputString.substring(i, i + 1));
        }
        return intArray;
    }
    private void verifyInputLength(String inputString) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("잘못된 길이의 입력입니다." + "\nExpect : " + 3 + "\nInput : " + inputString.length());
        }
    }
    private int getStrike(int[] inputNumber) {
        int strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (inputNumber[i] == answer.get(i)) {
                strike++;
            }
        }
        return strike;
    }
    private int getBall(int[] inputNumber) {
        int ballWithStrike = 0;
        for (int i : inputNumber) {
            if (answer.contains(i)) {
                ballWithStrike++;
            }
        }
        return ballWithStrike;
    }
}