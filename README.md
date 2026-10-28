# Stacks Lab

**IB Computer Science 2 (HL) · Unit 11 · B2.2.3 **

One ADT, two data structures, one application.

## The files

| File | Status |
|---|---|
| `Stack.java` | **given** — the Stack ADT as an interface: push, pop, peek, isEmpty, size |
| `Node.java` | **given** — similar to our List Node, made generic: `Node<E>` |
| `ArrayListStack.java` | **Part A — yours** — a stack kept in a `java.util.ArrayList` |
| `LinkedStack.java` | **Part A — yours** — a stack built from your own nodes |
| `RPNCalculator.java` | **Part B — yours** — evaluates Reverse Polish Notation with a stack |
| `StackTester.java` | **given** |

## Run it

```
javac *.java
java StackTester
java RPNCalculator "5 1 2 + 4 * + 3 -"
```

## Part A — decide where the top is, FIRST

- **ArrayListStack:** is the top at index 0 or at the end? One choice makes push and
  pop O(1); the other makes both O(n).
- **LinkedStack:** the top is the head. Push is the same two moves as `addFirst`
  in S3.16.
- Popping or peeking an empty stack throws `java.util.EmptyStackException`.

## Part B — the RPN calculator

- Push numbers. For an operator, pop TWICE — **the first pop is the RIGHT operand** —
  apply it, push the result. At the end exactly one value must be left.
- Anything invalid throws `IllegalArgumentException`. Never let a stack exception
  escape from `evaluate`.
- Use one of YOUR stacks, not `java.util.Stack`.

Part C is written — answer it in the comments of your Stack classes

## Opening this assignment

Pick **one** of the two. Both are fine, and you can switch later — your work lives in
the repository, not in the editor.

### Option A — GitHub Codespaces (VS Code in your browser)

1. On the repository page, click **Code → Codespaces → Create codespace on main**.
2. Wait for it to finish setting up. The first time is the slow one.
3. Open the `.java` file, write your code, and run it from the terminal:
   ```
   javac Main.java
   java Main
   ```
   or click **Run** above `main`.

**Reopen the same codespace next time** — do not create a new one every period. Go to
**Code → Codespaces** and click the one that is already there. Creating a new one makes
you wait through the whole setup again for no reason.

### Option B — IntelliJ IDEA (installed on your computer)

1. Copy the repository URL from the green **Code** button.
2. In IntelliJ: **File → New → Project from Version Control**, paste the URL, **Clone**.
3. If IntelliJ asks for a **Project SDK**, pick any Java 17 or newer entry in the list.
   If the list is empty, choose **Download JDK** and take the default it offers.
4. Open the `.java` file and click the green ▶ next to `main`.

### Committing your work

Either way, commit and push when you are done — pushing is what submits it.
In IntelliJ: **Git → Commit**, then **Git → Push**.
In Codespaces: the **Source Control** panel on the left, then **Commit** and **Sync**.

---
