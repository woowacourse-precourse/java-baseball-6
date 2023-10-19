package baseball;

public class NumberCompare {

    private final int CHANCE = 3;


    public int Hit(UserNumber userNumber, ComputerNumber computerNumber){
        int result = 0;

        for(int i = 0; i < CHANCE; i++){
            if(computerNumber.getComputerNumber().indexOf(userNumber.getUserNumber().charAt(i)) != -1){
                result++;
            }
        }

        return result;
    }

    public int Strike(UserNumber userNumber, ComputerNumber computerNumber){
        int strike = 0;

        for(int i = 0; i < CHANCE; i++){
            if(computerNumber.getComputerNumber().charAt(i) == userNumber.getUserNumber().charAt(i)){
                strike++;
            }
        }

        return strike;
    }

    public boolean PrintHint(UserNumber userNumber, ComputerNumber computerNumber){
        int strike = Strike(userNumber, computerNumber);
        int ball = Hit(userNumber, computerNumber) - strike;

        if(strike == 3){
            return true;
        }

        if(ball !=0 && strike == 0){
            System.out.println(ball + "볼");
        } else if( ball != 0 && strike != 0 ) {
            System.out.println(ball + "볼" + " " +strike + "스트라이크");
        } else if( ball == 0 && strike != 0 ) {
            System.out.println(strike + "스트라이크");
        }

        return false;
    }

}
