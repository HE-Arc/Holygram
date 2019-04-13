let religions = {};

fetch('/religion')
    .then(function (response) {
        return response.json();
    }).then(function (json) {
    for(let i = 0; i < json.length; i++)
    {
        let r = json[i];
        religions[r.id] = r;
    }
    addListeners();
});

function addListeners()
{
    let religionSelects = document.getElementsByClassName("religion-select");
    let demonSelects = document.getElementsByClassName("demon-select");

    for(let i = 0; i < religionSelects.length; i++)
    {
        let religionSelect = religionSelects[i];
        if(religionSelect.value != "") {
            let demonSelect = demonSelects[i];
            religionSelect.addEventListener("change", function() {
                updateDemonSelectWithReligion(demonSelect,religionSelect.value);
            })
            updateDemonSelectWithReligion(demonSelect,religionSelect.value);
        }
    }
}

function updateDemonSelectWithReligion(demonSelect, religionId)
{
    demonSelect.innerHTML = "";

    let r = religions[religionId];
    if(r == undefined)
        return;
    for(let i = 0; i < r.demons.length; i++)
    {
        let demon = r.demons[i];
        let option = document.createElement("option");
        option.value = demon.id;
        option.text = demon.name;
        if(demonSelect.dataset.id != undefined && demonSelect.dataset.id == demon.id) {
            option.selected = true;
            delete demonSelect.dataset.id;
        }
        demonSelect.add(option);
    }
}

function updateSelect()
{
    let demonSelects = document.getElementsByClassName("demon-select");

    for(let i = 0; i < demonSelects.length; i++)
    {
        let demonSelect = demonSelects[i];
        console.log(demonSelect.options);
    }
}