package baseball.domain;

import baseball.dto.BattedBallsDTO;
import baseball.dto.validator.BattedBallsValidator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BatterImpl implements Batter {

    private final BattedBallsValidator battedBallsValidator = new BattedBallsValidator();

    @Override
    public List<Baseball> tryBatting(BattedBallsDTO battedBallsDTO) {
        battedBallsValidator.validate(battedBallsDTO);
        return BattedBallConverter.convertToBaseballs(battedBallsDTO);
    }

    static class BattedBallConverter {

        private static List<Baseball> convertToBaseballs(BattedBallsDTO battedBallsDTO) {
            String[] battedBalls = battedBallsDTO.getBattedBalls().split("");

            return IntStream.range(0, BaseballGame.BALL_COUNT)
                    .mapToObj(ballOrder -> Baseball.of(ballOrder, Integer.parseInt(battedBalls[ballOrder])))
                    .collect(Collectors.toList());
        }
    }
}
