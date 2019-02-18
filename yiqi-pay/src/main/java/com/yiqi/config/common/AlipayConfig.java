package com.yiqi.config.common;

public class AlipayConfig {
    // 1.商户appid
    public static String APPID = "2018112262294279";

    // 2.私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC50KZxvOoa6KAcdBpxo4Fmrblh/kgjLkPuu1psxHyuPfbf7sYN/cJvTyMzTNpWeCIQ3qkN47x4wwgX3oJF4n1wvyLVcupWXUwaJoJRippRR7kKDwKK6TweRQmVJK5LLyTGAIQFC4uPZiAkXAec2PyLy/MxGWCHy+6kG6/uYfq/PRijcfe1MBDvRCcosZ5Q5ycriIvW2wat3IpzFT+swtleGTGM9Vy0rsxLvrCM/7nByQtxNfzlXeya+MzaDctgPD/frMpPnrL+xh84B9ojAzkUHVSVUQX6cdthGR8RdTrQnmhyAwoF5JktvYb1LfFo8zR7oecXULXHKdbHl9gEH1G1AgMBAAECggEAWMibXukXKrhQGIhZQkcPw1HqrCnlqfmnN+CJOkNAF7k/xou+Ul0XlDvJ4+8qu/o2vLzHJf3UxhbaPR1yPZYUvdR1/mskERQPEsenqPKC/ac5gNbfLiR3NzdhdsPKC96AwaLpccesbV4sqXLXqFf9g4Z1stYfS4NjiUI5c7uZJdppB+wp8f8ys9mlBMOrP2qc7b0W0LXxbbX6oRPwsP4X46viDZ7ugQFdGTCz9HPa8T7gM9LeuSykUno1GQnTnTjWZzpjj9+bJfAw+2zas0HYejF36LVoDja56W/gdGvF41OiQF1EEmJV7AbDEryZbT3o1bMOWDMDN+3AtfzXbrv9QQKBgQDbQoQMolszmRitqhSz6An8eUMpGTuIZ4UwPQidDCnRykgZXLJsyYrywXrGaAHdVz29pNDymmJkZ584KQQBaeR6halJua89u1HF/nDi5SoYs4Fj0kghOTJpiUSQx8lTk8JYpnVGdk7qp7dQ5hdulbBdrkgzqXxZcrVgk7C3zaejmQKBgQDY83ghVvA6yZ4y9ILJldQ4YP4TmxnToJWlIwufmEkJIfQiyado+m3JM49lRVFzJIACnO/Nc8hCzMMxOKAgZhx8rEyhta20TGdTdNQ2us+H6JSZJ4OloO7NjUHgUN0mA8R82mM7j2bJNGFr9E730IDW76eYKZZ2Xlr7foe93i3wfQKBgF/N5J0QpAEbuCjJ1Fn33cUvxyTCHb0wXoYBZS4aDnvYg0BxvJTES65e1CK1d3sbj6K5zYLz6mIs1OlZIqLrfiX7GUlZlTTIEKcO0oyRzZ8VcEgJrfK2Z0yt6gPJCDM4sQbDVSMAtuLZfcQfhcWQKowEhw/r0qXS9WXJosHtXn6hAoGBAMXXINGmamPxwGZPO4WBMIpJSOmwIxkt88kn8E2VneTKJcwjgJrm5H76meWMFP6fZmz7mGMPFqxz9fxI2x0wgQHgTfGZr9Ifaopcm7ldGiuiGQChXBgKbjrcehqJI2KrRN9md9+0odMSBVVg8TJj3VokKf1Ez4UZ/nYhqL+ogNQxAoGBANiDX4GX+iTvniMkI6A5njO4VkVPc8msvtRiL9ky3imY1JiLyti3BNjrVV3eblfO2oTI58sNoXYOU9IIaEZBSL61RFxneWVS1z9FpZB3iERnk1es8v5XVnA2T9aclI9rUhY4kfLW+MBtmTowD3UJL59eV2QiHXb5STYj6nLbn4s9";

    // 3.支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoVnVdSrvK/1iPJ4N+Yd53fgRWvF84RS8zQJSaKrJVccd3uqIqzkn5YjbEOHDZT9YCiy50WtQ3FE5uVdgOF8D6jIOvajHTvM2fAUt5abRxyYFCBEz1o9ivw6kBc9RBNMTWU/Bn39UcpHK/DeQGP4AWmi+A2fOsvqqkkGoBXmJVV300cl3+R4vCcweM9u5BR1J6D3xe8PFjDp3RBkfSickoef7K0CR2r1r6UQ0sYEdoBmvLdUoB/HdRasr7C+kB8jax7+rzP9K+RikFQNVl1hbBgZOhfFc+maRSpONBkvSX30U3f1CCKALvnWG+mjQ/FrshPhSYKTTSALwVCTV3aSowQIDAQAB";

    // 4.服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // public static String notify_url = "http://120.79.67.29/hangjia/pay/apialipay_notify_url.shtml";

    // public static String notify_url = "http://120.79.160.149/hangjia/pay/apialipay_notify_url.shtml";

    //订单回调
    public static String order_notify_url = NotifyUrlIp.PAYIP + "/pay/order_notify_url.shtml";
    //充值回调
    public static String recharge_notify_url = NotifyUrlIp.PAYIP + "/pay/recharge_notify_url.shtml";


    public static String URL = "https://openapi.alipay.com/gateway.do";


    // 7.编码
    public static String CHARSET = "utf-8";
    public static String CHARSET2 = "GBK";

    // 8.返回格式
    public static String FORMAT = "json";

    // 9.加密类型
    public static String SIGNTYPE = "RSA2";


}