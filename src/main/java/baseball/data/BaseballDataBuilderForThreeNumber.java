package baseball.data;

import baseball.util.IRandomValueGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseballDataBuilderForThreeNumber implements IBaseballDataBuilder<Integer> {

    private final IRandomValueGenerator<Integer> randomValueGenerator;

    public BaseballDataBuilderForThreeNumber(IRandomValueGenerator<Integer> randomValueGenerator
    ) {
        this.randomValueGenerator = randomValueGenerator;
    }

    @Override
    public IBaseballData<Integer> createComputerData() {

        if (randomValueGenerator instanceof BaseballDataUsingThreeNumber) {
            throw new IllegalArgumentException();
        }

        int LENGTH_OF_NUMBER = 3;

        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < LENGTH_OF_NUMBER) {
            int randomNumber = this.randomValueGenerator.generate();
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        StringBuilder numberString = new StringBuilder();

        for (int digit : randomNumbers) {
            numberString.append(digit);
        }

        int number = Integer.parseInt(numberString.toString());

        return new BaseballDataUsingThreeNumber(number);
    }

    @Override
    public IBaseballData createUserData(String userInput) {
        String regex = "^[1-9]{3}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        return new BaseballDataUsingThreeNumber(Integer.parseInt(userInput));
    }

}
