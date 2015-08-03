package cn.ace.android_mvp.biz.impl;

import cn.ace.android_mvp.bean.User;
import cn.ace.android_mvp.biz.inter.IUserBiz;
import cn.ace.android_mvp.biz.inter.OnLoginListener;

/*
 * PACKAGE_NAME :cn.ace.android_mvp.biz.impl
 * VERSION :[V 1.0.0]
 * AUTHOR :  yulongsun
 * CREATE AT : 8/1/2015 3:51 PM
 * COPYRIGHT : InSigma HengTian Software Ltd.
 * E-MAIL: yulongsun@hengtiansoft.com
 * NOTE :  业务层实现类
 */
public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登陆成功
                if ("syl".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.LoginSuccess(user);
                } else {
                    loginListener.LoginFailed();
                }

            }
        }.start();
    }
}
