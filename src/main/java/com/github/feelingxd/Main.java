package com.github.feelingxd;

import com.github.feelingxd.example.ExampleErrorCode;

public class Main {

  public static void main(String[] args) {
    System.out.println(ApiResponse.builder().code(ExampleErrorCode.EXAMPLE_ERROR_CODE).build().toString());
  }
}
