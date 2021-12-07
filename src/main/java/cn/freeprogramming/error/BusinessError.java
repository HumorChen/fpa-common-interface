package cn.freeprogramming.error;

import cn.freeprogramming.enums.CommonErrorEnums;
import cn.freeprogramming.interfaces.IErrorEntity;
import cn.hutool.core.util.EnumUtil;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.apache.dubbo.rpc.RpcException;

/**
 * 业务错误实体类（自己业务需要则用该类创建一个错误）
 *
 * @author humorchen
 * @date 2021/12/4 17:04
 */
@ToString
@Data
public class BusinessError extends RpcException implements IErrorEntity {
    private String errorCode;
    private String errorMessage;

    /**
     * 不需要错误代码的构造方法
     *
     * @param message
     */
    public BusinessError(String message) {
        this(CommonErrorEnums.BUSINESS_ERROR.name(), message);
    }

    public BusinessError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessError(IErrorEntity errorEntity) {
        this(errorEntity.getClass().getSimpleName()+"-"+errorEntity.getErrorCode(), errorEntity.getErrorMessage());
    }

}
