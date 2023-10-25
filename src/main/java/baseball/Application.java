package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = Integer.parseInt(Console.readLine());
            if(choice ==2){
                System.out.println("게임을 종료합니다. 감사합니다!");
                break;
            }

        }



    }
    public static void playGame(){
        List<Integer> computer = computerNumber();
        while (true){
            List<Integer> player = playerNumber();
            int strikes = countStrikes(computer, player);
            int balls = countBalls(computer, player);
            if(balls==0) {
                if (strikes == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.println(strikes + "스트라이크");
                }
            }else{
                if(strikes ==0){
                    System.out.println(balls + "볼");
                } else {
                    System.out.println(balls + "볼 " + strikes + "스트라이크");
                }
            }
            if(strikes ==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

    }
    public static List<Integer> computerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static List<Integer> playerNumber(){
        System.out.println("숫자를 입력해주세요: ");
        List<Integer> player = new ArrayList<>();
        try {
            String inputNumber = Console.readLine();
            if(inputNumber.length() != 3){
                throw new IllegalArgumentException("세 자리 숫자를 입력해주세요");
            }
            for (int i = 0; i < 3; i++) {
                int playerNumber = Character.getNumericValue(inputNumber.charAt(i));

                if (playerNumber < 1 || playerNumber > 9) {
                    throw new IllegalArgumentException("1에서 9 사이의 숫자를 입력해주세요.");
                }

                if (player.contains(playerNumber)) {
                    throw new IllegalArgumentException("세 자리 숫자는 서로 달라야 합니다.");
                }

                player.add(playerNumber);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return player;
    }
    public static int countStrikes(List<Integer> computer, List<Integer> player){
        int strikes =0;
        for (int i=0;i<3; i++){
            if (computer.get(i).equals(player.get(i))){
                strikes++;
            }
        }
        return strikes;
    }
    public static int countBalls(List<Integer> computer, List<Integer> player){
        int balls =0;
        for (int i=0; i<3; i++){
            if(!computer.get(i).equals(player.get(i))){
                for(int j=0; j<3; j++){
                    if(i!= j&& computer.get(i).equals(player.get(j))){
                        balls++;
                    }
                }
            }
        }
        return balls;
    }

}
