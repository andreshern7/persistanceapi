
const apiUrl = "http://localhost:8080/storage-api";

function postClientData(){

    var brand = document.getElementById("brandResponse").value;
    var color = document.getElementById("colorResponse").value;

    data = {firstField:brand,
    secondField:color}

    var xhr = new XMLHttpRequest();
    xhr.open('POST', apiUrl);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.send(JSON.stringify(data));
    console.log("Data "+data+" send correctyly")
    document.getElementById("submitButton")
    
};

function getClientData(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == XMLHttpRequest.DONE) {
            console.log(xhr.responseText);
        }
    }
    xhr.open('GET', apiUrl);
    xhr.send(null);
};

function getClientDataById(){

    var guitarId = document.getElementById("dataId").value;

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == XMLHttpRequest.DONE) {
            console.log(xhr.responseText);
        }
    }
    xhr.open('GET', apiUrl+"/"+guitarId);
    xhr.send(null);
}