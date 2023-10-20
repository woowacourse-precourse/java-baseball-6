package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayBaseballGame {
    static List<Integer> getRandomNum() {

        List<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }

        return computerNumberList;
    }

    static List<Integer> getPlayerGuess() throws IOException {
        InputStream numberGuessStream = System.in;
        InputStreamReader numberGuessStreamReader = new InputStreamReader(numberGuessStream);
        BufferedReader numberGuessBufferReader = new BufferedReader(numberGuessStreamReader);

        String numberGuessInput = numberGuessBufferReader.readLine();
        int numberGuess = Integer.parseInt(numberGuessInput);

        int firstNum;
        int secondNum;
        int thirdNum;

        try {
            firstNum = numberGuess/100;

            if(firstNum > 9 || firstNum == 0) {
                throw new IllegalArgumentException();
            }

            numberGuess = numberGuess%100;
            secondNum = numberGuess/10;
            if(secondNum == 0) {
                throw new IllegalArgumentException();
            }

            thirdNum = numberGuess%10;
            if(thirdNum == 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return List.of(0, 0, 0);
        }

        return List.of(firstNum, secondNum, thirdNum);

    }

    static boolean checkStrike(List<Integer> computerNum, List<Integer> playerNum) {
        int ballCnt = 0;
        int strikeCnt = 0;

        for(int i = 0; i < 3; i++) {
            if(Objects.equals(playerNum.get(i), computerNum.get(i))) {
                strikeCnt ++;
            } else if(computerNum.contains(playerNum.get(i))) {
                ballCnt ++;
            }
        }

        if(ballCnt == 0 && strikeCnt == 0) {
            System.out.println("낫싱");
            return false;
        } else if(strikeCnt == 3) {
            System.out.printf("%d스트라이크\n", strikeCnt);
            return true;
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ballCnt, strikeCnt);
            return false;
        }
    }
    public static void playGame() {

        boolean isCorrect = false;

        // set the number of the computer
        List<Integer> computerNumberList = getRandomNum();
        List<Integer> playerGuessNumberList;

        while(!isCorrect) {
            System.out.print("숫자를 입력해주세요 : ");

            try {
                playerGuessNumberList = getPlayerGuess();
            } catch (IOException e) {
                return;
            }

            isCorrect = checkStrike(computerNumberList, playerGuessNumberList);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
