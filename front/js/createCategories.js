function sendData() {
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
    }
    options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/JSON', 
        },
        body: JSON.stringify(params), 
    };
    fetch('http://localhost:9002/categories', options)
        .then(response => {
            console.log(response); 
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}

function alternar() {
    if (document.getElementById("createCategories").style.display == "block") {
        document.getElementById("createCategories").style.display = "none"
    } else {
        document.getElementById("createCategories").style.display = "block"
    }
}