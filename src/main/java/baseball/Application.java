package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean coin = true;
        int strike;
        int all;

        List<Integer> computer;
        List<Integer> player;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(coin){
            computer = selectComputerNum();
            all = 0;
            strike = 0;

            while(strike != 3){
                player = inputPlayerNum();

                if(player.size() != 3){
                    throw new IllegalArgumentException();
                }

                all = countAll(computer,player);
                strike = countStrike(computer,player);

                System.out.println(Umpire(all,strike));
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            coin = onceAgain();
        }
        System.out.println("게임 종료");
    }

    public static List<Integer> selectComputerNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> inputPlayerNum(){
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();

        List<Integer> player = new ArrayList<>();

        for(String num: input.split("")){
            player.add(Integer.parseInt(num));
        }

        return player;
    }

    public static int countAll(List<Integer> computer, List<Integer> player){
        int all = 0;
        for(int i=0;i<player.size();i++){
            for(int j=0;j< computer.size();j++){
                if(computer.get(j) == player.get(i)){
                    all++;
                }
            }
        }
        return all;
    }

    public static int countStrike(List<Integer> computer,List<Integer> player){
        int strike = 0;
        for(int i=0;i< player.size();i++){
            if(computer.get(i) == player.get(i)){
                strike++;
            }
        }
        return strike;
    }

    public static String Umpire(int all, int strike){
        //하나도 못 맞힌 경우
        if(all == 0){
            return "낫싱";
        }

        //하나 이상 맞힌 경우
        String judgment = "";

        if(strike < all){
            judgment = judgment + (all - strike) + "볼";

            if(strike!=0){
                judgment = judgment + " " + strike + "스트라이크";
            }
        } else{
            judgment = strike + "스트라이크";
        }
        return judgment;
    }

    public static boolean onceAgain(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        char answer = input.charAt(0);

        if(answer == '1'){
            return true;
        }
        return false;
    }
}