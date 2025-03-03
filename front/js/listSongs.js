
document.addEventListener('DOMContentLoaded', function () {

  getAllSongs()

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


async function getAllSongs(searchValue = '') {
  const apiUrl = 'http://localhost:9000/songs';
  let customURL = apiUrl;
  let search = false;

  if(searchValue != '') {
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

    .then(function (songs) {
      renderSongs(songs,search)

      .then(function() {
        return true;
      });
    })

    .catch(function (error) {
      console.error('Error al cargar las canciones:', error);
      document.getElementById('main').innerHTML = '<div><h1 class="error">Error</h1><p>Something went wrong with the server connection.</p></div>';
    });
}

async function renderSongs(songs,search) {
  var container = document.getElementById('ListSection');
  container.innerHTML = '';

  if (songs.length > 0 && songs) {

    songs.forEach(function (song) {
      var card = document.createElement('a');
      card.classList.add('song')

      card.onclick = function () {
        localStorage.setItem('idSong', song.id);
      }

      card.href = 'SongDetails.html'

      var content = document.createElement('div');
      content.innerHTML =
      '<div class="imagen" id=img'+song.id+'>' + '</div>' +
      '<i onclick="showActionBTN()" class="removeBTN song bi bi-x-square-fill"></i>' +
        '<p>' + song.name + '</p>'

      card.appendChild(content);
      container.appendChild(card);

      document.getElementById("img"+song.id).style.backgroundColor = `#` + song.color + '5b';

    });

  } else {

    if (!search) {
      
    showPopUp('Advise', 'There are no songs, please create a new one.')

    list = document.getElementById('ListSection')
    div = document.createElement("div")
    div.innerHTML =
      "<h1 class='error'>Advise</h1>" +
      "<p>There are no songs, please create a new one.</p>"
      
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

document.getElementById("searchInput").addEventListener('input',function() {
  getAllSongs(this.value)
})


