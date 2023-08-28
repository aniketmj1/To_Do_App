package com.mooi.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.os.Bundle;

import com.mooi.todoapp.model.ToDoModel;
import com.mooi.todoapp.todoadapter.ToDoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView taskRview ;
    private ToDoAdapter taskAdapter;

    private List<ToDoModel> taskList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskRview = findViewById(R.id.taskRecyclerView);
        taskRview.setLayoutManager(new LinearLayoutManager(this));

        taskList = new ArrayList<>();
        taskAdapter = new ToDoAdapter(this);
        taskRview.setAdapter(taskAdapter);
        ToDoModel task = new ToDoModel();
        task.setTask("testing");

        task.setStatus(0);
        task.setId(1);

        taskList.add(task);
        taskList.add(task);
        taskList.add(task);
        taskList.add(task);

        taskAdapter.setTasks(taskList);


    }
}