package przem.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView smallTextView, bigTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smallTextView = findViewById(R.id.smallTextView);
        bigTextView = findViewById(R.id.bigTextView);
    }

    public void zerobclick(View view) {
        bigTextView.append("0");
    }

    public void pointbclick(View view) {
        bigTextView.append(".");
    }

    public void equalsbclick(View view) {

    }

    public void onebclick(View view) {
        bigTextView.append("1");
    }

    public void twobclick(View view) {
        bigTextView.append("2");
    }

    public void threebclick(View view) {
        bigTextView.append("3");
    }

    public void fourbclick(View view) {
        bigTextView.append("4");
    }

    public void fivebclick(View view) {
        bigTextView.append("5");
    }

    public void sixbclick(View view) {
        bigTextView.append("6");
    }

    public void sevenbclick(View view) {
        bigTextView.append("7");
    }

    public void eightbclick(View view) {
        bigTextView.append("8");
    }

    public void ninebclick(View view) {
        bigTextView.append("9");
    }

    public void clearbclick(View view) {
        bigTextView.setText("");
    }

    public void resetbclick(View view) {
    }
}
