# CodeManchester

This project has the purpose of simulating the Manchester coding

The project consists in that given a text string it must be encoded using the Manchester encoding, in this case to simulate such encoding we will do the following:

to represent the logical zero we will use the string 01, for the logical 1 we will use 10
For the noise simulation we will use the string 11, this string will be interpreted by the code as an error in the message.

example

we have the string 1001 that will represent a text x
the coding in manchester will be: 10010110

Considerations:
each letter will be represented as an 8-bit binary string
