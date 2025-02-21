function deleteCategory() {
    let options;

    options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/JSON', 
        },
    };

    fetch('http://localhost:9000/categories/'+localStorage.getItem('idCategory'), options)

        .then(response => {
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
            window.location.href = 'CategoriesList.html'
        })

        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}

function showActionBTN() {
    const deleteCategories = document.getElementById("PopUpDelete");
    const deleteBtn = document.querySelector(".removeBTN");
  
    if (deleteCategories.style.display === "block") {
        deleteCategories.style.display = "none";
        deleteBtn.disabled = false; 
    } else {
        globalThis.scrollTo({top:0,left:0, behavior:"smooth"});
        deleteCategories.style.display = "block";
        deleteBtn.disabled = true; 
    }
  }
