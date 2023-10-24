package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean isStart = true;     //게임 시작 여부
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            boolean isCorrect = false;      //정답 여부

            List<Integer> computer = new ArrayList<>();     // 컴퓨터 3자리 랜덤수 생성
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            do {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNum = Console.readLine();

                int len = (int)(Math.log10(Integer.parseInt(inputNum)) + 1);
                if(len != 3)
                    throw  new IllegalArgumentException("");

                List<Integer> num = new ArrayList<>();
                num.add(Integer.parseInt(inputNum.split("")[0]));
                num.add(Integer.parseInt(inputNum.split("")[1]));
                num.add(Integer.parseInt(inputNum.split("")[2]));

                int strike = strike(computer, num);     //스트라이크 개수
                int ball = ball(computer, num);         //볼 개수

                printStr(ball, strike, 0);

                if(strike == 3) isCorrect = true;       //정답인 경우

            } while(!isCorrect);        //정답을 맞출 때까지 추측

            printStr(0, 0, 1);

            int newStart = Integer.parseInt(Console.readLine());

            if(newStart != 1 && newStart != 2)
                throw new IllegalArgumentException("");

            isStart = (newStart != 2) ? true : false;

        } while(isStart);
    }

    public static int strike(List<Integer> computer, List<Integer> num){
        int sum = 0;

        for(int i = 0; i < 3; i++){
            if(computer.get(i).equals(num.get(i)))
                sum++;
        }

        return sum;
    }

    public static int ball(List<Integer> computer, List<Integer> num){
        int sum = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == j)
                    continue;
                if(computer.get(i).equals(num.get(j)))
                    sum++;
            }
        }

        return sum;
    }

    public static void printStr(int ball, int strike, int answer){
        String str = "";

        switch (answer){
            case 0:
                str = (ball > 0) ? ball + "볼 " : "";
                str += (strike > 0) ? strike + "스트라이크" : "";
                str = (str.isEmpty()) ? "낫싱" : str;
                break;
            case 1:
                str = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
                str += "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
                break;
        }

        System.out.println(str);
    }
}



