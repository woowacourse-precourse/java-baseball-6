# 구현할 기능 목록
- 컴퓨터가 랜덤으로 1~9까지의 3개 난수를 생성하는 createComputerNumber()
- 사용자에게 숫자를 입력받는 기능(Buffered Reader)
- 입력받은 수에서 숫자가 3개가 아니거나 or 문자가 들어왔을때 IllegalArgumentException 예외처리
- 입력받은 유저의 수와 컴퓨터의 값을 비교하는 checkAnswerCorrect()
- 결과값을 출력하는 printResult()
- 전체 게임을 시작하는 playGame()
- 전체 게임을 한바퀴 다시 하는 wannaPlayAgain()
---
#### 뒤늦게 추가 구현 목록
- 사용자 입력을 camp.nextstep.edu.missionutils.Console의 readLine()을 활용해서 받는다
- 유저가 같은 숫자 3개를 입력했을때의 예외처리하기

## 기능 요구 사항


### 구현
#### 랜덤의 사용방식(컴퓨터의 역할)
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현하기
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
#### 입력 방식(사용자의 입력)
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- 예외 입력시 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 서로 다른 3자리수를 입력한다
- 게임이 끝난 뒤에는 1/2 (재시작/종료) 를 입력

#### 출력방식
- 게임 시작 문구
  - 숫자 야구 게임을 시작합니다.
- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시 
  - 1볼 1스트라이크
- 하나도 없을경우 
  - 낫싱
- 3개 모두 맞췄을때 
  - 3스트라이크 
  - 3개의 숫자를 모두 맞히셨습니다! 게임 종료
## 숫자야구
- 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 
- 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.

## 프로그래밍 요구 사항
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
#### 자바 컨벤션
- 블럭 들여쓰기는 4스페이스를 유지
- 열 제한은 120자 => 짧게 쓰자
- 줄바꿈시 그 다음줄은 원래 줄에서 +8이상 들여쓰기

## 과제 진행 요구 사항
- 기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가한다.


