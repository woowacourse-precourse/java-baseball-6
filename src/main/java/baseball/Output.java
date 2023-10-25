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

    public void printGameEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
