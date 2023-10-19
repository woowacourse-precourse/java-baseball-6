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
            boolean isCorrect = false;      //정답여부

            // 컴퓨터 3자리 랜덤수 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            do {
                // 추측 수 입력
                System.out.print("숫자를 입력해주세요 : ");
                int inputNum = Integer.parseInt(Console.readLine());

                //예외처리(3자리가 아닌 경우)
                int len = (int)(Math.log10(inputNum) + 1);
                if(len != 3)
                    throw new IllegalArgumentException("");

                //리스트로 변환(자리수 별로 각 인덱스에 입력)
                ArrayList<Integer> num = new ArrayList<>();
                int n1 = inputNum % 100;
                int n2 = n1 % 10;
                num.add(inputNum / 100);
                num.add(n1 / 10);
                num.add(n2);

                int strike = strike(computer, num);     //스트라이크 개수
                int ball = ball(computer, num);         //볼 개수

                String str = "";
                str = (ball > 0) ? ball + "볼 " : "";
                str += (strike > 0) ? strike + "스트라이크" : "";
                str = (str.isEmpty()) ? "낫싱" : str;

                System.out.println(str);

                if(strike == 3) isCorrect = true;       //정답인 경우

            } while(!isCorrect);        //정답을 맞출 때까지 추측

            String str = "";
            str = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            str += "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
            System.out.println(str);

            int newStart = Integer.parseInt(Console.readLine());

            //예외처리(입력값이 1이나 2가 아닌 경우)
            if(newStart != 1 && newStart != 2)
                throw new IllegalArgumentException("");

            switch (newStart) {
                case 1:     //재시작
                    isStart = true;
                    break;
                case 2:     //중단
                    isStart = false;
                    break;
            }
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
}



