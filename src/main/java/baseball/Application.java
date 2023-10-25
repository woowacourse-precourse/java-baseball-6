package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        /*
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        * */
        boolean keep_going=true;
        while(keep_going){
            List<Integer> computer=new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            int strike=0;
            int ball=0;
            System.out.println("숫자 야구 게임을 시작합니다.");
            String line;
            while(strike!=3){
                strike=0;
                ball=0;
                System.out.print("숫자를 입력해주세요: ");
                line=Console.readLine();
                if (!isValidInput(line)) {// 입력된 문자열이 3자리 숫자인지 확인
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
                else {
                    for (int i = 0; i < 3; i++) {
                        char digitChar = line.charAt(i);
                        int digit = Character.getNumericValue(digitChar);
                        for (int j = 0; j < 3; j++) {
                            if (digit == computer.get(j)) {
                                if (i == j) {//숫자와 자릿수가 모두 같으면 strike
                                    strike++;
                                } else {//숫자만 같은 경우 ball
                                    ball++;
                                }
                            }
                        }
                    }
                    if (ball + strike == 0) {
                        System.out.println("낫싱");
                    } else {
                        System.out.println(ball + "볼 " + strike + "스트라이크");
                    }

                }

            }
            //다 맞은 경우 밖으로 나오게 됨.
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart=Console.readLine();
            if(restart.equals("1")){
                System.out.println("restart");
            }
            else{
                System.out.println("finish");
                keep_going=false;
            }
        }

    }
    private static boolean isValidInput(String input) {
        if(input.matches("\\d{3}")){//숫자이면서 3자리수여야함
            if(input.contains("0")){//0포함하면 안됨
                return false;
            }
            else{
                for (int i = 0; i < input.length(); i++) {
                    for (int j = i + 1; j < input.length(); j++) {
                        if(input.charAt(i) == input.charAt(j)) {
                            return false; // 중복된 숫자가 있음
                        }
                    }
                }
            }
        }else{
            return false;
        }
        return true;
    }
}
