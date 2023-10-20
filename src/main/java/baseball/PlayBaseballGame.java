package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
    public static void playGame() {

        boolean isCorrect = false;

        // set the number of the computer
        List<Integer> computerNumberList = getRandomNum();
        List<Integer> playerGuessNumberList = getRandomNum();

        while(!isCorrect) {
            System.out.print("숫자를 입력해주세요 : ");

            try {
                playerGuessNumberList = getPlayerGuess();
            } catch (IOException e) {
                return;
            }

            System.out.println(playerGuessNumberList);

            isCorrect = true;
        }
    }
}
