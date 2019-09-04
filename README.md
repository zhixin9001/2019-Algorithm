# Algorithm

# 避坑
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

# 计划 & 复核
## 8.30
年底前完成，距离年底还有4个月=120天
按页数算：共610页，8.30号在归并排序180页，剩余430页，平均每天至少需前进2.4页，这也是最少的量，因为练习题耗时很长，还有笔记
按章算：还有半个2章，3，4，5，最后6章很少，差不多3，4，5保证每月完成1章，2章和6章在1个月完成，要完成笔记和练习题
按节算：还有19节，平均1月需要完成5节，一周保证1.3节

进度计划：
    按页数：3页/天；
    按节：1.3节/周；
    按章：1章/月；


