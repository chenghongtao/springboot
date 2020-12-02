package com.cht.springboot_mybaties.execption;

public enum ErrorEnum {

    DATA_VALID_ERROR(400, "参数校验不通过"),
    UNNOW_ERROR(600, "位置错误");

    private int code;

    private String message;

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
