const radius = 120;
const delta = 30;

function getDot() {
    const svgArea = document.getElementById("area");
    let rect = svgArea.getBoundingClientRect();
    let yCor = (event.clientY - rect.top);
    let xCor = (event.clientX - rect.left);
    const r = getR().value;
    const yVal = -((yCor - (radius + delta)) / radius) * r;
    const xVal = ((xCor - (radius + delta)) / radius) * r;
    sendRequest(xVal, yVal, r);
}

function sendRequest(x, y, r) {
    getX().value = x;
    getY().value = y;
    document.getElementById(FORM_NAME)[9].click();
}


function changeR() {
    const curR = getR().value;
    document.getElementById('radius-text-right').innerHTML = curR;
    document.getElementById('radius-text-bottom').textContent = '-' + curR;
    document.getElementById('radius-text-left').textContent = '-' + curR;
    document.getElementById('radius-text-top').textContent = curR;
}

getSVG = () => document.getElementById('area');
