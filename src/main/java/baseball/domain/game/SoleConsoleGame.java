package baseball.domain.game;

import baseball.domain.player.attacker.Attacker;
import baseball.domain.player.defender.Defender;
import baseball.domain.player.defender.value.Results;
import baseball.domain.player.value.Balls;
import baseball.initializer.GameFactory;
import baseball.support.generator.BallGenerator;
import baseball.support.generator.RandomBallsGenerator;
import baseball.utils.input.Selector;
import baseball.utils.viewer.Viewer;
import java.util.List;

public class SoleConsoleGame extends SoleGame {

	private final Defender defender;
	private final Attacker attacker;

	public SoleConsoleGame(Selector selector, Viewer viewer, Defender defender, Attacker attacker) {
		super(selector, viewer);
		this.defender = defender;
		this.attacker = attacker;
	}

	public SoleConsoleGame(GameFactory factory, Defender defender, Attacker attacker) {
		this(factory.getSelector(), factory.getViewer(), defender, attacker);
	}

	@Override
	protected void initializeDefender() {
		Long ballSize = getSelectorSize();
		defender.initialize(RandomBallsGenerator.generate(ballSize));
	}

	@Override
	protected Balls getBalls() {
		Selector selector = getSelector();
		List<Long> numbers = selector.selectNumbers();
		attacker.initialize(BallGenerator.generate(numbers));
		return attacker.attack();
	}

	@Override
	protected Results play(Balls balls) {
		return defender.defend(balls);
	}
}
