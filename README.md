# Truth Table

This project is used to convert an expression from a prefix to a suffix. Then convert the expression to a truth table.


## How It Work?
```
Example: 

Input:  A | ~( B & C )
Convert to RPN: A B C & ~ |
Truth Table:  A   B   C   (B & C)   ~(B & C)  A | ~( B & C )
              0   0   0      0          1           1
              0   0   1      0          1           1
              0   1   0      0          1           1
              0   1   1      1          0           0
              1   0   0      0          1           1
              1   0   1      0          1           1
              1   1   0      0          1           1
              1   1   1      1          0           1
              
Note: 1 considered as TRUE, 0 as FALSE
```

## Running the tests

The application will read the "input.txt" file and export the result into "post-fix.txt" and "truthtable-result.txt" file.

## Language
Java

## Authors

* **Hy Minh Tran (Mark)**.
