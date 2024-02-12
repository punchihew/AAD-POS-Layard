const CUS_ID_REGEX = /^(C)[0-9]{3}$/;
const CUS_NAME_REGEX = /^[A-Za-z ]{5,}$/;
const CUS_ADDRESS_REGEX = /^[A-Za-z0-9 ]{5,}$/;
const CUS_SALARY_REGEX = /^[0-9]{2,}([.][0-9]{2})?$/;

var validationId;
var validationName;
var validationAddress;
var validationSalary;

// let customerNumberCounter = 1;
// let customerIDstor;
//
// generateID();
// function generateID() {
//     const customerID = `C${String(customerNumberCounter).padStart(3, '0')}`;
//     customerNumberCounter++;
//     customerIDstor = customerID;
//     $("#txtCustomerID").val(customerID);
// }

// function clearCustomerInputFields() {
//     $("#txtCustomerID,#txtCustomerName,#txtCustomerAddress,#txtCustomerSalary").val("");
//     $("#txtCustomerID,#txtCustomerName,#txtCustomerAddress,#txtCustomerSalary").css("border", "1px solid #ced4da");
//     $("#txtCustomerID").focus();
// }


$("#btnSave").attr('disabled',true);
$("#btnUpdate").attr('disabled',true);

$("#customerIdText").keyup(function (e) {
    let value = $("#customerIdText").val();
    if (value.length == 1) {
        $("#btnSave").attr('disabled',true);
        $("#customerIdText").css('border', '1px solid #ced4da');
    } else {
        let res = CUS_ID_REGEX.test(value);
        if (res) {
            validationId =1;
            setBtn();
            $("#customerIdText").css('border', '2px solid green');
        } else {
            $("#customerIdText").css('border', '2px solid red');
        }
    }});

$("#customerNameText").keyup(function (e) {
    let value = $("#customerNameText").val();
    if (value.length == 0) {
        $("#btnSave").attr('disabled',true);
        $("#customerNameText").css('border', '1px solid #ced4da');
    } else {
        let res = CUS_NAME_REGEX.test(value);
        if (res) {
            validationName=1;
            setBtn();
            $("#customerNameText").css('border', '2px solid green');
        } else {
            $("#customerNameText").css('border', '2px solid red');
        }
    }});

$("#customerAddressText").keyup(function (e) {
    let value = $("#customerAddressText").val();
    if (value.length == 0) {
        $("#btnSave").attr('disabled',true);
        $("#customerAddressText").css('border', '1px solid #ced4da');
    } else {
        let res = CUS_ADDRESS_REGEX.test(value);
        if (res) {
            validationAddress=1;
            setBtn();
            $("#customerAddressText").css('border', '2px solid green');
        } else {
            $("#customerAddressText").css('border', '2px solid red');
        }
    }});

$("#customerSalaryText").keyup(function (e) {
    let value = $("#customerSalaryText").val();
    if (value.length == 0) {
        $("#btnCusAdd").attr('disabled',true);
        $("#customerSalaryText").css('border', '1px solid #ced4da');
    } else {
        let res = CUS_SALARY_REGEX.test(value);
        if (res) {
            validationSalary=1;
            setBtn();
            $("#btnSave").attr('disabled',false);
            $("#btnUpdate").attr('disabled',false);
            $("#customerSalaryText").css('border', '2px solid green');
        } else {
            $("#customerSalaryText").css('border', '2px solid red');
        }
    }});


function setBtn() {
    if (validationId==1 && validationName==1 && validationAddress==1 && validationSalary==1){
        $("#btnSave").attr('disabled',false);
        $("#btnUpdate").attr('disabled',false);
    }
}

// function saveUpdateAlert(vale, value2) {
//     Swal.fire({
//         position: 'top-end',
//         icon: 'success',
//         title: vale + ' has been ' + value2,
//         showConfirmButton: false,
//         timer: 2500
//     });
// }