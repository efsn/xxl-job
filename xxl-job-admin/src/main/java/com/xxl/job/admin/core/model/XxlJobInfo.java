package com.xxl.job.admin.core.model;

import com.xxl.job.admin.core.route.ExecutorRouteStrategyEnum;
import com.xxl.job.admin.core.scheduler.MisfireStrategyEnum;
import com.xxl.job.admin.core.scheduler.ScheduleTypeEnum;
import com.xxl.job.core.enums.ExecutorBlockStrategyEnum;

import java.util.Date;

/**
 * xxl-job info
 *
 * @author xuxueli  2016-1-12 18:25:49
 */
public class XxlJobInfo {

    private int id;                // 主键ID

    private int jobGroup;        // 执行器主键ID
    private String jobDesc;

    private Date addTime;
    private Date updateTime;

    private String author;        // 负责人
    private String alarmEmail;    // 报警邮件

    private String scheduleType;            // 调度类型
    private String scheduleConf;            // 调度配置，值含义取决于调度类型
    private String misfireStrategy;            // 调度过期策略

    private String executorRouteStrategy;    // 执行器路由策略
    private String executorHandler;            // 执行器，任务Handler名称
    private String executorParam;            // 执行器，任务参数
    private String executorBlockStrategy;    // 阻塞处理策略
    private int executorTimeout;            // 任务执行超时时间，单位秒
    private int executorFailRetryCount;        // 失败重试次数

    private String glueType;        // GLUE类型	#com.xxl.job.core.glue.GlueTypeEnum
    private String glueSource;        // GLUE源代码
    private String glueRemark;        // GLUE备注
    private Date glueUpdatetime;    // GLUE更新时间

    private String childJobId;        // 子任务ID，多个逗号分隔

    private int triggerStatus;        // 调度状态：0-停止，1-运行
    private long triggerLastTime;    // 上次调度时间
    private long triggerNextTime;    // 下次调度时间


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(int jobGroup) {
        if (jobGroup > 0) {
            this.jobGroup = jobGroup;
        }
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        if (null != jobDesc && jobDesc.trim().length() > 0) {
            this.jobDesc = jobDesc;
        }
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        if (null != addTime) {
            this.addTime = addTime;
        }
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        if (null != updateTime) {
            this.updateTime = updateTime;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (null != author && author.trim().length() > 0) {
            this.author = author;
        }
    }

    public String getAlarmEmail() {
        return alarmEmail;
    }

    public void setAlarmEmail(String alarmEmail) {
        if (null != alarmEmail && alarmEmail.trim().length() > 0) {
            this.alarmEmail = alarmEmail;
        }
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        if (ScheduleTypeEnum.match(scheduleType, null) != null) {
            this.scheduleType = scheduleType;
        }
    }

    public String getScheduleConf() {
        return scheduleConf;
    }

    public void setScheduleConf(String scheduleConf) {
        if (null != scheduleConf && scheduleConf.trim().length() > 0) {
            this.scheduleConf = scheduleConf;
        }
    }

    public String getMisfireStrategy() {
        return misfireStrategy;
    }

    public void setMisfireStrategy(String misfireStrategy) {
        if (MisfireStrategyEnum.match(misfireStrategy, null) != null) {
            this.misfireStrategy = misfireStrategy;
        }
    }

    public String getExecutorRouteStrategy() {
        return executorRouteStrategy;
    }

    public void setExecutorRouteStrategy(String executorRouteStrategy) {
        if (ExecutorRouteStrategyEnum.match(executorRouteStrategy, null) != null) {
            this.executorRouteStrategy = executorRouteStrategy;
        }
    }

    public String getExecutorHandler() {
        return executorHandler;
    }

    public void setExecutorHandler(String executorHandler) {
        if (null != executorHandler && executorHandler.trim().length() > 0) {
            this.executorHandler = executorHandler;
        }
    }

    public String getExecutorParam() {
        return executorParam;
    }

    public void setExecutorParam(String executorParam) {
        if (null != executorParam && executorParam.trim().length() > 0) {

            this.executorParam = executorParam;
        }
    }

    public String getExecutorBlockStrategy() {
        return executorBlockStrategy;
    }

    public void setExecutorBlockStrategy(String executorBlockStrategy) {
        if (ExecutorBlockStrategyEnum.match(executorBlockStrategy, null) != null) {
            this.executorBlockStrategy = executorBlockStrategy;
        }
    }

    public int getExecutorTimeout() {
        return executorTimeout;
    }

    public void setExecutorTimeout(int executorTimeout) {
        if (executorTimeout > 0) {
            this.executorTimeout = executorTimeout;
        }
    }

    public int getExecutorFailRetryCount() {
        return executorFailRetryCount;
    }

    public void setExecutorFailRetryCount(int executorFailRetryCount) {
        if (executorFailRetryCount > 0) {
            this.executorFailRetryCount = executorFailRetryCount;
        }
    }

    public String getGlueType() {
        return glueType;
    }

    public void setGlueType(String glueType) {
        if (null != glueType) {
            this.glueType = glueType;
        }
    }

    public String getGlueSource() {
        return glueSource;
    }

    public void setGlueSource(String glueSource) {
        if (null != glueSource) {
            this.glueSource = glueSource;
        }
    }

    public String getGlueRemark() {
        return glueRemark;
    }

    public void setGlueRemark(String glueRemark) {
        if (null != glueRemark) {
            this.glueRemark = glueRemark;
        }
    }

    public Date getGlueUpdatetime() {
        return glueUpdatetime;
    }

    public void setGlueUpdatetime(Date glueUpdatetime) {
        if (null != glueUpdatetime) {
            this.glueUpdatetime = glueUpdatetime;
        }
    }

    public String getChildJobId() {
        return childJobId;
    }

    public void setChildJobId(String childJobId) {
        if (null != childJobId && childJobId.trim().length() > 0) {
            this.childJobId = childJobId;
        }
    }

    public int getTriggerStatus() {
        return triggerStatus;
    }

    public void setTriggerStatus(int triggerStatus) {
        this.triggerStatus = triggerStatus;
    }

    public long getTriggerLastTime() {
        return triggerLastTime;
    }

    public void setTriggerLastTime(long triggerLastTime) {
        this.triggerLastTime = triggerLastTime;
    }

    public long getTriggerNextTime() {
        return triggerNextTime;
    }

    public void setTriggerNextTime(long triggerNextTime) {
        this.triggerNextTime = triggerNextTime;
    }

}
