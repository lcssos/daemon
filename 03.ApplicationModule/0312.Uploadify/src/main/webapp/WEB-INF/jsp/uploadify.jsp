<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <script src="<c:url value="/static/jquery/1.7.1/jquery.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/static/uploadify/jquery.uploadify.min.js" />" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/uploadify/uploadify.css" />">

    <style type="text/css">
        body {
            font: 13px Arial, Helvetica, Sans-serif;
        }
    </style>

</head>
<body>
    <h1>Uploadify Demo</h1>
    <form>
        <div id="queue"></div>
        <input id="file_upload" name="file_upload" type="file" multiple="true">
    </form>



    <script type="text/javascript">



        $(function() {
            $('#file_upload').uploadify(
                    {
                        'formData' : {
                            'timestamp' : '',
                            'token' : ''
                        },
                        'swf' : '<c:url value="/static/uploadify/uploadify.swf" />',
                        'uploader' : '<c:url value="/uploadify/" />'

                    });
        });
    </script>


</body>
</html>
