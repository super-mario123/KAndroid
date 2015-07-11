package com.android.mario.api;

import com.android.mario.api.utils.EncrypUtil;
import com.android.mario.model.CouponBO;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/7/10.
 */
public class ApiImpl implements Api {
    private static final String APP_KEY = "ANDROID_KCOUPON";

    private static final String TIME_OUT_EVENT = "CONNECT_TIME_OUT";

    private static final String TIME_OUT_EVENT_MSG = "连接服务器失败";

    private HttpEngine httpEngine;

    public ApiImpl(){
        httpEngine = HttpEngine.getInstance();
    }
    @Override
    public ApiResponse<Void> sendSmsCode4Register(String phoneNum) {
        Map<String, String> paramsMap = new HashMap<>();

        paramsMap.put("appKey",APP_KEY);
        paramsMap.put("method",SEND_SMS_CODE);
        paramsMap.put("phoneNumber",phoneNum);

        Type type = new TypeToken<ApiResponse<Void>>(){}.getType();

        try {
            return httpEngine.postHandle(paramsMap,type);
        } catch (IOException e) {
            e.printStackTrace();
            return new ApiResponse<>(TIME_OUT_EVENT,TIME_OUT_EVENT_MSG);
        }
    }

    @Override
    public ApiResponse<Void> registerByPhone(String phoneNum, String code, String password) {
        Map<String, String> paramsMap = new HashMap<>();

        paramsMap.put("appKey",APP_KEY);
        paramsMap.put("method",REGISTER);
        paramsMap.put("phoneNum",phoneNum);
        paramsMap.put("code",code);
        paramsMap.put("password", EncrypUtil.makeMD5(password));

        Type type = new TypeToken<ApiResponse<List<CouponBO>>>(){}.getType();

        try {
            return httpEngine.postHandle(paramsMap,type);
        } catch (IOException e) {
            e.printStackTrace();
            return new ApiResponse<>(TIME_OUT_EVENT,TIME_OUT_EVENT_MSG);
        }
    }

    @Override
    public ApiResponse<Void> loginByApp(String loginName, String password, String imei, int loginOS) {
        Map<String, String> paramsMap = new HashMap<>();

        paramsMap.put("appKey",APP_KEY);
        paramsMap.put("method",LOGIN);
        paramsMap.put("loginName",loginName);
        paramsMap.put("password",EncrypUtil.makeMD5(password));
        paramsMap.put("imei",imei);
        paramsMap.put("loginOS",String.valueOf(loginOS));

        Type type = new TypeToken<ApiResponse<List<CouponBO>>>(){}.getType();

        try {
            return httpEngine.postHandle(paramsMap,type);
        } catch (IOException e) {
            e.printStackTrace();
            return new ApiResponse<>(TIME_OUT_EVENT,TIME_OUT_EVENT_MSG);
        }
    }

    @Override
    public ApiResponse<List<CouponBO>> listNewCoupon(int currentPage, int pageSize) {
        Map<String, String> paramsMap = new HashMap<>();

        paramsMap.put("appKey",APP_KEY);
        paramsMap.put("method",LIST_COUPON);
        paramsMap.put("currentPage",String.valueOf(currentPage));
        paramsMap.put("pageSize",String.valueOf(pageSize));

        Type type = new TypeToken<ApiResponse<List<CouponBO>>>(){}.getType();

        try {
            return httpEngine.postHandle(paramsMap,type);
        } catch (IOException e) {
            e.printStackTrace();
            return new ApiResponse<>(TIME_OUT_EVENT,TIME_OUT_EVENT_MSG);
        }
    }
}
