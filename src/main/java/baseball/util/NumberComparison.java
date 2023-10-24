package baseball.util;

import baseball.model.Game;

public class NumberComparison {
    public Game compareNumber(String computer, String userInput) {
        Game game = new Game();

        // if. 3자리 수 모두 일치
        if (computer.equals(userInput)) {
            game.setStrikeCount(userInput.length());
            return game;
        }

        // TODO 수식 계산
        // 3.1 if 같은 숫자 없음 -> 낫싱
        // 3.2 if 숫자 동일, 같은 자리 -> 숫자당 1스트라이크
        // 3.3 if 숫자 동일, 다른 자리 -> 숫자당 1볼

        return game;
    }
}
