package strathcafe.strathcafe.com.chef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import strathcafe.strathcafe.com.R;
import strathcafe.strathcafe.com.customer.MainActivity;

public class AdminHome extends AppCompatActivity {

    Button tocustomerhome,AddF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        tocustomerhome=(Button)findViewById(R.id.btntocustomerhome);
        AddF=(Button)findViewById(R.id.btntoaddfood);

        tocustomerhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(AdminHome.this, MainActivity.class);
                startActivity(n);
                finish();
                return;
            }
        });

        AddF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent t = new Intent(AdminHome.this, add.class);
                startActivity(t);
                finish();
                return;

            }
        });
            }


}
