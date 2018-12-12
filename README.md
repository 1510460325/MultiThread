# MultiThread
学习多线程的学习笔记
### 知识点
* CountDownLatch 闭锁：一个大门，当大门打开了，才能允许线程继续访问；
* CyclicBarrier 栅栏：等候线程全部到达才继续往下进行
* FutureTask 有返回值的线程，当调用结果的时候阻塞
* Semaphore 信号量，控制并发个数，获取相应的许可证之后线程才能往下执行
