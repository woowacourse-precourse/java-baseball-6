package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Ball {
    private Integer numberLength = null;
    private String number = "";


    public Ball(int numberLength){
        this.numberLength = numberLength;
    }

    public String randomNumber(){
        number = "";
        while(number.length() < numberLength){
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!number.contains(Integer.toString(randomNumber))){
                number += randomNumber;
            }
        }

        return new String(number);
    }

    public void checkNumber(String inputNumbers) throws IllegalArgumentException{
        if(inputNumbers.length() != this.numberLength){
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < this.numberLength; i++){
            String checkNumber = new String(inputNumbers);

            if(!Character.isDigit(inputNumbers.charAt(i))){
                throw new IllegalArgumentException();
            }
            if(checkNumber.replace(Character.toString(inputNumbers.charAt(i)), "").length() != this.numberLength-1){
                throw new IllegalArgumentException();
            }

        }
    }


    private int getBall(String inputNumbers){
        int ballCount = 0;

        for(int i = 0; i < this.numberLength; i++){
            String tmpInputNumber = Character.toString(inputNumbers.charAt(i));
            if(this.number.contains(tmpInputNumber) && i != number.indexOf(tmpInputNumber)){
                ballCount += 1;
            }
        }

        return ballCount;
    }

    private int getStrike(String inputNumbers){
        int strikeCount = 0;

        for(int i = 0; i < this.numberLength; i++){
            if(this.number.indexOf(inputNumbers.charAt(i)) == i){
                strikeCount += 1;
            }
        }

        return strikeCount;
    }

    public boolean restartGame(int flag) throws IllegalArgumentException{
        if(flag == 1){
            randomNumber();
            return true;
        }
        else if(flag == 2){
            return false;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public String getNumbers(){
        return new String(number);
    }
}
