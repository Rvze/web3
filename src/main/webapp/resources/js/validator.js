const sendButton = document.getElementById('submit');

const FORM_NAME = "j_idt23";


function validate() {
    const y = getY().value;

    if (y == null || isNaN(y) || y === '') {
        getY().style.background = 'red';
    }
}

function isEmpty(obj) {
    for (let key in obj) {
        return false;
    }
    return true;
}

getY = () => document.forms[FORM_NAME].elements[2];

