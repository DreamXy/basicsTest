package com.yiqi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 生成不重复的uid
 * @author chan
 * @email chan150@163.com
 * @date 2019-01-06 12:10:18
 */
public class OrderUUID {

    private static int sequence = 0;

    private static int length = 4;

    /**
     * YYYYMMDDHHMMSS+6位自增长码(20位)
     *
     * @return
     */
    public static synchronized String getLocalTrmSeqNum() {
        sequence = sequence >= 999999 ? 1 : sequence + 1;
        String datetime = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date());
        String s = Integer.toString(sequence);
        return datetime +addLeftZero(s, length);
    }

    /**
     * 左填0
     * @param s
     * @param length
     * @return
     */
    public static String addLeftZero(String s, int length) {
        // StringBuilder sb=new StringBuilder();
        int old = s.length();
        if (length > old) {
            char[] c = new char[length];
            char[] x = s.toCharArray();
            if (x.length > length) {
                throw new IllegalArgumentException(
                        "Numeric value is larger than intended length: " + s
                                + " LEN " + length);
            }
            int lim = c.length - x.length;
            for (int i = 0; i < lim; i++) {
                c[i] = '0';
            }
            System.arraycopy(x, 0, c, lim, x.length);
            return new String(c);
        }
        return s.substring(0, length);
    }

    /*
     * 使用UUID生成唯一的订单编号
     *
     * type : DD(为订单)
     */
    public static String getOrderIdByUUId(String type) {
        int machineId = 1;// 最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {// 有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return type + machineId + String.format("%011d", hashCodeV);
    }

    public static String getTcUUId(String type) {
        int machineId = 1;// 最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {// 有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return type + machineId + String.format("%04d", hashCodeV);
    }

    public static String getUserUid() {
        int machineId = 1;// 最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {// 有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        String userUid = hashCodeV + "";
        return userUid.substring(0, 5);
    }


    public static String getToken() {
        return UUID.randomUUID().toString();
    }
}
