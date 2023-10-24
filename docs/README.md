# 기능 명세서

## Computer(컴퓨터)
- `List<Integer> generateRandomNumbers()`
    - 숫자 3개를 랜덤으로 만들어내서 맞추어야할 정답을 만들어낼 수 있다
- `GameResult calculateGameResult(List<Integer> targetNumbers, List<Integer> userGuess)`
    - 사용자의 입력을 결과를 검증할 수 있다
- `void printHint(GameResult result)`
    - 사용자의 입력에 대하여 힌트를 제공할 수 있다

## User(사용자)
- `List<Integer> changeStringToIntegerList(String userInput)`
    - 입력을 숫자 배열로 바꾸어줄 수 있다

## BaseballGameManager(야구 게임 매니저)
- `BaseballGameManger(User user, Computer computer)`
  - 야구 게임을 위해 컴퓨터 객체와 사용자 객체를 사용할 수 있다.
- `void playBaseballGame()`
  - 야구 게임을 시작할 수 있다.
- `int menuChoice()`
  - 야구 게임 종료 여부를 위해 메뉴를 입력받을 수 있다.

## 게임 결과
- `boolean isGameEnd()`
  - 스트라이크와 볼 개수에 따라 게임 종료 여부를 판단해준다

---
## 테스트 코드

### 전체 게임 실행
- 게임 종료 후 재시작
- 예외 테스트
- 게임 2번 종료하고 재시작하기
- 사용자 입력 길이 예외(길이:2)
- 사용자 입력 중복 

### 컴퓨터
- 숫자랜덤생성에서 길이, 중복 여부, 숫자 범위 확인 
- 게임 결과 힌트 출력 확인

### 사용자
- 사용자 입력 길이 테스트
- 사용자 입력 중 중복된 숫자 테스트