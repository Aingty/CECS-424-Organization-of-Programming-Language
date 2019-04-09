import Debug.Trace

debug = flip trace

permute :: Show a => [a] -> [a] 
permute xs = 
    permute' xs xs
    where 
        permute' xy xz = case xy of
            [] -> []
            (x:xn) ->  permute' (xn) (tail xz ++ [x])  `debug` (show (xz))
              

permute'' :: [a] -> [[a]]
permute'' xs =
    permute''' [xs] xs xs 
    where
        permute''' xx xy xz = case xy of
            [] -> xx
            (x:xn) -> (permute'''  ( xx ++ [(tail xz ++ [x])])  (xn) (tail xz ++ [x]))