package com.jiuxiao.zoubei.letusgo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jiuxiao.zoubei.letusgo.R;
import com.jiuxiao.zoubei.letusgo.utils.StringUtils;


public class LoginMainActivity extends Activity implements View.OnClickListener{
    /**
     * 注册和登录按钮
     */
    private TextView mTvForget;
    private TextView mTvRegister;
    /**
     * 密码和账号的编辑框
     */
    private EditText mEtPhone;
    private EditText mEtPwd;

    /**
     *     login button
     */

    private Button mBtnLogin;

    /**
     * 存储账号和密码的字符串
     */
    private String mStrPhone;
    private String mStrPwd;

    private Intent mIntent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        /**
         * 初始化变量和监听
         */
        InitiVariebles();
        InitListener();



    }

    private void InitListener() {

        mBtnLogin.setOnClickListener(this);
        mTvForget.setOnClickListener(this);
        mTvRegister.setOnClickListener(this);

    }


    private void InitiVariebles() {
        mTvForget = (TextView) findViewById(R.id.tv_forgetpassword);
        mTvRegister = (TextView) findViewById(R.id.tv_register);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mEtPhone = (EditText) findViewById(R.id.edt_mail_login);
        mEtPwd = (EditText) findViewById(R.id.edt_password_login);
    }


    private void StartActivity(Class target) {
                mIntent = new Intent(getApplicationContext(), target);
                startActivity(mIntent);
    }

    /**
     * @deprecated 点击事件的监听
     * @param v 控件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            /**
             * Click login
             */
            case R.id.btn_login:
                mStrPhone = mEtPhone.getText().toString();
                mStrPwd = mEtPwd.getText().toString();
                /**
                 *  判断密码账号
                 */
                if (StringUtils.judgeUserFormat(mStrPhone, mStrPwd, this)){
//              mIntent = new Intent(LoginMainActivity.this,LoginRegisterActivity.class);
                    StartActivity(LoginRegisterActivity.class);
                }
                break;
            case R.id.tv_register:
                StartActivity( LoginRegisterActivity.class);
                break;
            case R.id.tv_forgetpassword:
                StartActivity(LoginForgetPasswordActivity.class);
                break;
        }
    }
}
