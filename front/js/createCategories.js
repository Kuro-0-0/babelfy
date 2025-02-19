function createCategory() {
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
            console.log(response);
            getAllCategories()
            return response
        })
        .then (respuesta => {
            showActionBTN()
            if (respuesta.status == 200) {
                estado = 'Success'
            } else {
                estado = 'Error'
            }
            return respuesta.text()
        })
        .then(text => {
            showPopUp(estado,text)
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
    } catch (error) {
        showPopUp('Error',error.message)
    }
}

function showActionBTN() {
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

function checkText(textContent) {
    const maxLength = 27;
    const minLength = 1;
    const regEx = /^([a-zA-Z\. ,]){0,27}$/;
    const startsWith = /^[\ \,\.].*$/;
    const endsWith = /^.{1,26}[\ \,]$/;
    try {
        if (textContent.length > maxLength) {
            throw new Error("The text cant have more than 27 characters");
        }
        if (textContent.length < minLength) {
            throw new Error("The text cant have less than 1 character");
        }
        if (startsWith.test(textContent)) {
            throw new Error("The text cant start with space, dot or comma");
        }
        if (endsWith.test(textContent)) {
            throw new Error("The text cant ends with space or comma");
        }
        if (!regEx.test(textContent)) {
            throw new Error("The text contains things that are not text characters");
        }
        return textContent
    } catch (error) {
        return error
    }
}