package baseball;

public class 메세지생성 {
        private static int strike;
        private static int ball;
        private static final String STRIKETEXT = "스트라이크";
        private static final String BALLTEXT = "볼";
        private static final String NOTHINGTEXT = "낫싱";

        public 메세지생성(int strike, int ball) {

                this.strike = strike;
                this.ball = ball;
        }

        public String 메세지입력(){

                StringBuffer sb = new StringBuffer();

                if(strike == 0 && ball == 0){

                        sb.append(NOTHINGTEXT);
                }

                if(ball > 0){

                        sb.append(ball+BALLTEXT+" ");
                }

                if(strike > 0){

                        sb.append(strike+STRIKETEXT);
                }

                return sb.toString();
        }

}
