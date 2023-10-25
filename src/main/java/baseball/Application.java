package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

public class Application{
    public static void main(String[] args){
        Service service = new Service();
        service.play();
    }
}

//public class Application {
//    static boolean continueFlag = true;
//    static Integer ballCount = 0;
//    static Integer strikeCount = 0;
//    static ArrayList<Integer> comNum = new ArrayList<Integer>();
//    static ArrayList<Integer> player = new ArrayList<Integer>();
//    static Integer count = 0;
//
//
//    public static void main(String[] args) throws IllegalArgumentException{
//
//        // TODO: 프로그램 구현
////        Game game = new Game();
////        game.play();
//
//        System.out.println("숫자야구를 시작하겠습니다.");
//        comNum = setNums();
//        while(continueFlag){
//            String userData = "";
//            System.out.print("숫자를 입력해 주세요 : ");
//            userData = inputNum();
//            isError(userData);
//            player = setUserNum(userData);
//
//
//            for(int i = 0; i < comNum.size(); i++){
//                for(int j = 0 ; j < player.size() ; j++){
//                    if(comNum.get(i).equals(player.get(j)) && i == j){
//                        strikeCount++;
//                    } else if(comNum.get(i).equals(player.get(j)) && i != j){
//                        ballCount++;
//                    }
//                }
//            }
//
//            if(strikeCount == 3){
//                System.out.println(strikeCount+"스트라이크");
//                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//                String restart = Console.readLine();
//                Exceptions.restartException(restart);
//                if(restart.equals("1")){
//                    initializeCount();
//                    comNum = setNums();
//                    continueFlag = true;
//                } else {
//                    continueFlag = false;
//                    //Console.close();
//                }
//            }
//            else {
//                if( ballCount != 0 && strikeCount != 0){
//                    System.out.println(ballCount + "볼 " + strikeCount +"스트라이크");
//                } else if(ballCount == 0 && strikeCount != 0){
//                    System.out.println(strikeCount+"스트라이크");
//                } else if(ballCount != 0 && strikeCount == 0){
//                    System.out.println(ballCount+"볼");
//                }
//                else {
//                    System.out.println("낫싱");
//                }
//                player.clear();
//                ballCount = 0;
//                strikeCount = 0;
//            }
//        }
//    }
//
//    public static ArrayList<Integer> setUserNum(String number){
//        ArrayList<Integer> numberList = new ArrayList<Integer>();
//
//        for(int i = 0 ; i < number.length(); i++){
//            numberList.add(Integer.parseInt(String.valueOf(number.charAt(i))));
//        }
//        return numberList;
//    }
//    public static void restartError(String number){
//        Exceptions.noneNumberException(number);
//        Exceptions.noneLengthException(number);
//    }
//
//    public static void isError(String number){
//        Exceptions.outOfRangeException(number);
//        Exceptions.noneNumberException(number);
//        Exceptions.noneLengthException(number);
//        Exceptions.duplicateException(number);
//    }
//    public static ArrayList<Integer> setNums(){
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        while(list.size() < 3){
//            Integer randomNum = Randoms.pickNumberInRange(1,9);
//            if(!list.contains(randomNum)){
//                list.add(randomNum);
//            }
//
//        }
//
//        return list;
//    }
//    public static String inputNum(){
//        return Console.readLine();
//    }
//
//    public static void initializeCount(){
//        ballCount = 0;
//        strikeCount = 0;
//        comNum.clear();
//        player.clear();
//    }
//
//}

