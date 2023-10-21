# 구현 기능 목록



##  1. **GameProcessController**

- 게임의 동작 과정을 제어한다.
  - 동작 과정은 플레이어(computer, challenger) 입장, 게임 진행, 재시작/종료로 이루어짐.



##  2. **GameManager**

- 게임 진행에 필요한 도구들을 제공한다.
  - 플레이어들의 숫자 준비 및 게임 시작
  - 게임 결과 판정
  - 플레이어의 게임 진행 의사결정(재시작/종료)
  - 게임 종료

## 3. **GameEntities**
- 플레이어 객체를 관리

## 4. **Challenger**

- 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력 받음.

## 5. **SetNum (Interface)**

- 숫자 설정에 필요한 기능을 정의함.
  - 구체적인 수의 생성 및 입력 방식은 해당 인터페이스를 구현하는 클래스에 의해 결정됨.

## 6. **Computer**

- 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성함.


[Package Version History](https://fabulous-butterkase-809.notion.site/Package-Version-History-40b396bf1b31431084fa11abdd79d138?pvs=4)




