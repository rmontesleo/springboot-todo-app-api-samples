package com.example.demo.soap.client;

import com.example.demo.soap.client.generated.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit test for Soap Client.
 */
public class AppTest {

    private static TaskTrackerPort  servicePort;

    @BeforeAll
    public static void setup(){

        URL url = null;
        try {
            url = new URL("http://localhost:9090/ws/taskTracker.wsdl");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        TaskTrackerPortService taskService = new TaskTrackerPortService( url );

        servicePort  = taskService.getTaskTrackerPortSoap11();
        System.out.println( "taskService "   );
        System.out.println( "servicePort "  );
    }


    @Test
    public void verifyGetTaskByIdOneStatusIs200(){
        GetTaskByIdRequest request = new GetTaskByIdRequest();
        request.setTaskId(1L);
        GetTaskByIdResponse response =  servicePort.getTaskById( request );

        Assertions.assertEquals(200, response.getServiceStatus() );
    }

    @Test
    public void verifyGetTaskByIdOneGeItnfo(){
        GetTaskByIdRequest request = new GetTaskByIdRequest();
        request.setTaskId(1L);
        GetTaskByIdResponse response =  servicePort.getTaskById( request );

        Assertions.assertNotNull( response );
        Assertions.assertNotNull( response.getTaskInfo() );
    }

    @Test
    public void verifyAddNewTaskIsSuccessful(){
        AddTaskRequest request = new AddTaskRequest();
        request.setText( "Unit Testing Client Request" );
        request.setDay( "Today" );
        request.setReminder(true);
        AddTaskResponse response = servicePort.addTask( request  );

        Assertions.assertNotNull( response );
        Assertions.assertNotNull( response.getNewTask() );
        Assertions.assertEquals( 201, response.getServiceStatus() );
    }



    @Test
    public void verifyGetAllTaskHasData(){
        GetAllTasksRequest request = new GetAllTasksRequest();
        request.setStatus( true );
        GetAllTasksResponse response = servicePort.getAllTasks( request );

        Assertions.assertNotNull( response );
        Assertions.assertNotNull( response.getTaskList() );
        Assertions.assertNotNull( response.getTaskList().getTask() );
        Assertions.assertEquals( 200, response.getServiceStatus() );

    }





}
