package xyz.przemyk.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView smallFormulaTextView, smallResultTextView;
    private FontFitTextView largeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smallFormulaTextView = findViewById(R.id.smallFormulaTextView);
        largeTextView = findViewById(R.id.largeTextView);
        smallResultTextView = findViewById(R.id.smallResultTextView);

        largeTextView.setSelected(true); // Make it scrollable
    }

    private String calculateFormulaTextView() {
        return Math.eval(largeTextView.getText().toString());
    }

    private void calculateToTextView() {
        String result = calculateFormulaTextView();
        smallResultTextView.setText(result);
    }

    public void equalsbclick(View view) {
        smallFormulaTextView.setText(largeTextView.getText());
        largeTextView.setText(calculateFormulaTextView());
        smallResultTextView.setText("");
    }

    //<editor-fold> 1-9 buttons

    public void zerobclick(View view) {
        if (!largeTextView.getText().toString().equals("0")) {
            largeTextView.append("0");
            calculateToTextView();
        }
    }

    public void onebclick(View view) {
        if (largeTextView.getText().toString().equals("0")) {
            largeTextView.setText("1");
        } else {
            largeTextView.append("1");
        }
        calculateToTextView();
    }

    public void twobclick(View view) {
        if (largeTextView.getText().toString().equals("0")) {
            largeTextView.setText("2");
        } else {
            largeTextView.append("2");
        }
        calculateToTextView();
    }

    public void threebclick(View view) {
        if (largeTextView.getText().toString().equals("0")) {
            largeTextView.setText("3");
        } else {
            largeTextView.append("3");
        }
        calculateToTextView();
    }

    public void fourbclick(View view) {
        if (largeTextView.getText().toString().equals("0")) {
            largeTextView.setText("4");
        } else {
            largeTextView.append("4");
        }
        calculateToTextView();
    }

    public void fivebclick(View view) {
        if (largeTextView.getText().toString().equals("0")) {
            largeTextView.setText("5");
        } else {
            largeTextView.append("5");
        }
        calculateToTextView();
    }

    public void sixbclick(View view) {
        if (largeTextView.getText().toString().equals("0")) {
            largeTextView.setText("6");
        } else {
            largeTextView.append("6");
        }
        calculateToTextView();
    }

    public void sevenbclick(View view) {
        if (largeTextView.getText().toString().equals("0")) {
            largeTextView.setText("7");
        } else {
            largeTextView.append("7");
        }
        calculateToTextView();
    }

    public void eightbclick(View view) {
        if (largeTextView.getText().toString().equals("0")) {
            largeTextView.setText("8");
        } else {
            largeTextView.append("8");
        }
        calculateToTextView();
    }

    public void ninebclick(View view) {
        if (largeTextView.getText().toString().equals("0")) {
            largeTextView.setText("9");
        } else {
            largeTextView.append("9");
        }
        calculateToTextView();
    }

    //</editor-fold>

    public void pointbclick(View view) {
        String formula = largeTextView.getText().toString();
        String[] numbers = formula.split("[+\\-*/()√^]");
        if (formula.equals("") || formula.endsWith("+") || formula.endsWith("-")
                || formula.endsWith("*") || formula.endsWith("/") || formula.endsWith("^")
                || formula.endsWith("√") || formula.endsWith("(") || formula.endsWith(")")) {
            largeTextView.append("0.");
        } else if (!numbers[numbers.length - 1].contains(".")) {
            largeTextView.append(".");
        }
        calculateToTextView();
    }

    public void deletebclick(View view) {
        String formula = largeTextView.getText().toString();
        if (!formula.equals("")) {
            formula = formula.substring(0, formula.length() - 1);
            largeTextView.setText(formula);
        }
        calculateToTextView();
    }

    public void clearbclick(View view) {
        smallFormulaTextView.setText("");
        largeTextView.setText("");
        smallResultTextView.setText("");
    }

    public void clearentrybclick(View view) {
        // Clear only last typed entry
    }

    //<editor-fold> math operations

    public void dividebclick(View view) {
        String formula = largeTextView.getText().toString();
        if (!formula.equals("") && !formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith("√") && !formula.endsWith("(") && !formula.endsWith(".")){
            largeTextView.append("/");
            calculateToTextView();
        }
    }

    public void multiplybclick(View view) {
        String formula = largeTextView.getText().toString();
        if (!formula.equals("") && !formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith("√") && !formula.endsWith(".")){
            largeTextView.append("*");
            calculateToTextView();
        }
    }

    public void subtractbclick(View view) {
        String formula = largeTextView.getText().toString();
        if (!formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith(".")){
            largeTextView.append("-");
            calculateToTextView();
        }
    }

    public void addbclick(View view) {
        String formula = largeTextView.getText().toString();
        if (!formula.equals("") && !formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith("√") && !formula.endsWith("(") && !formula.endsWith(".")){
            largeTextView.append("+");
            calculateToTextView();
        }
    }

    public void sqrtbclick(View view) {
        String formula = largeTextView.getText().toString();
        if (!formula.endsWith(".")) {
            largeTextView.append("√");
            calculateToTextView();
        }
    }

    public void powerbclick(View view) {
        String formula = largeTextView.getText().toString();
        if (!formula.equals("") && !formula.endsWith("+") && !formula.endsWith("-")
                && !formula.endsWith("*") && !formula.endsWith("/") && !formula.endsWith("^")
                && !formula.endsWith("√") && !formula.endsWith(".")){
            largeTextView.append("^");
            calculateToTextView();
        }
    }

    //</editor-fold>

    //<editor-fold> brackets

    public void leftbracketbclick(View view) {
        if (!largeTextView.getText().toString().endsWith(".")) {
            largeTextView.append("("); // Not calculating because bracket must be closed
        }
    }

    public void rightbracketbclick(View view) {
        String formula = largeTextView.getText().toString();
        int leftbrackets = formula.length() - formula.replaceAll("\\(", "").length();
        int rightBrackets = formula.length() - formula.replaceAll("\\)", "").length();

        if (leftbrackets > rightBrackets && !formula.endsWith(".")) {
            largeTextView.append(")");
            calculateToTextView();
        }
    }

    //</editor-fold>

    //<editor-fold> constants

    public void pibclick(View view) {
        if (!largeTextView.getText().toString().endsWith(".")) {
            largeTextView.append("π");
            calculateToTextView();
        }
    }

    public void eulerbclick(View view) {
        if (!largeTextView.getText().toString().endsWith(".")) {
            largeTextView.append("e");
            calculateToTextView();
        }
    }

    public void imaginarybclick(View view) {
        if (!largeTextView.getText().toString().endsWith(".")) {
            largeTextView.append("i");
            calculateToTextView();
        }
    }

    public void goldratiobclick(View view) {
        if (!largeTextView.getText().toString().endsWith(".")) {
            largeTextView.append("φ");
            calculateToTextView();
        }
    }

    //</editor-fold>

    //<editor-fold> trigonometry

    public void tgbclick(View view) {
        if (!largeTextView.getText().toString().endsWith(".")) {
            largeTextView.append("tg(");
        }
    }

    public void sinbclick(View view) {
        if (!largeTextView.getText().toString().endsWith(".")) {
            largeTextView.append("sin(");
        }
    }

    public void cosbclick(View view) {
        if (!largeTextView.getText().toString().endsWith(".")) {
            largeTextView.append("cos(");
        }
    }

    //</editor-fold>
}
