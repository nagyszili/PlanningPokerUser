package com.example.plannigpokeruser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

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
    public void onBindViewHolder(@NonNull VoteAdapter.ViewHolder holder, final int position) {

        holder.imageButton.setBackgroundResource(items.get(position));
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                voteValue = position;
//                Toast.makeText(context,"Card is clicked " + position, Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0: {
                        voteValue = "One";
                        Toast.makeText(context, "One", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 1: {
                        voteValue = "Two";
                        Toast.makeText(context, "Two", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 2: {
                        voteValue = "Three";
                        Toast.makeText(context, "Three", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 3: {
                        voteValue = "Five";
                        Toast.makeText(context, "Five", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 4: {
                        voteValue = "Seven";
                        Toast.makeText(context, "Seven", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 5: {
                        voteValue = "Three";
                        Toast.makeText(context, "Ten", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 6: {
                        voteValue = "Twenty";
                        Toast.makeText(context, "Twenty", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 7: {
                        voteValue = "Three";
                        Toast.makeText(context, "Fifty", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 8: {
                        voteValue = "One Hundred";
                        Toast.makeText(context, "One Hundred", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 9: {
                        voteValue = "?";
                        Toast.makeText(context, "?", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 10: {
                        voteValue = "Coffee Time!";
                        Toast.makeText(context, "Coffee Time!", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    default: {
                        voteValue = "";
//                        Toast.makeText(context, "Please click a value!", Toast.LENGTH_SHORT).show();
                    }
                }



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
