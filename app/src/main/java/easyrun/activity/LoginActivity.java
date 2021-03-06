package easyrun.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;
import easyrun.server.SendDateToServer;
import easyrun.util.R;
import easyrun.util.ServerData;


public class LoginActivity extends Activity{

    private EditText account;
    private EditText password;
    private Button loginButton;
    private TextView newUser;
    private ProgressDialog dialog;// 创建等待框

    public static final int SEND_NULL=0x122;


    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SendDateToServer.SEND_SUCCESS:
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    break;
                case SendDateToServer.SEND_FAIL:
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    break;
                case SEND_NULL:
                    Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                default:
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActionBar().hide();
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//解决软键盘遮挡
        setContentView(R.layout.login);
        account = (EditText)findViewById(R.id.account);
        password = (EditText)findViewById(R.id.password);
        loginButton = (Button)findViewById(R.id.LoginButton);
        loginButton.setOnClickListener(loginListener);
        newUser = (TextView)findViewById(R.id.newUser);
        newUser.setOnClickListener(newUserListener);

    }

    TextView.OnClickListener newUserListener = new TextView.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            //finish();
        }
    };

    //登录按钮点击事件
    Button.OnClickListener loginListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.LoginButton:
                    // 检测网络
                    if (!checkNetwork()) {
                        Toast toast = Toast.makeText(LoginActivity.this,"网络未连接", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        break;
                    }
                    /*// 提示框
                    dialog = new ProgressDialog(getParent());
                    dialog.setTitle("提示");
                    dialog.setMessage("登录中...");
                    dialog.setCancelable(false);
                    dialog.show();*/
                    // 创建子线程，进行Post传输
                    new Thread() {
                        public void run() {
                            String username = account.getText().toString();
                            String passwd = password.getText().toString();
                            final String path= ServerData.BaseURL+"LoginServer";
                            if (username.equals("")||passwd.equals("")) {
                                handler.sendEmptyMessage(SEND_NULL);
                            }else{
                                Map<String, String> map = new HashMap<String, String>();
                                map.put("account",username);
                                map.put("password",passwd);
                                try {
                                    String result = new SendDateToServer(handler).doPost(map,path);
                                    if(result.equals("succeed")){
                                        Intent intent = new Intent();
                                        intent.setClass(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }.start();
                    break;
            }
        }
    };

    private boolean checkNetwork() {// 检测网络
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }

}
