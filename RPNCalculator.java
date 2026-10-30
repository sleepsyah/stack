/* RPNCalculator.java  --  S3.18 Part B  --  YOUR FILE.
 *
 * Evaluates a Reverse Polish Notation expression, tokens separated by spaces:
 *
 *     evaluate("3 4 +")              ->  7.0
 *     evaluate("10 2 + 9 3 - /")     ->  2.0
 *
 * THE ALGORITHM
 *   For each token, left to right:
 *     a number    -> push it
 *     + - * /     -> pop TWICE (the first pop is the RIGHT operand),
 *                    apply the operator, push the result
 *   At the end there must be EXACTLY ONE value on the stack: that is the answer.
 *
 * INVALID EXPRESSIONS -- throw IllegalArgumentException (never let a stack
 * exception escape):
 *   an operator with fewer than two values on the stack      "9 /"
 *   anything other than one value left at the end            "1 2"  and  ""
 *   a token that is neither a number nor + - * /             "2 x +"
 *
 * Use ONE of your own Stack classes -- not java.util.Stack.
 */
public class RPNCalculator {

    public static double evaluate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression must contain a value");
        }

        Stack<Double> values = new LinkedStack<Double>();
        for (String token : expression.trim().split("\\s+")) {
            if (token.equals("+") || token.equals("-")
                    || token.equals("*") || token.equals("/")) {
                if (values.size() < 2) {
                    throw new IllegalArgumentException("Not enough operands for " + token);
                }
                // The most recently pushed value is the RIGHT operand.
                double right = values.pop();
                double left = values.pop();
                switch (token) {
                    case "+": values.push(left + right); break;
                    case "-": values.push(left - right); break;
                    case "*": values.push(left * right); break;
                    case "/": values.push(left / right); break;
                }
            } else {
                try {
                    values.push(Double.parseDouble(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid token: " + token, e);
                }
            }
        }

        if (values.size() != 1) {
            throw new IllegalArgumentException("Expression must leave exactly one value");
        }
        return values.pop();
    }

    /** GIVEN -- try your own expressions:   java RPNCalculator "5 1 2 + 4 * + 3 -"  */
    public static void main(String[] args) {
        String e = args.length > 0 ? String.join(" ", args) : "5 1 2 + 4 * + 3 -";
        System.out.println(e + "  =  " + evaluate(e));
    }
}
