package agent.cn.com.mymvptest1.view;

import java.util.List;

/**
 * View层需要实现哪些方法
 */
public interface MvpView {
    //显示loading progress
    void showloading();
    //隐藏loading progress
    void hiedloading();
    //ListView的初始化
    void itemData(List<String> list);
    //ListView的初始化
    void showMessage(String str);
}
