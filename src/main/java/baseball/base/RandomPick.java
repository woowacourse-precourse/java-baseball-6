package baseball.base;
import camp.nextstep.edu.missionutils.Randoms;
public class RandomPick {
    public static String createComputerNumbers(){
        String computerNumbers ="";
        for(int i=0;i<3;i++){
            computerNumbers += PickRandomNumber(computerNumbers);
        }
        return computerNumbers;
    }

    public static String PickRandomNumber(String computerNumbers){
        String RandomNumber =String.valueOf(Randoms.pickNumberInRange(1,9));

        while(!isUnique(RandomNumber,computerNumbers)){
            RandomNumber = String.valueOf(Randoms.pickNumberInRange(1,9));
//            System.out.println("숫자를 뽑는 중입니다.");
        }
        return RandomNumber;
    }

    public static boolean isUnique(String RandomNumber,String computerNumbers) {
        if(computerNumbers.contains(RandomNumber)){
            return false;
        }
        return true;
    }
}
