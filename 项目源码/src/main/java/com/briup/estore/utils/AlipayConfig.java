package com.briup.estore.utils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AlipayConfig {
  /**
   * 服务网关   沙箱环境都是这个
   */
  public static String serverUrl = "https://openapi.alipaydev.com/gateway.do";
  
  /**
   * 应用id  后期可以替换成自己的id
   */
  public static String appId = "2021000119646365";
  
  /**
   *  用户私钥   后期替换成自己的私钥
   */
  public static String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCKEXqm3vfzmUp/LTmXKKFS+/lF45+SuOxZ/QlUYipOtrgc10lufGJ3IKbGnrL8+p/DrKGrcCv7ySLDhpNT4PIIPgQAMWPTheTUNDZbVq8L2lVSL/17IQXjzRSUs5GwCZIBdqXdx9K6YrUtEDG0I2l/zflglUMslmq79wK2LOTklX7ZlR/HBCihdDI4KVEINlfqX29KI4NNeX90qh7Bc2v1hHwQke4C2XVmTSn2/SiEOUn16aeAwrYKWhdDCRXT029vUKVyCE5WbWWOLiNkJ7Vj3DYuXRbyPGwJAos42q/ec+QY/6GDflIcukWBAkXx9Z4hBlrIrTjsozdJIknAsGa5AgMBAAECggEAAO3XLnJHptr8Nljej1bVpxJM/hxnAXy/EmfyfR/f+wGdwYvtUZICs5yDosiEmdEx7AYoXFf348zZsAkiyqiz2DxamIm8izrWbFshloHB0cmZU2FBSmfRe1Pw9IM00sNtuRbMTO7AS0LIx1HZk8W9Ov/u0qiOeClW9IbX/NPWgndAh2Wj1X/2KSnlVaS1sQgvvIHt2ESj1PgGUIPOXIs9O9QIbQb2D0BF/WLCmdnXdaN/9eSzmUwKZe5D3qCVUJq/1wqc2yxYOIpgHHKumM6aFDMdPepxmaBpDntS7tuV9LE8++zWrKNaUGl/7rnR7YPYJKrm14kM2FVjDzJDryuMxQKBgQDHewN6pw0N+ggANyoDjWgmuKT6QsIc+ryYzhR4sU2FvW35MGW8YQAmQkyX+vWoud5hTZEEhwswZ/V4lBmpExp7ELaLKT0PiEsnhnedzdIFikrskuX3gah4CUQyJmdJo7nOtxdxI99oQUzK1jXpsCppt1wvt75eMspODl3Pwj/gewKBgQCxMAfuxF14Cqeyj8Y4JrQ0Rj1yAwkbFd5nyezLl6LV7Qx+xvyK5+VcHAU40Dwk9CyzmpxE73oqgz3XontbzzKZ7uIk24spZLeh+ntI7nSFAhcgX9s/6CeVcLhNW0rfZGkAY8Bd9MsPJUJSe1dM+DPkllZH1l2CRHOtGX25mLdhWwKBgGZwRoYa+To/NxKdQYcXe+++jIIz/CkTnfw+gAbGzk+qyqnX77bAfWooS9sUNklSQd/oDFut2dIe4NDuBQttUwD1wThPkhrC3A1NIWo5Quwza2x3t37V56TU5V93lz0axhVgsroYOOb5+ayEOqVqIS2uyrl6e1k2beuNtyE02Ma3AoGBAJ8ym34AukY3tJKvsRYUWEa7cUu1xIGsdWZlO7d0554z3M0vdgpL7nyCxIJWPiOpq1w3pv4c+HOn9XGAEDvd/wXlZxRcmT04u/Dx/8D4VoKG7UZuOazCpoYTf9QpGS17pwftmBIS9jsGa/91yGtkeiOAm8bxqJR5ckFtrNOLjgAPAoGBAIPJLo2gaUQpBQ73WYFeHuhmIrmnAwZK6tQskOB02g9UBLKw/B4LkXJf6rFlVD8ByhQqXz939eQPgIcjkkDIsnOuCHpiYF6j6ZCvSLgCmyj4zcdudwpwsKSWfn49Rc3qTcXP6UVW+tMxK/RUhCe2Xz/bVPaVufhglIuJyPgqWMX6";
  
  /**
   *  发送数据的格式 目前只能为json
   */
  public static String format = "json";
  
  /**
   *  设置字符集编码 目前只能为utf-8
   */
  public static String charset = "utf-8";

  /**
   *  支付宝公钥 后期替换成自己的支付宝公钥
   */
  public static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhzG55tP0OY+iKsu9vgmmuYkt9jbtymtArj3JL0T8/SrJFiUiJONqEYuo2Qmw4LTyPlk5SO2RmpWa6qWNpW1ZY/+TdlXxQvnC8TZ1bOj1nOroHxlO8E05qWusRJa9oz6NVOznNTM4eRC9PGazBoGZjOl4CcLQTVgTyb05G8fRE7w7XQIH1eYgEPO5sai+iacdoh+Ndjh9MOZX2urlM7pfGSeBbYZzDmrMCydst3fMtTu8CxkFvju3kfi7QqnjHkUFD4JZTqyzEnIAzNzZ1+IEzZPTtF+LJYCmAvaM3PnrBu4phuGCVpxGe7V8wVOf31bttQ3Fk0MX+kgyykDPxUPl9QIDAQAB";
  
  /**
   *  支付宝签名 目前是 RSA2
   */
  public static String signType = "RSA2";

  /**
   *  页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
   */
  public static String return_url = "http://localhost:9999/JD03_estore/index.jsp";
  
  public static AlipayClient getAlipayClient() {
      // 获得初始化的AlipayClient
      AlipayClient alipayClient = new DefaultAlipayClient
    		  (AlipayConfig.serverUrl, AlipayConfig.appId, 
    		AlipayConfig.privateKey, AlipayConfig.format, 
    		AlipayConfig.charset, AlipayConfig.publicKey, AlipayConfig.signType);
      return alipayClient;
  }

}