package baseball.validate;

public class InputValidate {
    public void checkNumbers(String givenNumbers) {
        String[] numbers = givenNumbers.split("");
        if(numbers.length > 3 || numbers.length < 0){
            throw new NumberFormatException("[ERROR] Wrong Size");
        }
        for(String number : numbers) {
            checkNumber(number);
        }
    }

    public Integer checkNumber(String givenNumber) {
        try {
            return Integer.parseInt(givenNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR]" + givenNumber);
        }
    }
}