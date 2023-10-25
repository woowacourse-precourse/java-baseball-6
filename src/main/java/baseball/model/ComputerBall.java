package baseball.model;

import baseball.util.RandomNumberGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class ComputerBall {

    List<Integer> computer;

    /**
     * 랜덤한 세자리 숫자 생성
     */
    public ComputerBall() {
        this.computer = RandomNumberGenerator.generateRandomNumber();
    }

    /**
     * 스트라이크 카운트
     * @param user
     */
    public int countStrike(List<Integer> user) {
        return (int) IntStream.range(0, 3)
                .filter(idx -> Objects.equals(user.get(idx), computer.get(idx)))
                .count();
    }

    /**
     * 볼 카운트
     * @param user
     */
    public int countBall(List<Integer> user) {
        return (int) IntStream.range(0, 3)
                .filter(idx -> !Objects.equals(user.get(idx), computer.get(idx)) && computer.contains(user.get(idx)))
                .count();
    }
}
