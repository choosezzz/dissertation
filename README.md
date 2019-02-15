# dissertation
毕业论文--丁双恩

#2018-12-27
添加毕业设计开题报告文件

#2019-02-14
增加python文件调用，python文件在python目录下，在使用时需要修改yolo.py文件的23,24,25，129行的文件路径
在model_data/目录下yolo.h5太大无法上传，可以下载权重文件https://pjreddie.com/media/files/yolov3.weight
通过convert.py文件进行转换，命令：python convert.py yolov3.cfg yolov3.weights model_data/yolo.h5（注意文件路径）

前端上传文件最终识别结果默认保存到当前工程下的/target/classes/static/yolo-out/image/或者/target/classes/static/yolo-out/video
路径下，static静态文件可以直接通过前端访问，不需要修改访问路径

