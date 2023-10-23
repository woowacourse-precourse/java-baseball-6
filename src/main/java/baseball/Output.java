package baseball;
import java.util.List;

public class Output {
    private int strike,ball;
    Output(){}

    public void setScore(List<Integer>computerNumber,String userInput){
        strike=0; ball=0;
        for (int i=0; i<userInput.length(); i++){
            int digit=Character.getNumericValue(userInput.charAt(i));
            if(digit==computerNumber.get(i)) strike++;
            else if (computerNumber.contains(digit)) ball++;
        }
    }

    public void printOutput(){
        if(strike+ball==0) {
            System.out.println("낫싱");
            return;
        }

        if(ball>0) System.out.print(ball+"볼 ");
        if(strike>0) System.out.print(strike+"스트라이크");
        System.out.println();
    }

    public boolean userWin(){
        return strike==3;
    }

}
