package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isPlaying = true;
        int randomNum = Randoms.pickNumberInRange(111, 999);

        String answerComputer = Integer.toString(randomNum);
        String answerPlayer;

        String messageScore;
        System.out.print("생성된 숫자는 " + answerComputer + "\n");
        do {

            System.out.print("숫자를 입력해주세요 : ");
            answerPlayer = Console.readLine();

            messageScore = countStrikeBallHits(answerPlayer, answerComputer);

            System.out.println(messageScore);

            if (answerPlayer.equals(answerComputer)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isPlaying = false;
            }
        } while (isPlaying);
    }


    public String countStrikeBallHits(String source, String answer) {
        int ballCnt = 0;
        int strikeCnt = 0;
        String messageScore = "";
        String messageBall = "";
        String messageStrike = "";

        for (int i = 0; i < source.length(); i++) {
            char sourceChar = source.charAt(i);
            if (sourceChar == answer.charAt(i)) {
                strikeCnt++;
            } else if (answer.contains(String.valueOf(sourceChar))) {
                ballCnt++;
            }
        }

        if (ballCnt > 0) {
            messageBall = String.valueOf(ballCnt) + "볼 ";
        }
        if (strikeCnt > 0) {
            messageStrike = String.valueOf(strikeCnt) + "스트라이크";
        }

        if (ballCnt + strikeCnt > 0) {
            messageScore = messageBall + messageStrike;
        } else if (ballCnt + strikeCnt == 0) {
            messageScore = "낫싱";
        }

        return messageScore;
    }
}
