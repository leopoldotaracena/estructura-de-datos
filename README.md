### Código/Identificador del Reto Generado
* **Matrícula:** 07192202
* **Código del Reto:** BRHZVQ4

---

### Descripción Breve del Procedimiento Realizado
El desarrollo del Árbol Binario de Búsqueda (ABB) en Java se estructuró de manera gradual a través de las siguientes fases:

1. **Inserción de Nodos (`insertar` y `insertarRec`):** Se implementó la lógica recursiva de inserción. Si la raíz o el subárbol actual es nulo, se crea un nuevo nodo con el valor recibido. En caso contrario, se compara el valor a insertar con el dato del nodo actual: los valores menores se dirigen y enlazan recursivamente por la izquierda, mientras que los valores mayores se enlazan por la derecha.
2. **Recorridos del Árbol (`preorden`, `inorden`, `postorden`):** Se construyeron métodos recursivos que formatean la estructura del árbol en cadenas separadas por comas utilizando `StringBuilder`:
   * **Preorden:** Nodo $\rightarrow$ Izquierda $\rightarrow$ Derecha.
   * **Inorden:** Izquierda $\rightarrow$ Nodo $\rightarrow$ Derecha (devuelve los datos de forma ordenada ascendente).
   * **Postorden:** Izquierda $\rightarrow$ Derecha $\rightarrow$ Nodo.
3. **Búsqueda y Clasificación (`buscar` y `claseNodo`):** Se implementó la búsqueda binaria recursiva para validar la existencia de elementos en $O(\log n)$ y determinar la categoría estructural de cada nodo (`RAIZ`, `HOJA`, `UN_HIJO`, `DOS_HIJOS` o `NO_EXISTE`).
4. **Eliminación de Nodos (`eliminar` y `eliminarRec`):** Se abordó la remoción de elementos cubriendo los tres casos fundamentales de reestructuración:
   * **Caso 1 (Nodo Hoja):** Se desconecta directamente retornando `null`.
   * **Caso 2 (Un solo hijo):** Se sustituye el nodo a eliminar por la referencia de su único hijo existente (izquierdo o derecho).
   * **Caso 3 (Dos hijos):** Se localiza el **sucesor inorden** (el valor mínimo del subárbol derecho), se reemplaza el valor del nodo actual por dicho valor y se elimina recursivamente el nodo del sucesor duplicado.
5. **Prueba y Verificación Secuencial:** Se pobló el árbol con una secuencia de datos inicial y se ejecutaron eliminaciones en cadena de los nodos **1** (hoja), **25** (un hijo), **13** (dos hijos) y **26** (raíz con dos hijos), verificando el preorden resultante en cada iteración.

**resultados obtenidos y evidencias estan en las capturas y dibujos correspondientes
---

### Reflexión Sobre el Uso de Árboles Binarios de Búsqueda
Los árboles binarios de búsqueda son muy útiles según el propósito del programa. A diferencia de una lista donde los datos simplemente se avientan al final sin orden, el árbol mantiene una regla clara que permite saber dónde buscar un dato rápidamente. Además, ayudan a ahorrar memoria en los procesos ya que solo crean nodos a medida que se necesitan.
