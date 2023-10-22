package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isPlaying = true;
        int randomNum = Randoms.pickNumberInRange(111, 999);
        int ballCnt, strikeCnt;

        String answerComputer = Integer.toString(randomNum);
        String answerPlayer;

        String messageBallCnt, messageScore, messageStrikeCnt;
        System.out.print("생성된 숫자는 " + answerComputer + "\n");
        do {
            messageBallCnt = "";
            messageStrikeCnt = "";
            messageScore = "";
            ballCnt = 0;
            strikeCnt = 0;

            System.out.print("숫자를 입력해주세요 : ");
            answerPlayer = Console.readLine();

            ballCnt = countBallHits(answerPlayer, answerComputer);

            if (ballCnt > 0) {
                messageBallCnt = String.valueOf(ballCnt) + "볼";
            }

            if (ballCnt + strikeCnt > 0) {
                messageScore = messageBallCnt + messageStrikeCnt;
            } else if (ballCnt + strikeCnt == 0) {
                messageScore = "낫싱";
            }

            System.out.println(messageScore);

            if (answerPlayer.equals(answerComputer)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isPlaying = false;
            }
        } while (isPlaying);
    }

    public int countBallHits(String source, String answer) {
        int ballCnt = 0;

        for (int i = 0; i < source.length(); i++) {
            char sourceChar = source.charAt(i);
            if (answer.contains(String.valueOf(sourceChar))) {
                ballCnt++;
            }
        }

        return ballCnt;
    }
}
