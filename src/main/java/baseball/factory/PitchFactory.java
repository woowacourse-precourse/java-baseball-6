package baseball.factory;

import baseball.domain.Pitch;
import baseball.generator.NumberGenerator;

public class PitchFactory {
    private final NumberGenerator numberGenerator;

    public PitchFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Pitch create() {
        return new Pitch(numberGenerator.generate());
    }
}
