newList([], A, A).
newList([B|C], A, [B|D]) :- newList(C, A, D).

permute([], []).
permute([A], [A]) :-!.
permute([B|C], A) :- permute(C, H1), newList(L1, L2, H1), newList(L1, [B], X1), newList(X1, L2, A).

main1:-
    write("\n\nPermutation Program!\n-----------------\nPermutation: [a]\n"),
    permute([a],P), writeq(P), nl, fail. 
main2:-
    write("\n-----------------\nPermutation: [a,b]\n"),
    permute([a,b],P), writeq(P), nl, fail.
main3:-
    write("\n-----------------\nPermutation: [a,b,c]\n"),
    permute([a,b,c],P), writeq(P), nl, fail. 

:- style_check(-singleton).
:- initialization(main1).
:- initialization(main2).
:- initialization(main3).