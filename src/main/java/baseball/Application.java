package baseball;
//import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
//import camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구를 시작합니다");
    }
}
public class Game{
    private List<Integer> number;
    public Game(){

    }
    public void run(){
        try{
            do {
                play();
            } while (reStrart() == true);
        }catch (IllegalArgumentException e){
            throw e;
        }

    }
    private void play(){
        String input;
        init();
        do{
            try{
                input = getList();
            }catch (IllegalArgumentException e){
                throw e;
            }
        }while(checkResult(input) == false);
    }
}
