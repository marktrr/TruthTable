# Truth Table

This project basically converts an input expression (prefix) into a suffix also known as Reverse Polish notation (RPN). Then from the suffix expression, specify the operator and operand components to set up a corresponding truth table.

## Explanation

There are five logical operators:
  * CONJUNTION - Symbol: &
  * DISCONJUNTION - Symbol: |
  * CONDITIONAL - Symbol: ->
  * NEGATION - Symbol: ~
  * BICONDITIONAL - Symbol: =

## How It Work?

The project uses a STACK method as an intermediary to store operators and calculations.

```
Example: 

Input:  A | ~( B & C ) 

Convert to RPN: A B C & ~ |

Truth Table:  A   B   C   (B & C)   ~(B & C)  A | ~( B & C )
              F   F   F      F          T           T
              F   F   T      F          T           T
              F   T   F      F          T           T
              F   T   T      T          F           F
              T   F   F      F          T           T
              T   F   T      F          T           T
              T   T   F      F          T           T
              T   T   T      T          F           T
```

## Running the tests

The application will read the "input.txt" file and export the result into "post-fix.txt" and "truthtable-result.txt" file.

## Programming Language
Java

## Authors

* **Hy Minh Tran (Mark)**.
