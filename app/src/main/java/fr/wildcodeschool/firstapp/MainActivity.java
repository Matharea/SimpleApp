package fr.wildcodeschool.firstapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.button2);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox2);
        final EditText name = findViewById(R.id.editText4);
        final EditText lastname = findViewById(R.id.editText5);
        final TextView validation = findViewById(R.id.textView);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    name.setEnabled(true);
                    lastname.setEnabled(true);
                    button.setEnabled(true);
                }
                else {
                    name.setEnabled(false);
                    lastname.setEnabled(false);
                    button.setEnabled(false);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                Log.e("Activity", "");
                String goodText = getResources().getString(R.string.validate) + " " + name.getText().toString() + " " + lastname.getText().toString();
                int duration = Toast.LENGTH_SHORT;
                //validation.setVisibility(View.VISIBLE);
                if (TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(lastname.getText().toString()))
                    Toast.makeText(context, R.string.empty, duration).show();
                else validation.setText(goodText);
            }
        });
    }
}
