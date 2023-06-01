import heapq
import math

# Configuración de los parámetros del generador congruencial multiplicativo
semilla = 155
constante_multiplicativa = 163
modulo = 32768

# Función para generar números aleatorios utilizando el método congruencial multiplicativo
def generar_aleatorio():
    global semilla
    semilla = (constante_multiplicativa * semilla) % modulo
    return semilla / modulo

# Función para generar tiempo entre llegadas 


# Configuración de los parámetros de la simulación
num_atms = 3
tasa_llegada = 40 / 60  # convertir a llegadas por minuto
cola = []
reloj = 0
siguiente_tiempo_llegada = generar_aleatorio()
siguiente_tiempo_salida = [float('inf')] * num_atms
atms_ocupados = 0

# Inicializar variables para el cálculo de estadísticas
tiempo_total_en_sistema = 0
num_total_clientes = 0

# Ejecutar la simulación durante 8 horas (480 minutos)
tiempo_simulacion = 480
while reloj < tiempo_simulacion:
    # Avanzar el reloj al siguiente tiempo de evento
    reloj = min(siguiente_tiempo_llegada + 1, min(siguiente_tiempo_salida))

    if siguiente_tiempo_llegada < min(siguiente_tiempo_salida):
        # Llega un cliente
        if atms_ocupados < num_atms:
            # Asignar un cajero automático disponible al cliente
            atms_ocupados += 1
            cajero = siguiente_tiempo_salida.index(float('inf'))
            tiempo_servicio = generar_aleatorio()
            siguiente_tiempo_salida[cajero] = reloj + tiempo_servicio
        else:
            # Todos los cajeros automáticos están ocupados, el cliente se une a la cola
            heapq.heappush(cola, reloj)
        # Programar la próxima llegada
        siguiente_tiempo_llegada = reloj + generar_aleatorio()
    else:
        # Un cliente termina su transacción
        num_total_clientes += 1
        tiempo_total_en_sistema += min(siguiente_tiempo_salida) - siguiente_tiempo_llegada
        cajero = siguiente_tiempo_salida.index(min(siguiente_tiempo_salida))
        siguiente_tiempo_salida[cajero] = float('inf')
        if len(cola) > 0:
            # Asignar el próximo cliente en la cola al cajero automático
            siguiente_tiempo_cliente = heapq.heappop(cola)
            tiempo_servicio = generar_aleatorio()
            siguiente_tiempo_salida[cajero] = max(reloj, siguiente_tiempo_cliente) + tiempo_servicio
        else:
            # No hay clientes en la cola, el cajero automático queda libre
            atms_ocupados -= 1

# Calcular las estadísticas
tiempo_promedio_en_sistema = tiempo_total_en_sistema / num_total_clientes
num_promedio_clientes = num_total_clientes / (reloj/60)

# Imprimir los resultados
print(f"Tiempo promedio que un cliente pasa en el sistema: {tiempo_promedio_en_sistema:.2f} minutos")
print(f"Número promedio de clientes en el sistema: {num_promedio_clientes:.2f}")
print(f"Tiempo total en el sistema de todos los clientes: {tiempo_total_en_sistema:.2f} minutos")
print(f"Número total de clientes que ingresaron en 8 horas: {num_total_clientes}")
