# Comparación de Algoritmos de Ordenamiento

Este proyecto implementa y compara cuatro algoritmos de ordenamiento clásicos: **InsertionSort**, **MergeSort**, **HeapSort** y **QuickSort**.

## Objetivo

Analizar gráficamente el desempeño de los algoritmos midiendo el número de comparaciones realizadas en arreglos de diferentes tamaños (1,000 a 100,000 elementos).

## Archivos del Proyecto

### Algoritmos Implementados:

- `InsertionSort.java` - Algoritmo de ordenamiento por inserción (O(n²))
- `MergeSort.java` - Algoritmo de ordenamiento por mezcla (O(n log n))
- `HeapSort.java` - Algoritmo de ordenamiento por montículo (O(n log n))
- `QuickSort.java` - Algoritmo de ordenamiento rápido (O(n log n) promedio)

### Archivos de Experimentación:

- `ExperimentoAlgoritmos.java` - Programa principal que ejecuta todos los experimentos
- `AnalisisResultados.java` - Programa para mostrar un análisis formateado de los resultados
- `resultados_algoritmos.csv` - Archivo CSV con los datos generados (para Excel)

## Cómo Ejecutar

### 1. Compilar todos los archivos:

```bash
javac *.java
```

### 2. Ejecutar el experimento:

```bash
java ExperimentoAlgoritmos
```

### 3. Ver análisis de resultados (opcional):

```bash
java AnalisisResultados
```

Este comando:

- Genera arreglos aleatorios de tamaños: 1,000, 10,000, 20,000, ..., hasta 100,000
- Ejecuta los 4 algoritmos en cada arreglo (usando copias idénticas)
- Cuenta las comparaciones realizadas por cada algoritmo
- Guarda los resultados en `resultados_algoritmos.csv`

## Crear la Gráfica en Excel

1. Abre el archivo `resultados_algoritmos.csv` en Microsoft Excel
2. Selecciona todos los datos (incluyendo encabezados)
3. Inserta → Gráficos → Gráfico de Líneas
4. Configura:
   - **Eje X**: Tamaño del arreglo (1000, 10000, 20000, etc.)
   - **Eje Y**: Número de comparaciones
   - **Series**: Una línea para cada algoritmo

## Características Técnicas

- **Funciones Genéricas**: Todos los algoritmos usan generics (`<T extends Comparable<T>>`), lo que permite ordenar cualquier tipo de dato comparable.
- **Contador de Comparaciones**: Cada algoritmo tiene una función `comparar()` que incrementa un contador global.
- **Arreglos Aleatorios**: Se generan números aleatorios entre 0 y 9,999 para cada experimento.
- **Copias Independientes**: Cada algoritmo trabaja con una copia idéntica del arreglo original.

## Resultados Esperados

El proyecto debería demostrar gráficamente que:

1. **InsertionSort**: Crecimiento cuadrático (O(n²)) - El más lento para arreglos grandes
2. **MergeSort**: Crecimiento logarítmico-lineal (O(n log n)) - Consistente y eficiente
3. **HeapSort**: Crecimiento logarítmico-lineal (O(n log n)) - Bueno pero más comparaciones que MergeSort
4. **QuickSort**: Crecimiento logarítmico-lineal promedio (O(n log n)) - Muy eficiente en la práctica

## Notas Importantes

- Los contadores usan `int` para el número de comparaciones
- Los experimentos usan arreglos de enteros aleatorios
- Los resultados pueden variar ligeramente entre ejecuciones debido a la naturaleza aleatoria de los datos
- **Nota**: Para arreglos muy grandes (100,000+ elementos), InsertionSort puede causar overflow en el contador
