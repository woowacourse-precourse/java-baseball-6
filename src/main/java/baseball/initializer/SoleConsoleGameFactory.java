package baseball.initializer;

import baseball.domain.player.attacker.Attacker;
import baseball.domain.player.attacker.ConsoleAttacker;
import baseball.domain.player.defender.Computer;
import baseball.domain.player.defender.Defender;
import baseball.utils.input.ConsoleSelector;
import baseball.utils.input.Selector;
import baseball.utils.viewer.ConsoleViewer;
import baseball.utils.viewer.Viewer;

public class SoleConsoleGameFactory implements GameFactory {

	private static final Long DEFAULT_SELECT_SIZE = 3L;

	private final Long selectSize;

	public SoleConsoleGameFactory(Long selectSize) {
		this.selectSize = selectSize;
	}

	public SoleConsoleGameFactory() {
		this(DEFAULT_SELECT_SIZE);
	}

	@Override
	public Viewer getViewer() {
		return new ConsoleViewer();
	}

	@Override
	public Selector getSelector() {
		return new ConsoleSelector(selectSize);
	}

	public Defender getDefender() {
		return new Computer();
	}

	public Attacker getAttacker() {
		return new ConsoleAttacker();
	}
}
