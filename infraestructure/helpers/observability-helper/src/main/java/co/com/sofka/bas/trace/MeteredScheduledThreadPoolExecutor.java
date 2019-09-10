package co.com.sofka.bas.trace;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class MeteredScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
    public MeteredScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize);
    }

}
