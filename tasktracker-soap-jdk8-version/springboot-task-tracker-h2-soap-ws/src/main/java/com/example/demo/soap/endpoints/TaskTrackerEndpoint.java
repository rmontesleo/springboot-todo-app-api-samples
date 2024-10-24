package com.example.demo.soap.endpoints;

import com.example.demo.soap.models.Task;
import com.example.demo.soap.services.TaskService;

import com.example.demo.soap.ws.components.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
@AllArgsConstructor
@Slf4j
public class TaskTrackerEndpoint {

    private  static final String NAMESPACE ="http://www.soap.demo.example.com/api/taskTracker";

    private final TaskService taskService;


    @PayloadRoot( namespace = NAMESPACE, localPart = "getAllTasksRequest")
    @ResponsePayload
    public GetAllTasksResponse getAllTask(@RequestPayload GetAllTasksRequest request) {

        //request.isStatus()

        List<TaskInfo> taskInfoList =
                taskService.getAllTask().stream()
                    .map( currentTask ->{
                        TaskInfo taskInfo = new TaskInfo();
                        log.debug( "taskInfo is "+ taskInfo  );
                        BeanUtils.copyProperties( currentTask, taskInfo );
                        return  taskInfo;
                    }).collect( Collectors.toList() );

        GetAllTasksResponse response = new GetAllTasksResponse();
        TaskList taskList = new TaskList();
        taskList.getTask().addAll( taskInfoList );
        response.setTaskList( taskList );
        response.setServiceStatus(200);

        return response;
    }




    @PayloadRoot( namespace = NAMESPACE, localPart = "addTaskRequest" )
    @ResponsePayload
    public AddTaskResponse postNewTask(@RequestPayload AddTaskRequest  request ){
        Task task = new Task();
        BeanUtils.copyProperties( request, task );

        taskService.saveTask( task );
        TaskInfo newInfo = new TaskInfo();
        BeanUtils.copyProperties( task, newInfo );
        AddTaskResponse response = new AddTaskResponse();
        response.setServiceStatus( 201 );
        response.setNewTask( newInfo );

        return  response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getTaskByIdRequest")
    @ResponsePayload
    public GetTaskByIdResponse findTaskById( @RequestPayload GetTaskByIdRequest request ){

        GetTaskByIdResponse response = new GetTaskByIdResponse();

        return taskService.findTaskById( request.getTaskId()  )
                .map( task -> {
                    response.setServiceStatus(200);
                    TaskInfo info = new TaskInfo();
                    BeanUtils.copyProperties( task, info );
                    response.setTaskInfo( info );
                    return  response;
                })
                .orElseGet(  ()-> {
                    response.setServiceStatus(404);
                    return response;
                } );
    }

    @PayloadRoot( namespace = NAMESPACE, localPart = "deleteTaskRequest" )
    @ResponsePayload
    public DeleteTaskResponse deleteTask ( @RequestPayload DeleteTaskRequest request){
        DeleteTaskResponse response = new DeleteTaskResponse();

        if(taskService.deleteTask(  request.getTaskId() ) ){
            response.setServiceStatus( 200 );
        }
        response.setServiceStatus(404 );
        return response;
    }

    @PayloadRoot( namespace =  NAMESPACE, localPart = "updateTaskRequest" )
    @ResponsePayload
    public UpdateTaskResponse updateTask ( @RequestPayload UpdateTaskRequest request ){
        UpdateTaskResponse response = new UpdateTaskResponse();

        Task task = new Task();
        BeanUtils.copyProperties(  request.getTaskInfo(), task );

        return taskService.updateTask( request.getTaskInfo().getId(), task )
                .map( updated -> {
                    TaskInfo info = new TaskInfo();
                    BeanUtils.copyProperties( updated, info );
                    response.setServiceStatus(200);
                    response.setUpdatedTask(info);
                    return  response;
                })
                .orElseGet(  ()-> {
                    response.setServiceStatus(404);
                    return  response;
                });
    }

}
