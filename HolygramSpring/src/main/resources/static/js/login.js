let divDescription = document.getElementById("divDescription");
let divPhoneNumber = document.getElementById("divPhoneNumber");
let divCanton = document.getElementById("divCanton");

let inputDescription = document.getElementById("description");
let inputPhoneNumber = document.getElementById("phoneNumber");
let inputCanton = document.getElementById("canton");

let typeCustomer = document.getElementById("typeCustomer");
let typeExorcist = document.getElementById("typeExorcist");

typeCustomer.addEventListener("click", updateFrom);
typeExorcist.addEventListener("click", updateFrom);

function updateFrom() {
    let b = typeCustomer.checked;
    divDescription.hidden = b;
    divPhoneNumber.hidden = b;
    divCanton.hidden = b;

    inputDescription.disabled = b;
    inputPhoneNumber.disabled = b;
    inputCanton.disabled = b;
}