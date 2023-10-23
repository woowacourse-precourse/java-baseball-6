package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application myapp = new Application();
        StartEnd state = StartEnd.start;
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> cv = myapp.getCV();

        List<Integer> uv;
        while(state.getBool()){
            // sellect computer num
            PrintClass.printGetNum();
            String uvs = Console.readLine();//get num from user by String format
            uv = myapp.checkDup(//check dupilication
                    myapp.changeStrToList(//change str to list + check integer
                    myapp.checkLength(uvs, 3)//check length
                    )
            );

            Score score = myapp.calScore(cv, uv);//Scoring
            PrintClass.printScore(score);
            if(score.strike == 3) {
                PrintClass.printEndGame();
                PrintClass.printGetRestartNum();
                state = myapp.getRestartNum();//get user's opinion about restart
                if(state == StartEnd.end)
                    break;
                cv = myapp.getCV();
            }
        }
    }

    public List<Integer> getCV(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> checkDup(List<Integer> cv){
        if(cv.size() > 10)
            throw new IllegalArgumentException();
        Set<Integer> set = new TreeSet<>();

        for(int i=1;i<=9;i++)
            set.add(i);

        for (Integer value : cv) {
            if (!set.contains(value))
                throw new IllegalArgumentException();
            set.remove(value);
        }

        return cv;
    }

    public StartEnd getRestartNum(){
        int ret = Integer.parseInt(Console.readLine());
        if(ret == 1)
            return StartEnd.start;
        else if(ret == 2)
            return StartEnd.end;
        else
            throw new IllegalArgumentException();
    }

    public String checkLength(String str, int length){
        if(str.length() != length)
            throw new IllegalArgumentException();
        return str;
    }

    public List<Integer> changeStrToList(String uvi){
        List<Integer> uv = new ArrayList<>();
        try {
            for (String character : uvi.split("")) {
                uv.add(Integer.parseInt(character));
            }
        }
        catch(Exception e) {
            throw new IllegalArgumentException();
        }
        return uv;
    }

    public Score calScore(List<Integer> cv, List<Integer> uv){
        Score score = new Score();
        for(int ui=0;ui<uv.size();ui++){
            if(cv.get(ui).equals(uv.get(ui))) {
                score.strike +=1;
                continue;
            }
            for(int i=1;i<=cv.size()-1;i++){
                int ci = (ui + i) % (cv.size());
                if(cv.get(ci).equals(uv.get(ui))) {
                    score.ball +=1;
                    break;
                }
            }
        }
        return score;
    }
}
