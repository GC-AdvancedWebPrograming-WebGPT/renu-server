package com.server.authentication.common.exception.auth;

import com.server.authentication.common.exception.ErrorEnumCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthErrorCode implements ErrorEnumCode {
    USER_EXIST("A001","이미 존재하는 유저입니다."),
    USER_NOT_FOUND("A002","존재하지 않는 유저입니다."),
    INVALID_PASSWORD("A003","유효하지 않은 패스워드입니다.")
    ;

    private final String code;
    private final String message;
}
