function createSong() {
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
                    paramValue = Math.floor(paramValue)
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
            element.value = ''
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

function showActionBTNcr() {
    const createSong = document.getElementById("createSong");
    const createBtn = document.getElementById("createBtn");

    if (createSong.style.display === "block") {
        createSong.style.display = "none";
        createBtn.disabled = false;
    } else {
        document.getElementById('inputName').value = ''
        createSong.style.display = "block";
        createBtn.disabled = true;
        showCategoryOptions()
    }

}
