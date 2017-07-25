.svn 插件的安装：
将参考文档目录下的工具 eclipse插件 下的3个文件
 （第一个是老师提供的代码规范模版ftp上有相关的设置或者参考  
 ftp://192.168.21.26/  ( lxing abcd.1234  首先必须连在机房的网上里面有相关的参考文件)
  参考文档\Teacher\开发规范\规范代码配置文件） 
拷到eclipse安装目录下 重启即可
.tomacat配置：
在conf/tomcat-users.xml中 </tomcat-users>之前 加入
	<role rolename="admin-gui"/>  
    <role rolename="admin-script"/>
    <role rolename="manager-gui"/>
    <role rolename="manager-script"/>
    <role rolename="manager-jmx"/> 
    <role rolename="manager-status"/> 
    <user username="admin" password="admin" roles="manager-gui,manager-script,manager-jmx,manager-status,admin-script,admin-gui"/>
    
.maven 配置：
Maven的安装：  配置环境变量
		         更改仓库位置  conf/setting.xml  <localRepository>D:/mvn_repo/repository</localRepository>
   安装m2e插件：  Help/intall  workwith中加入 http://download.eclipse.org/technology/m2e/releases/
                                 下载m2e插件
                                  配置 window/preferences/maven
                                  installations 加入保存在本地的maven软件
                                  usersetings  加入本地maven下的setting.xml配置文件
                                  点击apply（应用）
           	
 
.运行：
      首先启动 tomacat
      工程右击   run as maven build： 第一次运行在Goals中输入  tomcat:deploy
  					     以后输入  tomcat:redeploy
     以后提交的时候 （右键工程  Team）首先 run as maven clear 下（或者不选择 编译文件） 否则会提交编译文件