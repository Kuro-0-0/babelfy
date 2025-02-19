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

    actionBTN = document.getElementsByClassName('action-btn')
    for (let i = 0; i < actionBTN.length; i++) {
        const element = actionBTN[i];
        element.disabled = true;
    }
}

function hidePopUp() {
    document.getElementById("PopUp").style.display = 'none'
    actionBTN = document.getElementsByClassName('action-btn')
    for (let i = 0; i < actionBTN.length; i++) {
        const element = actionBTN[i];
        element.disabled = false;
    }
}