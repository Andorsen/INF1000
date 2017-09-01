Oblig 07

The program was written test-driven, so every method was tested before it
was even created.

Fixes:
 - The archive reader was based on archives written by the program.
This bypassed some of the measures to avoid duplication and
capitalization errors when reading 3.rd party archive files.
Should work as intended now.

 - Added comments for javadoc

 - Added test suite.
TestSuite.java tests for the most common interactions and validates the results.
Creates several objects of both Person and DVD.
Mostly tests for DVD variables and DVD/Person interactions
Includes tests that should fail, fixes them, and tests again to verify.
