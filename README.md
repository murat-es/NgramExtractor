# NgramExtractor
Count repeated words or group of words

This program sorts the frequency of the letters.

---------------------------------------------------------
Before execute, be sure java file and input file at the same index.

To execute the program:
	**$javac NgramExtractor.java 
	$java NgramExtractor input.txt output.csv n**

-----------------------------------------------------

-It remove all punctuation
	ex: Non-English --> Non English (2 seperate words)

-It is case insensitive
	ex: the The THE --> the (only count as 1 word)

-Total number of token is the all words.
	ex: a a b c a --> total Token=5

-----------------------------------------
Suppose that input.txt has a following text:

You are expected to develop a text analyzer tool. The program allows you to ﬁnd the most frequent phrases and frequencies of words.
Non-English language texts are supported. It also counts number of words, characters, sentences and syllables. Also calculates lexical density

1.Unigram Features
The command ”java NgramExtractor input.txt output.csv 1” must extract all 1-gram features of text document to the output.csv ﬁle:

Total number of tokens: 42
ngram,count,frequency 

and,2,4.761904762 
of,2,4.761904762 
words,2,4.761904762 
are,2,4.761904762 
to,2,4.761904762 
calculates,1,2.380952381
Also,1,2.380952381 
syllables,1,2.380952381 
sentences,1,2.380952381
characters,1,2.380952381 
counts,1,2.380952381
also,1,2.380952381
It,1,2.380952381
supported,1,2.380952381
texts,1,2.380952381 
language,1,2.380952381
Non-English,1,2.380952381
lexical,1,2.380952381 
number,1,2.380952381
You,1,2.380952381 
frequencies,1,2.380952381 
The,1,2.380952381 
expected,1,2.380952381
develop,1,2.380952381
a,1,2.380952381
text,1,2.380952381 
analyzer,1,2.380952381 
tool,1,2.380952381 
program,1,2.380952381 
phrases,1,2.380952381 
allows,1,2.380952381
you,1,2.380952381 
ﬁnd,1,2.380952381 
the,1,2.380952381 
most,1,2.380952381 
frequent,1,2.380952381 
density,1,2.380952381

2.Bigram Features
The command ”java NgramExtractor input.txt output.csv 2” must extract all 2-gram features of text document:

Total number of tokens: 42
ngram,count,frequency
of words,2,4.761904762
also counts,1,2.380952381
words Non-English,1,2.380952381
Non-English language,1,2.380952381 
language texts,1,2.380952381
texts are,1,2.380952381
are supported,1,2.380952381 
supported It,1,2.380952381 
It also,1,2.380952381 
frequencies of,1,2.380952381 
number of,1,2.380952381 
words characters,1,2.380952381
characters sentences,1,2.380952381
sentences and,1,2.380952381 
and syllables,1,2.380952381 
syllables Also,1,2.380952381 
Also calculates,1,2.380952381
calculates lexical,1,2.380952381 
counts number,1,2.380952381
and frequencies,1,2.380952381 
You are,1,2.380952381 
tool The,1,2.380952381 
are expected,1,2.380952381 
expected to,1,2.380952381 
to develop,1,2.380952381
develop a,1,2.380952381
a text,1,2.380952381
text analyzer,1,2.380952381 
analyzer tool,1,2.380952381
The program,1,2.380952381
phrases and,1,2.380952381
program allows,1,2.380952381
allows you,1,2.380952381
you to,1,2.380952381 
to ﬁnd,1,2.380952381 
ﬁnd the,1,2.380952381
the most,1,2.380952381 
most frequent,1,2.380952381
frequent phrases,1,2.380952381
lexical density,1,2.380952381
