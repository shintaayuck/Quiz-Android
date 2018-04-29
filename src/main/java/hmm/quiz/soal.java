package hmm.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class soal extends AppCompatActivity {


    RadioButton jawab12;
    RadioButton jawab23;
    RadioButton jawab51;
    CheckBox jawab31;
    CheckBox jawab32;
    CheckBox jawab33;
    CheckBox jawab34;
    CheckBox jawab35;
    CheckBox jawab41;
    CheckBox jawab42;
    CheckBox jawab43;
    CheckBox jawab44;
    Button btnCheck;
    RadioGroup soal1;
    RadioGroup soal2;
    RadioGroup soal5;
    boolean[] kebenaran = new boolean[]{
            false, false, false, false, false
    };

    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);

        jawab12 = (RadioButton) findViewById(R.id.radio1_2);
        jawab23 = (RadioButton) findViewById(R.id.radio2_3);
        jawab51 = (RadioButton) findViewById(R.id.radio3_1);
        jawab31 = (CheckBox) findViewById(R.id.cbox1_1);
        jawab32 = (CheckBox) findViewById(R.id.cbox1_2);
        jawab33 = (CheckBox) findViewById(R.id.cbox1_3);
        jawab34 = (CheckBox) findViewById(R.id.cbox1_4);
        jawab35 = (CheckBox) findViewById(R.id.cbox1_5);
        jawab41 = (CheckBox) findViewById(R.id.cbox2_1);
        jawab42 = (CheckBox) findViewById(R.id.cbox2_2);
        jawab43 = (CheckBox) findViewById(R.id.cbox2_3);
        jawab44 = (CheckBox) findViewById(R.id.cbox2_4);
        btnCheck = (Button) findViewById(R.id.btn_check);
        soal1 = (RadioGroup) findViewById(R.id.soal_1);
        soal2 = (RadioGroup) findViewById(R.id.soal_2);
        soal5 = (RadioGroup) findViewById(R.id.soal_5);

        nama = getIntent().getStringExtra("nama");

        soal1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio1_2) {
                    kebenaran[0] = true;
                } else {
                    kebenaran[0] = false;
                }
            }
        });

        soal2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio2_3) {
                    kebenaran[1] = true;
                } else {
                    kebenaran[1] = false;
                }
            }
        });

        soal5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio3_1) {
                    kebenaran[4] = true;
                } else {
                    kebenaran[4] = false;
                }
            }
        });


        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (jawab32.isChecked() && jawab34.isChecked() && !jawab31.isChecked() && !jawab33.isChecked() && !jawab35.isChecked()) {
                    kebenaran[2] = true;
                } else {
                    kebenaran[2] = false;
                }

                if (jawab41.isChecked() && jawab42.isChecked() && !jawab43.isChecked() && !jawab44.isChecked()) {
                    kebenaran[3] = true;
                } else {
                    kebenaran[3] = false;
                }

                int nilai = 0;
                int i;

                for (i=0; i<5; i++) {
                    if (kebenaran[i]) {
                        nilai += 20;
                    }
                }

                Intent intent = new Intent(getApplicationContext(), Akhir.class);
                intent.putExtra("namaHasil",nama);
                intent.putExtra("nilai",nilai);


                startActivity(intent);
                finish();
            }
        });
    }
}

