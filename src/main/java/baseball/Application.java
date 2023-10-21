package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        IsNumber isNumber = new IsNumber();
        CompareNumber compareNumber = new CompareNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // 컴퓨터 인풋
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            for (int computernum:computer
            ) {
                System.out.print(computernum);
            }
            System.out.println("");

            while(true){
                // 유저 인풋 그리고 숫자,길이 판별 그리고 변환
                System.out.println("숫자를 입력해주세요");
                String numString = Console.readLine();

                Boolean bo = isNumber.isNum(numString);
                if (!bo) {
                    throw new IllegalArgumentException();
                }// 문자, 길이 판별후 예외

                List<Integer> user = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    user.add(Character.getNumericValue(numString.charAt(i)));
                }// 숫자 변환

                // 판별하기
                int[] strikeBall = compareNumber.compareNumber(computer, user);

                if(strikeBall[0]!=3){
                    if(strikeBall[0]==0 && strikeBall[1] != 0){
                        System.out.println(strikeBall[1]+"볼");
                    }else if(strikeBall[0]==0 && strikeBall[1]==0){
                        System.out.println("낫싱");
                    }else{
                        System.out.println(strikeBall[1]+"볼 "+strikeBall[0]+"스트라이크");
                    }
                }else{
                    System.out.println("3스트라이크\n"
                        + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;

                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String num = Console.readLine();
            if(num.equals("1")){
            }else if(num.equals("2")){
                break;
            }else{
                throw new IllegalArgumentException();
            }
        }


    }
}
