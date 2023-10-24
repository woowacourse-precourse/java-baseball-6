# 구현할 기능 목록

## 1. 컴퓨터 수 생성

### - 1에서 9까지 서로 다른 임의의 수 3개 생성

### - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용하여 생성

## 2. 사용자 입력 값 받기

### - camp.nextstep.edu.missionutils.Console의 readLine()을 활용하여 생성

### - 3자리가 아닌 수를 입력받으면 IllegalArgumentException 발생

### - 세 자리 수 중에서 두 자리가 같을 경우 IllegalArgumentException 발생

### - 세 자리 수 중에서 하나라도 0이 입력된 경우 IllegalArgumentException 발생

## 3. 컴퓨터 수와 사용자 수가 얼마나 일치하는 지 판단하기

### - 볼 개수와 스트라이크 개수를 나타내는 변수 선언 필요

#### 1. 볼 == 0, 스트라이크 == 0 이면

낫싱 출력

#### 2. 스트라이크 == 0 이면,

ㅇ볼 출력

#### 3. 볼 == 0 이면서 스트라이크는 3이 아닐 떄,

ㅇ스트라이크 출력

#### 4. 볼 == 0 이면서 스트라이크 3일 때,

3스트라이크 출력
3개의 숫자를 모두 맞히셨습니다! 게임 종료
를 출력

## 4. 게임을 계속할 건지 말건지 판단하기

### - 1을 누르면 재시작해야함

### - 2를 누르면 종료해야함

### - 1, 2가 아닌 값을 누르면 IllegalArgumentException 발생