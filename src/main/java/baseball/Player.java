package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Player {

    private final List<Integer> proposal;

    public Player(List<Integer> proposal) {
        //TODO 예외처리 로직(여기다가 할지 다른데서 할지)
        this.proposal = proposal;
    }

    /**
     * 플레이어가 입력한 답이 정답과 얼마나 일치하는지 결과를 반환
     * @param computer 정답
     * @return 볼 개수(result.get(0)), 스트라이크 개수(result.get(1))를
     *         List에 담아서 반환
     */
    public List<Integer> compareToAnswer(Computer computer) {

        List<Integer> answer = computer.getAnswer();

        int strike = (int)IntStream.range(0, 3)
                .filter(i -> answer.get(i).equals(proposal.get(i)))
                .count();
        int ball = (int) IntStream.range(0, 3)
                .filter(i -> !answer.get(i).equals(proposal.get(i)) && answer.contains(proposal.get(i)))
                .count();

        return List.of(ball, strike);
    }
}
