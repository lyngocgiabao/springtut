var contactTable;
var deletedID;
function setUpContactTable(id, tableBody) {
   contactTable = $(id).DataTable({
        "sAjaxSource": "api/alls",
        "sAjaxDataProp": "",
        "order": [[0, "asc"]],
        "paging": false,
        "deferRender": true,
        "aoColumns": [
            {"mData": "contactID"},
            {"mData": "name"},
            {"mData": "phoneNumber"},
            {"mData": "address"},
            {"mData": "age"},
            {"mData": null}
        ],
        "columnDefs": [
            {
                "targets": -1,
                "data": null,
                "searchable": false,
                "orderable": false,
                "defaultContent": "<button class='btn btn-success' id='editBtnTable'>Edit</button> <button id='deleteBtnTable' class='btn btn-danger'" +
                    " data-toggle='modal' data-target='#deleteConfirmation'>Delete</button>"
            }
        ]
    });
   $(tableBody).on('click', '#editBtnTable', function () {
      var contactID = contactTable.row($(this).parents('tr') ).data().contactID;
      document.location.href = "/edit/" + contactID;
   }).on('click','#deleteBtnTable', function () {
       deletedID = contactTable.row($(this).parents('tr') ).data().contactID;
        console.log(deletedID);
   })
}
// $('#cars_table tbody')
//     .on( 'click', '.btn-success', function () {
//         $('#addNewCar').css('display', 'block');
//         console.log(carsTable.row( $(this).parents('tr') ).data()[0]);
//         getSingleCarInfo(carsTable.row( $(this).parents('tr') ).data()[0]);
//         $("#carRegistrationForm").css('display', 'none');
//         $("#carUpdateForm").css('display', 'block');
//         $("#carUpdateForm")[0].reset();
//         $('#carUpdateForm').validate().resetForm();
//     }).on('click', '.btn-danger', function () {
//     //deleteCar()
//     var carPlate = carsTable.row($(this).parents('tr') ).data()[1];
//     rowsToRemove = carsTable.row( $(this).parents('tr') );
//     carToDel = carPlate;
//     $('#delLoadingBtn').css('display', 'none');
//     $('#doneBtn').css('display','none');
//     $('#deleteCarBtn').css('display','block');
//     $('#deleteLabel').text("Do you want to delete this car?");
//     $('#delCloseConfimModalBtn').css('display', 'block');
// });

function deleteContact(callback) {
    var deleteUrl = "/api/delete/" + deletedID;
    $('#closeModalDelBtn').css('display','none');
    $('#deleteConfirmLabel').text("Deleting the contact");
    $('#deleteBtn').css('display','none');
    $('#delLoadingBtn').css('display', 'block');
    $('#doneDelBtn').css('display', 'none');
    $.ajax({
        type: "DELETE",
        contentType : "application/json",
        url : deleteUrl,
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            if (typeof callback === "function") {
                callback();
            }
        },
        error : function(e) {
            $('#deleteConfirmLabel').text("Error occurred. Please try again later");
            console.log("ERROR: ", e);
        }
    })
}