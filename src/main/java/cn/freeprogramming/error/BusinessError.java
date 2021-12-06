package cn.freeprogramming.error;

import cn.freeprogramming.enums.CommonErrorEnums;
import cn.freeprogramming.interfaces.IErrorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * 业务错误实体类（自己业务需要则用该类创建一个错误）
 *
 * @author humorchen
 * @date 2021/12/4 17:04
 */
@ToString
@Data
@Getter
public class BusinessError extends RuntimeException implements IErrorEntity {
    private Integer code;
    private String message;

    /**
     * 不需要错误代码的构造方法
     *
     * @param message
     */
    public BusinessError(String message) {
        this.code = CommonErrorEnums.BUSINESS_ERROR.getCode();
        this.message = message;
    }

    public BusinessError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessError(IErrorEntity errorEntity) {
        this.code = errorEntity.getCode();
        this.message = errorEntity.getMessage();
    }

}
