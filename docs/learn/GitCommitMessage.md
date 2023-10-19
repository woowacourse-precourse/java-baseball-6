# Git Commit Message
기능 목록을 정리하고 나서 커밋하려고 했다. 이번 기회에 커밋 메시지를 체계적으로 작성해보자는 의미에 커밋 메시지에 관련한 글을 보았다. 
(https://meetup.nhncloud.com/posts/106, https://beomseok95.tistory.com/328)

커밋 메시지를 잘 적어야하는 이유는
- 가독성
- 협업
- 코드 유지보수
  를 위함이다.

읽고 정리한 바로는 
- 50자 이내 짧은 제목을 쓰고 
- 명령어로 제목을 쓰고
- 제목을 설명하는 본문을 줄바꿈해서 적어야 하고
- 본문의 내용은 "어떻게" 보다 "무엇을", "왜"를 위주로 설명해야한다.

## 커밋을 명령문으로 적어라?
커밋을 과거형으로 적는게 맞는 것 같지만 명령문으로 쓰는 이유는 커밋메시지의 의미는 "이 커밋이 적용되면 어떤일이 이루어진다"라는 내용이 있기 때문이다. 커밋 메시지를 이렇게 읽으면 이해가 된다.

(if applied, this commit will ) 리드미 파일 생성 = 적용된다면 이 커밋은 리드미 파일을 생성할 것. 

## 예
```
fix: fix foo to enable bar

This fixes the broken behavior of the component by doing xyz. 

BREAKING CHANGE
Before this fix foo wasn't enabled at all, behavior changes from <old> to <new>

Closes D2IQ-12345
```

올바른 커밋 메시지의 예이다. 
타입을 먼저 쓰고, 짧은 제목을 작성한다. 
한칸을 띄고 본문을 무엇을, 왜 작성했는지 적는다. 
추가로 이슈에 있는 내용을 해결하기 위해 커밋했다면 밑에 이슈 넘버를 넣는다.

## Type
Type은 외우는게 좋아서 적어봤다.
- feat : 새로운 기능
- fix : 버그 수정
- build: 빌드 관련 파일 수정
- docs: 문서 관련
- refactor: 코드 리펙토링
- test: 테스트 코드

## 적용
이를 적용해서 내 프로젝트에도 반영을 해보았다. 

```
feat: 게임 시작 문구 출력 구현

입출력을 담당하기 위해 Display Class 를 추가했다.
게임의 전체적인 흐름을 담당하는 Game Class를 추가했다.
```