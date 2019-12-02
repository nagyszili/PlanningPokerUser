package com.example.plannigpokeruser;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;

public class VoteAdapter extends RecyclerView.Adapter<VoteAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Integer> items;
    private String voteValue = "";

    public VoteAdapter() {
    }

    public VoteAdapter(Context context, ArrayList<Integer> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public VoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final VoteAdapter.ViewHolder holder, final int position) {


        holder.imageButton.setBackgroundResource(items.get(position));



        PushDownAnim.setPushDownAnimTo( holder.imageButton ).setScale(PushDownAnim.MODE_STATIC_DP, 8);


        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                switch (position) {
                    case 0: {
                        voteValue = "One";
                        break;
                    }
                    case 1: {
                        voteValue = "Two";
                        break;
                    }
                    case 2: {
                        voteValue = "Three";
                        break;
                    }
                    case 3: {
                        voteValue = "Five";
                        break;
                    }
                    case 4: {
                        voteValue = "Seven";
                        break;
                    }
                    case 5: {
                        voteValue = "Ten";
                        break;
                    }
                    case 6: {
                        voteValue = "Twenty";
                        break;
                    }
                    case 7: {
                        voteValue = "Fifty";
                        break;
                    }
                    case 8: {
                        voteValue = "One Hundred";
                        break;
                    }
                    case 9: {
                        voteValue = "?";
                        break;
                    }
                    case 10: {
                        voteValue = "Coffee Time!";
                        break;
                    }
                    default: {
                        voteValue = "";
//                        Toast.makeText(context, "Please click a value!", Toast.LENGTH_SHORT).show();
                    }
                }


                        Toast.makeText(context, voteValue, Toast.LENGTH_SHORT).show();


            }
        });

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public String getVoteValue() {
        return voteValue;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageButton imageButton;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageButton = itemView.findViewById(R.id.cardImageButton);
            parentLayout = itemView.findViewById(R.id.parentLayout);

        }
    }
}
