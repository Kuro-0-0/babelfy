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
                    paramValue = checkText(paramValue);
                    break;

                case "artistName":
                    paramValue = checkText(paramValue);
                    break;

                case "albumName":
                    paramValue = checkText(paramValue);
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

            .then (respuesta => {
                showActionBTNcr()
                return respuesta.text()
            })

            .then(text => {
                if (text!="This artist already has a song name like this") {
                    estado = 'Success'
                } else {
                    estado = 'Error'
                }
                showPopUp(estado,text)
            })

            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });

    } catch (error) {
        showPopUp('Error',error.message)
    }

}

function showActionBTNcr() {
    const createCategories = document.getElementById("createCategories");
    const createBtn = document.getElementById("createBtn");    

    if (createCategories.style.display === "block") {
        createCategories.style.display = "none";
        createBtn.disabled = false; 
    } else {
        document.getElementById('inputName').value = ''
        createCategories.style.display = "block";
        createBtn.disabled = true; 
    }

}