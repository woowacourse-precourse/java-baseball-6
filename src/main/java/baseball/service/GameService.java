package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.dto.response.GameResultResponse;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static baseball.common.config.GameConfig.NUMBER_SIZE;

public class GameService {
    public GameResultResponse getResult(final Computer computer, final User user) {
        List<Integer> computerNumberList = computer.getNumbers().getNumberList();
        List<Integer> userNumberList = user.getNumbers().getNumberList();

        int ballCount = getBallCount(computerNumberList, userNumberList);
        int strikeCount = 0;

        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (ballCount == 0) {
                break;
            }

            if (Objects.equals(computerNumberList.get(i), userNumberList.get(i))) {
                strikeCount++;
                ballCount--;
            }
        }

        return new GameResultResponse(ballCount, strikeCount);
    }

    private int getBallCount(final List<Integer> computerNumberList, final List<Integer> userNumberList) {
        final Set<Integer> entryNumberSet = getEntryNumberSet(userNumberList, computerNumberList);
        return userNumberList.size() + computerNumberList.size() - entryNumberSet.size();
    }

    private Set<Integer> getEntryNumberSet(final List<Integer> computerNumberList, final List<Integer> userNumberList) {
        final Set<Integer> set = new HashSet<>(userNumberList);
        set.addAll(computerNumberList);
        return set;
    }
}
