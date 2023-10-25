package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static int Gamestart(){ //게임이 시작되면 컴퓨터가 랜덤으로 세 가지의 수를 리스트에 저장
        System.out.println("숫자야구 게임을 시작합니다.");
        ArrayList<Integer> Correct = new ArrayList<>();
        while (Correct.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Correct.contains(randomNumber)) {
                Correct.add(randomNumber);
            }
        }
        Check(Correct);//정답이 되는 수를 가지고 Check함수로 이동
        return 0;
    }
    //사용자에게 숫자를 입력받아 숫자야구 규칙에 맞게 적용
    private static int Check(ArrayList<Integer> Correct){
        System.out.println("숫자를 입력해주세요");
        int UserInput = UserInput(); //입력예외처리를 위한 함수
        List<Integer> UserList = Numbersplit(UserInput); //입력값이 제대로 되었으면 LIST에 3자리의 숫자를 나눠서 넣는 함수
        int Strike = 0;
        int Ball = 0;
        for(int i = 0;i<3;i++){
            for(int j=0; j<3; j++){
                if (Correct.get(i).equals(UserList.get(j))&&i==j) {
                    Strike +=1;
                }
                if (Correct.get(i).equals(UserList.get(j)) &&i!=j) {
                    Ball += 1;
                }
            }
        }
        //점수에 따른 출력
        if (Strike==3) {
            System.out.println(Strike+"스트라이크");
            return restart();}
        if (Strike ==0 &&Ball!=0) System.out.println(Ball+"볼");
        if (Strike!=0&& Ball == 0) System.out.println(Strike+"스트라이크");
        if (Strike!=0&& Ball !=0) System.out.println(Ball+"볼"+" "+Strike+"스트라이크");
        if (Strike==0 && Ball==0) System.out.println("낫싱");
        return Check(Correct);
    }
    //입력받은 숫자 3자리를 각각 리스트 하나씩 넣는 함수
    private  static List<Integer> Numbersplit(int UserInput){
        List<Integer>UserList = new ArrayList<>();
        while (UserInput >0 ) {
            int split = UserInput%10;
            UserList.add(0,split);
            UserInput/=10;
        }
        return UserList;
    }
    //사용자의 입력을 받을 때 유효성 확인을 하는 함수
    private static int UserInput(){
        String UserInputString = Console.readLine();
        try {
            if(UserInputString.length() !=3) { //숫자가 3자리가 아닌경우
                throw new IllegalArgumentException("유효하지 않은 수 입니다..");
            }
            return Integer.parseInt(UserInputString);
        }

        catch (NumberFormatException ex) { //숫자가 아닌경우
            throw new IllegalArgumentException("유효하지 않은 수입니다.",ex);
        }
    }
    //게임 종료
    private static int restart(){
        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료\n");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String UserRestart = Console.readLine();
        int UserRestartInput = Integer.parseInt(UserRestart);
        if (UserRestartInput==1) return Gamestart();
        if (UserRestartInput==2) return(0);
        return 0;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Gamestart();
    }
}
