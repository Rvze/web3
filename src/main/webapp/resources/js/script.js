function setR(val) {
    getR().value = val;
}

getX = () => document.getElementById(FORM_NAME + ':' + 'decimal');
getR = () => document.forms["j_idt23"].elements[3];