package baseball.service;

import static baseball.enums.NumbersEnum.*;

import baseball.domain.ComputerNumbers;
import baseball.domain.Numbers;
import baseball.domain.PlayerNumbers;
import baseball.dto.BallCountDto;
import baseball.enums.NumbersEnum;
import baseball.vo.Number;
import java.util.SimpleTimeZone;
import java.util.stream.IntStream;

public class BallCountService {

    public BallCountDto calculateBallCount(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers) {
        int strike = countStrike(playerNumbers, computerNumbers);
        int ball = countBall(playerNumbers, computerNumbers);

        return new BallCountDto(strike, ball);

    }

    private int countBall(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers) {
        return (int) IntStream.range(0, LENGTH.showValue())
                .filter(index -> {
                    Number playerNumber = playerNumbers.showNumberAt(index);
                    Number computerNumber = computerNumbers.showNumberAt(index);
                    return !playerNumber.equals(computerNumber) && computerNumbers.contains(playerNumber);
                })
                .count();
    }

    private int countStrike(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers) {
        return (int) IntStream.range(0, LENGTH.showValue())
                .filter(i -> {
                    Number playerNumber = playerNumbers.showNumberAt(i);
                    Number computerNumber = computerNumbers.showNumberAt(i);
                    return playerNumber.equals(computerNumber);
                })
                .count();
    }



}
