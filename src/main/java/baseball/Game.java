package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private boolean exit = false;
    public void play(){
        while(!exit){
            game();
            if(!(not_exit())){
                exit = true;
            }
        }
    }

    public void game(){
        NumberGroup comBalls;
        NumberGroup userBalls;
        Compare compare;

        comBalls = NumberGroup.com_num();
        do{
            userBalls = NumberGroup.user_num(Input_user_num());
            compare = Compare.compare(comBalls, userBalls);

            printCompare(compare);
        } while(!compare.success());
    }

    public String Input_user_num(){
        return Console.readLine();
    }

    private void printCompare(Compare compare) {
        System.out.println(compare.Output());
    }

    public boolean not_exit(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String str_choice = Console.readLine();

        //TODO : 예외처리 작업 -> str_choice가 1또는 2가 아닐때, str_choce의 size가 1이 아닐 때, 숫자가 아닐 때;
        Error.is_Not_number(str_choice);

        int choice = Integer.parseInt(str_choice);
        Error.exit_error_check(choice);

        return choice == 1;
    }
}
