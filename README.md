# shopping-mall
가방 쇼핑몰 기획 및 개발

<br>

# 목차
- [개발 환경](#개발-환경)
- [사용 기술](#사용-기술)
    * [백엔드](#백엔드)
    * [프론트엔드](#프론트엔드)
    * [기타 주요 라이브러리](#기타-주요-라이브러리)
- [E-R 다이어그램](#e-r-다이어그램)
- [프로젝트 소개](#프로젝트-소개)
- [핵심 기능](#핵심-기능)
    * [USER 관련 기능](#USER-관련-기능)
    * [게시판](#게시판)
- [CONTACT](#CONTACT)

<br>

## 개발 환경
- IntelliJ IDEA
- Postman
- GitHub
- Visual Studio Code

<br>

## 사용 기술
### 백엔드
#### 주요 프레임워크 / 라이브러리
- Java 8
- Spring Boot 2.4.5
- Mybatis

#### Build tool
- Maven

#### Database
- MariaDB

### 프론트엔드
- Javascript
- HTML/CSS
- JSP (Java Server Pages)

#### 기타 주요 라이브러리
- JSON
- Java Mail Sender
- CKEditor

<br>

## E-R 다이어그램
![suavite-db](https://user-images.githubusercontent.com/83940731/177329056-1d8bc17d-3fa7-40d3-b314-72e76d7e604f.png)

<br>

## 프로젝트 소개

<img width="1792" alt="main" src="https://user-images.githubusercontent.com/83940731/177329406-d511f59f-8fa6-497e-bc98-d58858d134b9.png">

웹 개발 수업을 마무리하고 짧게나마 배웠던 지식들을 가지고 웹 페이지를 구현해 보고 싶었습니다. 
그래서 이번 프로젝트는 배운 내용에 충실하게 user 기능과 crud 게시판에 초점을 맞추어 작업하였습니다.
그리고 웹 디자인 실무 경험을 살려 홈페이지 디자인까지 전부 작업한 결과물을 만들고자 했습니다.
우선, 트렌디한 가방 쇼핑몰 사이트를 개발하고자 컨셉을 잡았습니다.
트렌드를 분석해서 웹 사이트 디자인을 기획하고, 상품들이 돋보일 수 있게 심플한 디자인으로 구상했습니다.
또한 고객 니즈에 맞도록 사용자 중심의 설계를 고민하여 기획하고 개발을 진행했습니다.

<br>

## 핵심 기능
### USER 관련 기능
#### 회원가입
정규식을 적극 활용하여 프론트엔드와 백엔드에서 정보 입력 시 오류 체크를 작업했습니다. 또 중복되는 정보로 가입 등 불법적인 접근이 불가하도록 보안에 신경 써 작업했습니다. 주소 정보 입력 시에는 카카오에서 제공하는 주소 검색 API를 사용해 입력할 수 있도록 하였습니다.

<br>

<img width="1792" alt="join" src="https://user-images.githubusercontent.com/83940731/177334220-bb0134d8-085d-4101-91b6-ed0ea334307b.png">
[회원가입]

<br>

<br>

<br>

<img width="48%" alt="join-email-check" src="https://user-images.githubusercontent.com/83940731/177338503-0a9a005a-98b4-4df0-aac6-1a54656c912d.png"> <img width="48%" align="right" alt="join-check-alert" src="https://user-images.githubusercontent.com/83940731/177338515-9bb41c1a-aec3-4a41-9f8f-302cd52ee990.png">
[데이터 중복 및 정보 미입력 체크]

<br>

<br>

<img width="48%" alt="join-address-api2" src="https://user-images.githubusercontent.com/83940731/177334936-f0bf74c0-40d3-43a2-89c5-a7dc9e3b6d24.png"> <img width="48%" align="right" alt="join-address" src="https://user-images.githubusercontent.com/83940731/177334951-de3ff7d2-96be-41ca-bd41-12895c69ed32.png">
[주소 검색 API]

<br>

<br>

#### 로그인
쿠키를 이용해 자동 로그인 기능을 작업했습니다. 자동 로그인에 체크 후 로그인을 하게 되면 키가 생성되고 해당 테이블에 insert 됩니다. 함께 insert 된 기간 동안 해당 키를 이용해 자동 로그인이 되도록 하였습니다.

<br>

<img width="1792" alt="auto-login" src="https://user-images.githubusercontent.com/83940731/177487680-e9e37b99-ce33-47eb-af1c-c4e517d79448.png">
[로그인 및 자동 로그인 기능]

<br>

<br>

<br>

#### 아이디, 비밀번호 찾기
DB에 저장되어 있는 회원 정보와 일치하는 정보를 입력하게 되면 해당 아이디를 성공 페이지에서 띄울 수 있도록 했습니다. 비밀번호는 Java Mail Sender 라이브러리를 이용하여 작업했습니다. 일치하는 아이디(이메일)로 생성된 임시 비밀번호를 보내어 임시 비밀번호로 로그인할 수 있도록 했습니다.

<br>

<img width="48%" alt="forgot-email" src="https://user-images.githubusercontent.com/83940731/177528761-07119212-d25f-4c83-9a41-344fa00ed071.png"> <img width="48%" align="right" alt="forgot-email-success" src="https://user-images.githubusercontent.com/83940731/177528779-1366435c-3d91-4f9f-82c3-a1c63759be0e.png">
[아이디 찾기]

<br>

<br>

<img width="48%" alt="forgot-password" src="https://user-images.githubusercontent.com/83940731/177530021-ac6d33b3-d7e6-4af1-bfce-17b733852b41.png"> <img width="48%" align="right" alt="forgot-password-success" src="https://user-images.githubusercontent.com/83940731/177530054-64914784-3ad6-47da-87ae-a743efa5fb31.png">
[비밀번호 찾기]

<br>

<br>

<img width="1792" alt="forgot-password-email" src="https://user-images.githubusercontent.com/83940731/177539673-d3bd8049-8fba-43d9-acec-47ffac6c6ef3.png">
[비밀번호 찾기 완료 시 임시 비밀번호 메일 전송]

<br>

<br>

<br>

<br>

### 게시판
유저와의 소통을 위한 community 게시판을 작업했습니다. 공지, 리뷰, Q&A 메뉴로 나누어 기획했습니다. Spring MVC 프레임워크를 이용해 글 작성, 수정, 삭제 기능을 작업했습니다. 조회수 카운트 처리와 글 목록을 불러올 때 글 개수가 초과되면 다음 페이지로 넘어가도록 페이징 처리를 하였습니다.

<img width="48%" alt="board-review" src="https://user-images.githubusercontent.com/83940731/177546077-52f23a87-96ef-479a-9379-8734a169ac35.png"> <img width="48%" align="right" alt="board-read" src="https://user-images.githubusercontent.com/83940731/177548315-233c0335-970d-4b7c-bafb-9e3b8e2b6790.png">
[페이징과 조회수 적용]

<br>

<br>

#### 글 작성 기능
글 작성에는 CKEditor를 적용해 글 작성에 용이하도록 작업했습니다.

<img width="1792" alt="board-write" src="https://user-images.githubusercontent.com/83940731/177548329-8e58f512-3b03-4465-aa49-4aba392d202c.png">
[글 작성]

<br>

<br>

<br>

#### 회원 등급 게시판 적용
회원에 등급을 부여하여 공지 게시판은 관리자만 글을 쓸 수 있는 권한을 적용했습니다.

<img width="1792" alt="board-notice" src="https://user-images.githubusercontent.com/83940731/177544918-fa995723-b566-40e7-8dc3-ca0e544995d9.png">
[회원 등급 적용 한 공지 게시판]

<br>

<br>

## CONTACT

홍수아
<br>
suaah.96@gmail.com


