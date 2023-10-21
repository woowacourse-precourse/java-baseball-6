<p align="center">
    <img src="https://i.namu.wiki/i/SkMTyiOBeQBy4NXE89AWo53cPQM1lMbEz82RGF8MTdhB9xjLY5WSV7u9NXMVbxfQ5Ie84YQd9l96-tyTbCDZFQ.webp" alt="우아한테크코스" width="250px">
</p>

# 프리코스 1주차 미션 - 숫자 야구

![Generic badge](https://img.shields.io/badge/precourse-week1-green.svg)
![Generic badge](https://img.shields.io/badge/test-2_passed-blue.svg)

> 우아한테크코스 6기 프리코스 1주차 미션, 숫자 야구를 구현한 저장소입니다.

#### 실행 결과 예시

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```

---

# 목차
- [기능 목록](#기능-목록)
    - [시작 전 세팅](#시작-전-세팅)
    - [게임 시작](#게임-시작)
    - [게임 종료](#게임-종료)

---


## 기능 목록

### 시작 전 세팅

- 1부터 9까지 서로 다른 임의의 수로 이루어진 3자리의 수가 생성된다.

### 게임 시작

- 사용자로부터 서로 다른 3자리의 수를 입력 받는다.
    - 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.
        - 자릿수가 3보다 작거나 큰 경우 (ex. 36, 3689)
        - 문자 또는 0이 들어간 경우 (ex. a36, 306)
        - 동일한 값이 있을 경우 (ex. 336)
    - 정상적인 값을 입력할 경우 입력 값에 따른 결과를 판정하고 볼, 스트라이크 개수로 표시한다.
        - `1볼 1스트라이크`
        - 하나도 맞추지 못한 경우 `낫싱` 을 표기
        - 3개 모두 맞힐 경우 `3스트라이크`

### 게임 종료

- 정답을 맞췄을 때에는 `3스트라이크`에 추가로 게임 종료 메시지 출력 후 재시작/종료 여부 값을 입력받는다. (1: 재시작, 2: 종료)
- 1와 2이외의 값을 입력한 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.
