package baseball_oop.domain.game;

import baseball_oop.enums.ReplayOrNot;
import baseball_oop.vo.Answer;
import baseball_oop.domain.participant.computer.Computer;
import baseball_oop.domain.participant.judgment.Judgment;
import baseball_oop.domain.participant.player.Player;
import baseball_oop.vo.Result;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallGame implements Game {
    private final Computer computer;
    private final Judgment judgment;
    private final Player player;

    public BaseBallGame(Computer computer, Player player, Judgment judgment) {
        this.computer = computer;
        this.judgment = judgment;
        this.player = player;
    }
    @Override
    public void start() {
        String command;
        PrintMessage.printGameStart();
        do {
            play();
        } while (askReplay());
    }

    private void play() {
        Answer answer = computer.generateAnswer();
        Answer input;
        Result result = null;
        while (!gameEnd(result)) {
            input = selectInputToPlayer();
            printHint(result = judgment.judge(answer, input));
        }
    }

    private static boolean askReplay() {
        PrintMessage.printGameReplayOrNot();
        return readLine().equals(ReplayOrNot.REPLAY.getCode());
    }

    private static boolean gameEnd(Result result) {
        if (result == null) {
            return false;
        }

        boolean isEnd = result.isWin();
        if (isEnd) {
            PrintMessage.printWinAndEnd();
        }
        return isEnd;
    }

    private Answer selectInputToPlayer() {
        PrintMessage.printRequestInputNumber();
        return player.generateAnswer();
    }

    private void printHint(Result result) { // TODO 코드리팩토링 필요
        if (result == null) {
            return;
        }
        int strikeCount = result.getStrikeCount();
        int ballCount = result.getBallCount();

        if (result.getBallCount() == 0 && result.getStrikeCount() == 0) {
            PrintMessage.printResultNothing();
            return;
        }
        if (strikeCount != 0 && ballCount == 0) {
            PrintMessage.printMessage(strikeCount + PrintMessage.STRIKE);
        }
        if (strikeCount == 0 && ballCount != 0) {
            PrintMessage.printMessage(ballCount + PrintMessage.BALL);
        }
        if (strikeCount != 0 && ballCount != 0) {
            PrintMessage.printMessage(ballCount + PrintMessage.BALL + " " + strikeCount + PrintMessage.STRIKE);
        }
    }

    private static class PrintMessage {
        private final static String START = "숫자 야구 게임을 시작합니다.";
        private final static String INPUT_NUMBER = "숫자를 입력해주세요 : ";
        private final static String WIN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        private final static String PLAY_NEXT_GAME_OR_NOT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        private final static String NOTHING = "낫싱";
        private final static String BALL = "볼";
        private final static String STRIKE = "스트라이크";
        public static void printRequestInputNumber() {
            System.out.print(INPUT_NUMBER);
        }
        public static void printGameStart() {
            System.out.println(START);
        }
        public static void printWinAndEnd() {
            System.out.println(WIN);
        }
        public static void printGameReplayOrNot() {
            System.out.println(PLAY_NEXT_GAME_OR_NOT);
        }

        public static void printResultNothing() {
            System.out.println(NOTHING);
        }

        public static void printMessage(String message) {
            System.out.println(message);
        }
    }
}
