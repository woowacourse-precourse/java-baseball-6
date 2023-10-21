package baseball.validate;

public class InputValidate {
    public void checkNumbers(String givenNumbers) {
        String[] numbers = givenNumbers.split("");
        for(String number : numbers) {
            checkNumber(number);
        }
    }

    public void checkNumber(String givenNumber) {
        try {
            Integer.parseInt(givenNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR]" + givenNumber);
        }
    }
}