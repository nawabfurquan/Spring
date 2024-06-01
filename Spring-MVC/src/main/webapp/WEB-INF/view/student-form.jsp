<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Student Form</title>
        <style>
            .error {color: red}
        </style>
    </head>
    <body>
        <form:form action="/student/processForm" modelAttribute="student">
           First Name: <form:input path="firstName" />
           <br><br>
           Last Name (*): <form:input path="lastName" />
           <form:errors path="lastName" cssClass="error" />
            <br><br>
            Nationality:
            <form:select path="nationality">
                <form:options items="${student.countryList}" />
            </form:select>
            <br><br>
            Postal Code: <form:input path="postalCode" />
            <form:errors path="postalCode" cssClass="error" />
            <br><br>
            Backlogs (0-10): <form:input path="backlogs" />
            <form:errors path="backlogs" cssClass="error" />
            <br><br>
            Course Code: <form:input path="courseCode" />
            <form:errors path="courseCode" cssClass="error" />
            <br><br>
            Favorite Language:
            <!--Radio Button-->
            <form:radiobutton path="favoriteLanguage" value="JAVA" /> JAVA
            <form:radiobutton path="favoriteLanguage" value="C++" /> C++
            <form:radiobutton path="favoriteLanguage" value="Python" /> Python
            <form:radiobutton path="favoriteLanguage" value="C#" /> C#
            <form:radiobutton path="favoriteLanguage" value="Javascript" /> Javascript
            <br><br>
            <!--Checkbox-->
            <form:checkbox path="operatingSystem" value="Linux" /> Linux
            <form:checkbox path="operatingSystem" value="Windows" /> Windows
            <form:checkbox path="operatingSystem" value="MacOS" /> MacOS
            <br><br>
            <input type="submit" value="Submit" />
        </form:form>
    </body>
</html>
