package baseball;

import java.util.List;

public class Game {
    private final String START_GAME_COMMENT = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_NUMBER_COMMENT = "숫자를 입력해주세요 : ";

    private final Player player;
    private final List<Integer> answer;

    public Game(Player player, List<Integer> answer) {
        this.player = player;
        this.answer = answer;
    }

    public void start() {
        System.out.println(START_GAME_COMMENT);
        play();

    }

    public void play() {
        System.out.println(INPUT_NUMBER_COMMENT);
        List<Integer> playerNumbers = player.loadListOf3Number();

        int duplicateCount = countDuplicateIntegers(playerNumbers, answer);
        int strike = countStrike(playerNumbers, answer);
        int ball = duplicateCount - strike;
    }


    private int countDuplicateIntegers(List<Integer> playerNumbers, List<Integer> answer) {
        int ball = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (answer.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private int countStrike(List<Integer> playerNumbers, List<Integer> answer) {
        int strike = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (answer.get(i) == playerNumbers.get(i)) {
                strike++;
            }
        }
        return strike;
    }

}
