package net.huray.lgssc.batch.sample.dynamic;

import lombok.Data;

@Data
public class TaskDefinition {
    private String cronExpression;
    private String actionType;
    private String data;
}
