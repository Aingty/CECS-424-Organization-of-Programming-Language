% Aingty Eung, Kelly Hall, Victor Kim
% CECS424 Murgolo
% Permutations in Prolog
% May 03, 2019

newList([], A, A).
newList([B|C], A, [B|D]) :- newList(C, A, D).

% an empty list can only be permuted into another empty list
permute([], []).

% ! is the cut operator
% if recursive calls succeed, do not retry permute (do not backtrack)
permute([A], [A]) :-!.

permute([B|C], A) :- permute(C, H1), newList(L1, L2, H1), newList(L1, [B], X1), newList(X1, L2, A).


% run program and output results
%-----------------------------------------------------------------------------
main1:-
    write("Permutation Program!\n-----------------\nPermutation: [a]\n"),
    permute([a],P), writeq(P), nl, fail. 
main2:-
    write("\n-----------------\nPermutation: [a,b]\n"),
    permute([a,b],P), writeq(P), nl, fail.
main3:-
    write("\n-----------------\nPermutation: [a,b,c]\n"),
    permute([a,b,c],P), writeq(P), nl, fail. 
main4:-
    write("\n\n").

% Suppress warning regarding singleton
:- style_check(-singleton).

% Initialization to force all main to run
:- initialization(main1).
:- initialization(main2).
:- initialization(main3).
:- initialization(main4).
%-----------------------------------------------------------------------------
