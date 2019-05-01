let religions = {};

fetch('/religion')
    .then(function (response) {
        return response.json();
    }).then(function (json) {
    for (let i = 0; i < json.length; i++) {
        let r = json[i];
        religions[r.id] = r;
    }
    addListeners();
});

let csrf = document.getElementById("csrf");

let submitExorcist = document.getElementById("submitExorcist");
let canton_select = document.getElementById("canton_select");
let phonenumber_input = document.getElementById("phonenumber_input");
let description_textarea = document.getElementById("description_textarea");

submitExorcist.addEventListener("click", function () {
    let data = {"canton": canton_select.value, "phonenumber": phonenumber_input.value, "description": description_textarea.value};

    let form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "/exorcist");

    for(let key in data) {
        if(data.hasOwnProperty(key)) {
            let hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            hiddenField.setAttribute("value", data[key]);
            form.appendChild(hiddenField);
        }
    }
    form.appendChild(csrf);

    document.body.appendChild(form);
    form.submit();
});

function addListeners() {
    let religionSelects = document.getElementsByClassName("religion-select");
    let demonSelects = document.getElementsByClassName("demon-select");

    for (let i = 0; i < religionSelects.length; i++) {
        let religionSelect = religionSelects[i];
        if (religionSelect.value != "") {
            let demonSelect = demonSelects[i];
            religionSelect.addEventListener("change", function () {
                updateDemonSelectWithReligion(demonSelect, religionSelect.value);
            })
            updateDemonSelectWithReligion(demonSelect, religionSelect.value);
        }
    }
}

function updateDemonSelectWithReligion(demonSelect, religionId) {
    demonSelect.innerHTML = "";

    let r = religions[religionId];
    if (r == undefined)
        return;
    for (let i = 0; i < r.demons.length; i++) {
        let demon = r.demons[i];
        let option = document.createElement("option");
        option.value = demon.id;
        option.text = demon.name;
        if (demonSelect.dataset.id != undefined && demonSelect.dataset.id == demon.id) {
            option.selected = true;
            delete demonSelect.dataset.id;
        }
        demonSelect.add(option);
    }
}