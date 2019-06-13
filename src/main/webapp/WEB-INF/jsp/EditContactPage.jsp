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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
    <script src="<c:url value="/resources/JS/ContactFormValidation.js"/>"></script>
</head>
<body>
<div class="jumbotron text-center jumbotron-fluid" style="margin-bottom:0;background: green">
    <h1 style="color: aliceblue">Spring Tutorial</h1>
    <h2 style="color: aliceblue">Web Services Demo</h2>
    <p style="color: aliceblue">Server side and client side validation when adding new contact information</p>
</div>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <h5 style="color: aliceblue">Contact Database CRUD</h5>
</nav>
<div class="container" style="margin-top:30px">
    <div class="row justify-content-center align-items-center">
        <h2>Update contact information</h2>
        <h2>${contactExist}</h2>
        <div class="row " style="width: 80%">
            <form:form id="contactForm" action="/updateContact" modelAttribute="updateContact" cssClass="needs-validation" cssStyle="width: 100%" novalidate="novalidate">
                <form class="needs-validation" novalidate>
                    <div class="form-group">
                        <form:label path="formID">Contact ID</form:label>
                        <form:input path="formID" cssClass="form-control" readonly="true"/>
                    </div>
                    <div class="form-group">
                        <form:label path="name">Name</form:label>
                        <form:input path="name" cssClass="form-control" placeholder="Your full name" />
                        <div class="invalid-feedback" id="nameError" >
                            <form:errors path="name" element="div"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-8">
                            <form:label path="phoneNumber">Phone number</form:label>
                            <form:input path="phoneNumber" cssClass="form-control" placeholder="Your phone number" cssErrorClass="form-control is-invalid" />
                            <div class="invalid-feedback" id="phoneNumError">
                                <form:errors path="phoneNumber"  element="div"/>
                            </div>
                        </div>
                        <div class="col-4">
                            <form:label path="age">Age</form:label>
                            <form:input path="age" cssClass="form-control" placeholder="Your age" cssErrorClass="form-control is-invalid"/>
                            <div class="invalid-feedback" id="ageError">
                                <form:errors path="age" element="div"/>
                            </div>
                        </div>

                    </div>
                    <div class="form-group">
                        <form:label path="address">Address</form:label>
                        <form:input path="address" cssClass="form-control" placeholder="Your address" cssErrorClass="form-control is-invalid"/>
                        <div class="invalid-feedback" id="addressError">
                            <form:errors path="address" element="div"/>
                        </div>
                    </div>
                    <button class="btn btn-primary btn-block" type="submit" id="submitBtn" disabled>Submit form</button>
                </form>

            </form:form>
        </div>
    </div>
</div>


</body>
<script>
    setUpValidation();
    saveValue($('#name').val(), $('#address').val(),$('#phoneNumber').val(), $('#age').val(), '#submitBtn');
    $(document).ready(function () {
        checkForm('#contactForm')
    });
    onlyChange('#name','#address','#phoneNumber', '#age');
</script>
</html>