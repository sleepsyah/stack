/* StackTester.java  --  GIVEN, COMPLETE.  DO NOT MODIFY.
 *
 *     javac *.java
 *     java StackTester
 *
 */
import java.util.EmptyStackException;
import java.util.function.Supplier;

public class StackTester {

    private static int earned = 0, possible = 0;
    private static boolean groupOk;
    private static String groupFail;

    public static void main(String[] args) {
        System.out.println("Stacks  --  automatic checks");
        System.out.println("===================================");
        System.out.println("PART A  --  two implementations of one ADT");
        stackChecks("ArrayListStack", ArrayListStack::new);
        stackChecks("LinkedStack", LinkedStack::new);
        int partA = earned;

        System.out.println();
        System.out.println("PART B  --  RPN calculator");
        group("one operator each: + - * /", 8, () -> {
            num("3 4 +", 7);
            num("8 5 -", 3);
            num("6 7 *", 42);
            num("12 3 /", 4);
        });
        group("longer expressions", 12, () -> {
            num("3 4 5 * +", 23);
            num("3 4 + 5 *", 35);
            num("10 2 4 / -", 9.5);
            num("8 3 - 4 2 + *", 30);
            num("7 6 3 1 - / +", 10);
            num("5 9 * 6 2 / -", 42);
            num("10 2 + 9 3 - /", 2);
        });
        group("operand ORDER: the first pop is the right operand", 6, () -> {
            num("2 8 -", -6);
            num("2 8 /", 0.25);
            num("20 4 2 / -", 18);
        });
        group("invalid expressions throw IllegalArgumentException", 14, () -> {
            bad("9 /");
            bad("+");
            bad("1 2");
            bad("");
            bad("2 x +");
            bad("1 2 + +");
        });

        System.out.println();
        System.out.println("Part A: " + partA + " / 40     Part B: " + (earned - partA) + " / 40");
        System.out.println("AUTOMATIC TOTAL: " + earned + " / " + possible
                + "   (+ 20 for Part C on the lab sheet)");
    }

    private static void stackChecks(String name, Supplier<Stack<Integer>> make) {
        group(name + ": last in, first out", 6, () -> {
            Stack<Integer> s = make.get();
            s.push(10); s.push(20); s.push(30);
            same(s.pop(), 30, "first pop");
            same(s.pop(), 20, "second pop");
            s.push(40);
            same(s.pop(), 40, "pop after a push in between");
            same(s.pop(), 10, "last pop");
        });
        group(name + ": peek does not remove", 4, () -> {
            Stack<Integer> s = make.get();
            s.push(7); s.push(9);
            same(s.peek(), 9, "peek");
            same(s.peek(), 9, "peek again");
            same(s.size(), 2, "size after two peeks");
        });
        group(name + ": isEmpty and size", 4, () -> {
            Stack<Integer> s = make.get();
            same(s.isEmpty(), true, "new stack isEmpty");
            same(s.size(), 0, "new stack size");
            s.push(1); s.push(2);
            same(s.isEmpty(), false, "isEmpty after pushes");
            same(s.size(), 2, "size after two pushes");
            s.pop(); s.pop();
            same(s.isEmpty(), true, "isEmpty after popping everything");
        });
        group(name + ": empty pop and peek throw EmptyStackException", 6, () -> {
            Stack<Integer> s = make.get();
            empty(() -> s.pop(), "pop on a new stack");
            empty(() -> s.peek(), "peek on a new stack");
            s.push(5); s.pop();
            empty(() -> s.pop(), "pop after emptying");
        });
    }

    // ------------------------------------------------------------------ helpers
    interface Check { void run(); }

    private static void group(String name, int points, Check body) {
        possible += points;
        groupOk = true;
        groupFail = "";
        try {
            body.run();
        } catch (UnsupportedOperationException e) {
            groupOk = false;
            groupFail = e.getMessage();
        } catch (Exception e) {
            groupOk = false;
            groupFail = "threw " + e.getClass().getSimpleName()
                    + (e.getMessage() == null ? "" : ": " + e.getMessage());
        }
        if (groupOk) {
            earned += points;
            System.out.printf("  PASS  %2d  %s%n", points, name);
        } else {
            System.out.printf("  FAIL   0  %s%n          -> %s%n", name, groupFail);
        }
    }

    private static void same(Object got, Object want, String what) {
        if (!groupOk) return;
        if (!String.valueOf(got).equals(String.valueOf(want))) {
            groupOk = false;
            groupFail = what + ": expected " + want + " but got " + got;
        }
    }

    private static void num(String expr, double want) {
        if (!groupOk) return;
        double got = RPNCalculator.evaluate(expr);
        if (Math.abs(got - want) > 1e-9) {
            groupOk = false;
            groupFail = "\"" + expr + "\": expected " + want + " but got " + got;
        }
    }

    private static void bad(String expr) {
        if (!groupOk) return;
        try {
            RPNCalculator.evaluate(expr);
            groupOk = false;
            groupFail = "\"" + expr + "\": no exception was thrown";
        } catch (IllegalArgumentException e) {
            // correct
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e) {
            groupOk = false;
            groupFail = "\"" + expr + "\": threw " + e.getClass().getSimpleName()
                    + " -- catch it and throw IllegalArgumentException instead";
        }
    }

    private static void empty(Check c, String what) {
        if (!groupOk) return;
        try {
            c.run();
            groupOk = false;
            groupFail = what + ": no exception was thrown";
        } catch (EmptyStackException e) {
            // correct
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e) {
            groupOk = false;
            groupFail = what + ": threw " + e.getClass().getSimpleName()
                    + " instead of EmptyStackException";
        }
    }
}
