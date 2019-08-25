package przem.calc;

import org.javia.arity.Complex;
import org.javia.arity.Function;
import org.javia.arity.FunctionAndName;
import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;
import org.javia.arity.Util;

public class Math {
    static String eval(String expr) {
        Symbols symbols = new Symbols();
        String result = "Syntax error";
        expr = expr.replaceAll("φ", "((1+√5)/2)"); // Arity doesn't support phi
        try {
            Complex complex;

            FunctionAndName fan = symbols.compileWithName(expr);
            Function f = fan.function;
            symbols.define(fan);

            // arity (number of math function arguments) will always be 0 in eval

            complex = f.evalComplex();
            result = Util.complexToString(complex, 20, 1);

        } catch (SyntaxException e) {
            e.printStackTrace(); //TODO: Print error instead of last result
        }
        return result;
    }
}
