# Algorithm

# tipas
## 编译
javac algs4\SortShell.java
java algs4.SortShell < ..\..\..\algs4-data\32Kints.txt
java命令用.而不是\

如果命令行执行报错 cannot find main class..
看看是不是CLASSPATH没有配置当前路径 .;

## eclipse
eclipse的输入输出重定向太难用，而且不同的版本功能有差异

eclipse程序执行后，中止按ctrl+Z

## RedirectionNotSupported
如果cmd包含重定向，运行报错RedirectionNotSupported，
可以使用cmd /c --% java algs4.SortInsertion < ..\..\..\algs4-data\8ints.txt
cmd, invokes cmd.exe, which knows what you mean by <
/c, tells cmd.exe to process one command following on the command lineand then exit.
--%, tells PowerShell to leave the rest of the command line alone, so that cmd.exe can deal with the < redirection.

##  unmappable character for encoding GBK
目前发现有的中文会这样，比如“你好啊”，但“试试”没有问题；尝试修改编码方式也没用，那么注释用英文吧

## git
git config --global http.sslVerify false



