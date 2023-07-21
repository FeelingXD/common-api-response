# common-api-response

## Purpose ✨

이 라이브러리는 rest api 에서 일관적 으로 공통된 response를 보장하기위해 작성한 라이브러리 입니다.

## How to use? 🤔

해당 라이브러리를 임포트하여 사용할 수 있습니다. 

### Setting
```gradle
//setting.gradle 
//다음 과 같이 public repo에서 소스컨트롤러를 추가해줍니다.
sourceControl {
    gitRepository("https://github.com/FeelingXD/common-api-response"){
        producesModule("org.feelingxd:common-api-response")
    }
}

```
```gradle
//build.gradle 
//setting.gradle 추가 이후 build.gradle에서 코드를 임포트합니다.

dependencies {
    implementation 'org.feelingxd:common-api-response:{version}'
}
```


### Response Shape

ApiResponse의 형태는 다음과 같습니다.
```java
    public class ApiResponse<T> {
        private String code;
        private HttpStatus status;
        private String msg;
        private T data;
    }
```


```json
//json 응답 형태

{
    code: "{CODE_NAME}",
    status: "{HTTP_STATUS}",
    msg: "{MSG}",
    data: "{DATA}" //OPTIONAL
}

```
### Example

```java
//Code inteface를 구현해서 Custom Code를 구현할수있습니다.
 public enum ExampleErrorCode implements Code {
  EXAMPLE_ERROR_CODE(HttpStatus.BAD_REQUEST, "테스트 에러코드입니다. xD");

  private final HttpStatus status;
  private final String msg;

  public HttpStatus getStatus() {
    return this.status;
  }

  public String getMsg() {
    return this.msg;
  }

  private ExampleErrorCode(HttpStatus status, String msg) {
    this.status = status;
    this.msg = msg;
  }
}
```

```java
//Api response는 builder 패턴이 적용되어있으며
// ResponseEntity타입으로 변환가능하도록 설계되어있습니다.
// 다음 예제는 간단하게 ApiResponse->ResponseEntity로 다음과같이 빌드할수있습니다.
public class Example {

  public static void main(String[] args){
    var responseEntity =ApiResponse.builder()
    .code(YourCode.EXAMPLE_ERROR_CODE)
    .data(YourCode.code) //optional
    .toEntity(); // ResponseEntity class
    
    var apiResponse =ApiResponse.builder()
    .code(YourCode.EXAMPLE_ERROR_CODE)
    .data(YourCode.code) //optional
    .build() // ApiResponse class
  }
}


```


```java
//code Example
@RestController
@RequestMapping("/")
public class testController {

  @GetMapping("api")
  public ResponseEntity<ApiResponse<String>> commonApiResponse(){
    return ApiResponse.builder()
    .code(ExampleErrorCode.EXAMPLE_ERROR_CODE)
    .toEntity();
  }
}
```

```json
// expected json response
{
    code: "EXAMPLE_ERROR_CODE",
    status: "400",
    msg: "테스트 에러코드입니다. xD",
    data: null //OPTIONAL
}

```
## Dependency
- Java > 8
- Spring-Web 2.7
- Lombok 