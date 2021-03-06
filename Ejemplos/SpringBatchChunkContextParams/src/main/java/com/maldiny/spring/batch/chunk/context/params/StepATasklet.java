package com.maldiny.spring.batch.chunk.context.params;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class StepATasklet implements Tasklet {

	String taskletName;
	
	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {

		System.out.println("Executing step with name " + taskletName);

		String param1 = "value1";
		MyObject myObject = new MyObject(1,"Persona 1", 10);
		System.out.println("[" + taskletName + "] add param: " + param1);
		System.out.println("[" + taskletName + "] add param: " + myObject);
		arg1.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put("param1", param1);
		arg1.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put("myObject", myObject);
		
		return RepeatStatus.FINISHED;
	}

	public String getTaskletName() {
		return taskletName;
	}

	public void setTaskletName(String taskletName) {
		this.taskletName = taskletName;
	}

}
