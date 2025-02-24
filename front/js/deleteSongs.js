function deleteSong(){
    let options;

    options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/JSON', 
        },
    };
    fetch('http://localhost:9000/songs/'+localStorage.getItem('idSong'), options)

    .then (response => {
        showActionBTN()
        return response.text()
    })

    .then(text => {
        if (text!="There is not a song with such id") {
            estado = 'Success'
        } else {
            estado = 'Error'
        }
        getAllSongs()
        showPopUp(estado,text)
    })

    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });

}

function showActionBTN() {

    const deleteSong = document.getElementById("PopUpDelete");
    const deleteBtn = document.querySelector(".removeBTN");
  
    if (deleteSong.style.display == "block") {
        deleteSong.style.display = "none";
        deleteBtn.disabled = false; 

        console.log('sgsegse')
    } else {
        globalThis.scrollTo({top:0,left:0, behavior:"smooth"});
        deleteSong.style.display = "block";
        deleteBtn.disabled = true; 
        console.log('sgsafaaaaaaegse')
    }
  }