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
        String result = "Syntax error!";
        try {
            double actual, actual2 = 0;
            Complex complex, complex2 = new Complex();

            FunctionAndName fan = symbols.compileWithName(expr);
            Function f = fan.function;
            symbols.define(fan);
            if (f.arity() == 0) {
                actual = f.eval();
                complex = f.evalComplex();
                result = Util.doubleToString(actual, 1);

                if (!Symbols.isDefinition(expr)) {
                    actual2 = symbols.eval(expr);
                    complex2 = symbols.evalComplex(expr);
                }
            }
        } catch (SyntaxException e) {
            e.printStackTrace(); //TODO: Print error instead of last result
        }
        return result;
    }
}
