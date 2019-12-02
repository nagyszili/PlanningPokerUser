package com.example.plannigpokeruser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ListVoteAdapter extends RecyclerView.Adapter<ListVoteAdapter.ViewHolder> {

    private Context context;
    private ArrayList<User> votedUsers = new ArrayList<>();

//    private String groupId;
//    private FirebaseDatabase database;
//    private DatabaseReference group;
//    private DatabaseReference dbFeatures;
//    private DatabaseReference activeFeature;
//    private FragmentManager fragmentManager;
//    private Feature aFeature;

    public ListVoteAdapter() {
    }


    public ListVoteAdapter(Context context, ArrayList<User> votedUsers) {
        this.context = context;
        this.votedUsers = votedUsers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_vote_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.userName.setText(votedUsers.get(position).getName());
        holder.voteValue.setText(votedUsers.get(position).getVotedValue());

    }

    @Override
    public int getItemCount() {
        return votedUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout parent;
        TextView userName;
        TextView voteValue;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.voteItemParent);
            userName = itemView.findViewById(R.id.userName);
            voteValue = itemView.findViewById(R.id.voteValue);
        }
    }
}
