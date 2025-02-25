
var songName;

//This event waits for the content of the page to load to make sure the function works okay 
document.addEventListener('DOMContentLoaded', function () {

    showSongDetails();

});

function showSongDetails() {
    const apiUrl = 'http://localhost:9000/songs/' + localStorage.getItem('idSong');

    fetch(apiUrl)
        .then(function (response) {
            if (!response.ok) {
                //This error is thrown so that (if an error occurs) gets to the .catch
                throw new Error('Error en la respuesta de la API: ' + response.statusText);
            }
            //This is .json because the render function needs it to be in this format
            return response.json();
        })

        .then(function (song) {
            renderSongDetails(song);
        })

        //This .catch is here to show through the console any errors that could appear 
        .catch(function (error) {
            console.error('Error al cargar la cancion', error);

            //This also shows that there was an error but through the html
            document.getElementById('main').innerHTML = '<div><h1 class="error">Error</h1><p>Something went wrong with the server connection.</p></div>';
        });
}


function renderSongDetails(song) {
    
    title = document.getElementById('name')
    title.innerHTML = song.name
    section = document.getElementById('sectionDetails');
    console.log(song);
    
    section.innerHTML = `
    <div class="usualDataContainer">
        <div class="dataContainer">
            <h2>Duration</h2>
            <p id="duration" class="original-view">${song.duration}</p>
        </div>
        <div class="dataContainer">
            <h2>Artist</h2>
            <p id="artistName" class="original-view">${song.artistName}</p>
        </div>
        <div class="dataContainer">
            <h2>Album</h2>
            <p id="albumName" class="original-view">${song.albumName}</p>
        </div>
        <div class="dataContainer">
            <h2>Release date</h2>
            <p id="releaseDate" class="original-view">${song.releaseDate}</p>
        </div>
        
        <div class="dataContainer">
            <h2>Category</h2>
            <a id="categoryName" class="original-view">${song.categoryName}</a>
        </div>
    </div>
`;


}

function showChanger() {
    var container = document.getElementById('updateSong');

    if (container.style.display == 'block') {
        container.style.display = 'none';
        document.getElementById('clickForShowing').disabled = false;
    } else {
        document.getElementById('clickForShowing').disabled = true;
        container.style.display = 'block';
        var name = document.getElementById('newName');
        name.value = songName;
    }
}

function changeName() {
    try {

        var submitter = document.getElementById('newName');
        var songId = localStorage.getItem('idSong');
        const apiUrlChange = 'http://localhost:9000/songs';
        var nameValue = checkText(submitter.value);

        //This could be an error because the checkText function could return one
        if (nameValue instanceof Error) {
            throw new Error(nameValue.message)
        }

        //This options are needed to 'send back' the changes
        options = {
            method: "put",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                'id': localStorage.getItem('idSong'),
                'name': submitter.value
            })
        }
        fetch(apiUrlChange, options)

            .then(function (response) {

                //This 'ok' means that the status is a 200
                if (response.ok) {
                    estado = 'Message'
                    showSongDetails();
                } else {
                    estado = 'Error'
                }
                return response.text()
            })

            .then(text => {
                //Calling again this function makes it disappear (revert the show)
                showChanger();

                showPopUp(estado, text)
                var popupTitle = document.getElementById('TitlePopUp');
                popupTitle.style.color = '#cdefed';
            })

            .catch(function (error) {

                console.error('Error al cargar la categoria', error);
                document.getElementById('main').innerHTML = '<p>Error al cargar la categoria.</p>';
            });

    } catch (error) {
        showPopUp('Error', error.message)
    }
}

