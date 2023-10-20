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

    public boolean isSamePlace(String number,int index){
        return numbers.indexOf(number)==index;
    }

    public boolean isExistNumber(String number){
        return numbers.contains(number);
    }

    public int index(String number){
        return numbers.indexOf(number);
    }
}
