* 미션은 기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항 세 가지로 구성되어 있다.
* 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만든다.
* 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

**구현할 기능 목록**

1. 상대방 역할을 하는 컴퓨터의 난수 값 3개 생성, 저장
2. 스트라이크, 볼을 판단하여 출력
2. 숫자를 맞췄을 때 스트라이크 상태 저장
3. 숫자 3개를 모두 맞췄는지에 대해 판단
3. 게임이 끝난 경우 새로 시작할 지, 종료할 지 결정


주의사항
camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.