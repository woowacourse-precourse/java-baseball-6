# 🧑🏻‍💻숫자 야구
> 1 ~ 9 까지 서로 다른 수로 이뤄진 `3자리의 수`를 맞추기

### 🏄‍ Flow

[![Flow](https://mermaid.ink/img/pako:eNpVkL1qwzAQx1_l0ORC8gIeArGdTu2SjnEGYSmNQZaNKlFKFCiFTOnQDqEftCb0Yyh4bek7-foOVexksKbjfr_THf8FSXLGiU9mIr9M5lRpOBnHEtwbToZFIdKE6jSXU-j3B1YZaSHwAnrBAyqE40etG-wwhB7eVPj8heUdYLmqt597HDY4muB2U6-_AR-q-uca_p42-Po7bZWoWYCPH06wEHaazZSFkYdlhesXLO-7X-y3jFr74LhLoQPeVvX7rYVjr63cFOmRjKuMpswlsNjJMdFznvGY-K5kfEaN0DGJ5dKp1Oj87EomxNfK8B4xBaOaRyk9VzQ7NDlLda5O21CbbJf_ILuNVA?type=png)](https://mermaid.live/edit#pako:eNpVkL1qwzAQx1_l0ORC8gIeArGdTu2SjnEGYSmNQZaNKlFKFCiFTOnQDqEftCb0Yyh4bek7-foOVexksKbjfr_THf8FSXLGiU9mIr9M5lRpOBnHEtwbToZFIdKE6jSXU-j3B1YZaSHwAnrBAyqE40etG-wwhB7eVPj8heUdYLmqt597HDY4muB2U6-_AR-q-uca_p42-Po7bZWoWYCPH06wEHaazZSFkYdlhesXLO-7X-y3jFr74LhLoQPeVvX7rYVjr63cFOmRjKuMpswlsNjJMdFznvGY-K5kfEaN0DGJ5dKp1Oj87EomxNfK8B4xBaOaRyk9VzQ7NDlLda5O21CbbJf_ILuNVA)

## ⭐ 요구 사항

**1️⃣ 기능 요구 사항**

- [x]  1 ~ 9 까지 서로 다른 수로 이루어진 3자리의 수를 맞추기
- [x]  같은 수가 같은 자리인 경우 **스트라이크**, 다른 자리인 경우 **볼**, 같은 수가 전혀 없다면 **낫싱**
   - ex) 425
      - 123 ⇒ 1 스트라이크
      - 456 ⇒ 1볼 1스트라이크
      - 789 ⇒ 낫싱
- [x]  컴퓨터가 1 ~ 9 까지의 서로 다른 임의의 수 3개를 선택
    - 프로그램 시작 / 재시작 시 새로운 랜덤숫자를 생성
- [x]  3개의 수를 모두 맞히면 게임이 종료
- [x]  잘못된 값을 입력한 경우 `IllegalArgumentException` 을 발생시킨 후 **애플리케이션 종료**
   - 3자리 미만, 3자리 초과의 수를 입력한 경우
   - 숫자가 아닌 다른 문자를 입력한 경우
   - 0 ~ 9 범위의 숫자가 아닌 숫자를 입력한 경우


**2️⃣ 프로그래밍 요구 사항**

- [x]  `JDK 17` 버전에서 실행 가능 여부  
  <img width="667" alt="image" src="https://github.com/qjatjr29/algorithm-java/assets/74031333/17da9b53-813e-40c3-b4db-7c66570395be">    
  </br>
- [x]  프로그램 실행 시작점의 Application의 `main()`
- [x]  build.gradle 파일 변경 ❌
- [x]  [**Java 코드 컨벤션**](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java) 가이드 준수
  <img width="958" alt="image" src="https://github.com/qjatjr29/algorithm-java/assets/74031333/a439be62-ce8e-4307-a98d-3e242b0ac3b4">  
  </br>
- [x]  프로그램 종료 시 `System.exit()` 호출하지 않는다.
- [x]  ApplicationTest의 모든 테스트 성공
  <img width="1141" alt="image" src="https://github.com/qjatjr29/algorithm-java/assets/74031333/2ee072d0-603a-4dc2-a99b-41a12a185180">  
  </br> 
- [x]  파일, 패키지 이름 수정 / 이동 ❌
- [x]  `camp.nextstep.edu.missionutils` 에서 제공하는 Randoms 및 Console API 사용하여 구현

3️⃣ **과제 진행 요구 사항**

- [x]  repository를 Fork & Clone
- [x]  **기능 구현 전 `docs/README.md`에 구현할 기능 목록을 정리후 추가**
- [x]  [프리 코스 과제 가이드](https://www.notion.so/Github-Actions-6beab55a4d6644bd81c199ef406ab2cc?pvs=21) 참고 


## 고민 / 공부 내용
### 🧑🏻‍💻[Notion 정리 ](https://generated-silene-2be.notion.site/41513f42b7c1489aa62bf80f3ccf95d7?pvs=4) 
- [x] Java17
- [x] Java Random
- [x] JMH
- [x] 단위 테스트, JUnit, Assertions, @ParameterizedTest
