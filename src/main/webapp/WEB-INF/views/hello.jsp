<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="ko">
<head>
    <title>Title</title>

</head>
<body>
<div class="inputArea">
    <label for="content">상품소개</label>
    <textarea rows="5" cols="50" id="content" name="content"></textarea>
</div>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/js/ckeditor/ckeditor.js"></script>
<script>
    var ckeditor_config = {
        resize_enaleb : false,
        enterMode : CKEDITOR.ENTER_BR,
        shiftEnterMode : CKEDITOR.ENTER_P,
        filebrowserUploadUrl : "/ckUpload"
    };

    CKEDITOR.replace("content", ckeditor_config);
</script>

</body>
</html>