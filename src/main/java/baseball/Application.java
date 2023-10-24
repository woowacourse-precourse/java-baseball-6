package baseball;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        boolean flag=true;
        Computer computer=new Computer();
        while(flag) {
            newGame(computer);
            flag=askNextGame();
        }
        Console.close();

    }
    public static void newGame(Computer computer){
        boolean flag=true;
        computer.think();
        print("숫자 야구 게임을 시작합니다.\n");
        while(flag){
            GuessNumber guess=askNumber();
            flag=judge(computer, guess);
        }
    }

    public static boolean judge(Computer computer, GuessNumber guess){
        int strike=computer.countStrike(guess);
        if(strike==3){
            print("3스트라이크\n");
            print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            return false;
        }
        int ball=computer.countContains(guess) - strike;
        if(strike+ball ==0){
            print("낫싱\n");
            return true;
        }
        if(ball>0 && strike>0){
            print(String.format("%d볼 %d스트라이크\n", ball, strike));
            return true;
        }
        if(ball>0){
            print(String.format("%d볼\n",ball));
            return true;
        }
        print(String.format("%d스트라이크\n",strike));
        return true;
    }
    public static GuessNumber askNumber() throws IllegalArgumentException{
        print("숫자를 입력해주세요 : ");
        String line = Console.readLine();
        return new GuessNumber(line);
    }

    public static void print(String string){
        System.out.print(string);
    }
    public static boolean askNextGame() throws IllegalArgumentException{
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        String readline = Console.readLine();
        if(readline.equals("1")){
            return true;
        }
        if (readline.equals("2")){
            return false;
        }
        throw new IllegalArgumentException();
    }

}
