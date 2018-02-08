package com.mars.android20180208_3;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends JobService {
    public MyService() {
    }
    /*
    让我们创建一个继承自JobService且名字为JobSchedulerService的类，
    这个类必须实现两个方法，分别是onStartJob(JobParameters params)和 onStopJob(JobParameters params)；
     */
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d("JOB", "This is onStartJob");
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {

        return false;
    }


}
