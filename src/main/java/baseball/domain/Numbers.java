package baseball.domain;

public class Numbers {
    private final String numbers;

    public Numbers(String numbers){
        Validator validator=new Validator();
        validator.validateNumbers(numbers);

        this.numbers=numbers;
    }

    public String[] splitNumbers(){
        return numbers.split("");
    }

    public int index(String number){
        return numbers.indexOf(number);
    }
}
