# [미션1] 숫자 야구 게임

## class Game
### member
- answer ; 정답
### method
- private void setRandomAnswer ; answer 설정
- public void start ; baseball game 시작
- boolean isRunning ; 게임이 계속 진행될 것인지 확인
- boolean askRetry ; 게임 종료 후, 다시 할 것인지 질문


## class InputNumber
### member
- List\<Integer> numbers
- String result
- boolean correct

### method
- public InputNumber(input) ; 생성자
- void checkInput ; 입력값 유효성 확인
- void makeResult(answer) ; 결과 구하기
- void displayResult ; 결과 출력