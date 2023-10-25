# 구현할 기능 목록

## Player
게임 참여자 인터페이스
* inputBaseballNumbers() : baseBallNumber 를 입력 받는다.
* getBaseballNumbers() : baseBallNumber 를 가져온다.

## User
Player 구현체
* inputBaseballNumbers() 를 `camp.nextstep.edu.missionutils.Console.readline()` 을 통해 입력 받는 기능을 구현한다.
* getBaseballNumbers() : 객체의 baseBallNumbers 를 return 한다.

## Computer
Player 구현체
* inputBaseballNumbers() 를 `camp.nextstep.edu.missionutils.Randoms.pickNumberInRange()` 을 통해 baseBallNumber 를 입력 받는 기능을 구현한다.
* getBaseballNumbers() : 객체의 baseBallNumbers 를 return 한다.

## NumberChecker
baseBallNumber 이 요구사항에 맞게 입력 받았는 지 검증하는 클래스
* validateNumbers(String inputNumbers) : baseBallNumber이 숫자이며 요구사항에 맞는 길이이며, 중복되지 않는 수인지 판별한다.
* validateNumberLength(int length) : 요구사항에 맞는 길이인지 판별한다.
* validateNumberRange(String number) : 숫자이지만 0이 들어가있는 지 판별한다.
* validateNumberFormat(String number) : 숫자형식으로 변환되는 지 판별한다.

## Game
Game 이용을 위한 클래스
* run() : 상태가 PLAYING일 때 게임이 계속해서 진행된다.
* play() : 해당 게임을 진행한다.
* compareNumbers(List<Integer> playerNumbers, List<Integer> otherPlayerNumbers) : Ball , Strike 의 값을 return 한다.
* restartOrExit() : 게임을 계속해서 시작하는 지 종료하는 지에 따라 status 값을 변경한다.
* isNotAnswer(BallCount ballCount) : Strike가 요구사항에 맞는 수와 같은 지 판별한다.

## BallCount
strike 와 ball 값을 가지는 클래스
불변 객체이다.

## Status
PLAYING 또는 EXIT 를 가지는 enum

## GamePrinter
게임의 메세지를 출력하는 클래스
* startGame() : 게임을 시작할 때 메세지를 출력한다.
* inputNumber() : 숫자를 입력받을 때 메세지를 출력한다.
* resultBallCount(BallCount ballCount) : Strike 가 몇개인지 Ball 이 몇개인지 출력한다.
* isAnswer(int strikeAnswer) : 모두 맞췄을 때 메세지를 출력한다.
* restartOrExit() : 게임을 새로 시작할 지, 종료할 지 선택할 때 메세지를 출력한다.