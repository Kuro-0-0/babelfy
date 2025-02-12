let inputs

function sendData() { // NO SIRVE, SON MIS COSAS
    inputs = document.getElementsByClassName("dataAPI")
    let paramName;
    let paramValue;
    let params = new URLSearchParams();
    let options;

    for (let index = 0; index < inputs.length; index++) {
        let element = inputs[index];
        paramName = element.name;
        paramValue = element.value;
        params.append(paramName, paramValue);
    }
    options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',  // Definir el tipo de contenido adecuado
        },
        mode: 'no-cors',
        body: params.toString(),  // Convertir los parámetros a cadena de URL codificada
    };
    fetch('http://localhost:9000/API/categoria/new/submit', options)
        .then(response => {
            console.log(response);  // Procesa la respuesta aquí
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}