<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Web services demo</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="<c:url value="/resources/JS/ContactTable.js"/>"></script>
</head>
<body>
<div class="jumbotron text-center" style="margin-bottom:0;background: green">
    <h1 style="color: aliceblue">Spring Tutorial</h1>
    <h2 style="color: aliceblue">Web Services Demo</h2>
</div>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <h5 style="color: aliceblue">Contact Database CRUD</h5>
</nav>
<div class="container" style="margin-top:30px">
    <h1>Contact information</h1>
    <hr>
    <div class="row" style="margin-top:30px">
        <div class="col-lg-12">
            <a href="<c:url value="/add" />" class="btn btn-success float-right">Add New Contact</a>
        </div>
    </div>
    <div class="row" style="margin-top:30px">
        <div class="col-lg-12">
            <table id="contactTable" class="display" style="width:100%">
                <!-- Header Table -->
                <thead>
                <tr>
                    <th>Contact ID</th>
                    <th>Name</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                    <th>Age</th>
                    <th>Action</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<div class="modal fade" id="deleteConfirmation">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="reset" class="close" data-dismiss="modal" id="closeModalDelBtn">&times;</button>
                <h4 class="modal-title w-100 font-weight-bold">Confirmation</h4>
            </div>
            <div class="modal-body text-center" >
                <h4 id="deleteConfirmLabel">Are you sure to delete this contact?</h4>
            </div>
            <div class="modal-footer d-flex justify-content-center">
                <button class="btn btn-danger" type="button" id="deleteBtn">Delete</button>
                <button class="btn btn-danger" type="button" id="delLoadingBtn" style="display: none" disabled>
                    <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>Deleting
                </button>
                <button class="btn btn-primary" type="button" id="doneDelBtn" style="display: none" data-dismiss="modal">Done</button>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
       setUpContactTable('#contactTable', '#contactTable tbody')
    });
    $('#deleteBtn').on('click', function () {
        deleteContact(function () {
            $('#closeModalDelBtn').css('display','block');
            $('#deleteConfirmLabel').text("The contact has been deleted");
            $('#deleteBtn').css('display','none');
            $('#delLoadingBtn').css('display', 'none');
            $('#doneDelBtn').css('display', 'block');
            $('#contactTable').DataTable().ajax.reload();
        })
    })
</script>
</html>