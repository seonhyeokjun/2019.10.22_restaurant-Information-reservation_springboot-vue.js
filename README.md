# 데모사이트

![image](https://user-images.githubusercontent.com/37436822/67266081-480f5600-f4ea-11e9-8c38-91941daefb77.png)

springboot를 이용하여 제작한 음식점 예약 사이트 입니다. 로그인,관리자,고객,음식점예약 API를 만들어 vue.js를 통해 프론트에 값을 뿌려 줄수 있도록 했습니다.
TDD를 주도적으로 개발했습니다. 

### 개발환경

* spring/springboot
* lombok
* jpa
* vue.js
* mysql
* docker

### 주요기능

* 테이블예약
* 리뷰
* 가게추가
* 메뉴
* 사용자 관리

### 작업방식
프론트 환경은 vue.js를 이용하였고 프론트엔드개발자와 협업하여 구축하였습니다.

저는 주로 Rest API를 작성하여 프론트단에 넘겨주는 형식으로 작성하였습니다.
각각 login,admin,common,restaurant,customar의 API를 각각 분리하여 작업해서 어디서든 쓸수 있도록 했습니다.
테스트와 H2데이터베이스를 이용하여 작업했지만 실제로 웹사이트에 띄울때는 mysql과 docker를 이용하여 전부 띄울수 있도록 했습니다.
토큰을 이용하여 해당 사용자의 비밀번호를 데이터베이스상에서 암호화 시키고 토큰을 통한 인가,인증들을 작업했습니다.

