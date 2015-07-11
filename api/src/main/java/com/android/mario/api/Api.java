package com.android.mario.api;

import com.android.mario.model.CouponBO;

import java.util.List;

/**
 * Created by Administrator on 2015/7/10.
 */
public interface Api {

    //发送验证码
    public static final String SEND_SMS_CODE = "service.sendSmsCode4Register";

    //注册
    public static final String REGISTER = "customer.registerByPhone";

    //登陆
    public static final String LOGIN = "customer.loginByApp";

    //卷列表
    public static final String LIST_COUPON = "issue.listNewCoupon";

    /**
     * 发送验证码
     *
     * @param number    手机号码
     * @return          成功时返回 {"event":"0","msg":"success"}
     */
    public ApiResponse<Void> sendSmsCode4Register(String number);

    /**
     * ע��
     *
     * @param number    手机号码
     * @param code      验证码
     * @param password  MD5加密的密码
     * @return          成功时返回 {"event":"0","msg":"success"}
     */
    public ApiResponse<Void> registerByPhone(String number, String code, String password);

    /**
     * ��½
     *
     * @param loginName     登陆名
     * @param password      MD5加密的密码
     * @param imei          手机IMEI串号
     * @param loginOS       Android为1
     * @return              成功时返回 {"event":"0","msg":"success"}
     */
    public ApiResponse<Void> loginByApp(String loginName, String password, String imei, int loginOS);

    /**
     * 卷列表
     *
     * @param currentPage   当前页数
     * @param pageSize      每页显示的数量
     * @return              成功时返回 {"event":"0","msg":"success","objList":[...]}
     */
    public ApiResponse<List<CouponBO>> listNewCoupon(int currentPage, int pageSize);

}
