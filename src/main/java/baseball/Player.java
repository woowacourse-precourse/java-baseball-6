package baseball;

import baseball.validator.PlayerProposalValidator;

import java.util.List;
import java.util.stream.IntStream;

public class Player {

    private final List<Integer> proposal;

    public Player(String input) {
        this.proposal = List.of(
                input.charAt(0)-'0',
                input.charAt(1)-'0',
                input.charAt(2)-'0');
    }

    public List<Integer> getProposal() {
        return proposal;
    }
}
