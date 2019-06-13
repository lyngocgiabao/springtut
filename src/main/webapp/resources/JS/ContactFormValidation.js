function setUpValidation() {
    jQuery.validator.setDefaults({
        errorElement: 'span',
        errorPlacement: function (error, element) {
            switch (element.attr("name")) {
                case "name":
                    error.addClass('invalid-feedback').appendTo("#nameError");
                    break;
                case "address":
                    error.addClass('invalid-feedback').appendTo("#addressError");
                    break;
                case "age":
                    error.addClass('invalid-feedback').appendTo("#ageError");
                    break;
                case "phoneNumber":
                    error.addClass('invalid-feedback').appendTo("#phoneNumError");
                    break;

            }
        },
        highlight: function (element, errorClass, validClass) {
            $(element).addClass('is-invalid');
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).removeClass('is-invalid');
        }
    });

    jQuery.validator.addMethod("phonePattern", function(value, element) {
        // allow any non-whitespace characters as the host part
        return this.optional( element ) || /^\d{10}$/.test( value );
    }, 'Please enter a valid email address.');
}

function checkForm(id) {
    $(id).validate({
        rules: {
            'name': {
                required: true,
                maxlength: 200
            },
            'address' : {
                required: true
            },
            'age': {
                required: true,
                digits:true,
                range: [0, 200]
            },
            'phoneNumber': {
                required: true,
                digits:true,
                maxlength: 10
            }
        },
        messages: {
            name: {
                required: "Name field is required",
                maxLength: "Name field should have 200 or less characters"
            },
            address: {
                required: "Address field is required"
            },
            age: {
                required: "Age field is required",
                range: "Age should be from 0 to 200",
                digits: "Age should be digits"
            },
            phoneNumber: {
                required: "Phone number is required",
                digits: "Phone number should be digits",
                maxlength: "Phone number should contains 10 digits"
            }
        },
        onfocusout: function(element) {
            this.element(element);
        }
    });
}


var name, address, phoneNum, age, submitBtn;
function saveValue(oldName, oldAddress, oldPhoneNum, oldAge, submitButton) {
    name = oldName;
    address = oldAddress;
    phoneNum = oldPhoneNum;
    age = oldAge;
    submitBtn = submitButton;
}
function onlyChange(nameInput, addressInput, phoneInput, ageInput) {
    $(nameInput).on("change paste keyup", function() {
        if($(this).val() !== name) {
            $(submitBtn).attr("disabled", false);
        }else {
            $(submitBtn).attr("disabled", true);

        }
    });
    $(addressInput).on("change paste keyup", function() {
        if($(this).val() !== address) {
            $(submitBtn).attr("disabled", false);
        }else {
            $(submitBtn).attr("disabled", true);
        }
    });
    $(phoneInput).on("change paste keyup", function() {
        if($(this).val() !== phoneNum) {
            console.log($(this).val());
            $(submitBtn).attr("disabled", false);
        }else {
            $(submitBtn).attr("disabled", true);
        }
    });
    $(ageInput).on("change paste keyup", function() {
        if($(this).val() !== age) {
            $(submitBtn).attr("disabled", false);
        }else {
            $(submitBtn).attr("disabled", true);
        }
    });
}