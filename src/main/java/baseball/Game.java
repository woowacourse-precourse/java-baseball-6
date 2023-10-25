package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static baseball.CreateAnswer.messageUtil;

public class Game {
    public static List<Integer> CreateComputerNumber(){

        List<Integer> computer = new ArrayList<>();

        while(computer.size()<3)
        {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }

        }
        return computer;
    };




    public static List<Integer> GetUserNumber(){
        System.out.println(messageUtil.INPUT);

        List<Integer> player=new ArrayList<>();
        String input = Console.readLine();

        for(String number: input.split("")){
            player.add(Integer.parseInt(number));
        }
        return player;

    }


    public static int CountAll(List<Integer> computer, List<Integer> player){

        int total = 0;
        for(int i = 0; i < player.size(); i++){
            if(computer.contains(player.get(i))){
                total += 1;
            }
        }
        return total;
    }


    public static int CountStrike(List<Integer> computer, List<Integer> player){

        int strike = 0;
        for(int i = 0; i < 3; i ++){

            if(computer.get(i)==player.get(i)){
                System.out.println(strike);
                strike+=1;
            }
        }

        return strike;
    }
    public  static boolean ReplayChoice(){

        System.out.println(messageUtil.RESTART);
        Scanner scanner  = new Scanner(System.in);
        String input = Console.readLine();;

        if(input=="1"){
            return true;
        }else{
            return false;
        }

    }

    public static String createAnswer(List<Integer> computer, List<Integer> player){


        int total = CountAll(computer, player);
        int strike = CountStrike(computer,player);
        int ball = CountAll(computer, player) - strike;

        if(total == 0){
            return "낫싱";
        }else if(strike == 0){
            return ball + "볼";
        }else if(ball == 0){
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";

    }

    public static void run() {
        try {




        boolean replay = true;

        while (replay) {

            List<Integer> computer = CreateComputerNumber();
            System.out.println(computer);

            String answer = " ";
            while(!answer.equals("3스트라이크")){

                answer = createAnswer(computer,  GetUserNumber());
                System.out.println(answer);
            }

            System.out.println(messageUtil.END);

            replay = ReplayChoice();



        }


        }
        catch (IllegalArgumentException exception) {

        }catch (Exception exception) {

        }

    }

}
