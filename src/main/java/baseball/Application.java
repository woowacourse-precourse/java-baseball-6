package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        ComputerNum computerNum = new ComputerNum();
        UserNum userNum = new UserNum();
        ResScore resScore = new ResScore();
        int con_game = 0;

        while(true){
            computerNum.makeComputerNum();

            while(true){
                userNum.getUserNum();
                resScore.initScore();
                check(computerNum,userNum,resScore);

                resScore.printScore();
                if(resScore.strike==3){break;}
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            con_game = Integer.parseInt(Console.readLine());
            if(con_game == 2){break;}
        }
    }

    public static void check(ComputerNum cn, UserNum un,ResScore rs){
        if(cn.getC1() == un.getN1()){rs.setStrike(rs.getStrike()+1); }
        if(cn.getC2() == un.getN2()){rs.setStrike(rs.getStrike()+1); }
        if(cn.getC3() == un.getN3()){rs.setStrike(rs.getStrike()+1); }
        if( (cn.getC1() == un.getN2()) ||(cn.getC1() == un.getN3()) ){rs.setBall(rs.getBall()+1); }
        if( (cn.getC2() == un.getN1()) ||(cn.getC2() == un.getN3()) ){rs.setBall(rs.getBall()+1); }
        if( (cn.getC3() == un.getN1()) ||(cn.getC3() == un.getN2()) ){rs.setBall(rs.getBall()+1); }
        if((rs.strike ==0) & (rs.ball ==0)){rs.setNothing(1);}
    }
}
