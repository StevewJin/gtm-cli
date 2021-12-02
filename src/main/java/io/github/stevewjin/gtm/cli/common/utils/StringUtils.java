package io.github.stevewjin.gtm.cli.common.utils;

/**
 * @author Steve Jin
 * @version 1.0.0
 * @description
 * @date 2021-12-02 18:22
 */
public class StringUtils {

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

}
