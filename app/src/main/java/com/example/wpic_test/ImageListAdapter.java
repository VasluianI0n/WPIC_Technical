package com.example.wpic_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<ImageListElement> imageListElements;

    public ImageListAdapter(Context context, ArrayList<ImageListElement> imageListElements, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.imageListElements = imageListElements;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ImageListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.activity_view_image_element,parent,false);

        MyViewHolder viewHolder = new MyViewHolder(view,recyclerViewInterface);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListAdapter.MyViewHolder holder, int position) {
        if(imageListElements.get(position).getName().equals("image1")){
            holder.imageView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(convertDpToPixel(176,context),convertDpToPixel(312,context)));
            holder.imageView.setImageResource(R.drawable.premium_1);
        }else if(imageListElements.get(position).getName().equals("image2")){
            holder.imageView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(convertDpToPixel(175,context),convertDpToPixel(175,context)));
            holder.imageView.setImageResource(R.drawable.image_2);
        }else if(imageListElements.get(position).getName().equals("image3")){
            holder.imageView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(convertDpToPixel(175,context),convertDpToPixel(175,context)));
            holder.imageView.setImageResource(R.drawable.image_3);
        }else if(imageListElements.get(position).getName().equals("image4")){
            holder.imageView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(convertDpToPixel(176,context),convertDpToPixel(312,context)));
            holder.imageView.setImageResource(R.drawable.premium_4);
        }else if(imageListElements.get(position).getName().equals("image5")){
            holder.imageView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(convertDpToPixel(176,context),convertDpToPixel(312,context)));
            holder.imageView.setImageResource(R.drawable.premium_5);
        }else if(imageListElements.get(position).getName().equals("image6")){
            holder.imageView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(convertDpToPixel(175,context),convertDpToPixel(175,context)));
            holder.imageView.setImageResource(R.drawable.image_6);
        }else if(imageListElements.get(position).getName().equals("image7")){
            holder.imageView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(convertDpToPixel(175,context),convertDpToPixel(175,context)));
            holder.imageView.setImageResource(R.drawable.image_7);
        }else if(imageListElements.get(position).getName().equals("image8")){
            holder.imageView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(convertDpToPixel(175,context),convertDpToPixel(312,context)));
            holder.imageView.setImageResource(R.drawable.premium_8);
        }else if(imageListElements.get(position).getName().equals("image9")){
            holder.imageView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(convertDpToPixel(350, context),convertDpToPixel(190, context)));
            holder.imageView.setImageResource(R.drawable.test);
            StaggeredGridLayoutManager.LayoutParams sglp = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();;
            sglp.setFullSpan(true);
            holder.imageView.setLayoutParams(sglp);
        }

    }

    public int convertDpToPixel(float dp, Context context) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    @Override
    public int getItemCount() {
        return imageListElements.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_list_element);

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

