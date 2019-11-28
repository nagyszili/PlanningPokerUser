package com.example.plannigpokeruser;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginFragment extends Fragment implements View.OnClickListener {


    private EditText userNameEditText;
    private EditText groupIdEditText;
    private Button joinBtn;
    private Context context;

    public LoginFragment() {
    }

    public LoginFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.login_fragment_layout, container, false);
        userNameEditText = view.findViewById(R.id.userName);
        groupIdEditText = view.findViewById(R.id.groupId);
        joinBtn = view.findViewById(R.id.joinBtn);

        joinBtn.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {

        final String groupId = groupIdEditText.getText().toString();
        final String userName = userNameEditText.getText().toString();

        if (!groupId.isEmpty() && !userName.isEmpty()) {

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference groups = database.getReference("groups");

            groups.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.child(groupId).exists())
                    {
                        strVoteFragment(userName,groupId);
                    } else {
//                        Toast.makeText(getContext(), "This group is not created!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), "This group does not exist!", Toast.LENGTH_SHORT).show();


                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });



        }


    }

    private void strVoteFragment(String userName, String groupId) {
        Bundle bundle = new Bundle();
//        bundle.putString("userName", userName);
        bundle.putString("groupId", groupId);
        User user = new User();
        user.setName(userName);
//        bundle.putBundle("user",user);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        VoteFragment voteFragment = new VoteFragment(context,user);
        voteFragment.setArguments(bundle);
        transaction.replace(R.id.container, voteFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
