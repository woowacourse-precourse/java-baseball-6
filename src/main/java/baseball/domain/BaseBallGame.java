package baseball.domain;

public interface BaseBallGame {

    BaseBallHint checkBaseBallNumber(AnswerNumbers baseBallNumber);

    AnswerNumbers getAnswerOf(Player player);
}
