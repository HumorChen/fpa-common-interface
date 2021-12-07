package cn.freeprogramming.enums;

import cn.freeprogramming.interfaces.IErrorEntity;

/**
 * 常用错误枚举（预先定义好的常用错误）
 *
 * @author humorchen
 * @date 2021/12/4 17:12
 */

public enum CommonErrorEnums implements IErrorEntity {
    BUSINESS_ERROR(1, "业务处理错误"),
    ILLEGAL_ARGUMENT(2, "参数不合法"),
    NEED_LOGIN(3, "请先登录"),
    ILLEGAL_REQUEST_BODY(4,"request body exception")

    ;
    private String errorCode;
    private String errorMessage;

    CommonErrorEnums(Integer code, String message) {
        this.errorCode = code + "";
        this.errorMessage = message;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
