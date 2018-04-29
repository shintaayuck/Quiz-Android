package hmm.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Akhir extends AppCompatActivity {
    TextView namaAkhir;
    TextView scoreAkhir;

    String nama;
    int nilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akhir);
        namaAkhir = (TextView)findViewById(R.id.nama_akhirr);
        scoreAkhir = (TextView) findViewById(R.id.score_akhir);

        nama = getIntent().getStringExtra("namaHasil");
        nilai = getIntent().getIntExtra("nilai",0);

        namaAkhir.setText(nama);
        scoreAkhir.setText(String.valueOf(nilai));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
