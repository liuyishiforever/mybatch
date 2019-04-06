　> Spring batch是用来处理大量数据操作的一个框架，主要用来读取大量数据，然后进行一定处理后输出成指定的形式。

Spring batch主要有以下部分组成：


| 关键类        | 描述    |
| --------   | :-----   |
| JobRepository|用来注册job的容器|
| JobLauncher| 用来启动Job的接口  |
| Job        | 实际执行的任务，包含一个或多个Step|   
| Step       | step包含ItemReader、ItemProcessor和ItemWriter  |   
| ItemReader |  用来读取数据的接口|  |   
| ItemProcessor  |  用来处理数据的接口|   
| ItemWriter     |  用来输出数据的接口|   

以上Spring Batch的主要组成部分只需要注册成Spring的Bean即可。若想开启批处理的支持还需在配置类上使用@EnableBatchProcessing，在Spring Batch中提供了大量的ItemReader和ItemWriter的实现，用来读取不同的数据来源，数据的处理和校验都要通过ItemProcessor接口实现来完成。


这个demo有4种常用的方式：
1. 读文件--处理--写入文件；
2. 读文件--处理--写入数据库；
3. 读数据库--处理--写入数据库；
4. 读数据库--处理--写入文件；

