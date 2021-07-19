package com.example.july16we;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder  extends RecyclerView.ViewHolder {

    private TextView mtvName;
    private TextView mtvEmail;
    private TextView mtvBody;





    public PostViewHolder(@NonNull  View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mtvBody=itemView.findViewById(R.id.tvBody);
        mtvName=itemView.findViewById(R.id.tvName);
        mtvEmail=itemView.findViewById(R.id.tvEmail);

    }

    public void setData(ResponseModel responseModel) {
        mtvBody.setText(responseModel.getName());
        mtvEmail.setText(responseModel.getEmail());
        mtvName.setText(responseModel.getName());

    }
}
