let evaluation_form = document.getElementById("evaluation_form");
let evaluation_thumbsUp = document.getElementById("evaluation_thumbsUp");
let evaluation_thumbsDown = document.getElementById("evaluation_thumbsDown");
let evaluation_thumbs = document.getElementById("evaluation_thumbs");

evaluation_form.reset(); // to ensure the form is reset onload (backward navigation cause problem with the custom radio buttons)

evaluation_thumbsUp.addEventListener("click", function () {
    evaluation_form.evaluation.value = "1";
    evaluation_thumbsUp.classList.add("btn-success");
    evaluation_thumbsUp.classList.remove("btn-light");
    evaluation_thumbsDown.classList.add("btn-light");
    evaluation_thumbsDown.classList.remove("btn-danger");
});

evaluation_thumbsDown.addEventListener("click", function () {
    evaluation_form.evaluation.value = "-1";
    evaluation_thumbsUp.classList.remove("btn-success");
    evaluation_thumbsUp.classList.add("btn-light");
    evaluation_thumbsDown.classList.remove("btn-light");
    evaluation_thumbsDown.classList.add("btn-danger");
});

function validate_input(input, condition) {
    if (condition) {
        input.classList.add("is-valid");
        input.classList.remove("is-invalid");
    } else {
        input.classList.add("is-invalid");
        input.classList.remove("is-valid");
        input.focus();
    }
    return condition;
}

function validate_evaluation() {
    let b = 1;
    b &= validate_input(evaluation_form.service, evaluation_form.service.selectedIndex > 0);
    b &= validate_input(evaluation_thumbs, evaluation_form.evaluation.value != "");
    b &= validate_input(evaluation_form.comment, evaluation_form.comment.value != "");
    return b == 1;
}