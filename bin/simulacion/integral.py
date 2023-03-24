import numpy as np
import matplotlib.pyplot as plt
from numpy.random import uniforms as unif

cant_num=10 #Cantodad de num aleatorios que generamos

#Estas dos lineas son para graficar 
c=np.linspace(0.0001,3.2)#No se comienza desde 0 para evitar un error 
f=1/(1+np.sinh(2*c)*(np.log(c))**2)

#Aqui se generan números aleatorios especificamente en este intervalo
lim_inf=0.8
lim_sup=3

x=unif(lim_inf,lim_sup,cant_num)

#Inicializamos las variables de la sumatoria 
suma=0
for j in range(cant_num):
    suma = suma+1/(1+np.sinh(2*x[j])*(np.log(x[j]))**2)

    resultado=(lim_sup-lim_inf)*suma/cant_num

    plt.xlabel('x')
    plt.ylabel('y')
    plt.plot(c,f)
    plt.hist(x,density=True)

    print('el resultado de la integral es:')
    print(resultado)
