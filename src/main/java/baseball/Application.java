package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void ValidityCheck(String playerInputString){
        String REGEX = "[0-9]+";
        if (playerInputString.length() > 3)
            throw new IllegalArgumentException();
        if (!playerInputString.matches(REGEX))
            throw new IllegalArgumentException();
    }

    // 플레이어에게 숫자를 입력받아 ball, strike 체크
    public static ArrayList<Integer> NumberCheck(List<Integer> computer){
        ArrayList<Integer> StrikeBallList = new ArrayList<Integer>();
        StrikeBallList.add(0);
        StrikeBallList.add(0);
        
        // 플레이어에게 숫자 입력 요청
        System.out.print("숫자를 입력해주세요 : ");
        String playerInputString = Console.readLine();
        ValidityCheck(playerInputString);

        for(int i=0; i<computer.size(); i++){
            if(computer.contains(Character.getNumericValue(playerInputString.charAt(i)))){
                StrikeBallList.set(1, StrikeBallList.get(1)+1);
            }
        }
        for(int i=0; i<computer.size(); i++){
            if(computer.get(i) == Character.getNumericValue(playerInputString.charAt(i))){
                StrikeBallList.set(0, StrikeBallList.get(0)+1);
                StrikeBallList.set(1, StrikeBallList.get(1)-1);
            }
        }
        return StrikeBallList;
    }

    public static int GameStart(int gameCoin) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }   
    
        // StrikeBallList =  ArrayList<Integer>(strike, ball)
        ArrayList<Integer> StrikeBallList = new ArrayList<Integer>();

        while (true){
            StrikeBallList = NumberCheck(computer);
            if (StrikeBallList.get(0) == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }else if (StrikeBallList.get(0) == 0){
                if (StrikeBallList.get(1) == 0){
                    System.out.println("낫싱");
                }else{
                    System.out.println(StrikeBallList.get(1)+"볼");
                }
            }else{
                if (StrikeBallList.get(1) != 0){
                    System.out.println(StrikeBallList.get(1)+"볼 " + StrikeBallList.get(0) + "스트라이크");
                }else{
                    System.out.println(StrikeBallList.get(0)+"스트라이크");
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        gameCoin = sc.nextInt();
        return gameCoin;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int gameCoin = 1;

        while(gameCoin == 1){
            gameCoin = GameStart(gameCoin);
        }
        
    }

}