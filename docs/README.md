# 기능정리

## 숫자생성 [O]
- 1 부터 9 까지 서로 다룬 수로 이루어진 3자리 수를 생성한다.
  -  Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.


## 출력  [O]
- 숫자 야구 게임을 시작합니다.
- 숫자를 입력해주세요 :
- 결과 (EX - 1볼 1스트라이크, 1스크라이크)
- 3개의 숫자를 모두 맞히셨습니다! 게임 종료
  게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.

## 입력 [O]
-  사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- 3자리 숫자 입력.
  - [Exception] 숫자가 아닌경우 Exception 발생
  - [Exception] 3자리가 아닌경우 Exception 발생
  - [Exception] 한가지 수가 반복될 경우 Exception 발생
- 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
  - [Exception] 1,2 외를 입력할 경우 Exception 발생

## 진행 [O]
- 생성 숫자와 사용자 입력 숫자의 각 자리수 비교후 결과 출력.
  - 같은수가 같은 자리에 있을경우 스트라이크
  - 같은수가 다른 자리에 있을경우 볼
  - 같은수가 없으면 낫싱
- 사용자가 올바른 값을 입력할 경우 게임은 계속 진행
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생시킨 후 종료