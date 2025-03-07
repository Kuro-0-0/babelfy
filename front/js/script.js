var categoryName
var artistName

if (document.getElementsByClassName("catDetails").length > 0) {
    document.addEventListener('DOMContentLoaded', function () {
        showCategoryDetails();
    });
}

if (document.getElementsByClassName("songDetails").length > 0) {
    document.addEventListener('DOMContentLoaded', function () {
        showSongDetails()
            .then(data => {
                if (data.categoryID == -1) {

                    categoryName = document.getElementById("categoryName")
                    categoryName.classList.remove("pointer")
                    categoryName.classList.remove("categoryHover")
                    categoryName.setAttribute('onclick', '')
                }
            })

    });
}

if (document.getElementsByClassName("artistDetails").length > 0) {
    document.addEventListener('DOMContentLoaded', function () {
        showArtistDetails();
    });
}

if (document.getElementById('createForm') != null) {
    document.getElementById('createForm').addEventListener('submit', function (event) {
        event.preventDefault();
    });
}

if (document.getElementsByClassName("list Song").length > 0) {

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

    document.getElementById("searchInput").addEventListener('input', function () {
        getAllSongs(this.value)
    })
}

if (document.getElementsByClassName("list Category").length > 0) {

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
            })
    });
    document.getElementById("searchInput").addEventListener('input', function () {
        getAllCategories(this.value)
    })
}

if (document.getElementsByClassName("list Artist").length > 0) {

    document.addEventListener('DOMContentLoaded', function () {
        getAllArtists()
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
            })
    });
    document.getElementById("searchInput").addEventListener('input', function () {
        getAllArtists(this.value)
    })
}

function preventLink(event) {
    event.preventDefault();
}

function showPopUp(status = 'Error', text = 'Error on PopUp loading') {

    popUpTitle = document.getElementById("TitlePopUp");
    document.getElementById("PopUp").style.display = 'block'
    popUpTitle.textContent = status;

    if (status == "Success") {
        popUpTitle.style.color = 'greenyellow'
    } else {
        popUpTitle.style.color = 'red'
    }

    document.getElementById("textPopUp").textContent = text;
    actionBTN = document.getElementsByClassName('action-btn')

    for (let i = 0; i < actionBTN.length; i++) {
        const element = actionBTN[i];
        element.disabled = true;
    }
}

function hidePopUp() {
    document.getElementById("PopUp").style.display = 'none'
    actionBTN = document.getElementsByClassName('action-btn')

    for (let i = 0; i < actionBTN.length; i++) {
        const element = actionBTN[i];
        element.disabled = false;
    }

}

function checkText(textContent, showable = false) {
    let maxLength;

    if (showable) {
        maxLength = 17
    } else {
        maxLength = 27
    }

    const minLength = 1;
    const regEx = /^([a-zA-Z0-9\.\/ ,]){0,27}$/;
    const startsWith = /^[\ \,\.].*$/;
    const endsWith = /^.{1,26}[\ \,]$/;
    const consecutivePunctuation = /(\.{2,}|,{2,})/;
    const multipleSpaces = /  +/;

    try {
        if (textContent.length > maxLength) {
            throw new Error("The name can't have more than " + maxLength + " characters");
        }
        if (textContent.length < minLength) {
            throw new Error("The name must contain at least one character");
        }
        if (startsWith.test(textContent)) {
            throw new Error("The name can't start with a space, dot or comma");
        }
        if (endsWith.test(textContent)) {
            throw new Error("The name can't end with a space or comma");
        }
        if (consecutivePunctuation.test(textContent)) {
            throw new Error("The name can't contain consecutive punctuation marks");
        }
        if (!regEx.test(textContent)) {
            throw new Error("The name contains characters that are not allowed to use");
        }
        if (multipleSpaces.test(textContent)) {
            throw new Error("The name can't contain consecutive spaces");
        }

        return textContent
    } catch (error) {
        return error
    }
}

function moveToThumbnail() {
    window.location.href = 'thumbnail.html'
}

function createCategory() {
    try {

        inputs = document.getElementsByClassName("dataAPI createCategory")
        let paramName;
        let paramValue;
        let params = {};
        let options;

        for (let index = 0; index < inputs.length; index++) {
            let element = inputs[index];
            paramName = element.name;
            paramValue = element.value;

            switch (paramName) {
                case "name":
                    paramValue = checkText(paramValue, true);
                    break;
                default:
                    break;
            }

            if (paramValue instanceof Error) {
                throw new Error(paramValue.message);
            }

            params[paramName] = paramValue
            element.value = ''
        }

        options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/JSON',
            },
            body: JSON.stringify(params),
        };

        fetch('http://localhost:9000/categories', options)

            .then(response => {
                getAllCategories()
                return response
            })

            .then(respuesta => {
                showActionBTNcr()
                if (respuesta.status == 200) {
                    estado = 'Success'
                } else {
                    estado = 'Error'
                }
                return respuesta.text()
            })

            .then(text => {
                globalThis.scrollTo({ top: 0, left: 0, behavior: "smooth" });
                showPopUp(estado, text)
            })

            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });

    } catch (error) {
        showPopUp('Error', error.message)
    }

}

function checkBoxChange() {
    checkboxes = document.getElementById('checkboxes')
    var alguno = false;

    for (let i = 0; i < checkboxes.children.length; i++) {
        const child = checkboxes.children[i].children[0];
        if (child.checked) {
            alguno = true
            document.getElementById('optionSelected').textContent = 'Option/s selected'
        }
        if (!alguno) {
            document.getElementById('optionSelected').textContent = 'Select an option'
        }
    }

}


function createArtist() {
    try {

        inputs = document.getElementsByClassName("dataAPI createArtist")
        let paramName;
        let paramValue;
        let params = {};
        let options;

        for (let index = 0; index < inputs.length; index++) {
            let element = inputs[index];
            paramName = element.name;
            paramValue = element.value;

            switch (paramName) {
                case "name":
                    paramValue = checkText(paramValue, true);
                    break;
                default:
                    break;
            }

            if (paramValue instanceof Error) {
                throw new Error(paramValue.message);
            }

            params[paramName] = paramValue
            element.value = ''
        }

        options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/JSON',
            },
            body: JSON.stringify(params),
        };

        fetch('http://localhost:9000/artists', options)
            .then(response => {
                getAllArtists()
                return response
            })
            .then(respuesta => {
                showActionBTNcr()
                if (respuesta.status == 200) {
                    estado = 'Success'
                } else {
                    estado = 'Error'
                }
                return respuesta.text()
            })

            .then(text => {
                globalThis.scrollTo({ top: 0, left: 0, behavior: "smooth" });
                showPopUp(estado, text)
            })

            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });

    } catch (error) {
        showPopUp('Error', error.message)
    }

}


function showActionBTNcr() {

    const createForm = document.getElementsByClassName("formCreate")
    const createBtn = document.getElementById("createBtn");

    for (let i = 0; i < createForm.length; i++) {
        const element = createForm[i];
        if (element.style.display === "block") {
            element.style.display = "none";
            createBtn.disabled = false;
        } else {
            document.getElementById('inputName').value = ''
            element.style.display = "block";
            createBtn.disabled = true;

            if (element.id == "createSong") {
                showCategoryOptions()
                showArtistOptions()
            }

        }
    }
}

function createSong() {
    try {

        inputs = document.getElementsByClassName("dataAPI createSong")
        let paramName;
        let paramValue;
        let params = {};
        let options;

        let artists = [];

        for (let index = 0; index < inputs.length; index++) {
            let element = inputs[index];
            paramName = element.name;
            paramValue = element.value;

            switch (paramName) {

                case "name":
                    paramValue = checkText(paramValue, true);
                    paramValue.message = paramValue.message + '. Refering to the song name.'
                    break;

                case "artistId":

                    checkboxes = document.getElementById('checkboxes')

                    for (let i = 0; i < checkboxes.children.length; i++) {
                        const child = checkboxes.children[i].children[0];
                        if (child.checked) {
                            artists.push(child.value)
                        }
                    }

                    paramValue = artists;
                    if (paramValue.length == 0) {
                        paramValue = new Error('None artist is selected')
                        paramValue.message = paramValue.message + '. Refering to the artists.'
                    }
                    break;

                case "albumName":
                    paramValue = checkText(paramValue);
                    paramValue.message = paramValue.message + '. Refering to the album name.'
                    break;
                case "duration":
                    paramValue = Math.floor(paramValue)
                    if (paramValue <= 0 || paramValue == null) {
                        paramValue = new Error('You need to add a valid duration')
                    }
                    if (paramValue > 30) {
                        paramValue = new Error('The duration of the song cant be more than 30 mins')
                    }
                    break;
                case "releaseDate":
                    if (paramValue <= 0 || paramValue == null) {
                        paramValue = new Error('You need to add a release date')
                    }
                    break;
                case "selectCategory":
                    paramName = 'idCategory'
                    break;

                default:
                    break;
            }

            if (paramValue instanceof Error) {
                throw new Error(paramValue.message);
            }

            params[paramName] = paramValue

            if (element.id != 'inputArtist') {
                element.value = ''
            }

        }

        options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/JSON',
            },
            body: JSON.stringify(params),
        };

        fetch('http://localhost:9000/songs', options)

            .then(response => {
                getAllSongs()
                return response
            })

            .then(respuesta => {
                showActionBTNcr()
                return respuesta.text()
            })

            .then(text => {
                if (text != "This artist already has a song named like this") {
                    estado = 'Success'
                } else {
                    estado = 'Error'
                }
                showPopUp(estado, text)
            })

            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });

    } catch (error) {
        showPopUp('Error', error.message)
    }

}

function showCategoryOptions() {

    const listoptions = document.getElementById("categoryList");
    getCategoryData()

        .then(data => {
            if (data.length > 0 && data) {
                listoptions.textContent = ''
                data.forEach(function (category) {
                    var option = document.createElement('option');
                    option.value = category.id
                    option.textContent = category.name
                    listoptions.appendChild(option);
                })
            }
        })


}

function showArtistOptions() {

    const listoptions = document.getElementById("checkboxes");
    getArtistData()
        .then(data => {
            if (data.length > 0 && data) {
                listoptions.textContent = ''
                data.forEach(function (artist) {
                    var label = document.createElement('label')
                    var input = document.createElement('input')

                    label.for = 'input-' + artist.id
                    input.id = 'input-' + artist.id
                    input.setAttribute('onclick', `checkBoxChange()`)
                    input.classList.add("artistCheckbox")
                    input.type = 'checkbox'
                    input.value = artist.id

                    label.appendChild(input)
                    label.innerHTML = label.innerHTML + artist.name
                    listoptions.appendChild(label)
                })
            }
        })


}

function deleteArtist() {
    let options;

    options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/JSON',
        },
    };

    fetch('http://localhost:9000/artists/' + localStorage.getItem('idArtist'), options)

        .then(response => {
            return response
        })

        .then(respuesta => {
            showActionBTN()
            console.log(respuesta.status);

            if (respuesta.status == 200) {
                estado = 'Success'
            } else {
                estado = 'Error'
            }
            return respuesta.text()
        })

        .then(text => {
            if (text == "This artist cannot be deleted because it has at least one song with another artist. You have to delete these songs to be able to delete this artist") {
                estado = "Error"
            }
            showPopUp(estado, text)
            getAllArtists()
        })

        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}

function deleteCategory() {
    let options;

    options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/JSON',
        },
    };

    fetch('http://localhost:9000/categories/' + localStorage.getItem('idCategory'), options)

        .then(response => {
            return response
        })

        .then(respuesta => {
            showActionBTN()
            if (respuesta.status == 200) {
                estado = 'Success'
            } else {
                estado = 'Error'
            }
            return respuesta.text()
        })

        .then(text => {
            showPopUp(estado, text)
            getAllCategories()
        })

        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}

function showActionBTN(idSong = '') {
    const deleteCategories = document.getElementById("PopUpDelete");
    const deleteBtn = document.querySelector(".removeBTN");

    const pointers = document.getElementsByClassName("pointer");

    if (idSong == '') {
        if (deleteCategories.style.display === "block") {
            deleteCategories.style.display = "none";
            deleteBtn.disabled = false;
        } else {
            globalThis.scrollTo({ top: 0, left: 0, behavior: "smooth" });
            deleteCategories.style.display = "block";
            deleteBtn.disabled = true;
        }
    } else {
        document.getElementById("yesDelete").setAttribute("onclick", "deleteSong(" + idSong + ")")
        globalThis.scrollTo({ top: 0, left: 0, behavior: "smooth" });
        deleteCategories.style.display = "block";

        for (let i = 0; i < pointers.length; i++) {
            const element = pointers[i];
            if (element.nodeName != 'A') {
                element.classList.add("NotPointer")
                element.classList.remove("pointer")
            }
        }
    }
}

function deleteSong(idSong = '') {

    URL = 'http://localhost:9000/songs/'
    options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/JSON',
        },
    };

    if (idSong == '') {
        URL = URL + localStorage.getItem('idSong');

        fetch(URL, options)
            .then(response => {
                showActionBTN()
                return response.text()
            })
            .then(text => {
                if (text != "There is not a song with such id") {
                    estado = 'Success'
                } else {
                    estado = 'Error'
                }
                getAllSongs()
                showPopUp(estado, text)
            })
            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });
    } else {

        if (document.getElementsByClassName("artistDetails").length > 0) {
            URL = URL + idSong;
            hideActionBTN()
            fetch(URL, options)
                .then(response => {
                    return response.text()
                })
                .then(text => {
                    if (text != "There is not a song with such id") {
                        estado = 'Success'
                    } else {
                        estado = 'Error'
                    }
                    showArtistDetails()
                })
                .catch(error => {
                    console.error('There was a problem with the fetch operation:', error);
                });
        } else {
            URL = URL + "category/" + idSong;
            hideActionBTN()
            fetch(URL, options)
                .then(data => {
                    showCategoryDetails();
                    if (data.status == ok) {
                        estado = "Success"
                    } else {
                        estado = "Error"
                    }
                    return data.text()
                })
                .then(text => {
                    showPopUp(estado, text)
                })
                .catch(error => {
                    console.log(error);
                })
        }


    }

}

function openArtistDetails(id) {
    localStorage.setItem("idArtist", id)
    window.location.href = "ArtistDetails.html"
}

function renderArtistDetails(artist) {
    var title = document.getElementById('name');
    artistName = artist.name;
    title.innerHTML = artistName + "  ";
    var pen = document.createElement('i');
    pen.classList = 'bi bi-pencil-fill';
    pen.id = 'clickForShowing';
    pen.onclick = showChanger;

    //This links the objects, saying that, whats in (), is inside of the other one
    title.appendChild(pen);

    var div = document.getElementById('songsTable');
    if (artist.songs.length <= 0) {

        div.innerHTML = ''
        div.innerHTML =
            "<h1 class='error'>Comment</h1>" +
            "<p>This artist does not have any song</p>"
    } else {
        div.innerHTML = ''
        var table = document.createElement('table');
        var tbody = document.createElement('tbody');
        table.innerHTML =
            ``
        table.innerHTML = `
            <thead>
              <tr>
                <th>Name</th>
                <th>Category</th>
                <th>Duration</th>
                <th>Release Date</th>
                <th>Album</th>
                <th>Other Artists</th>
                <th>Operations</th>
              </tr>
            </thead>
        `

        artist.songs.forEach(function (song) {
            var row = document.createElement('tr');
            var artistsLink = document.createElement('td');
            row.innerHTML = `

          <td><a class="pointer" onclick="openSongDetails(${song.id})">${song.name}</a></td>
          <td><a class="pointer" onclick="openCategoryDetails(${song.categoryID})">${song.categoryName}</a></td>
          <td>${song.duration}</td>
          <td>${song.releaseDate}</td>
          <td>${song.albumName}</td>`
            if (song.artistList.length > 1) {
                var names = '';
                var counter = 0;

                for (let i = 0; i < song.artistList.length; i++) {


                    if (song.artistList[i] != artist.name) {
                        if (counter < 1) {
                            artistsLink.innerHTML = `<a class="pointer" onclick="openArtistDetails(${song.artistsID[i]})">${song.artistList[i]}</a>`
                            counter++;
                        } else {
                            artistsLink.innerHTML = artistsLink.innerHTML + ', ' + `<a class="pointer" onclick="openArtistDetails(${song.artistsID[i]})">${song.artistList[i]}</a>`
                        }
                    }
                }
                row.innerHTML = row.innerHTML + `<td id="otherArtists">${artistsLink.innerHTML}</td>`
            } else {
                row.innerHTML = row.innerHTML + `<td>No other artist</td>`
            }
            row.innerHTML += `<td><a class="deleteSong" onclick="showActionBTN(${song.id})" title="Delete Song"><i class="bi pointer bi-x-square-fill"></i></a></td>`
            tbody.appendChild(row);
        })
        div.appendChild(table);
        table.appendChild(tbody);
    }


}

function showArtistDetails() {
    //This is the endPoint, it uses the saved Id to show the category
    const apiUrl = 'http://localhost:9000/artists/' + localStorage.getItem('idArtist');

    //Then this calls the 'API' from the categoryController that brings that method
    fetch(apiUrl)

        .then(function (response) {
            if (!response.ok) {
                //This error is thrown so that (if an error occurs) gets to the .catch
                throw new Error('Error en la respuesta de la API: ' + response.statusText);
            }
            //This is .json because the render function needs it to be in this format
            return response.json();
        })

        .then(function (artist) {
            renderArtistDetails(artist);
        })

        //This .catch is here to show through the console any errors that could appear
        .catch(function (error) {
            console.error('Error al cargar la info del artista', error);

            //This also shows that there was an error but through the html
            document.getElementById('sectionDetails').innerHTML = '<div><h1 class="error">Error</h1><p>Something went wrong with the server connection.</p></div>';
        });
}

function renderCategoryDetails(category) {

    //This gets an objects in the html with the Id 'name'
    var title = document.getElementById('name');
    var div = document.getElementById('songsTable');

    if (category.songs.length <= 0) {
        div.innerHTML = ''
        div.innerHTML =
            "<h1 class='error'>Comment</h1>" +
            "<p>This category does not have any song</p>"
    } else {
        div.innerHTML = ''
        var table = document.createElement('table');
        var tbody = document.createElement('tbody');
        table.innerHTML =
            ``

        if (category.name != "None") {
            table.innerHTML = `
            <thead>
              <tr>
                <th>Name</th>
                <th>Duration</th>
                <th>Artist/s</th>
                <th>Album</th>
                <th>Release Date</th>
                <th>Operations</th>
              </tr>
            </thead>
            `
        } else {
            table.innerHTML = `
            <thead>
              <tr>
                <th>Name</th>
                <th>Duration</th>
                <th>Artist</th>
                <th>Album</th>
                <th>Release Date</th>
              </tr>
            </thead>
            `
        }
        div.appendChild(table);
        table.appendChild(tbody);
        category.songs.forEach(function (song) {

            let divArtistName = document.createElement('div')

            for (let i = 0; i < song.artistList.length; i++) {
                const artist = song.artistList[i];


                let artistA = document.createElement('a')
                artistA.innerHTML = artist;
                artistA.setAttribute('onclick', `goToArtist('${song.artistsID[i]}')`)
                artistA.href = 'ArtistDetails.html'
                artistA.classList.add("pointer")
                artistA.classList.add("Artist")
                divArtistName.appendChild(artistA);


                if (i != song.artistList.length - 1) {
                    divArtistName.innerHTML += ', <br>';
                }
            }

            var row = document.createElement('tr');
            row.innerHTML = `
            <td><a class="pointer" onclick="openSongDetails(${song.id})">${song.name}</a></td>
            <td>${song.duration}</td>
            <td>${divArtistName.innerHTML}</td>
            <td>${song.albumName}</td>
            <td>${song.releaseDate}</td>
        `

            if (category.name != "None") {
                row.innerHTML = row.innerHTML + `<td><a class="deleteSong" onclick="showActionBTN(${song.id})" title="Delete from category"><i class="bi pointer bi-x-square-fill"></i></a></td>`
            }

            tbody.appendChild(row);
        })

    }
    //This 'category.name' is from the .json that we got from before
    categoryName = category.name;
    if (category.name != "None") {
        title.innerHTML = categoryName + "  ";
        var pen = document.createElement('i');
        pen.classList = 'bi bi-pencil-fill';
        pen.id = 'clickForShowing';
        pen.onclick = showChanger;
        title.appendChild(pen);
    } else {
        title.innerHTML = categoryName
    }


    //This links the objects, saying that, whats in (), is inside of the other one

}

function showChanger() {
    var container;
    var newName;
    if (document.getElementById('updateSong') != null) {
        container = document.getElementById('updateSong')
    } else if (document.getElementById('updateCategory') != null) {
        container = document.getElementById('updateCategory')
        newName = categoryName
    } else {
        container = document.getElementById('updateArtist')
        newName = artistName
    }

    if (container.style.display == 'block') {
        container.style.display = 'none';
        document.getElementById('clickForShowing').disabled = false;
    } else {
        document.getElementById('clickForShowing').disabled = true;
        container.style.display = 'block';
        var name = document.getElementById('newName');
        name.value = newName;
    }
}

function changeName() {
    try {

        var submitter = document.getElementById('newName');
        const apiUrlChange = 'http://localhost:9000/categories';
        var nameValue = checkText(submitter.value, true);

        if (nameValue == "None" || nameValue == "none") {
            throw new Error("You cant rename a category to None, please change the name.");
        }

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
                'id': localStorage.getItem('idCategory'),
                'name': nameValue
            })
        }
        fetch(apiUrlChange, options)

            .then(function (response) {

                //This 'ok' means that the status is a 200
                if (response.ok) {
                    estado = 'Message'
                    showCategoryDetails();
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

function modifyArtist() {
    try {

        var submitter = document.getElementById('newName');
        var id = localStorage.getItem('idArtist');
        const apiUrlChange = 'http://localhost:9000/artists';
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
                'id': id,
                'name': submitter.value
            })
        }
        fetch(apiUrlChange, options)

            .then(function (response) {

                //This 'ok' means that the status is a 200
                if (response.ok) {
                    estado = 'Message'
                    showArtistDetails();
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

                console.error('Error al cargar el artista', error);
                document.getElementById('main').innerHTML = '<p>Error loading the artist.</p>';
            });

    } catch (error) {
        showPopUp('Error', error.message)
    }
}

function hideActionBTN() {
    const NotPointer = document.getElementsByClassName("NotPointer")

    const deleteCategories = document.getElementById("PopUpDelete");
    deleteCategories.style.display = "none";

    for (let i = 0; i < NotPointer.length; i++) {
        const element = NotPointer[i];
        element.classList.add("pointer")
        element.classList.remove("NotPointer")


    }
}

function openSongDetails(id) {
    localStorage.setItem('idSong', id)
    window.location.href = 'SongDetails.html'
}

function renderSongDetails(song) {
    title = document.getElementById('name')
    title.innerHTML = song.name
    section = document.getElementById('sectionDetails');

    let artists = "";

    let divArtistName = document.createElement('div')

    for (let i = 0; i < song.artistList.length; i++) {
        const artist = song.artistList[i];


        let artistA = document.createElement('a')
        artistA.innerHTML = artist;
        artistA.setAttribute('onclick', `goToArtist('${song.artistsID[i]}')`)
        artistA.href = 'ArtistDetails.html'
        artistA.classList.add("pointer")
        artistA.classList.add("Artist")
        divArtistName.appendChild(artistA);


        if (i != song.artistList.length - 1) {
            divArtistName.innerHTML += ', <br>';
        }
    }



    section.innerHTML = `
    <div class="usualDataContainer">
        <div class="dataContainer">
            <h2>Duration</h2>
            <p id="duration" class="original-view">${song.duration}</p>
        </div>
        <div class="dataContainer">
            <h2>Artist</h2>
            <p id="artistName" class="original-view">${divArtistName.innerHTML}</p>
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
            <a id="categoryName" onclick="openCategoryDetails(${song.categoryID})" class="pointer categoryHover original-view">${song.categoryName}</a>
        </div>
    </div>
`;

}

function goToArtist(artistID) {
    localStorage.setItem('idArtist', artistID)
}

function openCategoryDetails(id) {
    localStorage.setItem("idCategory", id)
    window.location.href = "CategoryDetails.html"
}

function updater(confirmed = false, reloading = false) {
    ps = document.getElementsByClassName("original-view")
    inputs = document.getElementsByClassName("false-view")
    updateBTN = document.getElementById("updateBtn")

    if (confirmed) {

        if (!reloading) {
            showConfirm();
        }

        document.getElementById("submitUpdBtn").style.display = "none"
        updateBTN.textContent = "Update"
        for (let i = 0; i < inputs.length; i++) {
            const element = inputs[i];
            element.style.display = "none"
        }

        for (let i = 0; i < ps.length; i++) {
            const element = ps[i];
            element.style.display = "block"
        }

        document.getElementById("nameContainer").style.display = "none"
    } else {


        if (updateBTN.textContent == "Cancel") {

            showConfirm();

        } else {

            document.getElementById("submitUpdBtn").style.display = "block"


            updateBTN.textContent = "Cancel"
            if (inputs.length <= 0) {

                seccion = document.getElementById("sectionDetails")

                seccion.innerHTML = `
            <div id="nameContainer">
                <div class="dataContainer">
                    <h2>Name</h2>
                    <p id="name" class="original-view">${document.getElementById("name").textContent}</p>
                </div>
            </div>
            ` + seccion.innerHTML

                for (let i = 0; i < ps.length; i++) {
                    const element = ps[i];
                    if (element.id != 'artistName') {
                        element.style.display = "none"
                        divContainer = element.closest("div")

                        if (element.id == "categoryName") {
                            input = document.createElement("select")
                            input.name = "categoryId"
                        } else {
                            input = document.createElement("input")
                            input.value = element.textContent
                            input.name = element.id
                        }

                        input.classList.add("false-view")
                        input.classList.add("dataAPI")


                        if (element.id == "releaseDate") {
                            input.type = "date";
                            const today = new Date().toISOString().split('T')[0];
                            input.max = today;

                        } else if (element.id == "duration") {
                            input.type = "number"
                        } else if (element.id == "categoryName") {
                            getCategoryData()
                                .then(data => {
                                    for (let i = 0; i < data.length; i++) {
                                        const elementOption = data[i];
                                        option = document.createElement("option")
                                        option.value = elementOption.id
                                        option.textContent = elementOption.name
                                        input.appendChild(option)

                                        if (element.textContent == elementOption.name) {
                                            input.value = elementOption.id;
                                        }
                                    }
                                })
                        }

                        divContainer.appendChild(input)
                    } else {
                        for (let i = 0; i < inputs.length; i++) {
                            const element = inputs[i];
                            element.style.display = "block"
                            element.value = ps[i].textContent
                            ps[i].style.display = "none"
                        }
                        document.getElementById("nameContainer").style.display = "flex"
                    }
                }
            }
        }
    }
}

function showConfirm() {
    confirmPopUp = document.getElementById('PopUpUpdate')
    if (confirmPopUp.style.display == 'flex') {
        confirmPopUp.style.display = 'none'
        document.getElementById('updateBtn').disabled = false;
    } else {
        confirmPopUp.style.display = 'flex'
        document.getElementById('updateBtn').disabled = true;
    }
}

function sendUpdate() {
    try {

        inputs = document.getElementsByClassName("dataAPI")

        let paramName;
        let paramValue;
        let params = {};
        let options;

        for (let index = 0; index < inputs.length; index++) {
            let element = inputs[index];
            paramName = element.name;
            paramValue = element.value;

            switch (paramName) {

                case "name":
                    paramValue = checkText(paramValue, true);
                    paramValue.message = paramValue.message + '. Refering to the song name.'
                    break;

                case "artistName":
                    paramValue = checkText(paramValue);
                    paramValue.message = paramValue.message + '. Refering to the artist name.'
                    break;

                case "albumName":
                    paramValue = checkText(paramValue);
                    paramValue.message = paramValue.message + '. Refering to the album name.'
                    break;
                case "duration":
                    if (paramValue <= 0 || paramValue == null) {
                        paramValue = new Error('You need to add a valid duration')
                    }
                    break;
                case "releaseDate":
                    if (paramValue <= 0 || paramValue == null) {
                        paramValue = new Error('You need to add a release date')
                    }
                    break;

                default:
                    break;
            }

            if (paramValue instanceof Error) {
                throw new Error(paramValue.message);
            }

            params[paramName] = paramValue
        }

        params["id"] = localStorage.getItem("idSong")

        options = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/JSON',
            },
            body: JSON.stringify(params),
        };

        fetch('http://localhost:9000/songs', options)
            .then(response => {
                switch (response.status) {
                    case 200:
                        status = 'Success'
                        break;

                    default:
                        status = 'Error'
                        break;
                }
                return response.text();
            })
            .then(text => {
                updater(true, true)
                showSongDetails();
                showPopUp(status, text)
            })
            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });

    } catch (error) {
        showPopUp('Error', error.message)
    }
}

function showCategoryDetails() {

    //This is the endPoint, it uses the saved Id to show the category
    const apiUrl = 'http://localhost:9000/categories/' + localStorage.getItem('idCategory');

    //Then this calls the 'API' from the categoryController that brings that method
    fetch(apiUrl)

        .then(function (response) {
            if (!response.ok) {
                //This error is thrown so that (if an error occurs) gets to the .catch
                throw new Error('Error en la respuesta de la API: ' + response.statusText);
            }
            //This is .json because the render function needs it to be in this format
            return response.json();
        })

        .then(function (category) {
            renderCategoryDetails(category);
        })

        //This .catch is here to show through the console any errors that could appear 
        .catch(function (error) {
            console.error('Error al cargar la categoria', error);

            //This also shows that there was an error but through the html
            document.getElementById('sectionDetails').innerHTML = '<div><h1 class="error">Error</h1><p>Something went wrong with the server connection.</p></div>';
        });
}

async function showSongDetails() {
    const apiUrl = 'http://localhost:9000/songs/' + localStorage.getItem('idSong');

    return fetch(apiUrl)
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
            return song;
        })

        //This .catch is here to show through the console any errors that could appear 
        .catch(function (error) {
            console.error('Error al cargar la cancion', error);

            //This also shows that there was an error but through the html
            document.getElementById('main').innerHTML = '<div><h1 class="error">Error</h1><p>Something went wrong with the server connection.</p></div>';
        });
}

async function getCategoryData() {
    options = {
        method: 'GET',
    };

    return fetch("http://localhost:9000/categories/names", options)
        .then(data => {
            return data.json();
        })
        .catch(error => {
            console.log(error);
        })
}

async function getArtistData() {
    options = {
        method: 'GET',
    };

    return fetch("http://localhost:9000/artists/names", options)
        .then(data => {
            return data.json();
        })
        .catch(error => {
            console.log(error);
        })
}

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

async function getArtistIDName(artistName) {
    const apiUrl = 'http://localhost:9000/artists/limited'
    apiUrl += '?artistName=' + artistName;
    return fetch(apiUrl)
        .then((response) => {
            return response.json
        })
}

async function getAllArtists(searchValue = '') {
    const apiUrl = 'http://localhost:9000/artists';

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

        .then(function (artists) {
            renderArtists(artists, search)

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

async function getAllSongs(searchValue = '') {
    const apiUrl = 'http://localhost:9000/songs';
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

        .then(function (songs) {
            renderSongs(songs, search)

                .then(function () {
                    return true;
                });
        })

        .catch(function (error) {
            console.error('Error al cargar las canciones:', error);
            document.getElementById('main').innerHTML = '<div><h1 class="error">Error</h1><p>Something went wrong with the server connection.</p></div>';
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
                "<p>There are no categories with the name you are looking for.</p>"

            list.appendChild(div)
        }
    }
    return true;
}

async function renderArtists(artists, search) {
    var container = document.getElementById('ListSection');
    container.innerHTML = '';

    if (artists.length > 0 && artists) {

        artists.forEach(function (artist) {
            var card = document.createElement('a');
            card.classList.add('artist')

            card.onclick = function () {
                localStorage.setItem('idArtist', artist.id);
            }

            card.href = 'ArtistDetails.html'
            var content = document.createElement('div');
            div = document.createElement('div')
            div.classList.add("imagen")
            div.id = "img" + artist.id

            content.append(div)

            if (artist.name != "None") {
                content.innerHTML = content.innerHTML + '<i onclick="showActionBTN()" class="removeBTN artist bi bi-x-square-fill"></i>'
            }

            p = document.createElement('p')
            p.textContent = artist.name

            content.append(p)
            card.appendChild(content);
            container.appendChild(card);

            document.getElementById("img" + artist.id).style.backgroundColor = `#` + artist.color + '5b';
        });

    } else {
        if (!search) {
            showPopUp('Advise', 'There are no artists, please create a new one.')

            list = document.getElementById('ListSection')
            div = document.createElement("div")
            div.innerHTML =
                "<h1 class='error'>Advise</h1>" +
                "<p>There are no artists, please create a new one.</p>"

            list.appendChild(div)
        } else {
            list = document.getElementById('ListSection')
            div = document.createElement("div")
            div.innerHTML =
                "<h1 class='error'>Advise</h1>" +
                "<p>There are no artists with the name you are looking for.</p>"

            list.appendChild(div)
        }
    }
    return true;
}

async function renderSongs(songs, search) {
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
                '<div class="imagen" id=img' + song.id + '>' + '</div>' +
                '<i onclick="showActionBTN()" class="removeBTN song bi bi-x-square-fill"></i>' +
                '<p>' + song.name + '</p>'

            card.appendChild(content);
            container.appendChild(card);

            document.getElementById("img" + song.id).style.backgroundColor = `#` + song.color + '5b';

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

var expanded = false;
function showCheckboxes() {
    var checkboxes = document.getElementById("checkboxes");
    if (!expanded) {
        checkboxes.style.display = "block";
        expanded = true;
    } else {
        checkboxes.style.display = "none";
        expanded = false;
    }
}