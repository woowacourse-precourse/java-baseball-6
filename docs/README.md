# 🧑🏻‍💻숫자 야구
> 1 ~ 9 까지 서로 다른 수로 이뤄진 `3자리의 수`를 맞추기


## ⭐ 요구 사항

---

**1️⃣ 기능 요구 사항**

- [ ]  1 ~ 9 까지 서로 다른 수로 이루어진 3자리의 수를 맞추기
- [ ]  같은 수가 같은 자리인 경우 **스트라이크**, 다른 자리인 경우 **볼**, 같은 수가 전혀 없다면 **낫싱**
   - ex) 425
      - 123 ⇒ 1 스트라이크
      - 456 ⇒ 1볼 1스트라이크
      - 789 ⇒ 낫싱
- [ ]  컴퓨터가 1 ~ 9 까지의 서로 다른 임의의 수 3개를 선택
- [ ]  3개의 수를 모두 맞히면 게임이 종료
- [ ]  잘못된 값을 입력한 경우 `IllegalArgumentException` 을 발생시킨 후 **애플리케이션 종료**
   - 3자리 미만, 3자리 초과의 수를 입력한 경우
   - 숫자가 아닌 다른 문자를 입력한 경우


**2️⃣ 프로그래밍 요구 사항**

- [ ]  `JDK 17` 버전에서 실행 가능 여부
- [ ]  프로그램 실행 시작점의 Application의 `main()`
- [ ]  build.gradle 파일 변경 ❌
- [ ]  [**Java 코드 컨벤션**](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java) 가이드 준수
- [ ]  프로그램 종료 시 `System.exit()` 호출하지 않는다.
- [ ]  ApplicationTest의 모든 테스트 성공
- [ ]  파일, 패키지 이름 수정 / 이동 ❌
- [ ]  `camp.nextstep.edu.missionutils` 에서 제공하는 Randoms 및 Console API 사용하여 구현

3️⃣ **과제 진행 요구 사항**

- [ ]  repository를 Fork & Clone
- [ ]  **기능 구현 전 `docs/README.md`에 구현할 기능 목록을 정리후 추가**
- [ ]  [프리 코스 과제 가이드](https://www.notion.so/Github-Actions-6beab55a4d6644bd81c199ef406ab2cc?pvs=21) 참고