package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        List<Integer> computer_number;
        List<Integer> player_number;
        String input_player_number;
        int strike_count;
        int ball_count;
        int tmp;
        
        //(1)
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            //(2)
            computer_number = getComputerNumber();
            while(true){
                strike_count = 0;
                ball_count = 0;
                //(3)
                System.out.print("숫자를 입력해주세요 : ");
                input_player_number = Console.readLine();
                
                //input_player_number -> player_number (string -> List<Integer>)
                try {
                    tmp = Integer.parseInt(input_player_number);
                    player_number = changePlayerNumStrToList(input_player_number);
                } catch (Exception e) {
                    throw new IllegalArgumentException();
                }
                
                //(4)
                //strike counting and answer check
                strike_count = strikeJudgment(computer_number, player_number);
                if (strike_count == 3){
                    break;
                }

                //ball counting
                List<Integer> computer_number_copy = new ArrayList<Integer>(computer_number);
                ball_count = ballJudgment(computer_number_copy, player_number);
                ball_count -= strike_count;

                //(5)
                //print result
                printResult(ball_count, strike_count);
                //(6)
            }
            //(7)
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input_player_number = Console.readLine();
            try {
                tmp = Integer.parseInt(input_player_number);
                if(tmp == 1){
                    continue;
                }else if(tmp == 2){
                    break;
                }else{
                    throw new Exception();
                }
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }


    }


    private static List<Integer> getComputerNumber(){
        List<Integer> computer_number = new ArrayList<>();
        while (computer_number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer_number.contains(randomNumber)) {
                computer_number.add(randomNumber);
            }
        }
        return computer_number;
    }

    private static List<Integer> changePlayerNumStrToList(String input_player_number) throws IllegalArgumentException{
        List<Integer> player_number;

        if(input_player_number.length() != 3){
            throw new IllegalArgumentException();
        }

        player_number = Arrays.stream(input_player_number.split("")).map(Integer::parseInt).collect(Collectors.toList());
        return player_number;
    }

    private static int strikeJudgment(List<Integer> computer_number, List<Integer> player_number){
        int strike_count = 0;
        for (int i=0; i < computer_number.size(); i++){
            if (player_number.get(i) == computer_number.get(i)){
                strike_count++;
            }
        }
        
        return strike_count;
    }

    private static int ballJudgment(List<Integer> computer_number, List<Integer> player_number){
        int ball_count = 0;
        Collections.sort(computer_number);
        Collections.sort(player_number);
        int player_idx = 0;
        int computer_idx = 0;
        while(player_idx < player_number.size() && computer_idx < computer_number.size()){
            if(player_number.get(player_idx) == computer_number.get(computer_idx)){
                ball_count++;
                player_idx++;
                computer_idx++;
                continue;
            }
            if(player_number.get(player_idx) < computer_number.get(computer_idx)){
                player_idx++;
            }
            else{
                computer_idx++;
            }
        }

        return ball_count;
    }

    private static void printResult(int ball_count, int strike_count){
        String result_string = "";

        if (ball_count != 0){
            result_string += Integer.toString(ball_count) + "볼 " ;
        }
        if(strike_count != 0){
            result_string += Integer.toString(strike_count) + "스트라이크";
        }

        if(result_string.equals("")){
            result_string = "낫싱";
        }
        
        System.out.println(result_string);
    }
}
