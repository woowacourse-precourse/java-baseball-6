package baseball;

import java.util.HashSet;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    final static int SEQ_LENGTH = 3;
    final static int MAX_NUMBER = 9;
    final static int MIN_NUMBER = 1;
    static int[] answerSeq = new int[SEQ_LENGTH];
    static HashSet<Integer> answerSet = new HashSet<>(SEQ_LENGTH);
    static int[] userSeq = new int[SEQ_LENGTH];

    public static void main(String[] args) {
        int[] results;

        System.out.println("숫자 야구 게임을 시작합니다.");
        initGame();
        while (true) {
            setUserSeq();
            results = checkSeq();
            printResult(results);
            if (results[1] == SEQ_LENGTH) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String input = Console.readLine();
                if (Integer.parseInt(input) == 2) {
                    break;
                }
                initGame();
            }
        }
    }

    static void initGame() {
        int idx = 0;
        answerSet.clear();
        while (idx < SEQ_LENGTH) {
            answerSeq[idx] = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!answerSet.contains(answerSeq[idx])) {
                answerSet.add(answerSeq[idx]);
                idx++;
            }
        }
    }

    static void setUserSeq() {
        System.out.print("숫자를 입력해주세요 : ");
        String line = Console.readLine();
        if (line.length() > SEQ_LENGTH) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < SEQ_LENGTH; i++) {
            userSeq[i] = line.charAt(i) - '0';
            if ((userSeq[i] < MIN_NUMBER) || (userSeq[i] > MAX_NUMBER)) {
                throw new IllegalArgumentException();
            }
        }
    }

    static int[] checkSeq() {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < SEQ_LENGTH; i++) {
            if (userSeq[i] == answerSeq[i]) {
                strikeCount++;
            } else if (answerSet.contains(userSeq[i])) {
                ballCount++;
            }
        }
        return new int[]{ballCount, strikeCount};
    }

    static void printResult(int[] results) {
        int ballCount = results[0];
        int strikeCount = results[1];
        String msg;
        if ((ballCount > 0) && (strikeCount > 0)) {
            msg = String.format("%s볼 %s스트라이크", ballCount, strikeCount);
        } else if (ballCount > 0) {
            msg = String.format("%s볼", ballCount);
        } else if (strikeCount == 3) {
            msg = String.format("%s스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료", strikeCount);
        } else if (strikeCount > 0) {
            msg = String.format("%s스트라이크", strikeCount);
        } else {
            msg = "낫싱";
        }

        System.out.println(msg);
    }

    static void checkResult(int[] results) {

    }
}
