package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

//사용자 입력
public class UserInput {
    public static int insert(){

        System.out.print("숫자를 입력해주세요 : ");
        String num=readLine();
        catchException(num);
        return Integer.parseInt(num);
    }
    public static int reGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String num=readLine();
        return Integer.parseInt(num);
    }
    public static void catchException(String num){
        lengthException(num);
        zeroException(num);
        notNumberException(num);
        duplicateException(num);
    }
    public static void lengthException(String num){
        if(num.length()!=3){
            throw new IllegalArgumentException("3개의 숫자를 입력하세요.");
        }
    }
    public static void zeroException(String num){
        if(num.contains("0")){
            throw new IllegalArgumentException("1~9 사이의 숫자만 입력 가능합니다.");
        }
    }
    public static void notNumberException(String num){
        try{
            Integer.parseInt(num);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
    public static void duplicateException(String num){
        for (int i = 0; i < num.length(); i++) {
            char currentChar = num.charAt(i);
            for (int j = i + 1; j <num.length(); j++) {
                if (currentChar == num.charAt(j)) {
                    throw new IllegalArgumentException("중복된 숫자가 존재합니다");
                }
            }
        }
    }
}
