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
var categoryName;
document.addEventListener('DOMContentLoaded', function() {

    /*
     * Función: getSongs
     * Descripción: Llama a la API para obtener la lista de canciones.
     *              Luego, procesa la respuesta y llama a la función renderSongs.
     */
    function showCategoryDetails() {
      // URL del endpoint de la API que devuelve la lista de canciones.
      // Cambia la URL a la de tu API real si es necesario.
      const apiUrl = 'http://localhost:9000/categories/'+localStorage.getItem('idCategory');
  
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
        .then(function(category) {
          // 'songs' es un array de objetos, donde cada objeto representa una canción.
          // Se llama a la función que se encarga de pintar (renderizar) los datos en el HTML.
          renderCategoryDetails(category);
        })
        .catch(function(error) {
          // Paso 4: Manejo de errores.
          // Si ocurre algún error durante la petición o la conversión, se muestra en la consola.
          console.error('Error al cargar la categoria', error);
          // También se muestra un mensaje de error en el contenedor HTML.
          document.getElementById('main').innerHTML = '<p>Error al cargar la categoria.</p>';
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
    function renderCategoryDetails(category) {
      // Paso 5: Seleccionar el contenedor donde se mostrarán las tarjetas de canciones.
      var title = document.getElementById('name');
      // Limpiar el contenedor por si ya tenía contenido previo.
      categoryName=category.name;
      title.innerHTML = categoryName;
      var link = document.createElement('button');
      var pen = document.createElement('i');
      pen.classList='bi bi-pencil-fill';
      link.id='clickForShowing';
      link.onclick = showChanger;
      title.appendChild(link);
      link.appendChild(pen);

    }
  
    // Paso 9: Llamar a la función getSongs para iniciar el proceso cuando se carga la página.
    showCategoryDetails();
  });
  
  function showChanger(){
    var container = document.getElementById('updateCategory');

    if(container.style.display=='block'){
      container.style.display='none';
      document.getElementById('clickForShowing').disabled = false;
    }else{
      document.getElementById('clickForShowing').disabled = true;
      container.style.display='block';
      var name = document.getElementById('newName');
      name.value = categoryName;

    }

  }
  function changeName(){
    var submitter = document.getElementById('newName');
    var categoryId = localStorage.getItem('idCategory');
    const apiUrlChange ='http://localhost:9000/categories';

    options={
      method: "put",
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify ({
        'id': localStorage.getItem('idCategory'),
        'name': submitter.value
      })
    }
    fetch(apiUrlChange,options)
    .then(function(response) {
      return response.text();

      // Paso 2: Verificar que la respuesta sea exitosa.
      if (!response.ok) {
        // Si no es exitosa, se lanza un error para que se capture en el catch.
        throw new Error('Error en la respuesta de la API: ' + response.statusText);
      }
      // Paso 3: Convertir la respuesta a formato JSON para poder trabajar con ella.
      return response.json();
    })
    .then(function(response){
      location.reload();
    })
    .catch(function(error) {
      // Paso 4: Manejo de errores.
      // Si ocurre algún error durante la petición o la conversión, se muestra en la consola.
      console.error('Error al cargar la categoria', error);
      // También se muestra un mensaje de error en el contenedor HTML.
      document.getElementById('main').innerHTML = '<p>Error al cargar la categoria.</p>';
    });

  }
//add new function when clic on submit button n send 'put' send back

//request -> id, n new name




