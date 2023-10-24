package baseball.game.participant;

import java.util.List;

public class Player {

    private final List<Integer> proposal;

    private Player(List<Integer> proposal) {
        this.proposal = proposal;
    }

    public static Player create(String input) {
        List<Integer> proposal = List.of(
                input.charAt(0)-'0',
                input.charAt(1)-'0',
                input.charAt(2)-'0');

        return new Player(proposal);
    }

    public List<Integer> getProposal() {
        return proposal;
    }
}
