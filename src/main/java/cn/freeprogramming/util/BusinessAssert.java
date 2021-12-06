package cn.freeprogramming.util;

import cn.freeprogramming.enums.CommonErrorEnums;
import cn.freeprogramming.error.BusinessError;
import cn.freeprogramming.interfaces.IErrorEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 业务断言
 *
 * @author humorchen
 * @date 2021/12/4 17:40
 */
public class BusinessAssert {
    /**
     * 枚举错误缓存
     */
    private static final HashMap<IErrorEntity, BusinessError> ERROR_BUFFER = new HashMap<>();

    /**
     * 如果表达式不为true则抛异常
     *
     * @param expression
     * @param errorEntity
     */
    public static void isTrue(boolean expression, IErrorEntity errorEntity) {
        if (!expression) {
            throwBusinessError(errorEntity);
        }
    }

    /**
     * 字符串长度是否足够
     *
     * @param str
     * @param len
     * @param errorEntity
     */
    public static void hasLength(String str, int len, IErrorEntity errorEntity) {
        if (!StringUtils.hasLength(str, len)) {
            throwBusinessError(errorEntity);
        }
    }

    /**
     * 字符串不为空的
     *
     * @param str
     * @param errorEntity
     */
    public static void notEmpty(String str, IErrorEntity errorEntity) {
        if (StringUtils.isEmpty(str)) {
            throwBusinessError(errorEntity);
        }
    }

    /**
     * 集合不为空
     *
     * @param list
     * @param errorEntity
     */
    public static void notEmpty(List list, IErrorEntity errorEntity) {
        if (list == null || list.size() == 0) {
            throwBusinessError(errorEntity);
        }
    }

    /**
     * map不为空
     *
     * @param map
     * @param errorEntity
     */
    public static void notEmpty(Map map, IErrorEntity errorEntity) {
        if (map == null || map.size() == 0) {
            throwBusinessError(errorEntity);
        }
    }

    /**
     * 队列不为空
     *
     * @param queue
     * @param errorEntity
     */
    public static void notEmpty(Queue queue, IErrorEntity errorEntity) {
        if (queue == null || queue.size() == 0) {
            throwBusinessError(errorEntity);
        }
    }


    /**
     * 抛出业务异常
     *
     * @param errorEntity
     */
    private static void throwBusinessError(IErrorEntity errorEntity) {
        BusinessError businessError;
        if (errorEntity instanceof BusinessError) {
            businessError = (BusinessError) errorEntity;
        } else if (errorEntity.getClass().isEnum()) {
            //枚举的走Buffer
            businessError = ERROR_BUFFER.get(errorEntity);
            if (businessError == null) {
                businessError = new BusinessError(errorEntity);
                ERROR_BUFFER.put(errorEntity, businessError);
            }
        } else {
            //后续其他非枚举类型IErrorEntity不走缓存
            businessError = new BusinessError(errorEntity);
        }
        throw businessError;
    }
}
