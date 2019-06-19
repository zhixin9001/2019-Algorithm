# Algorithm

# 避坑
javac algs4\SortShell.java
java algs4.SortShell < ..\..\..\algs4-data\32Kints.txt
java命令用.而不是\

如果命令行执行报错 cannot find main class..
看看是不是CLASSPATH没有配置当前路径 .;

eclipse的输入输出重定向太难用，而且不同的版本功能有差异

eclipse程序执行后，中止按ctrl+Z