package com.example.searchworkerapp;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.orhanobut.dialogplus.ViewHolder;

public class RecordsAdapter extends FirebaseRecyclerAdapter<Users,RecordsAdapter.RecordViewHolder> {

    Context context;

    public RecordsAdapter(@NonNull FirebaseRecyclerOptions<Users> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull RecordsAdapter.RecordViewHolder holder, int position, @NonNull Users model) {

        holder.etlistname.setText(model.getName());
        holder.etlistfname.setText(model.getFname());
        holder.etlistdob.setText(model.getDob());
        holder.etlistcontact.setText(model.getContact());
        holder.etlistaddress.setText(model.getAddress());
        holder.etlistemail.setText(model.getEmail());
        holder.etlistpassword.setText(model.getPassword());
        holder.etlistedu.setText(model.getEdu());
        holder.etlistprojects.setText(model.getProjects());
        holder.etlistresearch.setText(model.getResearch());
        holder.etlistskill.setText(model.getSkill());

        holder.btnlistedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogPlus dialog = DialogPlus.newDialog(context)
                        .setContentHolder(new ViewHolder(R.layout.content))
                        .setGravity(Gravity.CENTER)
                        .setMargin(10,0,10,0)
                        .setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                            }
                        })
                        .setExpanded(false)  // This will enable the expand feature, (similar to android L share dialog)
                        .create();
               View V = dialog.getHolderView();

                EditText etname = V.findViewById(R.id.etname);
                EditText etfname = V.findViewById(R.id.etfname);
                EditText etdob = V.findViewById(R.id.etdob);
                EditText etcontact = V.findViewById(R.id.etcontact);
                EditText etaddress = V.findViewById(R.id.etaddress);
                EditText etemail = V.findViewById(R.id.etemail);
                EditText etpassword = V.findViewById(R.id.etpassword);
                EditText etedu = V.findViewById(R.id.etedu);
                EditText etprojects = V.findViewById(R.id.etprojects);
                EditText etresearch = V.findViewById(R.id.etresearch);
                EditText etskill = V.findViewById(R.id.etskill);
                EditText btnupdate = V.findViewById(R.id.btnupdate);

                dialog.show();
            }
        });
    }


    @NonNull
    @Override
    public RecordsAdapter.RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listrecorditem,parent,false);
        return new RecordViewHolder(view);
    }


    public class RecordViewHolder extends RecyclerView.ViewHolder {
        EditText etlistname,etlistfname,etlistdob,etlistcontact,etlistaddress,etlistemail,etlistpassword,etlistedu,etlistprojects,etlistresearch,etlistskill;

        Button btnlistedit;
        public RecordViewHolder(@NonNull View itemView) {

            super(itemView);

            etlistname = itemView.findViewById(R.id.etlistname);
            etlistfname = itemView.findViewById(R.id.etlistfname);
            etlistdob = itemView.findViewById(R.id.etlistdob);
            etlistcontact = itemView.findViewById(R.id.etlistcontact);
            etlistaddress = itemView.findViewById(R.id.etlistaddress);
            etlistemail = itemView.findViewById(R.id.etlistemail);
            etlistpassword = itemView.findViewById(R.id.etlistpassword);
            etlistedu = itemView.findViewById(R.id.etlistedu);
            etlistprojects = itemView.findViewById(R.id.etlistprojects);
            etlistresearch = itemView.findViewById(R.id.etlistresearch);
            etlistskill = itemView.findViewById(R.id.etlistskill);
            btnlistedit = itemView.findViewById(R.id.btnlistedit);

        }
    }
}


