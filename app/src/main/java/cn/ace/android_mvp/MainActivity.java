package cn.ace.android_mvp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import cn.ace.android_mvp.bean.User;
import cn.ace.android_mvp.presenter.UserLoginPresenter;
import cn.ace.android_mvp.view.IUserLoginView;


/*
 * PACKAGE_NAME :cn.ace.android_mvp
 * VERSION :[V 1.0.0]
 * AUTHOR :  yulongsun
 * CREATE AT : 8/1/2015 3:51 PM
 * COPYRIGHT : InSigma HengTian Software Ltd.
 * E-MAIL: yulongsun@hengtiansoft.com
 * NOTE :
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener, IUserLoginView {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnReset;
    private ProgressBar progressBar;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    private void findViews() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReset = (Button) findViewById(R.id.btn_reset);
        progressBar = (ProgressBar) findViewById(R.id.pb_loading);

        btnLogin.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnLogin) {
            // Handle clicks for btnLogin
            mUserLoginPresenter.Login();
        } else if (v == btnReset) {
            // Handle clicks for btnReset
            mUserLoginPresenter.clear();
        }
    }


    /**获取用户名
     * @return
     */
    @Override
    public String getUserName() {
        return etUsername.getText().toString();
    }

    /**获取密码
     * @return
     */
    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    /**
     * 清除用户名
     */
    @Override
    public void cleanUserName() {
        etUsername.setText("");
    }

    /**
     * 清除密码
     */
    @Override
    public void cleanPassword() {
        etPassword.setText("");
    }

    /**
     * 显示对话框
     */
    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);

    }

    /**
     * 隐藏对话框
     */
    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    /**登录成功，进入主页
     * @param user
     */
    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    /**
     * 登录失败
     */
    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
