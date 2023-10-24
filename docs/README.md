### Functions List

1. OutputManagerClass
    1) printStartMessage : 게임 시작 안내 문구를 출력하는 메소드
    2) printRequestInputMessage : 숫자 입력 요구 메시지를 출력하는 메소드
    3) printIfStrikeOrBallMessage : 스트라이크, 볼, 낫싱 여부를 출력하는 메소드
    4) printRetryOrEndMessage : 재시작 혹은 종료 여부 안내 문구를 출력하는 메소드
    5) printErrorMessage : 잘못된 입력에 대한 에러 메시지를 출력하는 메소드
2. InputManagerClass
    1) takeUserAnswerInput : 유저가 정답을 맞추기 위해 입력하는 input을 받기 위한 메소드
    2) takeUserEndOrRetryInput : 유저가 게임을 종료할 지 재시작 할 지 여부를 입력하는 input을 받기 위한 메소드
3. ExceptionClass
    1) generateIllegalArgumentException : 사용자가 잘못된 입력값을 제공했을 경우 IllegalArgumentException을 발생시키는 메소드
4. Computer Class
    1) playBaseBall : 숫자야구 게임 한 단위를 실행하는 메소드
    2) startBaseballGame : 숫자야구 게임을 시작하는 메소드
    3) makeAnswerNumber : 정답 숫자를 만드는 메소드
    4) JudgeHowManyStrike : Strike가 얼마나 있는지 판단하는 메소드
    5) JudgeHowManyBall : Ball이 얼마나 있는지 판단하는 메소드