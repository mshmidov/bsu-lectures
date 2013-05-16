function validateAndSubmit() {
    var formValid = true;

    var id = document.getElementById('id');
    if (id.value.trim() == "") {
        id.style.backgroundColor = "red";
        formValid = false;
    }

    var firstName = document.getElementById('firstName');
    if (firstName.value.trim() == "") {
        firstName.style.backgroundColor = "red";
        formValid = false;
    }

    var lastName = document.getElementById('lastName');
    if (lastName.value.trim() == "") {
        lastName.style.backgroundColor = "red";
        formValid = false;
    }

    if (formValid) {
        var form = document.getElementById("myform");
        form.submit();
    }

    return formValid;
}