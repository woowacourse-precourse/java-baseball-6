package baseball;

public class Compare {
    private final int contain;
    private final int strike;

    public Compare(int contain, int strike){
        this.contain = contain;
        this.strike = strike;
    }


    public static Compare compare(NumberGroup User_num_group, NumberGroup com_num_group) {
        int contain = 0;
        int strike = 0;

        contain = contain(User_num_group, com_num_group);
        strike = correct(User_num_group, com_num_group);

        return new Compare(contain, strike);
    }

    private static int contain(NumberGroup User_num_group, NumberGroup com_num_group) {
        int contain = 0;

        for(int i = 0 ; i < Constant.MAX_SIZE ; i++) {
            if(User_num_group.contains(com_num_group.get(i))) {
                contain++;
            }
        }

        return contain;
    }


    private static int correct(NumberGroup User_num_group, NumberGroup com_num_group) {
        int correct = 0;

        for(int i = 0 ; i < Constant.MAX_SIZE ; i++) {
            if(User_num_group.get(i).equals(com_num_group.get(i))) {
                correct++;
            }
        }

        return correct;
    }

    public String Output() {
        if(is_Nothing()) {
            return "낫싱";
        }
        if(no_Strike()) {
            return getBall() + "볼";
        }

        if(no_Ball()) {
            return strike + "스트라이크";
        }

        return getBall() + "볼" + " " + strike + "스트라이크";
    }

    public boolean success(){
        if(strike == 3){
            return true;
        }
        return false;
    }

    private boolean is_Nothing(){
        if(contain == 0){
            return true;
        }
        return false;
    }

    private boolean no_Ball(){
        int ball = contain - strike;
        if(ball == 0){
            return true;
        }
        return false;
    }

    private boolean no_Strike(){
        if(strike == 0){
            return true;
        }
        return false;
    }

    private int getBall(){
        return contain - strike;
    }
}
