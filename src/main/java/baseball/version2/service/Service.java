package baseball.version2.service;


import static baseball.version2.constants.Value.ANSWER_ARRAY_SIZE;
import static baseball.version2.constants.Value.RANGE_END_NUMBER;
import static baseball.version2.constants.Value.RANGE_START_NUMBER;

import baseball.version2.dto.ComputerAnswerDto;
import baseball.version2.dto.PlayerAnswerDto;
import baseball.version2.dto.ScoreDto;
import baseball.version2.object.Score;
import baseball.version2.tools.Converter;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Service {
    private static int[] computerAnswer;
    private final Converter converter;

    public Service() {
        this.converter = new Converter();
    }

    public ComputerAnswerDto getComputerAnswer() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        ComputerAnswerDto computerAnswerDto = new ComputerAnswerDto();

        while (randomNumbers.size() < ANSWER_ARRAY_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_START_NUMBER, RANGE_END_NUMBER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        int[] convertedAnswer = converter.convertListToArray(randomNumbers);

        computerAnswerDto.setAnswer(convertedAnswer);
        return computerAnswerDto;
    }

    public Score compareTwoAnswer(PlayerAnswerDto playerAnswerDto, ComputerAnswerDto computerAnswerDto) {
        this.computerAnswer = computerAnswerDto.getAnswer();
        int[] playerAnswer = playerAnswerDto.getAnswer();
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < ANSWER_ARRAY_SIZE; i++) {
            ScoreDto scoreDto = checkPlayerValueAndComputerAnswer(playerAnswer, i);
            ball += scoreDto.getBall();
            strike += scoreDto.getStrike();
        }
        return new Score(ball, strike);
    }

    private ScoreDto checkPlayerValueAndComputerAnswer(int[] playerAnswer, int i) {
        ScoreDto scoreDto = new ScoreDto();

        for (int j = 0; j < ANSWER_ARRAY_SIZE; j++) {
            if (playerAnswer[i] == computerAnswer[j] && i == j) {
                scoreDto.setStrike(scoreDto.getStrike() + 1);
            }
            if (playerAnswer[i] == computerAnswer[j] && i != j) {
                scoreDto.setBall(scoreDto.getBall() + 1);
            }
        }
        return scoreDto;
    }
}
