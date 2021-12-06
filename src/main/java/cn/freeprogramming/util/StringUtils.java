package cn.freeprogramming.util;

/**
 * 字符串工具类
 *
 * @author humorchen
 * @date 2021/12/4 18:01
 */
public class StringUtils {

    /**
     * 是否为空字符串
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否有足够长度
     *
     * @param str
     * @param len
     * @return
     */
    public static boolean hasLength(String str, int len) {
        if (!isEmpty(str)) {
            return str.length() >= len;
        }
        return false;
    }

}
