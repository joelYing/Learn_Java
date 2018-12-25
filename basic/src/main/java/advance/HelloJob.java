package advance;

import org.quartz.*;

/**
 * @PackageName advance
 * @Author joel
 * @Date 2018/12/25 16:59
 **/
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail detail = jobExecutionContext.getJobDetail();
        JobKey key = detail.getKey();

        int id = detail.getJobDataMap().getInt("id");
        String name = detail.getJobDataMap().getString("name");
        System.out.println("Job " + key + ", id: " + id + ", name: " + name);
    }
}
