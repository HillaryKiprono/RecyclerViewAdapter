package com.example.recyclerviewadapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "president app";
    private Button add;
    List<President> presidentList=new ArrayList<President>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private  RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillPresidentList();


        add =findViewById(R.id.btn_addOne);
        Log.d(TAG, "onCreate: "+presidentList.toString());


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });

        recyclerView=findViewById(R.id.lv_presidentList);
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter=new RecyclerViewAdapter(presidentList,MainActivity.this) ;
        recyclerView.setAdapter(mAdapter);
    }

    private void fillPresidentList()
    {
        President p0=new President(0,"John",1992,"https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Official_Presidential_portrait_of_John_Adams_%28by_John_Trumbull%2C_circa_1792%29.jpg/150px-Official_Presidential_portrait_of_John_Adams_%28by_John_Trumbull%2C_circa_1792%29.jpg");
        President p1=new President(1,"Thomas",1756,"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Vanderlyn_Burr.jpg/150px-Vanderlyn_Burr.jpg");
        President p2=new President(2,"Aaron",1836,"https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/George_Clinton_by_Ezra_Ames.jpg/150px-George_Clinton_by_Ezra_Ames.jpg");
        President p3=new President(3,"Gerry",1814,"https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Nathaniel_Jocelyn_-_Elbridge_Gerry_%281744-1814%29_-_1943.1816_-_Harvard_Art_Museums.jpg/150px-Nathaniel_Jocelyn_-_Elbridge_Gerry_%281744-1814%29_-_1943.1816_-_Harvard_Art_Museums.jpg");
        President p4=new President(4,"Daniel",1825,"https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Daniel_D_Tompkins_by_John_Wesley_Jarvis.jpg/150px-Daniel_D_Tompkins_by_John_Wesley_Jarvis.jpg");
        President p5=new President(5,"Calhoun",1850,"https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/JohnCalhoun.png/150px-JohnCalhoun.png");
        President p6=new President(6,"Buren",1862,"https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/MartinVanBuren.png/150px-MartinVanBuren.png");
        President p7=new President(7,"Richard",1850,"https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/John_Neagle%2C_Richard_Mentor_Johnson%2C_1843%2C_NGA_166465.jpg/150px-John_Neagle%2C_Richard_Mentor_Johnson%2C_1843%2C_NGA_166465.jpg");
        President p8=new President(8,"Tyler",1864,"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/John_Tyler.jpg/150px-John_Tyler.jpg");
        President p9=new President(9,"Dallas",1888,"https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/George_Mifflin_Dallas_1848_crop.png/150px-George_Mifflin_Dallas_1848_crop.png");

        presidentList.addAll(Arrays.asList(new President[]{p0,p1,p2,p3,p4,p5,p6,p7,p8,p9}));

    }
}