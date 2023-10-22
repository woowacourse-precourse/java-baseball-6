package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //do-while문을 통해 일단 한번 실행 후 1을 입력할 때만 다시 실행
        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (Console.readLine().equals("1"));
    }

    private static void playGame(){
        List<Integer> computer=generateComputerNumbers();

        while (true){
            System.out.print("숫자를 입력해주세요 : ");
            String userInput=Console.readLine();

            //만약 입력한 수가 기준에 맞지 않다면 예외발생 후 종료해야
            if (!isValidInput(userInput)){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            //플레이어
            List<Integer> userNumbers=parseUserInput(userInput);
            int strikes=countStrikes(computer,userNumbers);
            int balls=countBalls(computer,userNumbers);

            //힌트 기능 실행부분
            if (strikes==3){
                System.out.println("3스트라이크\n"
                        + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else if (strikes>0 || balls>0) {
                System.out.println(balls+"볼"+" "+strikes+"스트라이크");
            } else{
                System.out.println("낫싱");
            }
        }
    }

    //컴퓨터는 1부터 9까지 서로 다른 수로 이루어진 3자리 수 선택
    private static List<Integer> generateComputerNumbers(){
        List<Integer> computer= new ArrayList<>();  //computer라는 이름의 정수 리스트 생성,선택한 3개 숫자 저장 용도

        while (computer.size() < 3){
            int randomNumber=Randoms.pickNumberInRange(1,9);  //1~9 사이 임의의 숫자를 randomNumber 변수에 저장
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
            }
        return computer;
        }

    private  static boolean isValidInput(String input){
        return input.matches("^[1-9]{3}$");
    }

    //사용자가 입력한 문자열을 3자리 숫자로 파싱하는 메소드
    private static List<Integer> parseUserInput(String input){
        List<Integer> numbers =new ArrayList<>();  //파싱된 숫자들을 저장하기 위해 초기화
        for(int i=0; i<3; i++) {
            numbers.add(Integer.parseInt(input.substring(i,i+1)));
        }
        return numbers;
    }
    private static int countStrikes(List<Integer> computer, List<Integer> user){
        int strikes=0;
        for (int i=0; i<3; i++){
            if(computer.get(i).equals(user.get(i))){
                strikes++;
            }
        }
        return strikes;
    }
    private static int countBalls(List<Integer> computer, List<Integer> user){
        int balls=0;
        for(int i=0; i<3;i++){
            if (!computer.get(i).equals(user.get(i))&&computer.contains(user.get(i))){
                balls++;
            }
        }
        return balls;
    }
}
