package hmm.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Page_1 extends AppCompatActivity {

    EditText bacaNama;
    EditText bacaPrediksi;
    Button btnMulai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_1);
        getSupportActionBar().setTitle(" "); //judul di atas program
        getSupportActionBar().setDisplayHomeAsUpEnabled(false); //tanyain nanti ini buat apa

        //Inisialisasi awal

        bacaNama = (EditText) findViewById(R.id.baca_nama);
        bacaPrediksi = (EditText) findViewById(R.id.baca_prediksi);
        btnMulai = (Button) findViewById(R.id.btn_mulai);

        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(bacaNama.getText()) || TextUtils.isEmpty(bacaPrediksi.getText())) {
                    Toast.makeText(getApplicationContext(), "Field empty", Toast.LENGTH_SHORT).show();
                } else {
                    String nama = bacaNama.getText().toString();
                    String prediksi = bacaPrediksi.getText().toString();

                    Intent intent = new Intent(getApplicationContext(), soal.class);
                    intent.putExtra("nama", nama);

                    startActivity(intent);

                    bacaNama.setText("");
                    bacaPrediksi.setText("");
                }
            }
        });





    }
}
