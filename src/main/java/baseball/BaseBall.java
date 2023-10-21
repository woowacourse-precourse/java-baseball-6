package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        while(true) {
            player.clear();
            System.out.print("숫자를 입력해주세요 : ");
            String stringPlayer = Console.readLine();

            if(validationNumber(stringPlayer)) {
                // 사용자가 입력한 숫자와 정답 비교
            }
            else{
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
            }
        }
    }

    public boolean validationNumber(String stringPlayer) {
        if(stringPlayer.length() != 3)
            return false;
        for(char c : stringPlayer.toCharArray()){
            if(!Character.isDigit(c))
                return false;
        }
        return true;
    }

}