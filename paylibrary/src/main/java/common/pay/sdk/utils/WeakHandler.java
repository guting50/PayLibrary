package common.pay.sdk.utils;

import android.os.Handler;

import java.lang.ref.WeakReference;

/**
 * DESC: 将宿主弱引用的Handler
 */
public class WeakHandler<T> extends Handler {

    private WeakReference<T> mOwner;

    /**
     * 生成弱引用对象
     *
     * @param owner 被 弱引用对象
     */
    public WeakHandler(T owner) {
        mOwner = new WeakReference<T>(owner);
    }

    public T getOwner() {
        return mOwner.get();
    }
}
