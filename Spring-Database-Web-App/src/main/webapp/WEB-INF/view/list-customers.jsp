<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Customers List</title>
        <style><%@include file="/resources/css/style.css"%></style>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h2>CRM - Customer Relationship Manager</h2>
            </div>
            <div id="container">
                <div id="content">
                    <input type="button" value="Add Customer"
                        onclick="window.location.href='showFormForAdd'; return false;"
                        class="add-button"
                    />
                    <br><br>
                    <table>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="tempCustomer" items="${customers}">
                            <c:url var="updateLink" value="/customer/showFormForUpdate">
								<c:param name="customerId" value="${tempCustomer.id}" />
                            </c:url>
                            <c:url var="deleteLink" value="/customer/delete">
								<c:param name="customerId" value="${tempCustomer.id}" />
                            </c:url>
                            <tr>
                                <td>${tempCustomer.firstName}</td>
                                <td>${tempCustomer.lastName}</td>
                                <td>${tempCustomer.email}</td>
                                <td>
                                    <a href="${updateLink}">Update</a>
                                    |
                                    <a href="${deleteLink}"
                                      onclick="if (!(confirm('Are you sure you want to delete the customer?'))) return false"
                                    >
                                      Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>