package strathcafe.strathcafe.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import strathcafe.strathcafe.com.chef.cheflogin;
import strathcafe.strathcafe.com.customer.SignIn;

public class home extends AppCompatActivity {
    private TextView customerlogin,cheflog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        customerlogin=(TextView)findViewById(R.id.Clogin);
        cheflog=(TextView)findViewById(R.id.cLogin);


        customerlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(home.this, SignIn.class);
                startActivity(p);
                finish();
                return;
            }
        });

        cheflog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(home.this, cheflogin.class);
                startActivity(s);
                finish();
                return;
            }
        });
    }
}
