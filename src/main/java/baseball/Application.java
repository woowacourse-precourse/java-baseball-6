package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");
        while(true){
            List<Integer> randoms = new ArrayList<>();
            while (randoms.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!randoms.contains(randomNumber)) {
                    randoms.add(randomNumber);
                }
            }
            while(true){
                System.out.print("숫자를 입력하세요 : ");
                int input = 0;
                try{
                    input = Integer.parseInt(Console.readLine());
                } catch(NumberFormatException e){
                    throw new IllegalArgumentException(e);
                }
                validateNumber(input);

                List<Integer> inputs = new ArrayList<>();
                for(int c=100;c!=0;c/=10){
                    inputs.add((input%(c*10))/c);
                }

                if(compareTwoNumber(randoms, inputs))
                    break;
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int input = 0;
            try{
                input = Integer.parseInt(Console.readLine());
            } catch(NumberFormatException e){
                throw new IllegalArgumentException(e);
            }

            if(input == 2){
                break;
            } else if(input != 1){
                throw new IllegalArgumentException();
            }

        }
    }

    public static void validateNumber(int input){
        if(input <= 0)
            throw new IllegalArgumentException();
        if(input >= 1000)
            throw new IllegalArgumentException();

        int firstN = input/100;
        int secondN = (input%100)/10;
        int thirdN = input%10;

        if(firstN == secondN)
            throw new IllegalArgumentException();
        if(firstN == thirdN)
            throw new IllegalArgumentException();
        if(thirdN == secondN)
            throw new IllegalArgumentException();

        if(firstN == 0)
            throw new IllegalArgumentException();
        if(secondN == 0)
            throw new IllegalArgumentException();
        if(thirdN == 0)
            throw new IllegalArgumentException();
    }

    // if two numbers are same, return true
    private static boolean compareTwoNumber(
            List<Integer> randoms,
            List<Integer> inputs) {
        int cntStrike = 0;
        int cntBall = 0;
        for(int i=0;i<3;i++){
            if(randoms.get(i) == inputs.get(i)) cntStrike++;
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==j) continue;
                if(randoms.get(i) == inputs.get(j)) cntBall++;
            }
        }

        if(cntBall > 0)
            System.out.print(cntBall + "볼 ");
        if(cntStrike > 0)
            System.out.print(cntStrike + "스트라이크");
        if(cntBall == 0 && cntStrike == 0)
            System.out.println("낫싱");
        else System.out.println();

        if(cntStrike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
