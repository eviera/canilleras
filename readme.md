## TODO

### General
* Ver si no lo queremos fijar para orientacion vertical solamente
  * De ser asi, matar las pantallas land
* Pensar en que estructura almacenar cada diseño de 4 templates de canilleras. Quizas usando SQLite
  * Podria ser un objeto unico, que tenga los 4 templates (un array[4] de objeto template), un nombre (con el que el usuario guarda la cuaterna), y un thumbnail (tomado quizas del primer template no vacio)
  * Ver como guardar las imagenes en SQLite
 

### Pantalla Inicial
* ✔ Parece estar todo

### Eleccion de modelo o scan
* ✔ Parece estar todo

### Menu
* Que funcione el boton Nueva Canillera
  * Debe llevar a la pantalla de CuatroCanilleras con un objeto vacio
* Que funcione el boton Cargar Diseño
  * Debe llevar a lo mismo que el boton cargar de la pantalla de CuatroCanilleras
* ✔ Boton Cambiar Modelo ya anda

### Nueva Canillera / Pantalla CuatroCanilleras
* Tiene que viajar a la pantalla CuatroCanilleras al clickear el menu Nueva Canillera
* Cada uno de los cuatro templates de canillera tiene que estar asociado a un objeto que luego se va a persistir en la base
* Al tocar en el lapicito del template, llevarlo a EditCanillera, transportando el objeto del template
* Boton Cargar
  * Podria listar en una pantalla tipo popup (como el multilist de seleccion de tipo de canillera), donde hay un thumbnail de la primer canillera, y el nombre que le dio el usuario
  * Al elegir un elemento, dar un aviso que se van a reemplazar las actuales
  * Cargar de la base los cuatro templates
* Boton Guardar
  * Pide un nombre para la cuaterna la primera vez
  * Graba en la base el objeto y da un feedback de 'guardado' (quizas un disquette en fade en el centro)
* Boton Imprimir
  * TBD

### Editar Canillera
* Ver como cargar una imagen en el emulador
* Persistir los cambios en el objeto template
  * Creo que aca queremos persistir la imagen tal como la levantamos en la base de datos, con una posicion. Idem para el texto
* Armar el help

### Impresion
* TBD
 
    



## Links Utiles
### Rotacion/Drag/Zoom
- http://codesfor.in/move-zoom-and-rotate-imageview-in-android/
- https://stackoverflow.com/questions/5894736/rotate-zoom-drag-image-in-android-imageview
- https://github.com/devvoron/VoronImageView
- StickerView ? 
    - http://blog.nkdroidsolutions.com/how-to-rotate-scale-and-move-stickers-or-imageview/
    - https://github.com/kencheung4/android-StickerView
- https://github.com/alexvasilkov/GestureViews
- https://github.com/uptechteam/MotionViews-Android (este es el bueno)


### PinchZoom
- https://github.com/jsibbold/zoomage
- https://github.com/emrekose26/PinchZoom
- https://github.com/martinwithaar/PinchToZoom
- https://stackoverflow.com/questions/8399296/how-to-implement-zoom-effect-for-image-view-in-android

### Animaciones
- slide to left-right: https://kylewbanks.com/blog/left-and-right-slide-animations-on-android-activity-or-view
- compleja: http://myhexaville.com/2016/12/30/android-activity-transitions/
- ripple effect:  https://stackoverflow.com/questions/40008609/add-ripple-effect-to-my-button-with-button-background-color  
  - pre lollipop: https://stackoverflow.com/questions/30760822/how-to-create-ripple-effect-for-pre-lollipop
    
### Custom ImageView
- https://github.com/cesards/CropImageView/blob/master/cropimageview/src/main/java/com/cesards/cropimageview/CropImageView.java

### Inkscape
- Substraer (Path/Substract) https://graphicdesign.stackexchange.com/questions/78355/how-to-subtract-a-shape-from-other-shape-on-inkscape

### PDF
- http://tutorials.jenkov.com/java-itext/image.html
- https://stackoverflow.com/questions/30979732/itext-rectangle-from-milimeters

### Bugs
- ~~El dialogo de seleccion de tipos de canilleras no se ve en API 19 (blanco sobre blanco)~~

### Keystore
- El kestore esta en Dropbox/keystore, passsdd


