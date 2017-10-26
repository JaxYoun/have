package com.youn.have.javaNewFeature.base64;

import java.util.Base64;

/**
 * 在Java 8中，Base64编码已经成为其类库的标准。
 * Java 8 内置了 Base64 的编码器和解码器。
 * Base64工具类提供了一套静态方法获取下面三种BASE64编解码器：
 * ——基本：输出被映射到一组字符A-Za-z0-9+/，编码不添加任何行标，输出的解码仅支持A-Za-z0-9+/。
 * ——URL：输出映射到一组字符A-Za-z0-9+_，输出是URL和文件。
 * ——MIME：输出隐射到MIME友好格式。输出每行不超过76字符，并且使用'\r'并跟随'\n'作为分割。编码输出最后没有行分割。
 * <p>
 * 同时还提供了编码器、解码器内嵌类
 * ——static class Base64.Encoder 该类实现一个编码器，使用 Base64 编码来编码字节数据。
 * ——static class Base64.Decoder 该类实现一个解码器用于，使用 Base64 编码来解码字节数据。
 */
public class Base64Test {

    /**
     * 基本base64编解码
     */
    public static void basicTypeBase64() {
        String originString = "english";
        System.out.println("原始字符串" + originString);

        String basicEncodedString = Base64.getEncoder().encodeToString(originString.getBytes());
        System.out.println("基本型编码" + basicEncodedString);

        byte[] basicDecodedByteArr = Base64.getDecoder().decode(basicEncodedString);
        System.out.println("基本型解码" + new String(basicDecodedByteArr));
    }

    /**
     * mine型base64编解码
     */
    public static void mineTypeBase64() {
        String originMineString = "minimize";
        System.out.println("Mine型原始字符：" + originMineString);

        String mineEncodedString = Base64.getMimeEncoder().encodeToString(originMineString.getBytes());
        System.out.println("Mine型编码：" + mineEncodedString);

        byte[] mineDecodedByteArr = Base64.getMimeDecoder().decode(mineEncodedString);
        System.out.println("Mine型解码：" + new String(mineDecodedByteArr));
    }

    /**
     * URL型base64编解码
     */
    public static void utlTypeBase64() {
        String originUrlString = "www.baidu.com";
        System.out.println("Url型原始字符：" + originUrlString);

        String urlEncodedString = Base64.getUrlEncoder().encodeToString(originUrlString.getBytes());
        System.out.println("Url型编码：" + urlEncodedString);

        byte[] urlDecodedByteArr = Base64.getUrlDecoder().decode(urlEncodedString);
        System.out.println("Url型解码：" + new String(urlDecodedByteArr));
    }

    public static void main(String[] args) {
//        basicTypeBase64();
//        mineTypeBase64();
        utlTypeBase64();
    }

}
