기능 목록

|구분|상세 기능|Method|URI|Request|Response|비고|
|:----:|:-------:|:---:|:---:|:---:|:---:|:----:|
|게임 시작|시작 문구 출력| |startProcess| |{String}||
|게임 시작|서로 다른 임의의 수 3개 선택| |startProcess| |{Integer, Integer, Integer}|1 ~ 9|
|게임 진행|진행 문구 출력| |inProcess| |{String}|
|게임 진행|숫자 판단| |inProcess|{Integer}|{String}|
|게임 진행|결과 판단| |inProcess| |{String}|
|게임 재시작 및 종료|입력| |finishProcess|{Integer}| |1(재시작), 2(종료)|