-- Haskell Permute
-- CECS 424 Murgolo
-- Team: Kelly Hall, Victor Kim, Aingty Eung
-- 04/17/2019

-- :: 		"has type of"
-- => 		class constraint
-- filter	keep elements (matching)
-- <- 		variable assignment or declaration
-- \x		anonymous function
-- /=		inequality


-- permute has type of [a](list) and returns [[a]](list of lists) with the class constraint that the two values are of equal class and are of equal types
permute :: (Eq a) => [a] -> [[a]]

-- permute takes a parameter of type list and returns a list of lists
permute [] = [[]]

-- create an instance of permute called list, and recursively call permute until condition is met
-- match a:x such that a is declared as list and x is declared as:
-- in each recursion, permute the filtered values: keep elements of anonymous function x as long as it does not equal a
permute list = [a:x | a <- list, x <- (permute $ filter (\x -> x /= a) list)]


-- print out permutation results for given testers
main = do
    putStr ("\nHaskell permute String:\na =\n\t\t")
    print (permute "a")
    putStr ("--------------------------------------------------------------------------------------------\nab =\n\t\t")
    print (permute "ab")
    putStr ("--------------------------------------------------------------------------------------------\nabcd =\n\t\t")
    print (permute "abcd")
    putStr ("\nThe End, GoodBye!\n\n")

 
