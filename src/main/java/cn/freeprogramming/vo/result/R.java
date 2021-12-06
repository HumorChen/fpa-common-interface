package cn.freeprogramming.vo.result;

import cn.freeprogramming.interfaces.IErrorEntity;
import cn.freeprogramming.interfaces.IResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 常用格式
 *
 * @author humorchen
 * @date 2021/12/4 16:53
 */
@Data
@AllArgsConstructor
public class R<T> implements IResponse {
    /**
     * 响应代码 0 成功，非0为错误
     */
    private String code;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private T data;


    public static R success() {
        return success(null);
    }

    public static R success(String message) {
        return success(message, null);
    }

    public static R success(Object data) {
        return success("请求成功", null);
    }

    public static R success(String message, Object data) {
        return new R("OK", message, data);
    }

    public static R error(IErrorEntity errorEntity) {
        return new R(errorEntity.getClass().getSimpleName()+"-"+errorEntity.getCode(), errorEntity.getMessage(), null);
    }


}
