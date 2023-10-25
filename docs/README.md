## 기능 구현 목록

## GameController
1. start() : 숫자 야구 게임을 시작합니다.

## Computer
1. randomNumber() : 1~9 사이의 랜덤한 임의의 숫자 3개를 선택합니다.
2. getRandomNumber() : 임의의 숫자 3개를 리턴합니다.

## GameManager
1. check() : 컴퓨터가 선택한 임의의 3자리 숫자와 Player 가 입력한 3자리 숫자를 비교합니다.
    - strikeCheck() : 컴퓨터가 선택한 임의의 3자리 숫자와 Player 가 입력한 3자리 숫자에서 스트라이크 카운터를 리턴합니다.
    - ballCheck() : 컴퓨터가 선택한 임의의 3자리 숫자와 Player 가 입력한 3자리 숫자에서 볼 카운터를 리턴합니다.
    - result() : 스트라이크,볼,낫싱의 결과값을 리턴합니다.

## Player
1. inputNumber() : Player 는 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력합니다.
2. getInputNumber() : Player 가 입력한 임의의 3자리 수를 리턴합니다.

## GameService
1. start() : 숫자 야구 게임을 실행합니다.
2. reState() : 게임의 재시작 여부를 확인하고 재시작/종료합니다.

## ExceptionMessage
1. code() : 지정된 enum 의 value 를 반환합니다.
    - LENGTH : "3자리 숫자를 입력해주세요." 3자리 숫자를 입력하지 않았을때 반환합니다.
    - NUMBER : "숫자만 입력해주세요." 숫자를 입력하지 않았을때 반환합니다.
    - OVERLAP : "서로 다른 임의의 수 3개를 입력해야합니다." 중복된 수가 있을때 반환합니다.
    - INVALID : "잘못된 값을 입력하셨습니다." 지정된 값 이외에 값을 입력했을때 반환합니다.

## InputValidation
1. validation() : Player 가 입력한 임의의 3자리 수를 검증합니다.
    - lengthValidation() : 입력한 수가 3자리가 맞는지 검증합니다.
    - numberValidation() : 숫자만 입력했는지 검증합니다.
    - overlapValidation() : 중복된 수가 있는지 검증합니다.

## InputInformationView
1. numberInputGuide() : "숫자를 입력해주세요 : " 문장을 출력합니다.
2. reStateGuide() : "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 문장을 출력합니다.

## OutputInformationView
1. startGuide() : "숫자 야구 게임을 시작합니다." 문장을 출력합니다. 
2. gameOverGuide() : "게임 종료." 문장을 출력합니다.
3. checkAnswerGuide() : "3개의 숫자를 모두 맞추셨습니다." 문장을 출력합니다.
4. resultGuide() : 스트라이크,볼,낫싱의 결과값을 출력합니다.

