<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <link rel="stylesheet" type="text/css" href="<c:url value="/static/webuploader-0.1.5/webuploader.css" />">

    <script src="<c:url value="/static/jquery/1.7.1/jquery.min.js" />" type="text/javascript"></script>

    <script src="<c:url value="/static/webuploader-0.1.5/webuploader.js" />" type="text/javascript"></script>

    <script src="<c:url value="/static/md5.js"/>" type="text/javascript"></script>

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

        body {
            font: 13px Arial, Helvetica, Sans-serif;
        }
    </style>

</head>
<body>


<%--<div id="uploader">--%>
<%--<ul id="theList"></ul>--%>
<%--<div id="picker">选择文件</div>--%>
<%--</div>--%>

<div id="uploader" class="wu-example">
    <!--用来存放文件信息-->
    <div id="theList" class="uploader-list"></div>
    <div class="btns">
        <div id="picker">选择文件</div>
        <button id="ctlBtn" class="btn btn-default">开始上传</button>
    </div>
</div>


<script type="text/javascript">
    var data = {busiId: '134', md5: ''};
    var uniqueFileName = null;          //文件唯一标识符
    var chunkSize = 5000 * 1024;        //分块大小

    WebUploader.Uploader.register({
        "before-send-file": "beforeSendFile",
        "before-send": "beforeSend",
        "after-send-file": "afterSendFile"
    }, {
        beforeSendFile: function (file) {
            debugger;

            console.log('beforeSendFile');
            var task = new $.Deferred();
            var start = new Date().getTime();

            //1. 上传文件前,先检查md5是否已经存在,存在则不重复上传
            (new WebUploader.Uploader()).md5File(file, 0, 10 * 1024 * 1024).progress(function (percentage) {
                console.log('percentage:' + percentage);
            }).then(function (val) {
                console.log("总耗时: " + ((new Date().getTime()) - start) / 1000);
                data.md5 = val;
                console.log('md5Mark:' + val);
                $.ajax({
                    type: "POST"
                    , url: '<c:url value="/webupload2/md5Check" />'
                    , data: data
                    , cache: false
                    , timeout: 3000
                    , dataType: "json"
                }).then(function (data, textStatus, jqXHR) {
                    if(data.ifExist) {   //若存在，这返回失败给WebUploader，表明该文件不需要上传
                        task.reject();
                        uploader.skipFile(file);
                        file.path = data.path;
                        UploadComlate(file);
                    }else{
                        task.resolve();
                        //拿到上传文件的唯一名称，用于断点续传
                        uniqueFileName = md5(file.name+file.type+file.lastModifiedDate+file.size);
                    }
                }, function (jqXHR, textStatus, errorThrown) {    //任何形式的验证失败，都触发重新上传
                    task.resolve();
                    //拿到上传文件的唯一名称，用于断点续传
                    uniqueFileName = md5(file.name+file.type+file.lastModifiedDate+file.size);
                });
            })
            return $.when(task);

        },
        beforeSend: function (block) {
            console.log('beforeSend');
            //分片验证是否已传过，用于断点续传
            var task = new $.Deferred();
            $.ajax({
                type: "POST"
                , url: '<c:url value="/webupload2/chunkCheck" />'
                , data: {
                    uniqueName: uniqueFileName
                    , chunkIndex: block.chunk
                    , size: block.end - block.start
                }
                , cache: false
                , timeout: 3000 //todo 超时的话，只能认为该分片未上传过
                , dataType: "json"
            }).then(function(data, textStatus, jqXHR){
                if(data.ifExist){   //若存在，返回失败给WebUploader，表明该分块不需要上传
                    task.reject();
                }else{
                    task.resolve();
                }
            }, function(jqXHR, textStatus, errorThrown){    //任何形式的验证失败，都触发重新上传
                task.resolve();
            });
            return $.when(task);

        },
        afterSendFile: function (file) {
            console.log('afterSendFile');
            var chunksTotal = 0;
            if((chunksTotal = Math.ceil(file.size/chunkSize)) > 1){
                //合并请求
                var task = new $.Deferred();
                $.ajax({
                    type: "POST"
                    , url: '<c:url value="/webupload2/chunksMerge" />'
                    , data: {
                        uniqueName: uniqueFileName
                        , chunks: chunksTotal
                        , ext: file.ext
                        , md5: data.md5
                    }
                    , cache: false
                    , dataType: "json"
                }).then(function(data, textStatus, jqXHR){
                    //todo 检查响应是否正常
                    task.resolve();
                    file.path = data.path;
                    UploadComlate(file);

                }, function(jqXHR, textStatus, errorThrown){
                    task.reject();
                });
                return $.when(task);
            }else{
                UploadComlate(file);
            }

        }
    });


    $(function () {
        <%--var uploader = WebUploader.create({--%>
        <%--swf: "<c:url value="/static/webuploader-0.1.5/Uploader.swf" />"--%>
        <%--, server: <c:url value="/webupload2/"/>--%>
        <%--, pick: "#picker"--%>
        <%--, resize: false--%>
        <%--// [可选] [默认值：undefined] 指定Drag And Drop拖拽的容器，如果不指定，则不启动。--%>
        <%--//            , dnd: "#theList"--%>
        <%--// [可选] [默认值：undefined] 指定监听paste事件的容器，如果不指定，不启用此功能。此功能为通过粘贴来添加截屏的图片。建议设置为document.body.--%>
        <%--//            , paste: document.body--%>
        <%--//[可选] [默认值：false] 是否禁掉整个页面的拖拽功能，如果不禁用，图片拖进来的时候会默认被浏览器打开。--%>
        <%--//            , disableGlobalDnd: true--%>
        <%--//[可选] 配置生成缩略图的选项。--%>
        <%--//            , thumb: {--%>
        <%--//                width: 100--%>
        <%--//                , height: 100--%>
        <%--//                // 图片质量，只有type为`image/jpeg`的时候才有效。--%>
        <%--//                , quality: 70--%>
        <%--//                // 是否允许放大，如果想要生成小图的时候不失真，此选项应该设置为false.--%>
        <%--//                , allowMagnify: true--%>
        <%--//                // 是否允许裁剪。--%>
        <%--//                , crop: true--%>
        <%--//            }--%>
        <%--// [可选] 配置压缩的图片的选项。如果此选项为false, 则图片在上传前不进行压缩。--%>
        <%--//            , compress: false--%>
        <%--//[可选] [默认值：false] 是否允许在文件传输时提前把下一个文件准备好。 对于一个文件的准备工作比较耗时，比如图片压缩，md5序列化。 如果能提前在当前文件传输期处理，可以节省总体耗时。--%>
        <%--//            , prepareNextFile: true--%>
        <%--//[可选] [默认值：false] 是否要分片处理大文件上传。--%>
        <%--, chunked: true--%>
        <%--//        , chunkSize: chunkSize--%>
        <%--//        , threads: true--%>
        <%--//            , formData: function () {--%>
        <%--//                return $.extend(true, {}, data);--%>
        <%--//            }--%>
        <%--//[可选] [默认值：undefined] 验证文件总数量, 超出则不允许加入队列。--%>
        <%--//            , fileNumLimit: 1--%>
        <%--//[可选] [默认值：undefined] 验证单个文件大小是否超出限制, 超出则不允许加入队列。--%>
        <%--//            , fileSingleSizeLimit: 1000 * 1024 * 1024--%>
        <%--// [可选] [默认值：undefined] 去重， 根据文件名字、文件大小和最后修改时间来生成hash Key.--%>
        <%--//            , duplicate: true--%>
        <%--});--%>

        var uploader = WebUploader.create({
            // 不压缩image
            resize: false,
            // swf文件路径
            swf: '<c:url value="/static/webuploader-0.1.5/Uploader.swf" />',
            // 文件接收服务端。
            server: '<c:url value="/webupload2/upload"/>',
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker',
            // 开起分片上传。
            chunked: true
            , chunkSize: chunkSize
            // [可选] [默认值：undefined] 指定Drag And Drop拖拽的容器，如果不指定，则不启动。
            , dnd: "#theList"
            , paste: document.body
            , disableGlobalDnd: true
            //[可选] 配置生成缩略图的选项。
            , thumb: {
                width: 100
                , height: 100
                // 图片质量，只有type为`image/jpeg`的时候才有效。
                , quality: 70
                // 是否允许放大，如果想要生成小图的时候不失真，此选项应该设置为false.
                , allowMagnify: true
                // 是否允许裁剪。
                , crop: true
            }
            , compress: false
            , prepareNextFile: true
            , formData: data
            , duplicate: true
        });


        //当文件被加入队列以后触发。
        uploader.on("fileQueued", function (file) {

            console.log('fileQueued');

            $("#theList").append('<li id="' + file.id + '">' +
                    '<img /><span>' + file.name + '</span><span class="itemUpload">上传</span><span class="itemStop">暂停</span><span class="itemDel">删除</span>' +
                    '<div class="percentage"></div>' +
                    '</li>');

            var $img = $("#" + file.id + ' img');

            //生成预览图
            uploader.makeThumb(file, function (error, src) {
                if (error) {
                    $img.replaceWith("<span>不能预览</span>");
                }
                $img.attr("src", src);
            });

        });


        $("#theList").on("click", ".itemUpload", function () {
            uploader.upload();
            //"上传"-->"暂停"
            $(this).hide();
            $(".itemStop").show();
        });

        $("#theList").on("click", ".itemStop", function () {
            uploader.stop(true);
            //"暂停"-->"上传"
            $(this).hide();
            $(".itemUpload").show();
        });

        //todo 如果要删除的文件正在上传（包括暂停），则需要发送给后端一个请求用来清除服务器端的缓存文件
        $("#theList").on("click", ".itemDel", function () {
            uploader.removeFile($(this).parent().attr("id"));	//从上传文件列表中删除
            $(this).parent().remove();	//从上传列表dom中删除
        });

        uploader.on("uploadProgress", function (file, percentage) {
            $("#" + file.id + " .percentage").text(percentage * 100 + "%");
        });

    });


    function UploadComlate(file) {
        console.log(file);

        $("#" + file.id + " .percentage").text("上传完毕");
        $(".itemStop").hide();
        $(".itemUpload").hide();
        $(".itemDel").hide();
    }


</script>
</body>
</html>
