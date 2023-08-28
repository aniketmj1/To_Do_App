package com.mooi.todoapp.todoadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.mooi.todoapp.MainActivity;
import com.mooi.todoapp.R;
import com.mooi.todoapp.model.ToDoModel;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {
    private List<ToDoModel> todolist;
    private MainActivity activity;

    public ToDoAdapter(MainActivity activity){
        this.activity = activity;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()) .inflate(R.layout.activity_list_layout, parent, false);
        return new ViewHolder(itemView);


    }

    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        ToDoModel item = todolist.get(position);
        viewHolder.task.setText(item.getTask());
        viewHolder.task.setChecked(toBoolean(item.getStatus()));

    }

    @Override
    public int getItemCount() {
        return todolist.size();
    }

    private boolean toBoolean(int n){
        return n!=0;
    }

    public  void setTasks(List<ToDoModel> todoList){
        this.todolist =todoList;
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox task;
        ViewHolder(View view){
            super(view);
            task = view.findViewById(R.id.checkbox);
        }
    }
}
