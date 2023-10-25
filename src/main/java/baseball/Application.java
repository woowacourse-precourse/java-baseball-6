package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        boolean play = true;

        while (play){
            //컴퓨터 랜덤 숫자 뽑기 및 리스트에 담기
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNum = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNum)) {
                    computer.add(randomNum);
                    System.out.println(computer);
                }
            }

            //플레이어 숫자 입력 받기
            List<Integer> player = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            String playerNum = Console.readLine();

            //플레이어에게 받은 값이 잘못된 값일 경우
            try{
                if (playerNum.length() != 3){
                    throw new IllegalAccessException();
                }
            } catch (IllegalAccessException e){
                System.out.println("3자리 숫자를 입력해주세요.");
                play = false;
            }

        }
    }
}
