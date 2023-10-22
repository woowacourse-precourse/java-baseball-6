package baseball.controller;

import baseball.domain.Pitch;
import baseball.factory.PitchFactory;
import baseball.ui.InputView;

public class GameController {
	private final InputView inputView;
	private final PitchFactory pitchFactory;

	public GameController(InputView inputView, PitchFactory pitchFactory) {
		this.inputView = inputView;
		this.pitchFactory = pitchFactory;
	}

	private Pitch getPlayer() {
		String input = inputView.scanNumbers();
		return pitchFactory.create(input);
	}
}