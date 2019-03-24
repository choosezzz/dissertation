window.onload = function () {

    var imgradio = document.getElementById("img");
    var videoradio = document.getElementById("video");
    imgradio.onclick = function () {
        document.getElementById("img-div").className = "active";
        document.getElementById("video-div").className = "hidden";
    }
    videoradio.onclick = function () {
        document.getElementById("video-div").className = "active";
        document.getElementById("img-div").className = "hidden";
    }
    var imgFile = document.getElementById("file-image");
    imgFile.onchange = function (event) {
        var files = event.target.files,
            file;
        if (files && files.length > 0) {
            // 获取目前上传的文件
            file = files[0];
            if (file.size > 0) {
                // 生成文件的虚拟url
                var imgurl = window.URL.createObjectURL(file);
                document.getElementById("img-show").src = imgurl;
            }
        }
    }

    var videoFile = document.getElementById("file-video");
    videoFile.onchange = function () {
        var video = this.files[0];
        if (video && video.size > 0) {
            var url = window.URL.createObjectURL(video);
            document.getElementById("aa").src = url;
        }
    }

    var imgForm = document.getElementById("img-form");
    var imgBtn = document.getElementById("img-btn");
    imgBtn.onclick = function () {

        var file = document.getElementById("file-image").files[0];
        if (file) {
            var form = new FormData();
            form.append("file", file);
            var xhr = null; //得到xhr对象
            if (XMLHttpRequest) {
                xhr = new XMLHttpRequest();
            } else {
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xhr.open("POST", "../image/upload/spot", true);

            var waitDiv= document.getElementById("wait-div");
                waitDiv.className = "active";
                var waitSpan= document.getElementById("wait-span");
                var time=setInterval(function () {
                    waitSpan.innerText = waitSpan.innerText == "..." ? "......":"...";
                },1000);
            xhr.onload = function () {

                window.clearTimeout(time);
                var waitDiv= document.getElementById("wait-div");
                waitDiv.className = "hidden";

                var data = xhr.responseText;   //得到返回值
                data = JSON.parse(data);
                if (data.code == 200) {
                    document.getElementById("img-result").hidden = false;
                    document.getElementById("img-result").src = data.data;
                    return;
                } else {
                    alert(data.msg);
                    return;
                }
            }
            xhr.send(form);
        }
    }
}