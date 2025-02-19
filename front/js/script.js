function showPopUp(status='Error',text='Error on PopUp loading') {
    
    popUpTitle = document.getElementById("TitlePopUp");

    document.getElementById("PopUp").style.display = 'block'

    popUpTitle.textContent = status;
    if (status == "Success") {
        popUpTitle.style.color = 'greenyellow'
    } else {
        popUpTitle.style.color = 'red'
    }
    document.getElementById("textPopUp").textContent = text;
    document.getElementById("createBtn").disabled = true;
}

function hidePopUp() {
    document.getElementById("PopUp").style.display = 'none'
    document.getElementById("createBtn").disabled = false;

}