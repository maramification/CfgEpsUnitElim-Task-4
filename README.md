# CfgEpsUnitElim-Task-4

## German University in Cairo
### Department of Computer Science
### Assoc. Prof. Haythem O. Ismail

### CSEN1002 Compilers Lab, Spring Term 2024
**Task 4: Context-Free Grammars Epsilon & Unit Rules Elimination**

## Overview
This project involves implementing algorithms to eliminate epsilon (ε) and unit rules from a given context-free grammar (CFG). A CFG is a quadruple (V, Σ, R, S) where V and Σ are disjoint alphabets (containing variables and terminals, respectively), R ⊆ V × (V ∪ Σ)* is a set of rules, and S ∈ V is the start variable.

## Objective
Implement algorithms for eliminating epsilon and unit rules from a CFG. This involves the following steps:
- Define a class constructor `CfgEpsUnitElim`.
- Implement methods `toString`, `eliminateEpsilonRules`, and `eliminateUnitRules`.

## Requirements

1. **Assumptions:**
   - The set V of variables consists of upper-case English letters.
   - The start variable is the symbol S.
   - The set Σ of terminals consists of lower-case English letters (excluding 'e').
   - The letter "e" represents ε.
   - ε ∉ L(G).

2. **Implementation:**
   - **Class Constructor `CfgEpsUnitElim`:**
     - Takes a single parameter, a string description of a CFG in the format `V#T#R`.
     - Example CFG: G1 = ({S,A,B,C}, {a,b,c,d,x}, R, S)
       - R: S → aAb|xB
              A → Bc|C|c|d
              B → CACA|ε
              C → A|b|ε
       - Encoded as: `S;A;B;C#a;b;c;d;x#S/aAb,xB;A/Bc,C,c,d;B/CACA,e;C/A,b,e`

   - **Method `toString`:**
     - Returns a string representation of the CFG, using the same format as the input to the constructor.

   - **Method `eliminateEpsilonRules`:**
     - Eliminates epsilon rules from the CFG using the classical algorithm.
     - Example: After eliminating epsilon rules from G1, the string returned by `toString` is:
       ```
       S;A;B;C#a;b;c;d;x#S/aAb,ab,x,xB;A/Bc,C,c,d;B/A,AA,AC,ACA,C,CA,CAA,CAC,CACA,CC,CCA;C/A,b
       ```

   - **Method `eliminateUnitRules`:**
     - Eliminates unit rules from the CFG using the classical algorithm.
     - Example: After eliminating unit rules from G1, the string returned by `toString` is:
       ```
       S;A;B;C#a;b;c;d;x#S/aAb,xB;A/Bc,b,c,d,e;B/CACA,e;C/Bc,b,c,d,e
       ```

   - **Sequential Execution:**
     - The methods `eliminateEpsilonRules` and `eliminateUnitRules` can be called sequentially.
     - Example: After invoking `eliminateEpsilonRules` then `eliminateUnitRules` on G1, the string returned by `toString` is:
       ```
       S;A;B;C#a;b;c;d;x#S/aAb,ab,x,xB;A/Bc,b,c,d;B/AA,AC,ACA,Bc,CA,CAA,CAC,CACA,CC,CCA,b,c,d;C/Bc,b,c,d
       ```

For any further details or clarifications, refer to the lab manual or contact the course instructor.
