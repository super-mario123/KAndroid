package com.android.mario.kandroid;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private FloatingActionButton btnFab;
    private CoordinatorLayout layoutRoot;
    private EditText userNameEdit;
    private EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEdit = (EditText) findViewById(R.id.edit_input_userName);
        passwordEdit = (EditText) findViewById(R.id.edit_input_password);
        btnFab = (FloatingActionButton) findViewById(R.id.btnFloatingButton);
        layoutRoot = (CoordinatorLayout) findViewById(R.id.root_layout);
        btnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = userNameEdit.getText().toString().trim();
                String password = passwordEdit.getText().toString().trim();

                if (userName.equals("mario") && password.equals("123456")) {
                    Snackbar.make(layoutRoot, "Login success", Snackbar.LENGTH_SHORT).setAction("Just do it", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).show();
                }else {
                    Snackbar.make(layoutRoot, "Login failure", Snackbar.LENGTH_SHORT).setAction("Just do it", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).show();
                }
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
