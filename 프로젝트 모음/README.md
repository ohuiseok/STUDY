1. JDBCTest
자바를 이용한 프로젝트 
사용하실 경우
https://github.com/ohuiseok/STUDY/blob/main/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EB%AA%A8%EC%9D%8C/JDBCTest/src/JDBCTest/SQLManage.java

여기 소스코드에서 
```
String url = "jdbc:mysql://경로";
con = DriverManager.getConnection(url, "id", "password");
```
이 두 문장을 수정하시면 됩니다. 경로는 외부 DB의 경로를 넣으면 됩니다. 그에 따른 id password를 이용하시면 됩니다. 
