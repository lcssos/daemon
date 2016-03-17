<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <link rel="stylesheet" type="text/css" href="<c:url value="/static/webuploader-0.1.5/webuploader.css" />">

    <script src="<c:url value="/static/jquery/1.7.1/jquery.min.js" />" type="text/javascript"></script>

    <script src="<c:url value="/static/webuploader-0.1.5/webuploader.js" />" type="text/javascript"></script>

    <script src="<c:url value="/static/md5.js"/>" type="text/javascript"/>

    <style type="text/css">
        .itemDel, .itemStop, .itemUpload {
            margin-left: 15px;
            color: blue;
            cursor: pointer;
        }

        #theList {
            width: 80%;
            min-height: 100px;
            border: 1px solid red;
        }

        #theList .itemStop {
            display: none;
        }
    </style>

</head>
<body>

<div id="uploader">
    <ul id="theList"></ul>
    <div id="picker">选择文件</div>
</div>


<script type="text/javascript">
    var data = {busiId:'134',md5:''};

    WebUploader.Uploader.register({
        "before-send-file": "beforeSendFile",
        "before-send": "beforeSend",
        "after-send-file": "afterSendFile"
    },{
        beforeSendFile: function(file){

        },
        beforeSend: function(block){

        },
        afterSendFile: function(file){

        }
    });
</script>
</body>
</html>
