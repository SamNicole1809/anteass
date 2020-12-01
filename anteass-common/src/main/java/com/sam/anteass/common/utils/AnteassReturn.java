package com.sam.anteass.common.utils;

import com.alibaba.fastjson.JSON;

public class AnteassReturn implements Cloneable {

    private static final AnteassReturn instance = new AnteassReturn();

    public AnteassReturn clone() {
        try {
            return (AnteassReturn) super.clone();
        } catch (Exception e) {
            return new AnteassReturn();
        }
    }

    // 初始化方法
    public static AnteassReturn newMessage() {
        return instance.clone();
    }

    private String code;
    private boolean success;
    private String message;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static String notFound() {
        return fullMessage(ReturnEnum.NOT_FOUND.getCode(), false, "查询异常，请稍后再试", null);
    }

    public static String paramError() {
        return fullMessage(ReturnEnum.PARAM_ERROR.getCode(), false, "条件异常，请稍后再试", null);
    }

    public static String forbidden() {
        return fullMessage(ReturnEnum.FORBIDDEN.getCode(), false, "请重新登录", null);
    }

    public static String notAllowed() {
        return fullMessage(ReturnEnum.NOT_ALLOWED.getCode(), false, "无此权限", null);
    }

    public static String serverError() {
        return fullMessage(ReturnEnum.SERVER_ERROR.getCode(), false, "系统异常，请稍后再试", null);
    }

    public static String error(String message) {
        return fullMessage(ReturnEnum.SUCCESS.getCode(), false, message, null);
    }

    public static String ok() {
        return ok(null);
    }

    public static String ok(String message) {
        return ok(message, null);
    }

    public static String ok(String message, Object data) {
        return fullMessage(ReturnEnum.SUCCESS.getCode(), true, message, data);
    }

    public static String ok(Object data) {
        return fullMessage(ReturnEnum.SUCCESS.getCode(), true, "OK", data);
    }

    // 完整方法
    public static String fullMessage(String code, boolean success, String message, Object data) {
        AnteassReturn msg = instance.clone();
        msg.setCode(code);
        msg.setSuccess(success);
        msg.setMessage(message);
        msg.setData(data);
        return JSON.toJSONString(msg);
    }

}
