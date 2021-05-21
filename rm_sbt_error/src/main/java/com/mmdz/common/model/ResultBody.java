package com.mmdz.common.model;

import com.alibaba.fastjson.JSONObject;
import com.mmdz.exception.model.BaseErrorInfoInterface;
import lombok.Data;

/**
 * @Author: MMDZ
 * @Date: 2021/5/20
 * @Desc:
 */
@Data
public class ResultBody {

    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object result;

    public ResultBody() {
    }

    public ResultBody(BaseErrorInfoInterface errorInfo) {
        this.code = errorInfo.getResultCode();
        this.message = errorInfo.getResultMsg();
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultBody success(String code, String message, Object result) {
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setResult(result);
        return rb;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultBody success(Object data) {
        return success(CommonEnum.SUCCESS.getResultCode(),CommonEnum.SUCCESS.getResultMsg(),data);
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message) {
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(BaseErrorInfoInterface errorInfo) {
        return error(errorInfo.getResultCode(),errorInfo.getResultMsg());
    }

    /**
     * 失败
     */
    public static ResultBody error( String message) {
        return error("-1", message);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
