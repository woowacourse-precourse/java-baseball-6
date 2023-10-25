package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static int mode = 1;
    //define variables
    private int[] computer = new int[3];
    private int[] user = new int[3];
    private int[] item = new int[2];
    public void Application(){
        com3Digit(this);
        System.out.println(this.computer[0] + this.computer[1] + this.computer[2]);
    }
    public static void start(){
        //create an instance for one game
        Application app = new Application();
//        while(item[0]<3){
//
//        }
    }
    public void com3Digit(Application app){
        for(int i=0; i<app.computer.length; i++){
            //save the random value range of 1-9
            app.computer[i] = Randoms.pickNumberInRange(1, 9);
        }
    }
    public static void main(String[] args) {
        while(mode==1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            start();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            mode = Integer.parseInt(Console.readLine());
        }
    }
}
