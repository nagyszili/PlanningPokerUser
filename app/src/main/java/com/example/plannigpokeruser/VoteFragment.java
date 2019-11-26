package com.example.plannigpokeruser;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VoteFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    public VoteAdapter adapter;
    private ArrayList<Integer> numbers = new ArrayList<>();
    private TextView featureText;
    private Button voteButton;
    public Context context;
    public String voteValue;
    private DatabaseReference group;
    private DatabaseReference activeFeature;
    private String userName;
    private boolean active;
    private User user;

    private Feature aFeature;

    public VoteFragment() {
    }

    public VoteFragment(Context context) {
        this.context = context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        addNumbers();
        final View view = inflater.inflate(R.layout.vote_fragment_layout, container, false);
        featureText = view.findViewById(R.id.featureName);
        voteButton = view.findViewById(R.id.voteButton);


        Bundle args = getArguments();
        userName = args != null ? args.getString("userName") : null;
        final String groupId = args != null ? args.getString("groupId") : null;

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        group = database.getReference("groups/" + groupId);
        activeFeature = group.child("activeFeature");

        activeFeature.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                aFeature = dataSnapshot.getValue(Feature.class);
                if (aFeature != null) {
                    featureText.setText(aFeature.getName());
                    active = true;

                } else {
                    featureText.setText("No Active Feature!");
                    active = false;

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        voteButton.setOnClickListener(this);

        recyclerView = view.findViewById(R.id.gridRecyclerView);
        adapter = new VoteAdapter(getContext(), numbers);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void addNumbers() {

        numbers.add(R.drawable.ic_one);
        numbers.add(R.drawable.ic_two);
        numbers.add(R.drawable.ic_three);
        numbers.add(R.drawable.ic_five);
        numbers.add(R.drawable.ic_seven);
        numbers.add(R.drawable.ic_ten);
        numbers.add(R.drawable.ic_twenty);
        numbers.add(R.drawable.ic_fifty);
        numbers.add(R.drawable.ic_one_hundred);
        numbers.add(R.drawable.ic_question);
        numbers.add(R.drawable.ic_coffee_cup);


    }



    @Override
    public void onClick(View view) {
        voteValue = adapter.getVoteValue();
        if (voteValue.isEmpty()) {
            Toast.makeText(context, "Please click a value!", Toast.LENGTH_SHORT).show();

        } else {
            this.user = new User();
            user.setVotedValue(voteValue);
            user.setName(userName);

            if (active)
            {
                activeFeature.child("usersVoted").child(String.valueOf(user.getId())).setValue(user);
                int id = aFeature.getId();
                group.child("features").child(String.valueOf(id)).child("usersVoted").child(String.valueOf(user.getId())).setValue(user);
            }

////            activeFeature.addListenerForSingleValueEvent(new ValueEventListener() {
////                @Override
////                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                    aFeature = dataSnapshot.getValue(Feature.class);
////
////                    if (aFeature != null) {
////                        Toast.makeText(context, "addVotedUser!", Toast.LENGTH_SHORT).show();
////
//////                        aFeature.addVotedUser(user);
//////                        activeFeature.setValue(aFeature);
////                        activeFeature.child("usersVoted").child(String.valueOf(user.getId())).setValue(user);
////                    }
////                    else{
////                        Toast.makeText(context, "Not addVotedUser!", Toast.LENGTH_SHORT).show();
////
////                    }
////                }
////
////                @Override
////                public void onCancelled(@NonNull DatabaseError databaseError) {
////                    Toast.makeText(context, "Database Error!", Toast.LENGTH_SHORT).show();
////
////                }
////            });





        }


    }



}
