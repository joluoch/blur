package strathcafe.strathcafe.com.chef;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import straathcafe.cairoButton;
import straathcafe.cairoEditText;
import straathcafe.cairoTextView;
import strathcafe.strathcafe.com.R;


public class chefsignup extends AppCompatActivity {

    ImageView _backImageView;
    cairoEditText  _emailEditText, _passwordEditText;
    cairoButton _signUpButton;
    cairoTextView _privicePolice;
    //RelativeLayout _signUpFacebookRelativeLayout;
    View _lineView, _lineView2;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener firebaseAuthLister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        auth = FirebaseAuth.getInstance();
        // listener for a new user

        firebaseAuthLister = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if(user != null){
                    // after signup go to main

                    Intent s = new Intent(chefsignup.this, AdminHome.class);
                    startActivity(s);
                    finish();
                    return;
                }

            }
        };
        /*if (auth.getCurrentUser() != null) {
            startActivity(new Intent(SignUp.this, MainActivity.class));
            finish();
        }*/


        /////*     initialize view   */////
        _backImageView = findViewById(R.id.id_cback_ImageView);
        //_nameEditText = findViewById(R.id.id_name_EditText);
        _emailEditText = findViewById(R.id.id_cemail_EditText);
        _passwordEditText = findViewById(R.id.id_cpassword_EditText);
        _signUpButton = findViewById(R.id.id_signUp_Button);
        _privicePolice = findViewById(R.id.id_privacyPolicy_TextView);
        //_signUpFacebookRelativeLayout = findViewById(R.id.id_SignUpFacebook_RelativeLayout);
        _lineView = findViewById(R.id.id_view_1);
        _lineView2 = findViewById(R.id.id_view_2);


        _signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = _emailEditText.getText().toString();
                final String password =  _passwordEditText.getText().toString();

                try {
                    if (password.length() > 0 && email.length() > 0) {
                        //PD.show();
                        auth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(chefsignup.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (!task.isSuccessful()) {
                                            Toast.makeText(
                                                    chefsignup.this,
                                                    "Authentication Failed",
                                                    Toast.LENGTH_LONG).show();
                                            Log.v("error", task.getResult().toString());
                                        } else {
                                            //adds the id to the customer table

                                            String user_id = auth.getCurrentUser().getUid();
                                            DatabaseReference Current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child("CHEF").child(user_id);
                                            Current_user_db.setValue(true);
                                           /* Intent intent = new Intent(SignUp.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();*/
                                        }
                                        //PD.dismiss();
                                    }
                                });
                    } else {
                        Toast.makeText(
                                chefsignup.this,
                                "Fill All Fields",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



/*
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
*/

        /////*     On Click         */////
      /*  _backImageView.setOnClickListener(this);
        _signUpButton.setOnClickListener(this);
        _privicePolice.setOnClickListener(this);
        _signUpFacebookRelativeLayout.setOnClickListener(this);*/

        /////*      add Drawable to Edit Text and to line view     */////
      /*  _nameEditText.setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(SignUp .this,R.drawable.ic_profile),null,null,null);
        _nameEditText.setCompoundDrawablePadding(8);*/
        _emailEditText.setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(chefsignup .this,R.drawable.ic_email),null,null,null);
        _emailEditText.setCompoundDrawablePadding(8);
        _passwordEditText.setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(chefsignup .this,R.drawable.ic_password_lock),null,null,null);
        _passwordEditText.setCompoundDrawablePadding(8);
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk<android.os.Build.VERSION_CODES.JELLY_BEAN)

        {
            _lineView.setBackgroundDrawable(ContextCompat.getDrawable(chefsignup.this, R.drawable.line_view));
            _lineView2.setBackgroundDrawable(ContextCompat.getDrawable(chefsignup.this, R.drawable.line_view));
        } else

        {
            _lineView.setBackgroundResource(R.color.linecolor);
            _lineView2.setBackgroundResource(R.color.linecolor);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(firebaseAuthLister);

    }

    @Override
    protected void onStop() {

        super.onStop();
        auth.removeAuthStateListener(firebaseAuthLister);
    }
}

/*
    @Override
    public void onClick(View v)
    {
        if (v == _backImageView)
        {
            Intent intent = new Intent(this, SignIn.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out);
        }
        if (v==_signUpButton)
        {
            signupfunction();
        }
        if (v== _privicePolice)
        {
            showprivicypolicy();
        }
        if (v== _signUpFacebookRelativeLayout)
        {
            Toast.makeText(this," please insert Facebook SDK "  ,Toast.LENGTH_LONG).show();
        }

    }*/



   /* private void signupfunction()
    {

        //   Get  Email  && Name  && Password
        String fullName = _nameEditText.getText().toString();
        String email = _emailEditText.getText().toString();
        String password = _passwordEditText.getText().toString();

        //  Check if email and password written and valid
        if (!validate())
        {
            return;
        }else
        {
            signup(fullName,email,password);
        }
    }
*/

  /*  public boolean validate()
    {
        boolean valid = true;

        String fullName = _nameEditText.getText().toString();
        String email = _emailEditText.getText().toString();
        String password = _passwordEditText.getText().toString();

        if (fullName.isEmpty())
        {
            _nameEditText.setError(getString(R.string.enteryourname));
            valid = false;
        } else
        {
            _nameEditText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            _emailEditText.setError(getString(R.string.validemail));
            valid = false;
        } else
        {
            _emailEditText.setError(null);
        }

        if (password.isEmpty() || password.length() < 6 || password.length() > 12)
        {
            _passwordEditText.setError(getString(R.string.validpassword));
            valid = false;
        } else
        {
            _passwordEditText.setError(null);
        }

        return valid;
    }
    private void signup(String fullName, String email, String password)
    {
        //  Sign Up : success
        Toast.makeText(this,"Sign Up : success" + fullName +" " + email +" " + password ,Toast.LENGTH_LONG).show();

    }*/


   /* private void showprivicypolicy()
    {
        AlertDialog.Builder alertDialogBuilder =  new AlertDialog.Builder(this, R.style.DialogTheme);

        alertDialogBuilder.setTitle(getString(R.string.privacypolicy));
        alertDialogBuilder
                .setMessage(getString(R.string.privacypolicyterms))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.OK),new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        dialog.cancel();
                    }
                });


        //    create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();


        //   show it
        alertDialog.show();
    }
*/
