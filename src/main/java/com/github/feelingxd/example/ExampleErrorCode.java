package com.github.feelingxd.example;

import com.github.feelingxd.Code;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExampleErrorCode implements Code {

  EXAMPLE_ERROR_CODE(HttpStatus.BAD_REQUEST,"테스트 에러코드입니다. xD");

  private final HttpStatus status;
  private final String msg;
}
