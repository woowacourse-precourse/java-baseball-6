package baseball.utils.viewer;

import baseball.domain.player.defender.value.BallCount;
import baseball.domain.player.defender.value.StrikeCount;

public interface Viewer {

	void print(StrikeCount strikeCount, BallCount ballCount);

	void print(String message);

	void print(GuideMessage message);
}
