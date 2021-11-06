package vn.edu.usth.testregislogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    DatabaseAcc db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DatabaseAcc(this);
        e1=(EditText) findViewById(R.id.TextEmailL);
        e2=(EditText) findViewById(R.id.TextPasswordL);
        b1=(Button) findViewById(R.id.buttonLogin2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=e1.getText().toString();
                String password=e2.getText().toString();
                Boolean useraccount=db.useraccount(email,password);
                if(useraccount==true)
                    Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Wrong email or password!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}