package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String restart = "1"; //2면 재시작, 잘못 받는 경우 exception 고려

        while(restart.equals("1")){
            List<Integer> computer = new ArrayList<>();

            while(computer.size()<3){
                int randomNumber=Randoms.pickNumberInRange(1,9);
                if(!computer.contains(randomNumber)){
                    computer.add(randomNumber);
                }
            }

            List<Integer> player;

            while (true){
                player=new ArrayList<>();
                int strike=0,ball=0;

                System.out.print("숫자를 입력해주세요 : ");
                //사용자가 잘 못 입력했을때 exception 고려
                String[] input = Console.readLine().split("");

                if(input.length!=3){
                    throw new IllegalArgumentException("3글자 입력하세요");
                }

                for(String s :input){
                    try{
                        int number = Integer.parseInt(s);
                        if (number < 1 || number > 9) {
                            throw new IllegalArgumentException("1부터 9 사이의 숫자를 입력하세요");
                        }
                        if(!player.contains(number)){
                            player.add(number);
                        }
                    } catch (NumberFormatException e){
                        throw new IllegalArgumentException("올바른 숫자가 아닌 값이 입력되었습니다.");
                    }
                }

                for (int i=0;i<3;i++){
                    if(Objects.equals(computer.get(i),player.get(i))){
                        strike++;
                        continue;
                    }
                    if(computer.contains(player.get(i))){
                        ball++;
                    }
                }

                String score="";
                if(ball==0&&strike==0){
                    System.out.println("낫싱");
                    continue;
                }
                if(ball!=0) {
                    score+=ball+"볼 ";
                }
                if (strike!=0) {
                    score+=strike+"스트라이크";
                }
                System.out.println(score);
                if(strike==3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    restart=Console.readLine();
                    break;
                }
            }
            if(!restart.equals("1")&&!restart.equals("2"))
                throw new IllegalArgumentException("올바른 숫자가 아닌 값이 입력되었습니다.");
        }
    }
}
