
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

async function getAllCategories(searchValue = '') {
  const apiUrl = 'http://localhost:9000/categories';

  //This variable is created because apiUrl is a const so it cant be changed
  let customURL = apiUrl;
  let search = false;

  if (searchValue != '') {
    customURL += '?name=' + searchValue;
    search = true;
  }

  fetch(customURL)

    .then(function (response) {

      if (!response.ok) {
        throw new Error('Error en la respuesta de la API: ' + response.statusText);
      }

      return response.json();
    })

    .then(function (categories) {
      renderCategories(categories, search)

        .then(function () {
          return true;
        });
    })

    .catch(function (error) {
      console.error('Error al cargar las categorias:', error);
      document.getElementById('main').innerHTML = '<div><h1 class="error"> Error </h1>' +
        '<p>Something went wrong with the server connection.</p></div>'
    });
}

async function renderCategories(categories, search) {
  var container = document.getElementById('ListSection');
  container.innerHTML = '';

  if (categories.length > 0 && categories) {

    categories.forEach(function (category) {
      var card = document.createElement('a');
      card.classList.add('category')

      card.onclick = function () {
        localStorage.setItem('idCategory', category.id);
      }

      card.href = 'CategoryDetails.html'
      var content = document.createElement('div');
      div = document.createElement('div')
      div.classList.add("imagen")
      div.id = "img" + category.id

      content.append(div)

      if (category.name != "None") {
        content.innerHTML = content.innerHTML + '<i onclick="showActionBTN()" class="removeBTN category bi bi-x-square-fill"></i>'
      }

      p = document.createElement('p')
      p.textContent = category.name

      content.append(p)
      card.appendChild(content);
      container.appendChild(card);

      document.getElementById("img" + category.id).style.backgroundColor = `#` + category.color + '5b';
    });

  } else {
    if (!search) {
      showPopUp('Advise', 'There are no categories, please create a new one.')

      list = document.getElementById('ListSection')
      div = document.createElement("div")
      div.innerHTML =
        "<h1 class='error'>Advise</h1>" +
        "<p>There are no categories, please create a new one.</p>"

      list.appendChild(div)
    } else {
      list = document.getElementById('ListSection')
      div = document.createElement("div")
      div.innerHTML =
        "<h1 class='error'>Advise</h1>" +
        "<p>There are no songs with the name you are looking for.</p>"

      list.appendChild(div)
    }
  }
  return true;
}

//This gets the search 'button' and waits for it to have something
document.getElementById("searchInput").addEventListener('input', function () {
  getAllCategories(this.value)
})
