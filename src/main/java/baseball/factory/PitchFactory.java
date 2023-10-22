package baseball.factory;

import java.util.List;

import baseball.converter.ValueConverter;
import baseball.domain.Pitch;
import baseball.generator.NumberGenerator;

public class PitchFactory {
    private final NumberGenerator numberGenerator;
    private final ValueConverter converter;

    public PitchFactory(NumberGenerator numberGenerator, ValueConverter converter) {
        this.numberGenerator = numberGenerator;
        this.converter = converter;
    }

    public Pitch create() {
        return new Pitch(numberGenerator.generate());
    }

    public Pitch create(String input) {
        List<Integer> numbers = converter.convertToList(input);
        return new Pitch(numbers);
    }
}
