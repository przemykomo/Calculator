package przem.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView smallFormulaTextView, smallResultTextView;
    private FontFitTextView bigTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smallFormulaTextView = findViewById(R.id.smallFormulaTextView);
        bigTextView = findViewById(R.id.bigTextView);
        smallResultTextView = findViewById(R.id.smallResultTextView);

        bigTextView.setSelected(true); // Make it scrollable
    }

    private String calculateFormulaTextView() {
        return Math.eval(bigTextView.getText().toString());
    }

    private void calculateToTextView() {
        String result = calculateFormulaTextView();
        smallResultTextView.setText(result);
    }

    public void equalsbclick(View view) {
        smallFormulaTextView.setText(bigTextView.getText());
        bigTextView.setText(calculateFormulaTextView());
        smallResultTextView.setText("");
    }

    //<editor-fold> 1-9 buttons

    public void zerobclick(View view) {
        if (!bigTextView.getText().toString().equals("0")) {
            bigTextView.append("0");
            calculateToTextView();
        }
    }

    public void onebclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("1");
        } else {
            bigTextView.append("1");
        }
        calculateToTextView();
    }

    public void twobclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("2");
        } else {
            bigTextView.append("2");
        }
        calculateToTextView();
    }

    public void threebclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("3");
        } else {
            bigTextView.append("3");
        }
        calculateToTextView();
    }

    public void fourbclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("4");
        } else {
            bigTextView.append("4");
        }
        calculateToTextView();
    }

    public void fivebclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("5");
        } else {
            bigTextView.append("5");
        }
        calculateToTextView();
    }

    public void sixbclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("6");
        } else {
            bigTextView.append("6");
        }
        calculateToTextView();
    }

    public void sevenbclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("7");
        } else {
            bigTextView.append("7");
        }
        calculateToTextView();
    }

    public void eightbclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("8");
        } else {
            bigTextView.append("8");
        }
        calculateToTextView();
    }

    public void ninebclick(View view) {
        if (bigTextView.getText().toString().equals("0")) {
            bigTextView.setText("9");
        } else {
            bigTextView.append("9");
        }
        calculateToTextView();
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
        calculateToTextView();
    }

    public void deletebclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.equals("")) {
            formula = formula.substring(0, formula.length() - 1);
            bigTextView.setText(formula);
        }
        calculateToTextView();
    }

    public void clearbclick(View view) {
        smallFormulaTextView.setText("");
        bigTextView.setText("");
        smallResultTextView.setText("");
    }

    public void clearentrybclick(View view) {
        // Clear only last typed entry
    }

    //<editor-fold> math operations

    public void dividebclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.equals("") && !formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith("√") && !formula.endsWith("(") && !formula.endsWith(".")){
            bigTextView.append("/");
            calculateToTextView();
        }
    }

    public void multiplybclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.equals("") && !formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith("√") && !formula.endsWith(".")){
            bigTextView.append("*");
            calculateToTextView();
        }
    }

    public void subtractbclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith(".")){
            bigTextView.append("-");
            calculateToTextView();
        }
    }

    public void addbclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.equals("") && !formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith("√") && !formula.endsWith("(") && !formula.endsWith(".")){
            bigTextView.append("+");
            calculateToTextView();
        }
    }

    public void sqrtbclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.endsWith(".")) {
            bigTextView.append("√");
            calculateToTextView();
        }
    }

    public void powerbclick(View view) {
        String formula = bigTextView.getText().toString();
        if (!formula.equals("") && !formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith("√") && !formula.endsWith(".")){
            bigTextView.append("^");
            calculateToTextView();
        }
    }

    //</editor-fold>

    //<editor-fold> brackets

    public void leftbracketbclick(View view) {
        if (!bigTextView.getText().toString().endsWith(".")) {
            bigTextView.append("("); // Not calculating because bracket must be closed
        }
    }

    public void rightbracketbclick(View view) {
        String formula = bigTextView.getText().toString();
        int leftbrackets = formula.length() - formula.replaceAll("\\(", "").length();
        int rightBrackets = formula.length() - formula.replaceAll("\\)", "").length();

        if (leftbrackets > rightBrackets && !formula.endsWith(".")) {
            bigTextView.append(")");
            calculateToTextView();
        }
    }

    //</editor-fold>

    //<editor-fold> constants

    public void pibclick(View view) {
        if (!bigTextView.getText().toString().endsWith(".")) {
            bigTextView.append("π");
            calculateToTextView();
        }
    }

    public void eulerbclick(View view) {
        if (!bigTextView.getText().toString().endsWith(".")) {
            bigTextView.append("e");
            calculateToTextView();
        }
    }

    public void imaginarybclick(View view) {
        if (!bigTextView.getText().toString().endsWith(".")) {
            bigTextView.append("i");
            calculateToTextView();
        }
    }

    public void goldratiobclick(View view) {
        if (!bigTextView.getText().toString().endsWith(".")) {
            bigTextView.append("φ");
            calculateToTextView();
        }
    }

    //</editor-fold>
}
