package tk.jinhao.jhlibrary.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shanks on 15/6/8.
 */
public class ThreadManager {
    private ExecutorService es;

//    初始创建一个线程池里面包含10个线程
    public ThreadManager() {
        this.es = Executors.newFixedThreadPool(10);
    }

    static class Instance{
        static ThreadManager threadManager = new ThreadManager();
    }

    public static ThreadManager getInstace(){
        return Instance.threadManager;
    }

    /*
    * 执行线程池
    * */
    public void exe(Runnable runnable){
        es.execute(runnable);
    }

}
