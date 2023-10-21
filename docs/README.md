## BaseballGame
숫자 야구 게임의 메인 프로세스를 담당하는 클래스
- run : 숫자 야구 게임의 전체적인 프로세스를 담는다.
- countBall : computer의 숫자와 현재 guess를 비교해서 볼이면 1을 반환한다.
- sumBall : countBall의 개수를 합산한다.
- countStrike : computer의 숫자와 현재 guess를 비교해서 스트라이크이면 1을 반환한다.
- sumStrike : countStrike의 반환값을 합산한다.
- count : 볼과 스트라이크의 총 합을 ArrayList에 담아 반환한다.
- checkRestart : 3스트라이크인 경우 게임을 종료하는 커맨드를 반환하거나 재시작하는 커맨드를 반환한다.

---

## BaseballNumber
숫자 야구 게임의 숫자의 상위 클래스이다. 정수형 ArrayList로 숫자를 저장한다.
- getNumbers : List로 표현되는 3개의 숫자들을 반환한다.

## GuessNumber
숫자 야구 게임의 플레이어의 숫자를 나타내는 클래스이다.
- saveAsList : 문자열로 입력이 들어오면 숫자로 변환해서 List로 3개의 숫자를 저장한다.

## ComputerNumber
숫자 야구 게임의 컴퓨터의 숫자를 나타내는 클래스이다.
- ComputerNumber : 3개의 정수형을 파라미터로 받아서 인스턴스를 생성한다.
- ComputerNumber : List를 파라미터로 받아서 인스턴스를 생성한다.

---

## Command
숫자 야구 게임의 실행 명령어를 상수로 저장한 클래스이다.
- INITIALIZE : 게임을 실행하고 최초의 상태
- RESTARTED : 3스트라이크 후 재시작
- EXIT : 3스트라이크 후 종료

## Input
숫자 야구 게임의 입력 처리를 위한 유틸리티 클래스이다.
- sliceToThree : 입력된 정수형 배열을 3개씩 나눠서 ComputerNumber로 저장하기 위해 3개의 정수로 이루어진 List를 반환한다.

## Print
숫자 야구 게임의 출력 처리를 위한 유틸리티 클래스이다.
- printBaseballNumber : 입력 후 확인을 위해 BaseballNumber형 변수에 저장된 3개의 숫자를 콘솔에 출력한다.
- printResult : 볼과 스트라이크 정보를 콘솔에 출력한다.

## ValidityChecker
숫자 야구 게임의 유효성 검증을 위한 유틸리티 클래스이다.
- validateBaseballNumberSize : 3개로 이루어지지 않으면 IllegalArgumentException 예외를 발생시킨다.
- validateBaseballNumberType : 입력된 문자열 중 정수형으로 변환이 되지 않는 문자가 있으면 IllegalArgumentException 예외를 발생시킨다.
- isBaseballNumberSequence : 입력된 정수형 List중 중복되는 정수가 있을 경우 IllegalArgumentException 예외를 발생시킨다.