def congruencial_multiplicativo(semilla, a, m, n):
    numeros_aleatorios = []
    x = semilla
    for i in range(n):
        x = (a * x) % m
        numeros_aleatorios.append(x / m)
    return numeros_aleatorios
