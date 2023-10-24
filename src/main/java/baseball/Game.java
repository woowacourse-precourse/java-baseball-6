package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class Game {

    List<Integer> nums;

    public void play(){

        createNumbers();

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean flag = true;

        while (flag) {

            System.out.print("숫자를 입력해주세요 : ");

            String input = Console.readLine();

            if(!checkInput(input)) break;

            if (!decisionStrikeAndBall(input)) continue;

            while(true){

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String com = Console.readLine();

                if (com.equals("1")) {

                    createNumbers();
                    break;
                } else if (com.equals("2")) {

                    System.out.println("숫자 야구 게임을 종료합니다.");
                    flag = false;
                    break;
                } else {

                    System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }

    private void createNumbers(){

        nums = new ArrayList<>();

        while(nums.size() < 3){

            int tmp = Randoms.pickNumberInRange(1, 9);
            if(!nums.contains(tmp)){
                nums.add(tmp);
            }
        }
    }

    private boolean checkInput(String input){

        boolean check = true;

        String REGEX = "[1-9]+";

        if(input.length() != 3 || !input.matches(REGEX)){

            throw new IllegalArgumentException();
        }

        return check;
    }
    private boolean decisionStrikeAndBall(String input){

        int strike = 0;
        int ball = 0;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){

                int tmp = input.charAt(j) - '0';

                if(nums.get(i) == tmp){

                    if(i == j) strike++;
                    else ball++;
                }
            }
        }
        if(strike == 3){

            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            return true;
        }

        if(strike == 0 && ball == 0){

            System.out.println("낫싱");
        }

        else if(strike == 0){

            System.out.printf("%d볼\n",ball);
        }

        else if(ball == 0){

            System.out.printf("%d스트라이크\n",strike);
        }

        else{

            System.out.printf("%d볼 %d스트라이크\n",ball, strike);
        }

        return false;
    }

}
