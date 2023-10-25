## Functions List

### OutputManager Class
     1) printStartMessage : 게임 시작 안내 문구를 출력하는 메소드
     2) printRequestInputMessage : 숫자 입력 요구 메시지를 출력하는 메소드
     3) printIfStrikeOrBallMessage : 스트라이크, 볼, 낫싱 여부를 출력하는 메소드
     4) printRetryOrEndMessage : 재시작 혹은 종료 여부 안내 문구를 출력하는 메소드
     5) printErrorMessage : 잘못된 입력에 대한 에러 메시지를 출력하는 메소드
### InputManager Class
    1) takeUserAnswerInput : 유저가 정답을 맞추기 위해 입력하는 값을 받기 위한 메소드
    2) takeUserEndOrRetryInput : 유저가 게임을 종료할 지 재시작 할 지 여부를 입력하는 input을 받기 위한 메소드
### Exception Class
    1) 사용자가 정답을 맞추귀 위해 입력하는 값에 대한 예외
       - 숫자가 아닌 다른 문자가 입력되었을 경우 혹은 0이 입력되었을 경우
       - 숫자가 3개 초과 혹은 3개 미만으로 입력되었을 경우
       - 같은 숫자가 여러개 입력되었을 경우
    3) 사용자 재시작 혹은 게임 종료 여부를 결정하기 위해 입력하는 값에 대한 예외
       - 숫자가 아닌 다른 문자가 입력되었을 경우
       - 숫자가 1개 초과 혹은 1개 미만으로 입력되었을 경우
       - 숫자가 1, 2가 아닌 경우
### ValidateChecker
    1) isUserInputValidate : 유저가 정답을 맞추기 위해 입력하는 값에 대한 유효성 검사
        - checkLengthValidate : 길이에 대한 유효성 검사
        - isRangeValidate : 값의 범위에 대한 유효성 검사
        - checkDuplicateValidate : 중복에 대한 유효성 검사
        - count : 중복 유효성 검사시 한 문자열 안에 있는 특정 문자의 개수를 세기 위해 사용
    2) isRetryInputValidate : 유저가 재시작 여부를 결정하기 위해 입력하는 값에 대한 유효성 검사
### Computer Class
    1) playBaseBall : 숫자야구 게임 한 단위를 실행하는 메소드
    2) startBaseballGame : 숫자야구 게임을 시작하는 메소드
    3) makeAnswer : 정답 숫자를 만드는 메소드
    4) JudgeHowManyStrike : Strike가 얼마나 있는지 판단하는 메소드
    5) JudgeHowManyBall : Ball이 얼마나 있는지 판단하는 메소드
    6) isGameTerminated : 게임이 종료되었는지 확인하는 메소드
    7) terminateBaseballGame : 게임을 종료시키는 메소드