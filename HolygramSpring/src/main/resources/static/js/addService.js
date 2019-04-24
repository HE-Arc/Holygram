let addService_religion = document.getElementById("addService_religion");
let addService_demon = document.getElementById("addService_demon");
let addService_price = document.getElementById("addService_price");

let error_message = document.getElementById("error_message");


function validate_addService()
{
	let b = false;
	b = b || addService_religion.selectedIndex != 0;
	b = b || addService_demon.value != "";
	b = b || addService_price.value != "";
	error_message.hidden = b;
	return b;
}