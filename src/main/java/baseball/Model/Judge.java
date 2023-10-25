package baseball.Model;


import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    public static Result compareNumber(Number standard, Number player) {
        if (standard.checkStrike(player)) {
            return Result.STRIKE;
        } else if (standard.checkBall(player)) {
            return Result.BALL;
        }
        return Result.NOTHING;
    }

    public static List<Result> compareNumbers(List<Number> standards, List<Number> players) {
        return standards.stream()
                .map(standard -> {
                    return players.stream()
                            .map(player -> compareNumber(standard, player))
                            .filter(result -> result == Result.STRIKE || result == Result.BALL)
                            .findFirst()
                            .orElse(Result.NOTHING);
                })
                .collect(Collectors.toList());
    }
}
