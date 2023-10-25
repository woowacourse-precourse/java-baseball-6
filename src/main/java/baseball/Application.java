package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> randNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static int isNumber(List<Integer> computerNumber, String userNumber) throws IllegalArgumentException{
        if (userNumber.length() != 3){
            // 입력된 숫자가 3개가 아닌 경우
            throw new IllegalArgumentException("사용자가 입력한 숫자의 개수가 3개가 아닙니다.");
        }

        List<Integer> userNumList = new ArrayList<>();
        for (int i=0;i<3;i++){
            int num = userNumber.charAt(i) - '0';
            if(num >= 1 && num <= 9) {
                if (!userNumList.contains(num)){
                    userNumList.add(num);
                }
                else{
                    // 중복인 경우
                    throw new IllegalArgumentException("사용자가 입력한 숫자 중 중복된 숫자가 있습니다.");
                }
            }else{
                // 숫자가 아닌 경우
                throw new IllegalArgumentException("사용자가 입력한 값에 숫자가 아닌 값이 있습니다.");
            }
        }

        int strike = 0, ball = 0;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (userNumList.get(i).equals(computerNumber.get(j))){
                    if (i == j) strike++;
                    else ball++;
                }
            }
        }
        if (ball != 0) System.out.print(ball+"볼 ");
        if (strike != 0) System.out.println(strike+"스트라이크");
        if (ball ==0 && strike == 0) System.out.println("낫싱");
        return strike;
    }

    public static void main(String[] args)  throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean game;
        do {
            List<Integer> computerNumber = randNum();
            int strike;
            do{
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();
                strike = isNumber(computerNumber, userInput);
            }while(strike != 3);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = Console.readLine();
            if (userInput.equals("1")) game = true;
            else if (userInput.equals("2")) game = false;
            else{
                throw new IllegalArgumentException("사용자가 1, 2 이외의 값을 입력했습니다.");
            }
        }while(game);
    }
}