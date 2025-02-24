function updater(confirmed=false,reloading = false) {
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
                    <h2>Song Name</h2>
                    <p id="name" class="original-view">${document.getElementById("name").textContent}</p>
                </div>
            </div>
            ` + seccion.innerHTML
    
                for (let i = 0; i < ps.length; i++) {
                    const element = ps[i];
                    element.style.display = "none"
                    divContainer = element.closest("div")
                    input = document.createElement("input")
                    input.classList.add("false-view")
                    input.classList.add("dataAPI")
                    input.value = element.textContent
    
                    input.name = element.id
    
                    if (element.id == "releaseDate") {
                        input.type = "date"
                    } else if (element.id == "duration") {
                        input.type = "number"
                    }
                    divContainer.appendChild(input)
                }
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

function showConfirm() {
    confirmPopUp = document.getElementById('PopUpUpdate')
    if (confirmPopUp.style.display == 'flex') {
        confirmPopUp.style.display = 'none'
        document.getElementById('updateBtn').disabled = false;
    } else {
        confirmPopUp.style.display =  'flex'
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
                    paramValue = checkText(paramValue,true);
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
                    if(paramValue<=0||paramValue==null){
                        paramValue = new Error ('You need to add a valid duration')
                    }
                    break;
                case "releaseDate":
                    if(paramValue<=0||paramValue==null){
                        paramValue = new Error ('You need to add a release date')
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
                updater(true,true)
                showSongDetails();
                showPopUp(status,text)
            })
            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });

    } catch (error) {
        showPopUp('Error',error.message)
    }
}
