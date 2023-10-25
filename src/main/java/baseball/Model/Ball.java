package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Ball {
    private Integer length = null;
    private String number = "";


    public Ball(int numberLength){
        this.length = numberLength;
    }

    public String generateNumbers(){
        number = "";
        while(number.length() < length){
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!number.contains(Integer.toString(randomNumber))){
                number += randomNumber;
            }
        }

        return new String(number);
    }

    public void checkNumbers(String inputNumbers) throws IllegalArgumentException{
        if(inputNumbers.length() != this.length){
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < this.length; i++){
            String checkNumber = new String(inputNumbers);

            if(!Character.isDigit(inputNumbers.charAt(i))){
                throw new IllegalArgumentException();
            }
            if(checkNumber.replace(Character.toString(inputNumbers.charAt(i)), "").length() != this.length-1){
                throw new IllegalArgumentException();
            }

        }
    }
}
