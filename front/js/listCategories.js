
document.addEventListener('DOMContentLoaded', function () {

  getAllCategories()

    .then(function () {
      let container = document.getElementById('ListSection')

      if (container != null) {

        container.addEventListener('mouseover', function (event) {          
          if (event.target && event.target.classList.contains('removeBTN')) {
            const card = event.target.closest('a');
            card.addEventListener('click', preventLink);
          }
        });

        container.addEventListener('mouseout', function (event) {
          if (event.target && event.target.classList.contains('removeBTN')) {
            const card = event.target.closest('a');  
            card.removeEventListener('click', preventLink); 
          }
        });

      }

      function preventLink(event) {
        event.preventDefault();
      }

    })
});


async function getAllCategories() {
  const apiUrl = 'http://localhost:9000/categories';

  fetch(apiUrl)

    .then(function (response) {

      if (!response.ok) {
        throw new Error('Error en la respuesta de la API: ' + response.statusText);
      }

      return response.json();
    })

    .then(function (categories) {
      renderCategories(categories)

      .then(function() {
        return true;
      });
    })

    .catch(function (error) {
      console.error('Error al cargar las categorias:', error);
      document.getElementById('main').innerHTML = '<div><h1 class="error"> Error </h1>' +
      '<p>Something went wrong with the server connection.</p></div>'
    });
}

async function renderCategories(categories) {
  var container = document.getElementById('ListSection');
  container.innerHTML = '';

  if (categories.length > 0 && categories) {

    categories.forEach(function (category) {
      var card = document.createElement('a');

      card.onclick = function () {
        localStorage.setItem('idCategory', category.id);
      }

      card.href = 'CategoryDetails.html'

      var content = document.createElement('div');
      content.innerHTML =
        '<div class="imagen">' + '</div>' +
        '<i onclick="showActionBTN()" class="removeBTN bi bi-x-square-fill"></i>' +
        '<p>' + category.name + '</p>'

      card.appendChild(content);
      container.appendChild(card);
    });

  } else {
    showPopUp('Advise', 'There are no categories, please create a new one.')

    list = document.getElementById('ListSection')
    div = document.createElement("div")
    div.innerHTML =
      "<h1 class='error'>Advise</h1>" +
      "<p>There are no categories, please create a new one.</p>"
      
    list.appendChild(div)
  }
  return true;
}


