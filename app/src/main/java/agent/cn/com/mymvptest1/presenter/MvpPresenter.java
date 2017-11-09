package agent.cn.com.mymvptest1.presenter;

import android.os.Handler;
import android.os.Looper;

import java.util.List;

import agent.cn.com.mymvptest1.model.OnRequestBizimi;
import agent.cn.com.mymvptest1.model.OnRequestListener;
import agent.cn.com.mymvptest1.view.MvpView;

/**
 * Persenter
 */
public class MvpPresenter {
    MvpView mvpView;
    OnRequestBizimi onRequestBizimi;
    private Handler handler;
    public MvpPresenter(MvpView mvpView){
        this.mvpView=mvpView;
        onRequestBizimi=new OnRequestBizimi();
        handler=new Handler(Looper.getMainLooper());
    }

    public void onResume(){
        mvpView.showloading();
        onRequestBizimi.requestData(new OnRequestListener() {
            @Override
            public void onSuccess(final List<String> data) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mvpView.hiedloading();
                        mvpView.itemData(data);
                    }
                });
            }

            @Override
            public void onFilcted() {
                mvpView.showMessage("网络链接失败");
            }
        });
    }

}
