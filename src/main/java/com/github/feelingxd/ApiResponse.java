package com.github.feelingxd;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 * The {@code ApiResponse} 클래스는 코드, 상태, 메시지 및 데이터를 포함하는 제네릭 API 응답을 나타냅니다.
 *
 * @param <T> 는 반환할 데이터를 담는 매개변수입니다.
 */
@Data
@AllArgsConstructor
public class ApiResponse<T> {

  private String code;
  private HttpStatus status;
  private String msg;
  private T data;

  /**
   * 제공된 코드와 데이터로 {@code ApiResponse} 객체를 생성합니다.
   *
   * @param code 응답 상태를 나타내는 코드입니다.
   * @param data 응답과 연관된 데이터입니다.
   */
  public ApiResponse(Code code, T data) {
    this.code = code.getCode();
    this.status = code.getStatus();
    this.msg = code.getMsg();
    this.data = data;
  }

  public static <T> ApiResponseBuilder<T> builder() {
    return new ApiResponseBuilder<T>();
  }


  public static class ApiResponseBuilder<T> {

    private Code code;
    private T data;

    ApiResponseBuilder() {
    }

    public ApiResponseBuilder<T> code(Code code) {
      this.code = code;
      return this;
    }

    public ApiResponseBuilder<T> data(T data) {
      this.data = data;
      return this;
    }

    public ApiResponse<T> build() {
      return new ApiResponse<>(code, data);
    }

    public <T> ResponseEntity<ApiResponse<T>> toEntity() {
      return ResponseEntity.status(this.code.getStatus().value()).body(new ApiResponse<>(code, (T) data));
    }

    public String toString() {
      return "ApiResponse.ApiResponseBuilder(code=" + this.code + ", data=" + this.data + ")";
    }
  }
}
