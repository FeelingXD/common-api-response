package com.github.feelingxd.example;

import com.github.feelingxd.Code;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExampleResponseCode implements Code {
  RESPONSE_DELETED(HttpStatus.NO_CONTENT, "DELETED"),
  RESPONSE_CREATED(HttpStatus.CREATED, "CREATED"),
  RESPONSE_SUCCESS(HttpStatus.OK, "SUCCESS"),
  RESPONSE_FAIL(HttpStatus.BAD_REQUEST, "FAIL");
  HttpStatus status;
  String msg;
}
