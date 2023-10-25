https://github.com/woowacourse-precourse/java-baseball-6 프리코스 1주차 과제

https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java 자바 스타일 가이드

https://github.com/woowacourse/woowacourse-docs/tree/main/precourse 프리코스 설정 및 제출방법

1. 미션은 기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항 세 가지로 구성되어 있다.
2. 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만든다.
3. 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.
   https://goddaehee.tistory.com/195
   --IntelliJ 설치 및 설정

https://velog.io/@pgmjun/IntelliJ-%EC%BD%94%EB%93%9C-%EC%BB%A8%EB%B2%A4%EC%85%98%EC%9D%84-%EC%84%A4%EC%A0%95%ED%95%B4%EB%B3%B4%EC%9E%90-feat.%EC%9A%B0%ED%85%8C%EC%BD%94
--우테코 코드컨벤션( 코드 포맷 ) 적용방법

https://velog.io/@mquat/git-git%EA%B3%BC-github-wrap-up
--git 사용법

https://discord.com/channels/1149138870433230900/1165903049986949160/1165903049986949160
--좋은 커밋 메세지 만들기

https://jjeongil.tistory.com/2124
--객체 클래스 개념

https://printf-hellojudyworld.tistory.com/63
--Java 네이밍 규칙

https://engineerinsight.tistory.com/10
--TDD Test Driven Development 테스트 주도 개발

https://ikkison.tistory.com/82
--refactoring 방법

https://mangkyu.tistory.com/132
--클린코드 핵심 요약 및 정리 (책 구매해서 읽어보자!)

https://story.baemin.com/6193/
--배민다움 경쟁자와 함께 성장하라고요?

https://velog.io/@im_chaedong/Intellij-%EC%97%90%EC%84%9C-java.lang-%EA%B0%99%EC%9D%80-%EA%B8%B0%EB%B3%B8-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC-%EB%B3%B4%EB%8A%94-%EB%B0%A9%EB%B2%95
--라이브러리 확인방법

https://mainia.tistory.com/2323
--리스트 자료구조 사용법

https://playground.naragara.com/513/
--리스트 비교법

https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=heartflow89&logNo=220964832916
--final뜻

구현할 기능 목록 (기능이 작동하면 커밋해보기)

1. 컴퓨터가 서로 다른 수를 만드는 객체 --Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.

2. 서로 다른 3자리의 수를 입력받는 객체
   --사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
   --tochararray 변환해서 length 3자리 이상일경우 IllegalArgumentException

--https://cheershennah.tistory.com/147 --예외처리

-- https://www.freecodecamp.org/korean/news/java-string-to-int-how-to-convert-a-string-to-an-integer/ -- 입력값 범위 확인을 위해
100~1000 string to integer 변경 Integer.parseInt(String string) 사용

3. 3자리의 수가 서로 다른 수인지 확인하는 객체 1==2? 2==3? 1==3?
   -- IllegalArgumentException
   -- 비교형태로 list.get(i) 와 Character.getNumericValue(int value) 사용

4. 입력으로 3개의 수를 받아 스트라이크 볼 낫싱 확인하는 객체
   --string 변수 char[] 로 변경한 값을 통해

5. 게임이 끝난 경우 재시작/종료를 구분하는 1과 2중 하나의 수를 입력 객체
   -- 변수 오류일경우 IllegalArgumentException

https://geojun.tistory.com/36
--중복값 set으로 제거하는 방법1
https://tosuccess.tistory.com/145
--중복값 set으로 제거하는 방법2
https://e-you.tistory.com/214
--랜덤시드

🚀 기능 요구 사항
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다. 예) 상대방(컴퓨터)의 수가
425일 때 123을 제시한 경우 : 1스트라이크 456을 제시한 경우 : 1볼 1스트라이크 789를 제시한 경우 : 낫싱 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른
임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다. 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면
게임이 종료된다. 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

🎯 프로그래밍 요구 사항
JDK 17 버전에서 실행 가능해야 한다. JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다. 프로그램 실행의 시작점은 Application의 main()이다.
build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다. Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다. 프로그램 종료 시 System.exit()를 호출하지 않는다.
프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다. 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지
않는다.

✏️ 과제 진행 요구 사항
미션은 java-baseball-6 저장소를 Fork & Clone해 시작한다.
기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가한다.
과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고한다.

https://nongue.tistory.com/152
--스캐너 nosuchelementexception 문제

https://velog.io/@ssuh0o0/%ED%98%BC%EC%9E%90%EC%84%9C-%ED%95%B4%EA%B2%B0%ED%95%98%EA%B8%B0springExpecting-code-to-raise-a-throwable.-java.lang.AssertionError
--에러해결법

https://discord.com/channels/1149138870433230900/1166019644239380511/1166019644239380511
--효율적인 테스트 코드 작성법

https://discord.com/channels/1149138870433230900/1164374520635871272/1164374520635871272
--git 브랜치 전략

https://discord.com/channels/1149138870433230900/1166223698525691904/1166223698525691904
--기술 블로그 운영 게시글

https://discord.com/channels/1149138870433230900/1164393577242165320/1164393577242165320
--코드리뷰

https://velog.io/@pgmjun/Github-%ED%98%91%EC%97%85-%EC%9D%B4%EA%B2%83%EB%A7%8C%EC%9D%80-%EC%95%8C%EC%9E%90-Code-Review
--협업, 이것만은 알자

https://velog.io/@soyeon207/%EB%98%91%EB%98%91%ED%95%98%EA%B2%8C-PR%EC%9D%84-%ED%86%B5%ED%95%B4-%EC%BD%94%EB%93%9C%EB%A6%AC%EB%B7%B0-%ED%95%98%EA%B8%B0
--PR을 통한 코드리뷰

https://github.com/woowacourse/woowacourse-docs/tree/code-review/codereview
--PR을 통한 코드리뷰 by woowacourse

--P룰이나 RCA룰로 코드리뷰 하면 좋을듯

https://discord.com/channels/1149138870433230900/1165275661678690426/1165275661678690426
--디자인 패턴

https://velog.io/@jiiiiinni/Git-GitHub-push%ED%95%9C-commit-%EC%82%AD%EC%A0%9C
-git commit 내역 삭제(비추천, 한 번 커밋에 신경쓰자. 커밋시 readme는 최종적인 커밋으로 해도 될듯)