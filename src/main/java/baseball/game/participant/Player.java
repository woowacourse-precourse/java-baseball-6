package baseball.game.participant;

import java.util.List;

/**
 * 사용자가 추측한 답을 저장하기 위한 클래스
 */
public class Player {

    private final List<Integer> proposal;

    private Player(List<Integer> proposal) {
        this.proposal = proposal;
    }

    /**
     * 사용자가 입력한 답을 바탕으로 새로운 Player 객체를 생성한다.
     */
    public static Player create(String input) {
        List<Integer> proposal = List.of(
                input.charAt(0) - '0',
                input.charAt(1) - '0',
                input.charAt(2) - '0'
        );

        return new Player(proposal);
    }

    public List<Integer> getProposal() {
        return proposal;
    }
}
