
package com.yiqi.common.validator;

import com.yiqi.common.exception.RRException;
import com.yiqi.common.utils.CodeMsg;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 *
 * @date 2017-03-23 15:50
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new RRException(message);
        }
    }

    public static void isBlank(String str, CodeMsg codeMsg) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(codeMsg);
        }
    }

    public static void isNull(Object object, CodeMsg codeMsg) {
        if (object == null) {
            throw new RRException(codeMsg);
        }
    }
}
