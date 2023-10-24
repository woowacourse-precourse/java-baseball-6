### Functions List

1. OutputManager Class
    1) printStartMessage : 게임 시작 안내 문구를 출력하는 메소드
    2) printRequestInputMessage : 숫자 입력 요구 메시지를 출력하는 메소드
    3) printIfStrikeOrBallMessage : 스트라이크, 볼, 낫싱 여부를 출력하는 메소드
    4) printRetryOrEndMessage : 재시작 혹은 종료 여부 안내 문구를 출력하는 메소드
    5) printErrorMessage : 잘못된 입력에 대한 에러 메시지를 출력하는 메소드
2. InputManager Class
    1) takeUserAnswerInput : 유저가 정답을 맞추기 위해 입력하는 값을 받기 위한 메소드
    2) takeUserEndOrRetryInput : 유저가 게임을 종료할 지 재시작 할 지 여부를 입력하는 input을 받기 위한 메소드
3. Exception Class
    1) generateIllegalArgumentException : 사용자가 잘못된 입력값을 제공했을 경우 IllegalArgumentException을 발생시키는 메소드
    2) dealUserAnswerInputException : 에러 메시지 출력
       - 숫자가 아닌 다른 문자가 입력되었을 경우
       - 숫자가 3개 초과 혹은 3개 미만으로 입력되었을 경우
       - 같은 숫자가 여러개 입력되었을 경우
    3) dealUserEndOrRetryInputException : 에러메시지 출력
       - 숫자가 아닌 다른 문자가 입력되었을 경우
       - 숫자가 1개 초과 혹은 1개 미만으로 입력되었을 경우
       - 숫자가 1, 2가 아닌 경우
4. InputManager Class
    1) 유저가 정답을 맞추기 위해 입력하는 값에 대한 유효성 검사
    2) 유저가 재시작 여부를 결정하기 위해 입력하는 값에 대한 유효성 검사
5. Computer Class
    1) playBaseBall : 숫자야구 게임 한 단위를 실행하는 메소드
    2) startBaseballGame : 숫자야구 게임을 시작하는 메소드
    3) makeAnswerNumber : 정답 숫자를 만드는 메소드
    4) JudgeHowManyStrike : Strike가 얼마나 있는지 판단하는 메소드
    5) JudgeHowManyBall : Ball이 얼마나 있는지 판단하는 메소드