package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Number makeNumbers = new Number();
        List<Integer> computer = makeNumbers.makeRandomNumbers();

    }
}
/**
 * Number 클래스 처음 숫자를 만들어 냄 (완료)
 * Computer 클래스 입력받은 숫자로 strike, ball 판단 (완료)
 * Game 클래스 stirke, ball 가지고 게임의 완료 여부
 * Input 클래스 게임의 진행을 위해 입출력을 담당
 * Exception 클래스 예외를 담당하는 클래스
 */
class Number{
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;

    public List<Integer> makeRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
class Computer{
    private int strike = 0;
    private int ball = 0;
    public int[] count(List<Integer> computer, List<Integer> player){
        Number randNums = new Number();

        for(int i=0; i<player.size(); i++){
            int target = player.get(i);
            for(int j=0; j<computer.size(); j++){
                int checking = computer.get(j);
                if(i == j && target == checking){
                    // 숫자도 맞고 자릿수도 맞고
                    strike++;
                } else if (i != j && target == checking) {
                    // 숫자는 맞는데 자릿수가 안맞아
                    ball++;
                }
            }
        }
        int[] sb = {strike, ball};
        System.out.println(Arrays.toString(sb));
        return sb;
    }
}

