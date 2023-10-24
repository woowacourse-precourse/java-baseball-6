## ⚾ java-baseball ⚾ 의 기능 목록

---

#### <span style="background-color:#E8D595">1. 유저 입력

- [x] 유저에게 **3자리 숫자를 입력 받는** 기능 구현
    - [x] camp.nextstep.edu.missionutils.Console 으로 입력을 받는다.
    - **에러**
        - [x] 숫자가 아닌 것이 포함일 경우, Illegal Exception, 종료
        - [x] 3자리 이하 혹은 이상일 경우, Illegal Exception, 종료
        - [x] 0을 입력 받을 경우, Illegal Exception, 종료
    - **진행**
        - [x] 위 두가지가 포함되지 않을 경우 컴퓨터의 숫자와 대조한다.
    - **종료**
        - [x] 게임이 끝난 후 1 혹은 2 를 입력 받는다.
        - **에러**
            - [x] 만약 그 외 숫자를 입력 받는다면, Illegal Exception, 종료
            - [x] 숫자가 아니라면 Illegal Exception, 종료

#### <span style="background-color:#E8D595">2. 컴퓨터

- [x] 랜덤한 서로다른 3자리 숫자를 만든다.
    - [x] camp.nextstep.edu.missionutils.Randoms 을 사용한다.

#### <span style="background-color:#E8D595">3. 출력

- [x] 입력에 따라 숫자와 문장을 출력한다.

  ````
  같은 수가 같은 자리 : 스트라이크
  같은 수가 다른 자리 : 볼
  같은 수가 전혀 없을 경우 : 낫싱
  ````

- 진행
    - 처음
        - [x] 첫 시작일 경우 `숫자 야구 게임을 시작합니다.` 를 출력한다.
    - 맞춘 전적이 존재
        - [x] 맞춘 이후 재시작이라면 `숫자를 입력해주세요 :` 를 출력한다.

    - 공통
        - [x] 3스트라이크가 아닐 경우 입력창으로 돌아간다
        - [x] 3스트라이크 일 경우 `3개의 숫자를 모두 맞히셨습니다! 게임 종료`
          `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`를 출력한다.
