package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static int mode = 1;
    //define variables
    private int[] computer = new int[3];
    private int[] user = new int[3];
    //index 0: strike, index 1: ball
    private int[] item = new int[2];
    public Application(){
        this.com3Digit();
        System.out.println(this.computer[0]+""+this.computer[1]+""+this.computer[2]);
    }
    public static void start(){
        //create an instance for one game
        Application app = new Application();
        while(app.item[0]<3){
            app.user3Digit();
            app.compDigit();
            if(app.item[0]==0 && app.item[1]==0) System.out.println("낫싱");
            else if(app.item[0]>0 && app.item[1]==0) System.out.println(app.item[0] + "스트라이크");
            else if(app.item[0]==0 && app.item[1]>0) System.out.println(app.item[1] + "볼");
            else System.out.println(app.item[1] + "볼 " + app.item[0] + "스트라이크");

            if(app.item[0]==3){
                System.out.println(app.item[0] + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
    }
    public void com3Digit(){
        for(int i=0; i<this.computer.length; i++){
            //save the random value range of 1-9
            this.computer[i] = Randoms.pickNumberInRange(1, 9);
        }
    }
    public void user3Digit(){
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        int i = 0;
        for (String s : input.split("")){
            this.user[i] = Integer.parseInt(s);
            i++;
        }
    }
    public void compDigit(){
        int strike = 0, ball = 0;
        for(int i=0; i<this.computer.length; i++){
            for(int j=0; j<this.user.length; j++){
                //If the same number is in the same spot, it's a strike
                if(i==j && this.computer[i]==this.user[j]) strike++;
                //If the number is in a different position, it is a ball
                if(i!=j && this.computer[i]==this.user[j]) ball++;
            }
        }
        this.item[0] = strike;
        this.item[1] = ball;
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
