package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        PlayBaseBall();
    }

    public static void PlayBaseBall(){
        int compNum = random();
        System.out.println(compNum);

        while(true) {
            String num = "";
            while(true) {
                num = consoleProgramming();
                if (num.length() >= 4) throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
                else break;
            }
            int insertNum = Integer.parseInt(num);

            Point pointNums = checkNums(compNum, insertNum);

            boolean isEnd = checkShing(pointNums);
            if (isEnd) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                if (Integer.parseInt(consoleProgramming()) == 2) {
                    break;
                }else
                    compNum = random();
            }
        }
    }

    public static int random(){
        return Randoms.pickNumberInRange(100, 999);
    }

    public static String consoleProgramming(){
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static Point checkNums(int compNum, int insertNum){
        List<Integer> compList = new ArrayList<>();
        List<Integer> insertList = new ArrayList<>();
        int copyComp = compNum;
        int mok = compNum;
        int rest = 0;

        int copyInsert = insertNum;
        int insertMok = insertNum;
        int insertRest = 0;

        while(mok != 0){
            mok = copyComp/10;
            rest = copyComp%10;
            copyComp = mok;
            compList.add(rest);

            insertMok = copyInsert/10;
            insertRest = copyInsert%10;
            copyInsert = insertMok;
            insertList.add(insertRest);
        }

        Point pointNums = new Point(0, 0);

        for(int i=0;i<insertList.size();i++){
            for(int j=0;j<compList.size();j++){
                if(insertList.get(i).equals(compList.get(j))){
                    if(i!=j)
                        pointNums.setBallNum(pointNums.getBallNum()+1);
                    else
                        pointNums.setStrikeNum(pointNums.getStrikeNum()+1);
                    compList.set(j, -1);
                    break;
                }
            }
        }

        return pointNums;
    }

    public static boolean checkShing(Point pointNums){
        int ballNum = pointNums.getBallNum();
        int strikeNum = pointNums.getStrikeNum();
        if(ballNum > 0) System.out.print(ballNum+"볼 ");
        if(strikeNum > 0) {
            System.out.print(strikeNum + "스트라이크");
            System.out.println();
            if (strikeNum == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
        }else System.out.println();
        if(ballNum == 0 && strikeNum == 0) System.out.println("낫싱");

        return false;
    }

}

class Point{
    private int strikeNum = 0;
    private int ballNum = 0;
    Point(int strikeNum, int ballNum){
        this.strikeNum = strikeNum;
        this.ballNum = ballNum;
    }

    public int getStrikeNum(){
        return strikeNum;
    }

    public int getBallNum(){
        return ballNum;
    }

    public void setStrikeNum(int num){
        this.strikeNum = num;
    }

    public void setBallNum(int num){
        this.ballNum = num;
    }
}
