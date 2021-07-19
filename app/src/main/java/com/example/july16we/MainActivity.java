package com.example.july16we;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.DnsResolver;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText metPostId;
    private Button mBtnFetch;
    private RecyclerView mrecyclerView;
    private List<ResponseModel>postModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }
    public void callApi(){
        Apiservice apiservice=Network.getInstance().create(Apiservice.class);
        int PostId=Integer.parseInt(metPostId.getText().toString());
        apiservice.getpost(PostId).enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                if(response.body()!=null){
                    postModelList=response.body();
                    setRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });


        }
        private void setRecyclerView(){
           PostAdapter postAdapter=new PostAdapter(postModelList);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
            mrecyclerView.setLayoutManager(linearLayoutManager);
            mrecyclerView.setAdapter(postAdapter);
        }


    private void initViews() {
        metPostId=findViewById(R.id.etPostId);
        mBtnFetch=findViewById(R.id.btnFetch);
        mrecyclerView=findViewById(R.id.recyclerView);
        mBtnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });

    }
}