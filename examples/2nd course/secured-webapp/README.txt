1. Перед запуском программы, в томкате необходимо добавить роли и пользователей - файл $TOMCAT_HOME/conf/tomcat-users.xml

Содержимое файла:

<?xml version='1.0' encoding='utf-8'?>
<tomcat-users>
    <role rolename="admin"/>
    <role rolename="user"/>

    <user username="a1" password="a1" roles="admin"/>
    <user username="u1" password="u1" roles="user"/>
    <user username="au1" password="au1" roles="admin,user"/>
</tomcat-users>


2. В демке используются API Servlets 3.x которые в Tomcat с версии 7.х

3. Для компиляции/запуска проекта необходимо подключить библиотеку $TOMCAT_HOME/lib/servlet-api.jar
