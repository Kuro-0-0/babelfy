function createCategory() {
    inputs = document.getElementsByClassName("dataAPI")
    let paramName;
    let paramValue;
    let params = {};
    let options;

    for (let index = 0; index < inputs.length; index++) {
        let element = inputs[index];
        paramName = element.name;
        paramValue = element.value;
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
            alternar()
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
}

function alternar() {
    const createCategories = document.getElementById("createCategories");
    const createBtn = document.getElementById("createBtn");

    if (createCategories.style.display === "block") {
        createCategories.style.display = "none";
        createBtn.disabled = false; 
    } else {
        createCategories.style.display = "block";
        createBtn.disabled = true; 
    }
}


async function processNewData(respuesta) {

}