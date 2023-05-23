## 📝 Preguntas

**¿Cuál es la principal ventaja de utilizar Recycler View?**

r/ La principal ventaja de utilizar Recycler View es que permite una mejor optimización y rendimiento al trabajar con grandes cantidades de datos y elementos en una lista, ya que recicla las vistas y sólo muestra en pantalla los elementos que son necesarios, en lugar de cargar todos los elementos en la memoria del dispositivo. 

**Menciona los componentes de RecyclerView y la función que tiene cada uno de ellos**

r/ RecyclerView consta de tres componentes principales: el List Item, el ViewHolder y el Adapter.

- El List Item es un archivo XML que define la vista que se mostrará para cada elemento de la lista, incluyendo la estructura visual y los elementos de diseño, como texto, imágenes, botones, etc.

- El ViewHolder almacena una referencia a la vista de cada elemento de la lista y se utiliza para optimizar el rendimiento del RecyclerView, permitiendo la reutilización de vistas y reduciendo la carga en la memoria del dispositivo. Cada vez que se desplaza la lista de elementos, algunos elementos de la lista se mueven fuera de la vista y se vuelven a utilizar para mostrar nuevos elementos en pantalla.

- El Adapter vincula los datos de una lista o conjunto de datos con las vistas que se muestran en pantalla.  El Adapter es responsable de crear y mantener los ViewHolder y de actualizar la información en la vista de cada elemento cuando se producen cambios en los datos.


