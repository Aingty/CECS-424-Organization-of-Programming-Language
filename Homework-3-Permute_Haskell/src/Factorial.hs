factorial 0 = 1
factorial n = n * factorial (n - 1)

main = do
    print(factorial 30)
    print(factorial 20)