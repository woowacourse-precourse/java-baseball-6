package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class BaseballGameSet {
    List<Integer> computerNumberList = new ArrayList<>();

    List<Integer> getRandomNum() {
        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }

        return computerNumberList;
    }

    List<Integer> getPlayerGuess() throws IOException {

        String numberGuessInput = readLine();
        int numberGuess = Integer.parseInt(numberGuessInput);

        int firstNum;
        int secondNum;
        int thirdNum;

        firstNum = numberGuess / 100;

        if (firstNum > 9 || firstNum == 0) {
            throw new IllegalArgumentException();
        }

        numberGuess = numberGuess % 100;
        secondNum = numberGuess / 10;
        if (secondNum == 0) {
            throw new IllegalArgumentException();
        }

        thirdNum = numberGuess % 10;
        if (thirdNum == 0) {
            throw new IllegalArgumentException();
        }

        return List.of(firstNum, secondNum, thirdNum);

    }
}

record StrikeData(int strikeCnt, int ballCnt) {
}

class StrikeChecker {
    int ballCnt = 0;
    int strikeCnt = 0;

    StrikeData checkStrike(List<Integer> computerNum, List<Integer> playerNum) {
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(playerNum.get(i), computerNum.get(i))) {
                strikeCnt++;
            } else if (computerNum.contains(playerNum.get(i))) {
                ballCnt++;
            }
        }

        return new StrikeData(strikeCnt, ballCnt);
    }
}

public class PlayBaseballGame {
    
    static boolean checkStrike(List<Integer> computerNum, List<Integer> playerNum) {

        StrikeChecker newStrikeChecker = new StrikeChecker();
        StrikeData strikeCheckResult = newStrikeChecker.checkStrike(computerNum, playerNum);

        if (strikeCheckResult.ballCnt() == 0 && strikeCheckResult.strikeCnt() == 0) {
            System.out.println("낫싱");
            return false;
        } else if (strikeCheckResult.strikeCnt() == 3) {
            System.out.printf("%d스트라이크\n", strikeCheckResult.strikeCnt());
            return true;
        } else {
            System.out.printf("%d볼 %d스트라이크\n", strikeCheckResult.ballCnt(), strikeCheckResult.strikeCnt());
            return false;
        }
    }

    static boolean askNewGame() throws IOException {
        System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");

        String newGameAnswerString = readLine();
        int newGameAnswer = Integer.parseInt(newGameAnswerString);

        if (newGameAnswer == 1) {
            return true;
        } else if (newGameAnswer == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void playGame() {

        boolean isCorrect = false;

        BaseballGameSet newSet = new BaseballGameSet();

        // set the number of the computer
        List<Integer> computerNumberList = newSet.getRandomNum();
        List<Integer> playerGuessNumberList;

        while (!isCorrect) {
            System.out.print("숫자를 입력해주세요 : ");

            try {
                playerGuessNumberList = newSet.getPlayerGuess();
            } catch (IOException e) {
                return;
            }

            isCorrect = checkStrike(computerNumberList, playerGuessNumberList);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        boolean startNewGame;

        try {
            startNewGame = askNewGame();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        if (startNewGame) {
            playGame();
        }
    }
}
