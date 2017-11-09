package agent.cn.com.mymvptest1.model;

import java.util.List;

/**
 * 数据请求的回调接口
 */
public interface OnRequestListener {
    //        声明了成功和失败的方法
    void onSuccess(List<String> data);

    void onFilcted();
}
