/*
 * Archivo: app.js
 * Descripción: Este archivo JavaScript se encarga de:
 *              1. Llamar a la API para obtener una lista de canciones.
 *              2. Procesar la respuesta de la API (en formato JSON).
 *              3. Crear y pintar en el HTML una tarjeta (card) para cada canción.
 * Cada paso se explica en detalle mediante comentarios.
 */

/*
 * Paso 1: Esperar a que el documento HTML se cargue completamente.
 * Esto asegura que todos los elementos (como el contenedor) estén disponibles.
 */
document.addEventListener('DOMContentLoaded', function() {
    // Paso 9: Llamar a la función getSongs para iniciar el proceso cuando se carga la página.
  getAllCategories();
 });


    /*
     * Función: getSongs
     * Descripción: Llama a la API para obtener la lista de canciones.
     *              Luego, procesa la respuesta y llama a la función renderSongs.
     */
    function getAllCategories() {
      // URL del endpoint de la API que devuelve la lista de canciones.
      // Cambia la URL a la de tu API real si es necesario.
      const apiUrl = 'http://localhost:9000/categories';

      // Se realiza la petición a la API utilizando fetch.
      fetch(apiUrl)
        .then(function(response) {
          // Paso 2: Verificar que la respuesta sea exitosa.
          if (!response.ok) {
            // Si no es exitosa, se lanza un error para que se capture en el catch.
            throw new Error('Error en la respuesta de la API: ' + response.statusText);
          }
          // Paso 3: Convertir la respuesta a formato JSON para poder trabajar con ella.
          return response.json();
        })
        .then(function(categories) {
          // 'songs' es un array de objetos, donde cada objeto representa una canción.
          // Se llama a la función que se encarga de pintar (renderizar) los datos en el HTML.
          renderCategories(categories);
        })
        .catch(function(error) {
          // Paso 4: Manejo de errores.
          // Si ocurre algún error durante la petición o la conversión, se muestra en la consola.
          console.error('Error al cargar las categorias:', error);
          // También se muestra un mensaje de error en el contenedor HTML.
          document.getElementById('main').innerHTML = '<p>Error al cargar las categorias.</p>';
        });
    }

    /*
     * Función: renderSongs
     * Descripción: Recorre el array de canciones recibido de la API y crea
     *              una tarjeta HTML para cada canción. Luego, añade cada tarjeta
     *              al contenedor definido en el HTML.
     *
     * Parámetro:
     *    songs - Array de objetos, donde cada objeto contiene datos de una canción.
     */
    function renderCategories(categories) {
      // Paso 5: Seleccionar el contenedor donde se mostrarán las tarjetas de canciones.
      var container = document.getElementById('ListSection');
      // Limpiar el contenedor por si ya tenía contenido previo.
      container.innerHTML = '';

      // Paso 6: Recorrer el array de canciones.
      console.log(categories);
      console.log(categories.length);
      
      if (categories.length > 0 && categories) {
        categories.forEach(function(category) {
          // Crear un nuevo elemento <div> para la tarjeta de la canción.
          var card = document.createElement('a');
          // Agregar la clase "song-card" para aplicar los estilos CSS definidos.
          card.onclick = function (){
            localStorage.setItem('idCategory',category.id);
            window.location.href='CategoryDetails.html';
          }
  
          var content = document.createElement('div');
          // Paso 7: Asignar el contenido HTML de la tarjeta.
          // Se muestran los datos: título, artista, año y categoría.
          content.innerHTML =
          '<div class="imagen">'+'</div>'+
          '<p>' + category.name + '</p>';
  
          // Paso 8: Añadir la tarjeta al contenedor.
          container.appendChild(card);
          card.appendChild(content);
        });
      } else {
        showPopUp('Error','There are no categories, please create a new one.')
        list = document.getElementById('ListSection')
        div = document.createElement("div")
        div.innerHTML = 
        "<h1 class='error'>ERROR</h1>" +
        "<p>There are no categories, please create a new one.</p>"
        list.appendChild(div)
      }
    }