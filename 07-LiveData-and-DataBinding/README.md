## 📝 Preguntas

**¿Qué ventajas tiene el utilizar LiveData?**

r/ En LiveData actualiza automáticamente sin importar si el ciclo de vida de la actividad se queda inactivo, actualiza los objetos cuando se actualizan los datos sin necesidad de actualizar la UI cada vez que cambian los datos de la app, puede prevenir errores de referencia nula y fugas de memoria

**2. ¿Qué patrón de diseño utiliza LiveData?**

r/ LiveData sigue el patrón de diseño **observador**


**Menciona que se debe agregar al Gradle para poder implementar DataBinding**

r/ 
```
dataBinding {
  enabled true
}
```

**¿Qué es DataBinding? Menciona sus ventajas frente a findViewById**

r/ Es una caracteristica de Android para enlazar los datos entre la UI y lod datos, no es necesario realizar actualizaciones manuales para que la interfaz refleje los cambios en los datos, frente a findViewById DataBinding proporciona una mayor eficiencia y rendimiento, reduce la cantidad de codigo, soporte para enlaces bidireccionales.


