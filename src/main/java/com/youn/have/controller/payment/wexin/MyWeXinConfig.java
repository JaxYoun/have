package com.youn.have.controller.payment.wexin;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：YangJx
 * @Description：微信支付配置类
 * @DateTime：2017/11/30 16:53
 */
public class MyWeXinConfig implements WXPayConfig {

    private byte[] certData;

    public MyWeXinConfig() throws Exception {
        String certPath = "/path/to/apiclient_cert.p12";
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    @Override
    public String getAppID() {
        return "wx8888888888888888";
    }
    @Override
    public String getMchID() {
        return "12888888";
    }
    @Override
    public String getKey() {
        return "88888888888888888888888888888888";
    }
    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }
    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }
    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }

}
