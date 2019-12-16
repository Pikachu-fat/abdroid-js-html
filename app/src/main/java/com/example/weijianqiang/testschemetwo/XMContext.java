package com.example.weijianqiang.testschemetwo;

import android.content.Context;

/**
 * Created by weijianqiang
 * On 2019/12/6
 * Description:
 */
public class XMContext {
    private static Context context;
    private XMContext(){}


    public static Context getContext(){
        return context;
    }

    public static void setContext(Context context){
        XMContext.context = context;
    }
}
