<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Customer</title>
        <style><%@include file="/resources/css/style.css"%></style>
        <style><%@include file="/resources/css/add-customer-style.css"%></style>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h2>CRM - Customer Relationship Manager</h2>
            </div>
            <div id="container">
                    <h2>Save Customer</h2>
                    <form:form action="saveCustomer" modelAttribute="customer" method="POST" >
                    <form:hidden path="id" />
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                    <label>First Name: </label>
                                </td>
                                <td>
                                    <form:input path="firstName" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Last Name: </label>
                                </td>
                                <td>
                                    <form:input path="lastName" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Email: </label>
                                </td>
                                <td>
                                    <form:input path="email" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label></label>
                                </td>
                                <td>
                                    <input type="submit" value="Save" class="save" />
                                </td>
                            </tr>
                    </tbody>
                    </table>

                    </form:form>
                    <div style="clear; both;">
                        <p>
                            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
                        </p?
                    </div>
            </div>
        </div>
    </body>
</html>