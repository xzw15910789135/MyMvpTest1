package agent.cn.com.mymvptest1.model;

import java.util.ArrayList;

/**
 * 请求的实现类为了模拟网络请求
 */
public class OnRequestBizimi implements RequestBizi {
    //  开启了一个会sleep2秒的线程，然后装填请求的数据，通过OnRequestListener 接口回调出去
    @Override
    public void requestData(final OnRequestListener onRequestListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    ArrayList<String> list = new ArrayList<String>();
                    for (int i = 0; i < 8; i++) {
                        list.add("item" + i);
                    }
                    if (onRequestListener != null) {
                        onRequestListener.onSuccess(list);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
