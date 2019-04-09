permutate :: (Eq a) => [a] -> [[a]]
permutate [] = [[]]
permutate l = [a:x | a <- l, x <- (permutate $ filter (\x -> x /= a) l)]

main = do
    putStr ("\nHaskell Permutate String:\na =\n\t\t")
    print (permutate "a")
    putStr ("--------------------------------------------------------------------------------------------\nab =\n\t\t")
    print (permutate "ab")
    putStr ("--------------------------------------------------------------------------------------------\nabcd =\n\t\t")
    print (permutate "abcd")
    putStr ("\nThe End, GoodBye!\n\n")