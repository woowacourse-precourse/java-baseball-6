# ⚾️ 구현할 기능 목록 

## 컴퓨터 숫자 생성

`createComputerNumber()` : `camp.nextstep.edu.missionutils.Randoms.pickNumberInRange()` 를 이용하여 3개의 중복없는 숫자 생성한다. 

## 사용자 숫자 입력


`validate(String input)` : 사용자 입력을 검증하고 입력 문자열을 정수 리스트로 변환한다.  

- `isThreeLenght(String input)` : 입력 길이가 3인지 체크한다.
- `isNatural(String input)` : 입력이 1~9 의 자연수로 이뤄진 세자리 수인지 체크한다.
- `isUnique(String input)` : 입력에 중복이 없는지 체크한다.

예외 처리 : 위 세 조건을 만족하지 않는 경우 `IllegalArgumentException` 을 발생시킨다.

## 스트라이크 카운트

`countStrike()` : 컴퓨터 숫자와 사용자 숫자의 같은 자리에 있는 같은 수의 개수를 센다.

## 볼 카운트

`countBall()` : 컴퓨터 숫자와 사용자 숫자의 다른 자리에 있는 같은 수의 개수를 센다

## 힌트 출력

`printHint(int ball, int strike)` : 볼과 스트라이크 개수에 따라 적절한 힌트를 출력한다. 

    볼이 하나라도 있다면 "${카운트}볼", 스트라이크가 하나라도 있다면 "${카운트}스트라이크" 형태로 출력한다.
    만약 볼과 스트라이크 동시에 있다면 "${볼 카운드}볼 ${스트라이크 카운트}스트라이크" 형태로 출력한다.

    볼과 스트라이크가 하나도 없는 경우 "낫싱"을 출력한다.

## 게임 종료

사용자가 3개의 숫자를 모두 맞히면 `“3개의 숫자를 모두 맞히셨습니다! 게임 종료”` 를 출력하고 게임을 종료한다.

## 재시작/종료

`askReplay()` : 사용자에게 재시작 여부를 묻는다. 재시작할 경우 true를 종료인 경우 false를 반환한다.
* 예외 처리 : 
이 때 1, 2 외의 다른 입력이 들어오면 `IllegalArgumentException` 을 발생시킨다. 