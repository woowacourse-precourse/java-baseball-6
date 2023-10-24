package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private String answerComputer;
    private String answerPlayer;
    private boolean isPlaying;
    final int INPUT_LENGTH_MAX = 3;

    final int BALL_MIN = 1;
    final int BALL_MAX = 9;

    final int INPUT_RESTART_LENGTH_MAX = 1;
    final int INPUT_RESTART_MIN = 1;
    final int INPUT_RESTART_MAX = 2;


    public void startGame() {

        initGame();

        String messageScore;

        do {

            inputAnswerPlayer();

            messageScore = countStrikeBallHits(answerPlayer, answerComputer);

            System.out.println(messageScore);

            if (answerPlayer.equals(answerComputer)) {
                System.out.println("3개의 숫자 를 모두 맞히셨습니다! 게임 종료");
                isPlaying = restartGame();
            }
        } while (isPlaying);
    }

    private void inputAnswerPlayer() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputPlayer = Console.readLine();
        exceptLengthInvalid(inputPlayer, INPUT_LENGTH_MAX);
        exceptNotInteger(inputPlayer);
        exceptInvalidRange(inputPlayer, BALL_MIN, BALL_MAX);
        exceptInputSameNumber(inputPlayer);
        this.answerPlayer = inputPlayer;

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


    public void initGame() {
        answerComputer = "";
        answerPlayer = "";
        initAnswer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        isPlaying = true;
        System.out.println("생성된 숫자는 " + answerComputer);
    }

    public void initAnswer() {
        List<Integer> computer = new ArrayList<>();
        StringBuilder answerBuilder = new StringBuilder();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                answerBuilder.append(Integer.toString(randomNumber));
            }
        }

        this.answerComputer = answerBuilder.toString();
    }

    public boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInput = Console.readLine();
        exceptLengthInvalid(playerInput, INPUT_RESTART_LENGTH_MAX);
        exceptNotInteger(playerInput);
        exceptInvalidRange(playerInput, INPUT_RESTART_MIN, INPUT_RESTART_MAX);

        if (playerInput.equals("1")) {
            initAnswer();
            return true;
        }
        if (playerInput.equals("2")) {
            return false;
        }

        return false;
    }

    public void exceptLengthInvalid(String source, int exclusive) {
        if (source.length() != exclusive) {
            throw new IllegalArgumentException("입력값의 길이는 " + Integer.toString(exclusive) + " 과(와) 같아야 합니다.");
        }
    }


    public void exceptNotInteger(String source) {
        for (int i = 0; i < source.length(); i++) {
            if (!Character.isDigit(source.charAt(i))) {
                throw new IllegalArgumentException("입력값은 반드시 정수여야 합니다.");
            }
        }
    }

    public void exceptInvalidRange(String source, final int startInclusive, final int endInclusive) {
        int eachDigit;
        for (int i = 0; i < source.length(); i++) {
            eachDigit = Integer.parseInt(String.valueOf(source.charAt(i)));
            if (eachDigit < startInclusive || endInclusive < eachDigit) {
                throw new IllegalArgumentException("입력값은 " + startInclusive + " 이상" + endInclusive + " 이하여야 합니다.");
            }
        }
    }

    public void exceptInputSameNumber(String source) {
        for (int i = 0; i < source.length(); i++) {
            for (int j = i + 1; j < source.length(); j++) {
                if (source.charAt(i) == source.charAt(j)) {
                    throw new IllegalArgumentException("입력값은 서로 다른 숫자로 이루어져야 합니다.");
                }
            }
        }
    }

}
