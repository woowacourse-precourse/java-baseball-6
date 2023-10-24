package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        boolean end = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(end){
            
            List<Integer> computer = new ArrayList<>();
            while(computer.size() < 3){
                int randomNum = Randoms.pickNumberInRange(1,9);
                if(!computer.contains(randomNum)){
                    computer.add(randomNum);
                }
            }
            String ques = "";
            for(int i = 0 ; i < computer.size() ; i++){
                ques += computer.get(i);
            }
            System.out.println("숫자를 이볅해주세요 : ");
            String userInput = Console.readLine();

            while(!ques.equals(userInput)){
                int st = 0;
                int ba = 0;
                try{
                    int number = Integer.parseInt(userInput);
                    if(userInput.length() != 3){
                        throw new IllegalAccessException();
                    }
                }catch (Exception e){
                    throw new IllegalArgumentException();
                }

                for (int i = 0; i < computer.size(); i++){
                    if(ques.charAt(i) == userInput.charAt(i)){
                        st += 1;
                    }
                    for (int j =0 ; j < userInput.length() ; j++){
                        if(i!=j && ques.charAt(i) == userInput.charAt(j)){
                            ba += 1;
                        }
                    }
                }
                if (st != 0 && ba != 0) System.out.println(ba + "볼 " + st + "스트라이크");
                else if (st != 0) System.out.println(st + "스트라이크");
                else if (ba != 0) System.out.println(ba + "볼");
                else if (st == 0 && ba == 0) System.out.println("낫싱");
                System.out.println("숫자를 입력해주세요 : ");
                userInput = Console.readLine();
            }

            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String branch = Console.readLine();
            if (branch.equals("1")) end = true;
            else if (branch.equals("2")) end = !end;
        }
    }
}