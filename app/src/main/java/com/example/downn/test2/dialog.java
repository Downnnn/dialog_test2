package com.example.downn.test2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

public class dialog extends AppCompatActivity implements View.OnClickListener {
    private Button prompt;
    private Button login;

    private void initView() {
        prompt = (Button) findViewById(R.id.prompt);
        login = (Button) findViewById(R.id.login);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        initView();
        prompt.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.prompt:
                new AlertDialog.Builder(this)
                        .setTitle("提示对话框")
                        .setMessage("这里是提示!")
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();

                break;
            case R.id.login:
                final TableLayout tableLayout = (TableLayout) getLayoutInflater().inflate(R.layout.login, null);
                new AlertDialog.Builder(this)
                        .setTitle("登录对话框")
                        .setView(tableLayout)
                        .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String UserID = ((EditText) tableLayout.findViewById(R.id.UserID)).getText().toString();
                                String Password = ((EditText) tableLayout.findViewById(R.id.Password)).getText().toString();

                                if(UserID.equals("abc")&&Password.equals("123")){
                                    Toast.makeText(dialog.this,"登陆成功",Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(dialog.this,"输入错误",Toast.LENGTH_LONG).show();
                                }
                            }
                        })
                        .show();
                break;
            default:
                break;


        }
    }

}
