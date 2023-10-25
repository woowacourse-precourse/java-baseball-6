package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String answer, trial = "";
        int restart =1;
        int strike =0, ball=0;
        char t;
        List<Integer> computer = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(restart == 1) {
            // generate random number
            computer.clear();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            answer = computer.toString().replaceAll("[^0-9]", "");

//            System.out.println(answer); // ***** for test

            // take user's trial until 3 strike
            strike = 0;
            while(strike != 3) {
                strike = 0;
                ball = 0;
                System.out.print("숫자를 입력해주세요 : ");
//                trial = Console.readLine();
                try {
                    trial = GetUserAnswer();
                }catch (IllegalArgumentException e){
                    e.printStackTrace();
                    exit(0);
                }
                // test user's trial
                for (int i = 0; i < 3; i++) {
                    t = trial.charAt(i);
//                    System.out.println(answer.indexOf(t));  // ****** for test
                    if (answer.indexOf(t) == i) {
                        strike++;
                    } else if (answer.indexOf(t) >= 0) {
                        ball++;
                    }
                }
                if (ball == 0 && strike == 0) {
                    System.out.println("낫싱");
                } else if (strike == 0) {
                    System.out.println(ball + "볼 ");
                } else if (ball == 0) {
                    System.out.println(strike + "스트라이크");
                    if (strike == 3) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    }
                } else{
                    System.out.println(ball + "볼 "+ strike + "스트라이크");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                restart = isGameRestart();
            }catch (IllegalArgumentException e){
                e.printStackTrace();
                exit(0);
            }

        }
    }
    public static String GetUserAnswer() throws IllegalArgumentException{
        String trial;
        boolean same=false;
        trial = Console.readLine();
        if(trial.charAt(0) == trial.charAt(1)) same=true;
        else if(trial.charAt(0) == trial.charAt(2)) same=true;
        else if(trial.charAt(1) == trial.charAt(2)) same=true;

//        System.out.println("==test : "+ trial.charAt(0) + "== "+ trial.contains(String.valueOf(trial.charAt(0))));
        if(trial.length() != 3 || same){
            throw new IllegalArgumentException();
        }

        return trial;
    }

    public static int isGameRestart() throws IllegalArgumentException{
        int restart;
        restart = Integer.parseInt(Console.readLine());

//        System.out.println("==test : "+ trial.charAt(0) + "== "+ trial.contains(String.valueOf(trial.charAt(0))));
        if(restart != 1 && restart != 2){
            throw new IllegalArgumentException();
        }

        return restart;
    }
}
