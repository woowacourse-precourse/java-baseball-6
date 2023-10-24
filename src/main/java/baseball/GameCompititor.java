package baseball;
import camp.nextstep.edu.missionutils.Randoms;
public class GameCompititor {
    private StringBuffer CompititorNumber = new StringBuffer();
    public String generateRandomNumber(){
        for (int i = 0; i < 3; i++){
            int num = Randoms.pickNumberInRange(1, 9);
            CompititorNumber = CompititorNumber.append(num);
        }
        System.out.println(CompititorNumber);
        return CompititorNumber.toString();
    }
}
