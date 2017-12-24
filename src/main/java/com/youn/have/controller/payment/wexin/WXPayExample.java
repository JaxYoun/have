package com.youn.have.controller.payment.wexin;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：YangJx
 * @Description：统一下单
 * @DateTime：2017/11/30 16:58
 */
public class WXPayExample {

    /**
     * @Author：YangJx
     * @Description：统一下单
     * @DateTime：
     */
    public static void unifiedOrder() {
        MyWeXinConfig config = null;
        try {
            config = new MyWeXinConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "腾讯充值中心-QQ会员充值");
        data.put("out_trade_no", "2016090910595900000012");
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "123.12.12.123");
        data.put("notify_url", "http://www.example.com/wxpay/notify");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", "12");

        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author：YangJx
     * @Description：订单查询
     * @DateTime：
     */
    public static void orderQuery() {
        MyWeXinConfig config = null;
        try {
            config = new MyWeXinConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", "2016090910595900000012");

        try {
            Map<String, String> resp = wxpay.orderQuery(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author：YangJx
     * @Description：退款查询
     * @DateTime：
     */
    public static void refundQuery() {
        MyWeXinConfig config = null;
        try {
            config = new MyWeXinConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", "2016090910595900000012");

        try {
            Map<String, String> resp = wxpay.refundQuery(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author：YangJx
     * @Description：下载对账单
     * @DateTime：
     */
    public static void downloadBill() {
        MyWeXinConfig config = null;
        try {
            config = new MyWeXinConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("bill_date", "20140603");
        data.put("bill_type", "ALL");

        try {
            Map<String, String> resp = wxpay.downloadBill(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dowloadXmlBill() {
        MyWeXinConfig config = null;
        try {
            config = new MyWeXinConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("bill_date", "20140603");
        data.put("bill_type", "ALL");
        data.put("tar_type", "GZIP");

        try {
            data = wxpay.fillRequestData(data);
            System.out.println(WXPayUtil.mapToXml(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * @Author：YangJx
    * @Description：收到支付结果通知时，需要验证签名，可以这样做
    * @DateTime： 
    */
    public static void validSign() {
        String notifyData = "...."; // 支付结果通知的xml格式数据

        MyWeXinConfig config = null;
        try {
            config = new MyWeXinConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WXPay wxpay = new WXPay(config);

        Map<String, String> notifyMap = null;  // 转换成map
        try {
            notifyMap = WXPayUtil.xmlToMap(notifyData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {
                // 签名正确
                // 进行处理。
                // 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户侧订单状态从退款改成支付成功
            } else {
                // 签名错误，如果数据里没有sign字段，也认为是签名错误
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * @Author：YangJx
    * @Description：HTTPS请求默认使用MD5算法签名，若需要使用HMAC-SHA256
    * @DateTime： 
    */
    public static void hyperHash() {
        MyWeXinConfig config = null;
        try {
            config = new MyWeXinConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WXPay wxpay = new WXPay(config, WXPayConstants.SignType.HMACSHA256);
    }

    /**
    * @Author：YangJx
    * @Description：使用sandbox环境
    * @DateTime： 
    */
    public static void forSandBox() {
        MyWeXinConfig config = null;
        try {
            config = new MyWeXinConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WXPay wxpay = new WXPay(config, WXPayConstants.SignType.MD5, true);
    }

    public static void main(String[] args) throws Exception {


    }

}
