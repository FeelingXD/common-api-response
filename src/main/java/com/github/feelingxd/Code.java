package com.github.feelingxd;
import org.springframework.http.HttpStatus;

public interface Code {

  String code = null;
  HttpStatus status = null;
  String msg = null;

  default String getCode() {
    return this.toString();
  }

  default HttpStatus getStatus(){
    return this.status;
  };

  default String getMsg(){
    return this.msg;
  };

}

