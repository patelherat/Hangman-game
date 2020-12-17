# Hangman-game
Hangman game for one player. Program will choose word from a dictionary file and the user must guess the word within a limited number of guesses.

Output:-
$ java Hangman e
Welcome to the Hangman Game!!
Word: *****
Misses:
Num. of Remaining Tries: 8
Enter a letter: I

Secret word: *****
Misses: i
Num. of Remaining Tries: 7
Enter a Letter: A

Secret word: ***A*
Misses: i
Num. of Remaining Tries: 7
Enter a Letter: c

Secret word: ***A*
Misses: i, c
Num. of Remaining Tries: 6
Enter a Letter:

If user enters ‘0’, program should terminate with no further output. If user guesses secret word, print “You guessed the secret word!” and the program terminates.

Secret word: B R E A _
Misses: i, c, f
Num. of Remaining Tries: 3
Enter a Letter: k

Secret word: B R E A K
Misses: i, c, f
Num. of Remaining Tries: 3
You guessed the secret word!

If the number of remaining tries reaches zero, print “Game Over! The secret word was ____.

Secret word: B R E A _
Misses: i, c, f, l, p, m, t
Num. of Remaining Tries: 7
Enter a Letter: d
Game Over! The secret word was BREAK.
