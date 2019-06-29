package com.atiqrs.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {

    Context context;
    String[] name;
    String[] email;
    int[] img;

    public MyAdapter(Context context,String[] name,String[] email,int[] img) {
        this.context = context;
        this.name = name;
        this.email = email;
        this.img = img;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_item_layout,viewGroup,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder myViewholder, int i) {
        myViewholder.Icon.setImageResource(img[i]);
        myViewholder.Name.setText(name[i]);
        myViewholder.Email.setText(email[i]);
        myViewholder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class MyViewholder extends RecyclerView.ViewHolder{

        ImageView Icon;
        TextView Name;
        TextView Email;
        LinearLayout linearLayout;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            Icon = itemView.findViewById(R.id.imageIcon);
            Name = itemView.findViewById(R.id.Txtname);
            Email = itemView.findViewById(R.id.Txtemail);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
