package baseball.Model;

public class NumberModel {
    private Integer firstNumber;
    private Integer secondNumber;
    private Integer thirdNumber;

    public NumberModel(Integer firstNumber, Integer secondNumber, Integer thirdNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    public Integer getFirstNumber(){
        return firstNumber;
    }
    public Integer getSecondNumber(){
        return secondNumber;
    }
    public Integer getThirdNumber(){
        return thirdNumber;
    }


}
