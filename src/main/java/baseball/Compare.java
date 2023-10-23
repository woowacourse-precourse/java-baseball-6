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

        for(int i = 0 ; i < 3 ; i++) {
            if(User_num_group.contains(com_num_group.get(i))) {
                contain++;
            }
        }

        return contain;
    }


    private static int correct(NumberGroup User_num_group, NumberGroup com_num_group) {
        int correct = 0;

        for(int i = 0 ; i < 3 ; i++) {
            //System.out.println(User_num.get(i) + " " + com_num.get(i));
            if(User_num_group.get(i).equals(com_num_group.get(i))) {
                correct++;
            }
        }

        return correct;
    }
}
