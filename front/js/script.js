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