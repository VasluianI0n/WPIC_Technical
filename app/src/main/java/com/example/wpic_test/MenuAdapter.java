package com.example.wpic_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<MenuListElement> menuListElements;

    public MenuAdapter(Context context, ArrayList<MenuListElement> menuListElements, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.menuListElements = menuListElements;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MenuAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.activity_view_menu_element,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view,recyclerViewInterface);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MyViewHolder holder, int position) {
        holder.name.setText(menuListElements.get(position).getName());
        if(menuListElements.get(position).getName().equals("Single Frames")){
            holder.imageView.setImageResource(R.drawable.single);
        }else if(menuListElements.get(position).getName().equals("Double Frames")){
            holder.imageView.setImageResource(R.drawable.double_frame);
        }else if(menuListElements.get(position).getName().equals("Triple Frames")){
            holder.imageView.setImageResource(R.drawable.triple);
        }else if(menuListElements.get(position).getName().equals("Collage")){
            holder.imageView.setImageResource(R.drawable.collage);
        }else if(menuListElements.get(position).getName().equals("Photo Edit")){
            holder.imageView.setImageResource(R.drawable.photo_edit);
        }else if(menuListElements.get(position).getName().equals("Add Text")){
            holder.imageView.setImageResource(R.drawable.add_text);
        }

    }

    @Override
    public int getItemCount() {
        return menuListElements.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.menuImage);
            name = itemView.findViewById(R.id.menuText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
