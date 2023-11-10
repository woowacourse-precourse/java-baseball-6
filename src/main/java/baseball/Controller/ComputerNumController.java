package baseball.Controller;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class ComputerNumController {
    List<Integer> computer = new ArrayList<>(); //computer라는 List 생성
    public void computerRandom() {
        while (computer.size() < 3) {   //리스트에 들어있는 원소 수!
            int randomNumber = Randoms.pickNumberInRange(1, 9); //1~9까지의 수 랜덤으로 집어넣음
            if (!computer.contains(randomNumber)) { //중복방지
                computer.add(randomNumber);
            }
        }
    }

    List<Integer> myinput = new ArrayList<>(); //myinput이라는 List 생성

    //내가 입력한 3개의 값을 리스트에 저장
    public void myInput(){
        for (int i = 0; i < 3; i++) {
            System.out.println((i+1) + "번째 수 입력: ");
            myinput.add(Integer.valueOf(readLine()));  //입력받고 myinput 리스트에 저장
        }
    }

    //판별하기
    public void numCheck(){
//        List<Integer> matchList = computer.stream().filter()

        for (int i = 0; i < 3; i++) {
            int check = myinput.get(i);
//            if (check.)
            System.out.println(myinput.get(1));

            if (myinput.get(1) != null){
                //myinput.close();
                myinput = null;

//                private static Scanner scanner;
//
//                private Console() {
//                }
//
//                public static String readLine() {
//                    return getInstance().nextLine();
//                }
//
//                public static void close() {
//                    if (scanner != null) {
//                        scanner.close();
//                        scanner = null;
//                    }
//                }
//
//                private static Scanner getInstance() {
//                    if (scanner == null) {
//                        scanner = new Scanner(System.in);
//                    }
//                    return scanner;
//                }

            }
        }

        //만약 아니다 그럼 예외 처리 하기

    }

    public static void main(String[] args){
        ComputerNumController mainController = new ComputerNumController();
        mainController.computerRandom();


        mainController.myInput();
        mainController.numCheck();

    }

}
