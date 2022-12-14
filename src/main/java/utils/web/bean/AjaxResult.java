package utils.web.bean;


import lombok.Data;


@Data
//@ApiModel(value ="统一ajax返回对象")
public class AjaxResult<T> {

    /**
     * 状态码
     */

    private int code;

    /**
     * 返回内容
     */

    private String msg;

    /**
     * 数据对象
     */

    private T data;

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public AjaxResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public AjaxResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;


    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static<T>  AjaxResult<T>  success() {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static  <T> AjaxResult<T>  success(T data) {
        return AjaxResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static<T>  AjaxResult<T>  success(String msg) {
        return AjaxResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static  <T> AjaxResult<T>  success(String msg, T data) {
        return new AjaxResult<T>(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static<T> AjaxResult<T> error() {
        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static<T>  AjaxResult<T>  error(String msg) {
        return AjaxResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static <T> AjaxResult<T>  error(String msg, T data) {
        return new AjaxResult<T> (HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static <T> AjaxResult <T> error(int code, String msg) {
        return new AjaxResult<T> (code, msg, null);
    }


    /**
     * 响应返回结果
     *
     * @param b 影响行数
     * @return 操作结果
     */
    public static<T>  AjaxResult<T>  toAjax(Boolean b) {
        return b ? AjaxResult.success() : AjaxResult.error();
    }



}
