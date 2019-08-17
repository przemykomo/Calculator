package przem.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView smallFormulaTextView, bigTextView, smallResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smallFormulaTextView = findViewById(R.id.smallFormulaTextView);
        bigTextView = findViewById(R.id.bigTextView);
        smallResultTextView = findViewById(R.id.smallResultTextView);
    }

    public void equalsbclick(View view) {

    }

    //<editor-fold> 1-9 buttons

    public void zerobclick(View view) {
        if (!bigTextView.getText().toString().equals("0")) {
            bigTextView.append("0");
        }
    }

    public void onebclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("1");
        } else {
            bigTextView.append("1");
        }
    }

    public void twobclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("2");
        } else {
            bigTextView.append("2");
        }
    }

    public void threebclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("3");
        } else {
            bigTextView.append("3");
        }
    }

    public void fourbclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("4");
        } else {
            bigTextView.append("4");
        }
    }

    public void fivebclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("5");
        } else {
            bigTextView.append("5");
        }
    }

    public void sixbclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("6");
        } else {
            bigTextView.append("6");
        }
    }

    public void sevenbclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("7");
        } else {
            bigTextView.append("7");
        }
    }

    public void eightbclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("8");
        } else {
            bigTextView.append("8");
        }
    }

    public void ninebclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("9");
        } else {
            bigTextView.append("9");
        }
    }

    //</editor-fold>

    public void pointbclick(View view) {
        String formula = bigTextView.getText().toString();
        String[] numbers = formula.split("[+\\-*/()√^]");
        if (formula.equals("") || formula.endsWith("+") || formula.endsWith("-")
                || formula.endsWith("*") || formula.endsWith("/") || formula.endsWith("^")
                || formula.endsWith("√") || formula.endsWith("(") || formula.endsWith(")")) {
            bigTextView.append("0.");
        } else if (!numbers[numbers.length - 1].contains(".")) {
            bigTextView.append(".");
        }
    }

    public void deletebclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.equals("")) {
            formula = formula.substring(0, formula.length() - 1);
            bigTextView.setText(formula);
        }
    }

    public void clearbclick(View view) {
        bigTextView.setText("");
        smallResultTextView.setText("");
    }

    public void resetbclick(View view) {
        smallFormulaTextView.setText("");
        bigTextView.setText("");
    }

    //<editor-fold> math operations

    public void dividebclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.equals("") && !formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith("√") && !formula.endsWith("(") && !formula.endsWith(".")){
            bigTextView.append("/");
        }
    }

    public void multiplybclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.equals("") && !formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith("√") && !formula.endsWith(".")){
            bigTextView.append("*");
        }
    }

    public void subtractbclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith(".")){
            bigTextView.append("-");
        }
    }

    public void addbclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.equals("") && !formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith("√") && !formula.endsWith("(") && !formula.endsWith(".")){
            bigTextView.append("+");
        }
    }

    public void sqrtbclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.endsWith(".")) {
            bigTextView.append("√");
        }
    }

    public void powerbclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.equals("") && !formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith("√") && !formula.endsWith(".")){
            bigTextView.append("^");
        }
    }

    //</editor-fold>

    //<editor-fold> brackets

    public void leftbracketbclick(View view) {
        if (!bigTextView.getText().toString().endsWith(".")) {
            bigTextView.append("(");
        }
    }

    public void rightbracketbclick(View view) {
        String formula = bigTextView.getText().toString();
        int leftbrackets = formula.length() - formula.replaceAll("\\(", "").length();
        int rightBrackets = formula.length() - formula.replaceAll("\\)", "").length();

        if (leftbrackets > rightBrackets && !formula.endsWith(".")) {
            bigTextView.append(")");
        }
    }

    //</editor-fold>

    //<editor-fold> constants

    public void pibclick(View view) {
        if (!bigTextView.getText().toString().endsWith(".")) {
            bigTextView.append("π");
        }
    }

    public void eulerbclick(View view) {
        if (!bigTextView.getText().toString().endsWith(".")) {
            bigTextView.append("e");
        }
    }

    public void imaginarybclick(View view) {
        if (!bigTextView.getText().toString().endsWith(".")) {
            bigTextView.append("i");
        }
    }

    public void goldratiobclick(View view) {
        if (!bigTextView.getText().toString().endsWith(".")) {
            bigTextView.append("φ");
        }
    }

    //</editor-fold>
}
