package baseball;

import static baseball.BaseballConstants.*;

public class BaseballGame implements Game {

    private Reader reader;
    private Writer writer;
    private Validator baseballNumValidator;
    private Validator terminateValidator;
    private BaseballGameProcessor processor;
    private RandomNumberGenerator randomNumberGenerator;

    public BaseballGame(Reader reader, Writer writer, Validator baseballNumValidator,
        Validator terminateValidator, BaseballGameProcessor processor,
        RandomNumberGenerator randomNumberGenerator) {

        this.reader = reader;
        this.writer = writer;
        this.baseballNumValidator = baseballNumValidator;
        this.terminateValidator = terminateValidator;
        this.processor = processor;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public void play() {
        writer.write(START_MESSAGE);
        while (true) {
            String computerNumber = randomNumberGenerator.generateNonRepeatingRandomDigitSequence(
                BASEBALL_NUMBER_SIZE);
            playMainContent(computerNumber);
            writer.write(END_MESSAGE);
            writer.write(NEXT_GAME_MESSAGE);
            String endNumber = reader.read();
            terminateValidator.validate(endNumber);
            if (isEnd(endNumber)) {
                break;
            }
        }
    }

    private void playMainContent(String computerNumber) {
        while (true) {
            writer.write(INPUT_MESSAGE);
            String inputNumber = reader.read();
            baseballNumValidator.validate(inputNumber);
            String result = processor.process(computerNumber, inputNumber);
            writer.write(result);
            if (isAllStrike(result)) {
                break;
            }
        }
    }

    private boolean isAllStrike(String result) {
        return result.equals(ALL_STRIKE);
    }

    private boolean isEnd(String input) {
        return (Integer.parseInt(input) == END_GAME_NUMBER);
    }

}
